package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "family")
    private String family;

    public User1() {
    }

    public User1(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public User1(User1 user) {
        name = user.getName();
        family = user.getFamily();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
