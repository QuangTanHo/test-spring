package testspring.com.serivce.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import testspring.com.entity.District;
import testspring.com.reponse.DistrictReponse;
import testspring.com.repository.DistrictRepository;
import testspring.com.serivce.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	private final DistrictRepository districtRepository;

	public DistrictServiceImpl(DistrictRepository districtRepository) {
		this.districtRepository = districtRepository;
	}

	@Override
	public Page<DistrictReponse> getDistricts(int page, int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<District> pageDistrict;
		pageDistrict = districtRepository.findByIsDelete(Boolean.FALSE, paging);

		return new PageImpl(pageDistrict.getContent(), pageDistrict.getPageable(), pageDistrict.getTotalElements());
	}

	@Override
	public void saveDistrict(District district) {

		this.districtRepository.save(district);
	}

	@Override
	public void updateDistrict(Long id, District district) {
		if (!this.districtRepository.existsById(id)) {
			throw new RuntimeException(" DistrictId is already exists");
		}

		this.districtRepository.save(district);
	}

	@Override
	public void deleteDistrict(Long id) {
		if (!this.districtRepository.existsById(id)) {
			throw new RuntimeException(" DistrictId is already exists");
		}

		District district = this.districtRepository.findByIdAndIsDelete(id, Boolean.FALSE);
		district.setIsDelete(Boolean.TRUE);
		
		this.districtRepository.save(district);
	}

}
