package kodlamaio.rentacar.business.abstracts;

import java.util.List;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Car;
import kodlamaio.rentacar.entities.dtos.CarDetailsDto;

public interface CarService {
	
	DataResult<List<Car>> getAll();
	Result add(Car car);
	Result update(Car car);
	Result deleteById(int id);
	DataResult<List<Car>> getCarsByBrandId(int brandId);
	DataResult<List<Car>> getCarsByColorId(int colorId);
	DataResult<List<CarDetailsDto>> getCarDetails();
}
