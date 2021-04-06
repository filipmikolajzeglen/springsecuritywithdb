package pl.filipzeglen.springsecuritywithdb.model.elearning.result;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseResult implements Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private Long userId;
    private float maxAmountOfPoints;
    private float gainedAmountOfPoints;
    private float status;

    public CourseResult(Long userId, float maxAmountOfPoints, float gainedAmountOfPoints, float status) {
        this.userId = userId;
        this.maxAmountOfPoints = maxAmountOfPoints;
        this.gainedAmountOfPoints = gainedAmountOfPoints;
        this.status = status;
    }

    public CourseResult() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getMaxAmountOfPoints() {
        return maxAmountOfPoints;
    }

    public void setMaxAmountOfPoints(float maxAmountOfPoints) {
        this.maxAmountOfPoints = maxAmountOfPoints;
    }

    public float getGainedAmountOfPoints() {
        return gainedAmountOfPoints;
    }

    public void setGainedAmountOfPoints(float gainedAmountOfPoints) {
        this.gainedAmountOfPoints = gainedAmountOfPoints;
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseResult{" +
                "courseId=" + courseId +
                ", userId=" + userId +
                ", maxAmountOfPoints=" + maxAmountOfPoints +
                ", gainedAmountOfPoints=" + gainedAmountOfPoints +
                ", status=" + status +
                '}';
    }
}
