package at.fhv.itm16.pictogo.rest;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String themeItem;
    private Date startDateOfTheme;
    private Date endDateOfTheme;

    public String getThemeItem() {
        return themeItem;
    }

    public void setThemeItem(String themeItem) {
        this.themeItem = themeItem;
    }

    public Date getStartDateOfTheme() { return startDateOfTheme; }

    public void setStartDateOfTheme(Date startDateOfTheme) { this.startDateOfTheme = startDateOfTheme; }

    public Date getEndDateOfTheme() { return endDateOfTheme; }

    public void setEndDateOfTheme(Date endDateOfTheme) { this.endDateOfTheme = endDateOfTheme; }

    public long getId() { return id; }
}
