package testspring.com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testspring.com.entity.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long>{
	
	Page<Apartment> findByAveragePrice (Double averagePrice , Pageable pageable);
}
