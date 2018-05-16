package at.fhv.itm16.pictogo.rest;

import at.fhv.itm16.pictogo.rest.Theme;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Api(tags = "themes", description = "manage theme strings with start and end date")
public interface ThemeRepository extends PagingAndSortingRepository<Theme, Long>, ThemeRepositoryCustom {
}

