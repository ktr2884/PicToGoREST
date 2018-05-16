package at.fhv.itm16.pictogo.rest;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String themeItem;
    private LocalDate startDateOfTheme;
    private LocalDate endDateOfTheme;

    public String getThemeItem() {
        return themeItem;
    }

    public void setThemeItem(String themeItem) {
        this.themeItem = themeItem;
    }

    public LocalDate getStartDateOfTheme() { return startDateOfTheme; }

    public void setStartDateOfTheme(LocalDate startDateOfTheme) { this.startDateOfTheme = startDateOfTheme; }

    public LocalDate getEndDateOfTheme() { return endDateOfTheme; }

    public void setEndDateOfTheme(LocalDate endDateOfTheme) { this.endDateOfTheme = endDateOfTheme; }
}
