package testspring.com.reponse;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class commonPageReponse {
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}