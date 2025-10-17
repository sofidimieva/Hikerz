package com.hikerzactivity.hikerzactivity.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hikerzactivity.hikerzactivity.CustomRepository;
import com.hikerzactivity.hikerzactivity.model.Activity;
import java.util.List;

public interface ActivityRepository extends CustomRepository<Activity, Long>{

    @Query(value = """
        SELECT ST_AsGeoJSON(a.route)
        FROM activity a
        WHERE a.id = :id
    """, nativeQuery = true)
    String findGeomGeoJsonById(@Param("id") Long id);

    @Query(value = """
        SELECT a
        FROM Activity a
        WHERE a.username IN :usernames
        ORDER BY a.date DESC
    """)
    List<Activity> findByUsernameInOrderByDateDesc(@Param("usernames") List<String> usernames);
}
