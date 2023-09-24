package testspring.com.serivce;

import org.springframework.data.domain.Page;

import testspring.com.entity.Home;
import testspring.com.reponse.HomeReponse;

public interface HomeService {

	void saveHome(Home home);
	
	Page<HomeReponse> getHome(Double searchPrice,String email, int pageNo, int pageSize);

	void updateHome(Long id, Home home);

	void deleteHome(Long id);  
	
}
