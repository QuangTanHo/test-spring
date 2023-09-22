package testspring.com.reponse;

import java.util.List;

import lombok.Data;
import testspring.com.entity.History;

@Data
public class HistoryReponse{
    private List<History> results;
}
