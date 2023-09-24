package testspring.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HOME")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "district_id")
	private Long districtId;

	@Column(name = "acreage")
	private Double acreage;

	@Column(name = "price")
	private Double price;

	@Column(name = "description")
	private String description;

	@Column(name = "del_flg")
	private String delFlg = "0";

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", updatable = false)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", insertable = false)
	private Date updateDate;

	@Column(name = "update_by", insertable = false)
	private Integer updateBy;

}
