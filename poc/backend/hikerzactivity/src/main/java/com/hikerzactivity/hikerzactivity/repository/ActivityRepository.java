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

    @Query("""
        SELECT a
        FROM Activity a
        WHERE a.userId = :userId
    """)
    List<Activity> findByUserId(@Param("userId") String userId);


    @Query(value = """
        SELECT a
        FROM Activity a
        WHERE a.userId IN :usernames
        ORDER BY a.createdAt DESC
    """)
    List<Activity> findByUsernameInOrderByDateDesc(@Param("usernames") List<String> usernames);
}
