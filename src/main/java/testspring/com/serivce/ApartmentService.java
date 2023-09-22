package testspring.com.serivce;

import org.springframework.data.domain.Page;

import testspring.com.entity.Apartment;
import testspring.com.reponse.ApartmentReponse;

public interface ApartmentService {

	void saveApartment(Apartment  apartment);
	
	Page<ApartmentReponse> getApartment(Double searchPrice,String email, int pageNo, int pageSize);  
	
}
