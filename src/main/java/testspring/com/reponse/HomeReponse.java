package testspring.com.reponse;

import java.util.List;

import lombok.Data;
import testspring.com.entity.Home;
@Data
public class HomeReponse {
    private List<Home> results;
}
