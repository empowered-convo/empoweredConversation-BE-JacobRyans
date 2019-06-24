package naught.local.empconvo.service;

import naught.local.empconvo.models.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> findAllResourcesByCatId(long id);
}
