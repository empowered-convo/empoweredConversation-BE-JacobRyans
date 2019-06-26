package naught.local.empconvo.service;

import naught.local.empconvo.EmpconvoApplication;
import naught.local.empconvo.models.Category;
import naught.local.empconvo.models.Conversation;
import naught.local.empconvo.repos.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmpconvoApplication.class)
class ConversationServiceImplTest {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Category testCategory = categoryService.findById(2);

        Conversation cs = new Conversation("Jim", "+12823728288", "Meg", "+18923234444", testCategory);

        Conversation addConvo = conversationService.save(cs);

        assertNotNull(addConvo);

        Conversation foundCourse = conversationService.findById(addConvo.getConversationid());
        assertEquals(addConvo.getFfname(), foundCourse.getFfname());
    }

    @Test
    void findById() {
        assertEquals("John", conversationService.findById(1).getSurvivorname());
    }

    @Test
    void delete() {
        conversationService.delete(2);
        assertEquals(1,conversationService.findAll().size());
    }

    @Test
    void findAll() {
        assertEquals(1, conversationService.findAll().size());
    }
}