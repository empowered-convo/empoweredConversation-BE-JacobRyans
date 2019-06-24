package naught.local.empconvo.repos;

import naught.local.empconvo.models.Resource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResourceRepository extends CrudRepository<Resource, Long> {
}
