package pl.filipzeglen.springsecuritywithdb.model.account;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_details")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailsId;
    private String firstName;
    private String lastName;
    private String location;

    @OneToOne(mappedBy = "details")
    private User user;

    @Temporal(TemporalType.DATE)
    private Date registeredDate;
    private boolean activated;

    public UserDetail(String firstName, String lastName, String location, Date registeredDate, boolean activated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.registeredDate = registeredDate;
        this.activated = activated;
    }

    public UserDetail() {
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
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

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
