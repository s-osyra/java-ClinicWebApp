package pl.deso.ClinicWebApp.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <User, String> {



    Optional<User> findByUserEmail(String UserEmail);

    @Query (value = "SELECT * FROM userDB WHERE USER_EMAIL = ?1", nativeQuery = true)
    User returnUserByEmail(String userEmail);


}
