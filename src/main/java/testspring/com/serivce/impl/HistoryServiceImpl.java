package testspring.com.serivce.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		Pageable paging = PageRequest.of(page, size);
		Page<History> pageHistory;
		//covert date => Timestamp
		Timestamp dateFrom = DateF == null ? null : new Timestamp(DateF.getTime());
		Timestamp dateTo = DateT == null ? null : this.getEndOfDayTimestamp(DateT);
		
		pageHistory = historyRepository.findByCreateDate(userId, dateFrom, dateTo, paging);

		return new PageImpl<>(pageHistory.getContent(), pageHistory.getPageable(), pageHistory.getTotalElements());

	}

	public Timestamp getEndOfDayTimestamp(Date endDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endDate);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		Date endOfDay = calendar.getTime();

		return new Timestamp(endOfDay.getTime());
	}
}
