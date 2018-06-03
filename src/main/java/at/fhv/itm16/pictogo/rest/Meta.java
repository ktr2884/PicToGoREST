package at.fhv.itm16.pictogo.rest;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Karin on 29.11.2017.
 */
@Entity
@Table(name = "meta")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ApiModelProperty(notes = "The database generated product ID")
    private String userId;
    private Date created;
    private Boolean isActive;
    private String tag;
    private String imageURI;
    private String theme;

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public long getId() { return id; }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }
}
