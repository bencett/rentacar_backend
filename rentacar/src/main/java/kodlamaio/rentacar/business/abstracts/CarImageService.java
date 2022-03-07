package kodlamaio.rentacar.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.CarImage;

public interface CarImageService {

	DataResult <List<CarImage>> getAll();
	Result add(CarImage carImage, MultipartFile multipartFile);
	Result update(CarImage carImage, MultipartFile multipartFile);
	Result delete(int id);
	DataResult<List<CarImage>> getCarImagesByCarId(int carId);
	public Optional<CarImage> getOne(int id);
	boolean exists(int id);
}
