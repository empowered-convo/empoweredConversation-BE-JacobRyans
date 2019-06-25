package naught.local.empconvo.service;

import naught.local.empconvo.models.Conversation;

import java.util.List;

public interface ConversationService {
    Conversation save(Conversation conversation);
    Conversation findById(long id);
    void delete(long id);
    List<Conversation> findAll();
}
