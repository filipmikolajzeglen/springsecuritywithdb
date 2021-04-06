package pl.filipzeglen.springsecuritywithdb.model.account;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;

    private String firstName;
    private String lastName;
    private String location;

    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = UserRole.class,
            mappedBy = "user",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            })
    private Set<UserRole> roles = new HashSet<>();

    public User(@NotEmpty String login,
                @NotEmpty String password,
                @NotEmpty String email,
                String firstName,
                String lastName,
                String location,
                Set<UserRole> roles) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.roles = roles;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<UserRole> getRoles() { return roles; }

    public void setRoles(Set<UserRole> roles) { this.roles = roles; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", role=" + roles +
                '}';
    }
}
