package testspring.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "APARTMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

	  @Column(name = "district")
	  private String district;
	  
	  @Column(name = "acreage")
	  private Double acreage;
	  
	  @Column(name = "average_price")
	  private Double averagePrice;

	  @Column(name = "description")
	  private String description;
}
