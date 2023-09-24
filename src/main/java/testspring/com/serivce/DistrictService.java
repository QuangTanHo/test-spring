package testspring.com.serivce;

import org.springframework.data.domain.Page;

import testspring.com.entity.District;
import testspring.com.reponse.DistrictReponse;


public interface DistrictService {

	Page<DistrictReponse> getDistricts(int page, int size);
	
	void saveDistrict(District district);

	void updateDistrict(Long id, District district);

	void deleteDistrict(Long id);


}
