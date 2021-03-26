package Homework.twentyfourth.Interfaces;



import Homework.twentyfourth.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
