package testspring.com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testspring.com.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
	String TABLE = "home";

	Page<Home> findByIsDelete(Boolean isDelete, Pageable pageable);

	Page<Home> findByPriceAndIsDelete(Double price, Boolean isDelete, Pageable pageable);

	Home findByIdAndIsDelete(Long id, Boolean isDelete);
}
