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
import testspring.com.repository.DistrictRepository;

@Entity
@Table(name = DistrictRepository.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Double averagePrice;

	private String description;

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
