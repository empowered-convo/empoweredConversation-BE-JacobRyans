package naught.local.empconvo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long conversationid;

    private String survivorname;
    private String survivornumber;
    private String ffname;
    private String ffnumber;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("conversations")
    private Category category;

    public Conversation() {
    }

    public Conversation(String survivorname, String survivornumber, String ffname, String ffnumber) {
        this.survivorname = survivorname;
        this.survivornumber = survivornumber;
        this.ffname = ffname;
        this.ffnumber = ffnumber;
    }

    public Conversation(String survivorname, String survivornumber, String ffname, String ffnumber, Category category) {
        this.survivorname = survivorname;
        this.survivornumber = survivornumber;
        this.ffname = ffname;
        this.ffnumber = ffnumber;
        this.category = category;
    }

    public long getConversationid() {
        return conversationid;
    }

    public String getSurvivorname() {
        return survivorname;
    }

    public void setSurvivorname(String survivorname) {
        this.survivorname = survivorname;
    }

    public String getSurvivornumber() {
        return survivornumber;
    }

    public void setSurvivornumber(String survivornumber) {
        this.survivornumber = survivornumber;
    }

    public String getFfname() {
        return ffname;
    }

    public void setFfname(String ffname) {
        this.ffname = ffname;
    }

    public String getFfnumber() {
        return ffnumber;
    }

    public void setFfnumber(String ffnumber) {
        this.ffnumber = ffnumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
