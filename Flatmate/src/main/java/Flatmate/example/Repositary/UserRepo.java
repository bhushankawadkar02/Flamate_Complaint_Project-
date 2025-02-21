package Flatmate.example.Repositary;

import Flatmate.example.Enities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {

 public    Optional<User> findByEmail(String email);
 List<User> findAllByOrderByKarmaPointsDesc();


}
