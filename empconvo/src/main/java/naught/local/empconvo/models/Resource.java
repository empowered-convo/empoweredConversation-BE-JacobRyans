package naught.local.empconvo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resourceid;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("resources")
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String textbody;

    private String author;
    private String title;

    public Resource() {
    }

    public Resource(String textbody, String author) {
        this.textbody = textbody;
        this.author = author;
    }

    public Resource(Category category, String textbody, String author) {
        this.category = category;
        this.textbody = textbody;
        this.author = author;
    }

    public Resource(Category category, String textbody, String author, String title) {
        this.category = category;
        this.textbody = textbody;
        this.author = author;
        this.title = title;
    }

    public String getTextbody() {
        return textbody;
    }

    public void setTextbody(String textbody) {
        this.textbody = textbody;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getResourceid() {
        return resourceid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
