package at.fhv.itm16.pictogo.rest;

/**
 * Created by Karin on 29.11.2017.
 */

import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;

@Api(tags = "meta data", description = "manage meta data of images")
public interface MetaRepository extends PagingAndSortingRepository<Meta, Long> {

}
