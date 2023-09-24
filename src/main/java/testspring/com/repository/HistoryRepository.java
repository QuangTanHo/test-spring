package testspring.com.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import testspring.com.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
	String TABLE = "history";

	@Query("SELECT e FROM History e "
			+ "WHERE (:dateFrom IS NULL OR e.createDate >= :dateFrom) AND (:dateTo IS NULL OR e.createDate <= :dateTo) AND (:userId is null or e.userId = :userId) AND (e.isDelete= 0)"
			+ "ORDER BY e.createDate DESC")
	Page<History> findByCreateDate(@Param("userId") Long userId, @Param("dateFrom") LocalDateTime dateFrom,
			@Param("dateTo") LocalDateTime dateTo, Pageable pageable);

}
