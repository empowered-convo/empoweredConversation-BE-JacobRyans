package naught.local.empconvo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryid;

    private String categoryname;

    @OneToMany(mappedBy = "category")
    private List<Conversation> conversations = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Resource> resources = new ArrayList<>();

    public Category() {
    }

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public Category(String categoryname, List<Conversation> conversations, List<Resource> resources) {
        this.categoryname = categoryname;
        this.conversations = conversations;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
