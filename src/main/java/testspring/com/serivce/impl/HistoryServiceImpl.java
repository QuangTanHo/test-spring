package testspring.com.serivce.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
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
	public Page<History> getHistory(Long userId, Date dateF, Date dateT, int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<History> pageHistory;

		LocalDateTime dateFrom = dateF.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime dateTo = dateT.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
				.with(LocalTime.of(23, 59, 59));

		pageHistory = historyRepository.findByCreateDate(userId, dateFrom, dateTo, paging);

		return new PageImpl<>(pageHistory.getContent(), pageHistory.getPageable(), pageHistory.getTotalElements());

	}

}
