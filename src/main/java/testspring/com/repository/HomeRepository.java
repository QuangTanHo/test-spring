package testspring.com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testspring.com.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long>{
	
	Page<Home> findByDelFlg (String delFlg , Pageable pageable);
	
	Page<Home> findByPriceAndDelFlg (Double price,String delFlg , Pageable pageable);
	
	Home findByIdAndDelFlg(Long id,String delFlg);
}
