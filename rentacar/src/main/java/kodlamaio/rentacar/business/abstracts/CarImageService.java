package kodlamaio.rentacar.business.abstracts;

import java.util.List;

import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.CarImage;

public interface CarImageService {

	DataResult <List<CarImage>> getAll();
	Result add(CarImage carImage);
	Result update(CarImage carImage);
	Result delete(CarImage carImage);
}
