package naught.local.empconvo.repos;

import naught.local.empconvo.models.Conversation;
import org.springframework.data.repository.CrudRepository;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
}
