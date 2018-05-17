package at.fhv.itm16.pictogo.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Api(tags = "themes", description = "manage theme strings with start and end date")
@RestController
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @RequestMapping(value = "/themes/findByTargetDate", method = RequestMethod.GET)
    @ApiOperation(value = "find themes, if targetDate is between start and end date", notes= "Date Format= 'yyyy-MM-dd'")
    public List<Theme> findByTargetDate(
        @RequestParam("targetDate")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date targetDateOfTheme
    ) {
        return themeRepository.findByTargetDate(targetDateOfTheme);
    }
}
