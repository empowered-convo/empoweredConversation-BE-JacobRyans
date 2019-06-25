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

    private String textbody;
    private String author;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
