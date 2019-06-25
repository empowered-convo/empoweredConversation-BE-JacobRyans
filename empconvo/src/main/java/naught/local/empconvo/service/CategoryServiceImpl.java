package naught.local.empconvo.service;

import naught.local.empconvo.exception.ResourceNotFoundException;
import naught.local.empconvo.models.Category;
import naught.local.empconvo.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "catService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository restrepos;

    @Override
    public Category findById(long id) {
        return restrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id) + " category not found."));
    }

    @Override
    public List<Category> findAll() {
        ArrayList<Category> list = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
