package naught.local.empconvo.controller;

import naught.local.empconvo.exception.ResourceNotFoundException;
import naught.local.empconvo.models.Conversation;
import naught.local.empconvo.models.Resource;
import naught.local.empconvo.service.ConversationService;
import naught.local.empconvo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class EmpConvoController {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ConversationService convoService;

    @GetMapping(value="/categories/{categoryid}/resources")
    public ResponseEntity<?> getAllResourcesByCategoryId(@PathVariable long categoryid) {
        List<Resource> response = resourceService.findAllResourcesByCatId(categoryid);
        if(response.size() > 0) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new EntityNotFoundException(Long.toString(categoryid));
        }
    }

    @PostMapping(value="/conversations")
    public ResponseEntity<?> createNewConversation(@Valid @RequestBody Conversation newConvo) {
        return new ResponseEntity<>(convoService.save(newConvo), HttpStatus.CREATED);
    }

}
