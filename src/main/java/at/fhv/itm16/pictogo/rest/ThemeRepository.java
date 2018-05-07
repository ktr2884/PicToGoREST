package at.fhv.itm16.pictogo.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ThemeRepository extends PagingAndSortingRepository<Theme, Long>{
    List<Theme> findByIsActiveTheme(@Param("isActiveTheme") Boolean isActiveTheme);
}
