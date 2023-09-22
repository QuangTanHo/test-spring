package testspring.com.serivce.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import testspring.com.entity.History;
import testspring.com.repository.HistoryRepository;
import testspring.com.serivce.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

	private HistoryRepository historyRepository;

	public HistoryServiceImpl(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

	@Override
	public Page<History> getHistory(Long userId, Date DateF, Date DateT, int page, int size) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Pageable paging = PageRequest.of(page, size);
		Page<History> pageHistory;
		
		if (userId == null)
			pageHistory = historyRepository.findAll(paging);
		else {
			String dateFrom = DateF == null? null:  dateFormat.format(DateF);
			String dateTo = DateT ==null? null: dateFormat.format(DateT);
			
//			pageHistory = historyRepository.findByCreateDate(userId, dateFrom, dateTo, paging);
			
//			Timestamp dateFrom = new Timestamp(DateF.getTime());
//			Timestamp dateTo = new Timestamp(DateT.getTime());
			
			pageHistory = historyRepository.findByCreateDate(userId, dateFrom, dateTo, paging);
		}


		return new PageImpl<>(pageHistory.getContent(), pageHistory.getPageable(), pageHistory.getTotalElements());

	}
}
