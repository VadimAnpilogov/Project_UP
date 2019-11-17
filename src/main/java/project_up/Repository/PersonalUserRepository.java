package project_up.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_up.Entity.User;

import java.util.List;

@Repository
public interface PersonalUserRepository extends JpaRepository<User, Long> {
        List<User> findByUsername(String username);

}
