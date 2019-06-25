package naught.local.empconvo.service;

import naught.local.empconvo.models.Category;
import naught.local.empconvo.models.Conversation;
import naught.local.empconvo.repos.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            newConvo.setCategory(conversation.getCategory());
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
}
