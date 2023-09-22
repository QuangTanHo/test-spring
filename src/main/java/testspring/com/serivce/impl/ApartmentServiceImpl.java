package testspring.com.serivce.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import testspring.com.entity.Apartment;
import testspring.com.entity.History;
import testspring.com.entity.User;
import testspring.com.reponse.ApartmentReponse;
import testspring.com.repository.ApartmentRepository;
import testspring.com.repository.HistoryRepository;
import testspring.com.repository.UserRepository;
import testspring.com.serivce.ApartmentService;

@Service
public class ApartmentServiceImpl implements ApartmentService {
	
	private final ApartmentRepository apartmentRepository;
	
	private final HistoryRepository historyRepository ;
	
	private final UserRepository userRepository;

	
	public ApartmentServiceImpl(ApartmentRepository apartmentRepository, HistoryRepository historyRepository,
			UserRepository userRepository) {
		this.apartmentRepository = apartmentRepository;
		this.historyRepository = historyRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void saveApartment(Apartment apartment) {
		apartmentRepository.save(apartment);
	}
		
	@SuppressWarnings("unchecked")
	@Override
    public Page<ApartmentReponse> getApartment(Double searchPrice,String email,int page, int size) {

		// Check user login by email
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new RuntimeException("Email is already exists");
		}

		Pageable paging = PageRequest.of(page, size);
		Page<Apartment> pageApartment;
		if (searchPrice == null) {
			pageApartment = apartmentRepository.findAll(paging);
		} else {
			pageApartment = apartmentRepository.findByAveragePrice(searchPrice, paging);
			if (pageApartment.getContent().size() > 0) {
				History historyEntity = new History();
				historyEntity.setKeyword(searchPrice.toString());
				historyEntity.setUserId(user.getId());
				this.historyRepository.save(historyEntity);
			}
		}
	     return new PageImpl(pageApartment.getContent(), pageApartment.getPageable(), pageApartment.getTotalElements());
	} 
}
