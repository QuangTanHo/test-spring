package testspring.com.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import testspring.com.Utils.PaginationUtils;
import testspring.com.entity.Home;
import testspring.com.reponse.HomeReponse;
import testspring.com.serivce.HomeService;

@RestController
@RequestMapping("api/home")
public class HomeController {

	
	private  final HomeService homeService;

	
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("")
	public ResponseEntity<?> getPriceHome(@RequestParam(required = false) Double price,
			@RequestParam("email") String email, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Page<HomeReponse> homeReponse = this.homeService.getHome(price, email, page, size);
		HttpHeaders headers = PaginationUtils
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), homeReponse);
		return new ResponseEntity<>(PaginationUtils.generatePage(homeReponse), headers, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Home> saveUser(@RequestBody Home home) {
		this.homeService.saveHome(home);
		return new ResponseEntity<>(home, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Home> updateHome(@RequestParam("id") Long id, @RequestBody Home home) {
		this.updateHome(id, home);
		return new ResponseEntity<>(home, HttpStatus.OK);
	}
	
	@PutMapping("/delete")
	public ResponseEntity<Home> updateDistrict(@RequestParam("id") Long id) {
		this.homeService.deleteHome(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
