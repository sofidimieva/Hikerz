package com.hikerzuser.hikerzuser.repository;
import com.hikerzuser.hikerzuser.CustomRepository;
import com.hikerzuser.hikerzuser.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CustomRepository<User, String>{

    @Query("""
        SELECT u FROM User u
        WHERE LOWER(u.username) <> LOWER(:current)
          AND (
            :q IS NULL OR :q = '' OR
            LOWER(u.username) LIKE LOWER(CONCAT('%', :q, '%')) OR
            LOWER(u.name)     LIKE LOWER(CONCAT('%', :q, '%'))
          )
        """)
    Page<User> searchAllExcludingCurrent(
            @Param("current") String currentUsername,
            @Param("q") String query,
            Pageable pageable
    );
}
