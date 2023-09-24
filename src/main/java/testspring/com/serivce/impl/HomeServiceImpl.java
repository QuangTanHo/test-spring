package testspring.com.serivce.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import testspring.com.entity.Home;
import testspring.com.Utils.Constants;
import testspring.com.entity.District;
import testspring.com.entity.History;
import testspring.com.entity.User;
import testspring.com.reponse.HomeReponse;
import testspring.com.repository.HomeRepository;
import testspring.com.repository.DistrictRepository;
import testspring.com.repository.HistoryRepository;
import testspring.com.repository.UserRepository;
import testspring.com.serivce.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	private  HomeRepository homeRepository;
	
	@Autowired
	private  HistoryRepository historyRepository ;
	
	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private  DistrictRepository districtRepository;
	
	
	@Override
	public void saveHome(Home home) {		
		District district = this.districtRepository.findByIdAndDelFlg(home.getDistrictId(),"0");
		if(Objects.isNull(district)) {
			throw new RuntimeException(" District is already exists");
		}
		home.setPrice((home.getAcreage() *district.getAveragePrice()));
		homeRepository.save(home);
	}
		
	@Override
    public Page<HomeReponse> getHome(Double price,String email,int page, int size) {

		// Check user login by email
		User user = userRepository.findByEmail(email);
		if (Objects.isNull(user)) {
			throw new RuntimeException("Email is already exists");
		}

		Pageable paging = PageRequest.of(page, size);
		Page<Home> pageHome;	
		if (price == null) {
			pageHome = homeRepository.findByDelFlg(Constants.DEL_FLG_0,paging);
		} else {
			pageHome = homeRepository.findByPriceAndDelFlg(price,Constants.DEL_FLG_0, paging);
			if (pageHome.getContent().size() > 0) {
				History historyEntity = new History();
				historyEntity.setKeyword(price.toString());
				historyEntity.setUserId(user.getId());
				this.historyRepository.save(historyEntity);
			}
		}
	     return new PageImpl(pageHome.getContent(), pageHome.getPageable(), pageHome.getTotalElements());
	}

	@Override
	public void updateHome(Long id,Home home) {
		if(!this.homeRepository.existsById(id)) {
			throw new RuntimeException(" Id is already exists");
		}
		
		this.homeRepository.save(home);
	}
	@Override
	public void deleteHome(Long id) {
		if (!this.homeRepository.existsById(id)) {
			throw new RuntimeException(" home is already exists");
		}
		Home home = this.homeRepository.findByIdAndDelFlg(id,Constants.DEL_FLG_0);
		home.setDelFlg(Constants.DEL_FLG_1);
		this.homeRepository.save(home);
	}

	
}
