package testspring.com.repository;

import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import testspring.com.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

//	 @Query("SELECT e FROM History e "
//	          + "WHERE (Date(e.createDate) >= Date(:dateFrom)) AND (DATE(e.createDate) <= Date(:dateTo)) AND (e.userId is null or e.userId = :userId) "
//	          + "ORDER BY e.createDate DESC")
//	 Page<History> findByCreateDate( @Param("userId") Long userId,@Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo,Pageable pageable);
//	
	 @Query("SELECT e FROM History e "
	          + "WHERE (:dateFrom IS NULL OR DATE(e.createDate) >= DATE(:dateFrom)) AND (:dateTo IS NULL OR DATE(e.createDate) <= DATE(:dateTo)) AND (e.userId is null or e.userId = :userId) "
	          + "ORDER BY e.createDate DESC")
	 Page<History> findByCreateDate( @Param("userId") Long userId,@Param("dateFrom") String  dateFrom, @Param("dateTo") String  dateTo,Pageable pageable);

}
