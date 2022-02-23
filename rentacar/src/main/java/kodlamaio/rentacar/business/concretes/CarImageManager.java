package kodlamaio.rentacar.business.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.rentacar.business.abstracts.CarImageService;
import kodlamaio.rentacar.core.services.CloudinaryService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.CarImageDao;
import kodlamaio.rentacar.entities.concretes.CarImage;

@Service
public class CarImageManager implements CarImageService{

	private CarImageDao carImageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CarImageManager(CarImageDao carImageDao, CloudinaryService cloudinaryService) {
		super();
		this.carImageDao = carImageDao;
		this.cloudinaryService = cloudinaryService;
	}
	
	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<>
		(this.carImageDao.findAll(),"Araba resimleri listelendi.");
	}

	
	@Override
	public Result add(CarImage carImage, MultipartFile multipartFile) {
		Map<String, String> uploadPhoto;
		try {
			 uploadPhoto = this.cloudinaryService.upload(multipartFile);
			 carImage.setImagePath(uploadPhoto.get("public_id"));
			 carImage.setDate(LocalDate.now());
			 this.carImageDao.save(carImage);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return new SuccessResult("Araba resmi eklendi.");
		
	}

	@Override
	public Result update(CarImage carImage, MultipartFile multipartFile) {
		add(carImage, multipartFile);
		this.carImageDao.save(carImage);
		return new SuccessResult("Araba resmi güncellendi.");
	}

	@Override
	public Result delete(CarImage carImage) {
		
		this.carImageDao.delete(carImage);
		return new SuccessResult("Araba resmi silindi.");
	}

	@Override
	public DataResult<CarImage> getOneById(int id) {
		
		return new SuccessDataResult<>
		(this.carImageDao.getById(id));
	}

}
