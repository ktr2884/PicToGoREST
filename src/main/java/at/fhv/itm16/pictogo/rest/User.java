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

    public long getId() { return id; }


    public void setCredits(Integer credits) { this.credits = credits; }

    public void setNumberOfTakenPictures(Integer numberOfTakenPictures) {
        this.numberOfTakenPictures = numberOfTakenPictures;
    }
}
