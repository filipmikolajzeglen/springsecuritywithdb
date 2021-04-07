package pl.filipzeglen.springsecuritywithdb.model.account;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    @UniqueElements
    private String login;
    @NotEmpty
    private String password;
    @NotEmpty
    @UniqueElements
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detailsId", referencedColumnName = "detailsId")
    private UserDetail details;

    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = UserRole.class,
            mappedBy = "user",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            })
    private Set<Role> roles = new HashSet<>();

    public User(@NotEmpty String login,
                @NotEmpty String password,
                @NotEmpty String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public Long getId() { return userId; }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role userRole) {
        this.roles.add(userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + roles +
                '}';
    }
}
