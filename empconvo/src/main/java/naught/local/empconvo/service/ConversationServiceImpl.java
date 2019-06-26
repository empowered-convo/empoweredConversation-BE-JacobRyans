package naught.local.empconvo.service;

import naught.local.empconvo.exception.ResourceNotFoundException;
import naught.local.empconvo.models.Category;
import naught.local.empconvo.models.Conversation;
import naught.local.empconvo.repos.CategoryRepository;
import naught.local.empconvo.repos.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "convoService")
public class ConversationServiceImpl implements ConversationService {
    @Autowired
    private ConversationRepository restrepos;

    @Autowired
    private CategoryRepository catrepos;

    @Override
    public Conversation save(Conversation conversation) {
        Conversation newConvo = new Conversation();
        if(conversation.getCategory() != null) {
            newConvo.setCategory(catrepos.findById(conversation.getCategory().getCategoryid()).orElseThrow(() -> new EntityNotFoundException("No category found with that id.")));
        } else {
            newConvo.setCategory(new Category("None Provided"));
        }
        if(conversation.getFfname() != null) {
            newConvo.setFfname(conversation.getFfname());
        }
        if(conversation.getFfnumber() != null) {
            newConvo.setFfnumber(conversation.getFfnumber());
        }
        if(conversation.getSurvivorname() != null) {
            newConvo.setSurvivorname(conversation.getSurvivorname());
        }
        if(conversation.getSurvivornumber() != null) {
            newConvo.setSurvivornumber(conversation.getSurvivornumber());
        }
        return restrepos.save(newConvo);
    }

    @Override
    public Conversation findById(long id) {
        return restrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conversation with that ID not found"));
    }

    @Override
    public void delete(long id) {
        restrepos.deleteById(id);
    }

    @Override
    public List<Conversation> findAll() {
        ArrayList<Conversation> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
