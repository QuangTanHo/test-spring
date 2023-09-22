package testspring.com.reponse;

import java.util.List;

import lombok.Data;
import testspring.com.entity.Apartment;
@Data
public class ApartmentReponse {
    private List<Apartment> results;
}
