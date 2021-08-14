package io.hari.demo.dao;

import io.hari.demo.entity.Contest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestDao extends BaseDao<Contest>{
    @Query(value = "select * from contests where level = :level", nativeQuery = true)
    List<Contest> findAllContestByLevelSQL(String level);
}
