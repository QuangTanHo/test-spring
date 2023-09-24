package testspring.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testspring.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

//	Boolean existsByEmail(String email);
	public User findByEmail(String email);
}
