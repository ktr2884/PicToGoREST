package at.fhv.itm16.pictogo.rest;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userId;
    private String userName;
    private Integer credits;
    private Integer numberOfTakenPictures;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public int getCredits() { return credits; }

    public void setCredits(int credits) { this.credits = credits; }

    public int getNumberOfTakenPictures() { return numberOfTakenPictures; }

    public void setNumberOfTakenPictures(int numberOfTakenPictures) {
        this.numberOfTakenPictures = numberOfTakenPictures;
    }
}
