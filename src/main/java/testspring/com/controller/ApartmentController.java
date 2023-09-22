package testspring.com.controller;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import testspring.com.Utils.PaginationUtils;
import testspring.com.entity.Apartment;
import testspring.com.entity.History;
import testspring.com.reponse.ApartmentReponse;
import testspring.com.serivce.ApartmentService;
import testspring.com.serivce.HistoryService;

@RestController
@RequestMapping("api/apartments")
public class ApartmentController {

	private ApartmentService apartmentService;
	private HistoryService historyService;

	public ApartmentController(ApartmentService apartmentService, HistoryService historyService) {
		this.apartmentService = apartmentService;
		this.historyService = historyService;
	}

	@PostMapping("")
	public ResponseEntity<Apartment> saveUser(@RequestBody Apartment apartment) {
		apartmentService.saveApartment(apartment);
		return new ResponseEntity<>(apartment, HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<?> getPriceApartment(@RequestParam(required = false) Double searchPrice,@RequestParam("email") String email,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
		Page<ApartmentReponse> apartmentReponse = this.apartmentService.getApartment(searchPrice,email, page, size);
		HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), apartmentReponse);
		return new ResponseEntity<>(PaginationUtils.generatePage(apartmentReponse), headers, HttpStatus.OK);
	}

	@GetMapping("/show-history")
	public ResponseEntity<?> getHistory(@RequestParam(required = false) Long userId, @RequestParam(required = false) Date dateFrom,
			@RequestParam(required = false) Date dateTo, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Page<History> historyReponse = this.historyService.getHistory(userId, dateFrom, dateTo, page, size);
		HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), historyReponse);
		return new ResponseEntity<>(PaginationUtils.generatePage(historyReponse), headers, HttpStatus.OK);

	}

}
