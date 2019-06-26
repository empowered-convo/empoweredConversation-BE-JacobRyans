package naught.local.empconvo.service;

import naught.local.empconvo.EmpconvoApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmpconvoApplication.class)
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById() {
        assertEquals("Harassment", categoryService.findById(1).getCategoryname());
    }

    @Test
    void findAll() {
        assertEquals(2, categoryService.findAll().size());
    }
}