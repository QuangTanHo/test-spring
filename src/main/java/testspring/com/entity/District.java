package testspring.com.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class District {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

	  @Column(name = "name")
	  private String name;
	  
	  @Column(name = "average_price")
	  private Double averagePrice;

	  @Column(name = "description")
	  private String description;
}
