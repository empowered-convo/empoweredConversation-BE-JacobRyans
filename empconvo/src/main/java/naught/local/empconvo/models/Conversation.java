package naught.local.empconvo.models;

import javax.persistence.*;

@Entity
@Table(name = "conversation")
public class Conversation {
    private String survivorname;
    private String survivornumber;
    private String ffname;
    private String ffnumber;

    @Column(nullable = false)
    private long categoryid;

    public Conversation() {
    }

    public Conversation(String survivorname, String survivornumber, String ffname, String ffnumber, long categoryid) {
        this.survivorname = survivorname;
        this.survivornumber = survivornumber;
        this.ffname = ffname;
        this.ffnumber = ffnumber;
        this.categoryid = categoryid;
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

    public long getCategoryid() {
        return categoryid;
    }

}
