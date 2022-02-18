package kodlamaio.rentacar.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.CarImageService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.CarImageDao;
import kodlamaio.rentacar.entities.concretes.CarImage;

@Service
public class CarImageManager implements CarImageService{

	private CarImageDao carImageDao;
	
	@Autowired
	public CarImageManager(CarImageDao carImageDao) {
		super();
		this.carImageDao = carImageDao;
	}
	
	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<>
		(this.carImageDao.findAll(),"Araba resimleri listelendi.");
	}

	@Override
	public Result add(CarImage carImage) {
		
		this.carImageDao.save(carImage);
		return new SuccessResult("Araba resmi eklendi.");
	}

	@Override
	public Result update(CarImage carImage) {
		
		this.carImageDao.save(carImage);
		return new SuccessResult("Araba resmi güncellendi.");
	}

	@Override
	public Result delete(CarImage carImage) {
		
		this.carImageDao.delete(carImage);
		return new SuccessResult("Araba resmi silindi.");
	}

}
