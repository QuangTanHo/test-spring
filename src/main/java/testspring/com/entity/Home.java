package testspring.com.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import testspring.com.repository.HomeRepository;

@Entity
@Table(name = HomeRepository.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Long districtId;

	private Double acreage;

	private Double price;

	private String description;

	private Boolean isDelete = false;

	private LocalDateTime createDate = LocalDateTime.now();

	private LocalDateTime updateDate = LocalDateTime.now();

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
