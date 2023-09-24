package testspring.com.reponse;

import java.util.List;

import lombok.Data;
import testspring.com.entity.District;

@Data
public class DistrictReponse {

	 private List<District> results;
}
