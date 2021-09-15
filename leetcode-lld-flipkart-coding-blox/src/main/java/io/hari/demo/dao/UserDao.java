package io.hari.demo.dao;

import io.hari.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao<User>{
    @Query(value = "select * from users order by score desc", nativeQuery = true)
    List<User> findLeaderBoard();
}
