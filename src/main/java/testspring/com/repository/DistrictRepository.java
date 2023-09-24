package testspring.com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testspring.com.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{
	
	Page<District> findByDelFlg (String delFlg , Pageable pageable);
	District findByIdAndDelFlg(Long id,String delFlg);
}
