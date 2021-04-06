package pl.filipzeglen.springsecuritywithdb.model.account;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;
    private String role;
    private String description;

    public UserRole(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public UserRole() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long id) {
        this.roleId = id;
    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + roleId +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
