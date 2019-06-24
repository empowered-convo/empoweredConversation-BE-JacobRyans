package naught.local.empconvo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resource")
public class Resource {

    @Column(nullable = false)
    private long categoryid;

    private String textbody;
    private String author;

    public Resource() {
    }

    public Resource(long categoryid, String textbody, String author) {
        this.categoryid = categoryid;
        this.textbody = textbody;
        this.author = author;
    }

    public long getCategoryid() {
        return categoryid;
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
}
