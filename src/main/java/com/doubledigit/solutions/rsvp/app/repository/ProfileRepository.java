package com.doubledigit.solutions.rsvp.app.repository;

import com.doubledigit.solutions.rsvp.app.model.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findByNameIgnoreCase(String name);
    List<Profile> findByUsernameAndPassword(String username, String password);
    List<Profile> findByUsernameStartingWith(String prefix);
    List<Profile> findByApprovedTrue();

    @Query(value = "select * from signup", nativeQuery = true)
    List<Profile> findProfiles();

    @Query(value = "from Profile")
    Stream<Profile> findStreamProfiles();

    @Query(value = "from Profile p WHERE p.id = :id")
    public Profile findProfile(@Param("id") Long id);

    @Query(value = "from Profile p WHERE p.username = ?1 AND p.password = ?2")
    List<Profile> findProfiles(String username, String password);

    @Query(value = "Select * from signup WHERE username LIKE ?1 AND password LIKE ?2", nativeQuery = true)
    List<Profile> findNativeProfiles(String username, String password);

    @Query(value = "from Profile")
    public List<Profile> findSortedProfiles(Sort sort);

    @Query(value = "delete from signup where username = :username", nativeQuery = true)
    public void deleteByUsername(@Param("username") String username);

}
