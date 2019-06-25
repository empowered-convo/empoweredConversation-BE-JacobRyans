package naught.local.empconvo.controller;

import io.swagger.annotations.*;
import naught.local.empconvo.exception.ResourceNotFoundException;
import naught.local.empconvo.models.Category;
import naught.local.empconvo.models.Conversation;
import naught.local.empconvo.models.ErrorDetail;
import naught.local.empconvo.models.Resource;
import naught.local.empconvo.service.CategoryService;
import naught.local.empconvo.service.ConversationService;
import naught.local.empconvo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import com.twilio.sdk.resource.list.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class EmpConvoController {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ConversationService convoService;

    @Autowired
    private CategoryService catService;

    @ApiOperation(value = "return all resources.", response = Resource.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value="/categories/{categoryid}/resources")
    public ResponseEntity<?> getAllResourcesByCategoryId(@PathVariable long categoryid) {
        List<Resource> response = resourceService.findAllResourcesByCatId(categoryid);
        if(response.size() > 0) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new EntityNotFoundException(Long.toString(categoryid));
        }
    }

    @ApiOperation(value = "return all conversations", response = Conversation.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value="/conversations")
    public ResponseEntity<?> findAllConvos() {
        return new ResponseEntity<>(convoService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Create new conversation.", response=Conversation.class)
    @ApiResponses(value = {
            @ApiResponse(code=201, message = "Author book added successfully", response = Conversation.class),
            @ApiResponse(code=404, message = "Incorrect endpoint.", response = EntityNotFoundException.class),
            @ApiResponse(code=500, message = "Invalid request body.", response = ErrorDetail.class)
    })
    @PostMapping(value="/conversations")
    public ResponseEntity<?> createNewConversation(@Valid @RequestBody Conversation newConvo) {
        Conversation createdConvo = convoService.save(newConvo);
        String ACCOUNT_SID = "AC3004f5000c8be4bc0f62a04d63d5b6d0";
        String AUTH_TOKEN = "763bfc43915422c9baf19f2e36e2fd9f";
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+13375524505"));
        params.add(new BasicNameValuePair("From", "+19179206969"));
        params.add(new BasicNameValuePair("Body", createdConvo.getSurvivorname() + " would like to speak with you about a sensitive matter. " + "https://empconvo.com/conversation/" + "?cid=" + createdConvo.getConversationid() + "&caid=" + createdConvo.getCategory().getCategoryid() ));
        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        try { messageFactory.create(params); } catch(Exception exc) { System.out.println(exc); };
        return new ResponseEntity<>(createdConvo, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletes conversation.", response=String.class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Conversation deleted successfully", response = String.class),
            @ApiResponse(code=404, message = "Conversation ID not valid.", response = EntityNotFoundException.class),
    })
    @DeleteMapping(value="/conversations/finished/{conversationid}")
    public ResponseEntity<?> finishConversation(@PathVariable long conversationid) {
        Conversation createdConvo = convoService.findById(conversationid);
        String ACCOUNT_SID = "AC3004f5000c8be4bc0f62a04d63d5b6d0";
        String AUTH_TOKEN = "763bfc43915422c9baf19f2e36e2fd9f";
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+13375524505"));
        params.add(new BasicNameValuePair("From", "+19179206969"));
        params.add(new BasicNameValuePair("Body", createdConvo.getFfname() + " is ready to speak with you and has read resources to prepare themselves, thank you for trusting in us."));
        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        try { messageFactory.create(params); convoService.delete(conversationid); } catch(Exception exc) { throw new EntityNotFoundException(exc.toString()); };
        return new ResponseEntity<>("Conversation " + conversationid + " has been closed.", HttpStatus.OK);
    }

    @ApiOperation(value = "return all categories.", response = Category.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping(value="/categories")
    public ResponseEntity<?> findAllCategories() {
        return new ResponseEntity<>(catService.findAll(), HttpStatus.OK);
    }
}
