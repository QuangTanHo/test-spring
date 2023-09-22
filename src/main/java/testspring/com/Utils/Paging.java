package testspring.com.Utils;

import java.util.List;

import org.springframework.data.domain.Page;

public class Paging<T> {

	private final long totalPages;
	private final long totalElements;
	private final long pageSize;
	private final long pageNumber;
	private final List<T> content;

	public Paging(Page<T> page) {
		this.totalPages = page.getTotalPages();
		this.totalElements = page.getTotalElements();
		this.pageSize = page.getSize();
		this.pageNumber = page.getNumber();
		this.content = page.getContent();
	}

    public long getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public List<T> getContent() {
        return content;
    }

}
