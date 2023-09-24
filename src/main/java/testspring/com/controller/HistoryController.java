package testspring.com.controller;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import testspring.com.Utils.PaginationUtils;
import testspring.com.entity.History;
import testspring.com.serivce.HistoryService;

@RestController
@RequestMapping("api/history")
public class HistoryController {
	
	private HistoryService historyService;
	
	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}

	@GetMapping("")
	public ResponseEntity<?> getHistory(@RequestParam(required = false) Long userId, @RequestParam(required = false) Date dateFrom,
			@RequestParam(required = false) Date dateTo, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		Page<History> historyReponse = this.historyService.getHistory(userId, dateFrom, dateTo, page, size);
		HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), historyReponse);
		return new ResponseEntity<>(PaginationUtils.generatePage(historyReponse), headers, HttpStatus.OK);

	}
    
}
