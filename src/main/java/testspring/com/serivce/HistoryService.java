package testspring.com.serivce;

import java.util.Date;

import org.springframework.data.domain.Page;

import testspring.com.entity.History;

public interface HistoryService {

	Page<History> getHistory(Long userId, Date dateFrom, Date dateTo, int page, int size);

}
