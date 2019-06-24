package naught.local.empconvo.models;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryid;

    private String categoryname;

    public Category() {
    }

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String name) {
        this.categoryname = categoryname;
    }

}
