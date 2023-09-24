package testspring.com.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import testspring.com.repository.HistoryRepository;

@Entity
@Table(name = HistoryRepository.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String keyword;

	private Long userId;

	private Boolean isDelete = false;

	private LocalDateTime createDate;

	private LocalDateTime updateDate;

	private String updateBy;

	@PrePersist
	public void prePersist() {
		this.createDate = LocalDateTime.now();
		this.updateDate = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.updateDate = LocalDateTime.now();
	}

}
