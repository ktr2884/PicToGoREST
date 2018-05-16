package at.fhv.itm16.pictogo.rest;

import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Api(tags = "user data")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByUserId (@Param("userId") String userId);
    List<User> findByUserName (@Param("userName") String userName);
}
