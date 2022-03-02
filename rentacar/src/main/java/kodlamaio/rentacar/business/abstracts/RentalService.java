package kodlamaio.rentacar.business.abstracts;

import java.util.List;

import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Rental;

public interface RentalService {

	DataResult<List<Rental>> getAll();
	Result add(Rental rental);
	Result update(Rental rental);
	Result deleteById(int id);
	Result returnRentedCar(Rental rental);
}
