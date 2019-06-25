package naught.local.empconvo.service;

import naught.local.empconvo.models.Category;

import java.util.List;

public interface CategoryService {
    Category findById(long id);
    List<Category> findAll();
}
