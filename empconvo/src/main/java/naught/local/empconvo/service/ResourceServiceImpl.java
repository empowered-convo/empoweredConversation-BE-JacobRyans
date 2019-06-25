package naught.local.empconvo.service;

import naught.local.empconvo.exception.ResourceNotFoundException;
import naught.local.empconvo.models.Conversation;
import naught.local.empconvo.models.Resource;
import naught.local.empconvo.repos.ConversationRepository;
import naught.local.empconvo.repos.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "resourceService")
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository restrepos;

    @Override
    public List<Resource> findAllResourcesByCatId(long id) {
        ArrayList<Resource> resources = new ArrayList<>();
        for(Resource resource : restrepos.findAll()) {
            if(resource.getCategory().getCategoryid() == id) {
                resources.add(resource);
            }
        }
        if(resources.size() == 0) {
            throw new ResourceNotFoundException("No resources found for this category.");
        }
        return resources;
    }
}
