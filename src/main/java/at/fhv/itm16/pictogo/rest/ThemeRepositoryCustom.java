package at.fhv.itm16.pictogo.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ThemeRepositoryCustom {
    List<Theme> findByTargetDate(@Param("targetDate") Date targetDateOfTheme);
}

