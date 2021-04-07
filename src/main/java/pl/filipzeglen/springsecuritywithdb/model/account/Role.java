package pl.filipzeglen.springsecuritywithdb.model.account;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String role;
    private String description;

    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = UserRole.class,
            mappedBy = "role",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            })
    private Set<Role> roles = new HashSet<>();

    public Role(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public Role() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long id) {
        this.roleId = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "UserRole{" +
                "id=" + roleId +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
