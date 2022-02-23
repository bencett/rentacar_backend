package kodlamaio.rentacar.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.CarImage;

public interface CarImageService {

	DataResult <List<CarImage>> getAll();
	Result add(CarImage carImage, MultipartFile multipartFile);
	Result update(CarImage carImage, MultipartFile multipartFile);
	Result delete(CarImage carImage);
	DataResult<CarImage> getOneById(int id);
}
