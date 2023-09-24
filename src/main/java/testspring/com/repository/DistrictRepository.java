package testspring.com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testspring.com.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
	String TABLE = "district";

	Page<District> findByIsDelete(Boolean isDelete, Pageable pageable);

	District findByIdAndIsDelete(Long id, Boolean isDelete);
}
