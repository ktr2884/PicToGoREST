package at.fhv.itm16.pictogo.rest;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String themeItem;
    private Boolean isActiveTheme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThemeItem() {
        return themeItem;
    }

    public void setThemeItem(String themeItem) {
        this.themeItem = themeItem;
    }

    public Boolean getActiveTheme() {
        return isActiveTheme;
    }

    public void setActiveTheme(Boolean activeTheme) {
        isActiveTheme = activeTheme;
    }
}
