package kodlamaio.rentacar.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.CarService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.ErrorResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.CarDao;
import kodlamaio.rentacar.entities.concretes.Car;

@Service
public class CarManager implements CarService{
	
	private CarDao carDao;
	
	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>
		(this.carDao.findAll(),"Arabalar listelendi.");
	}

	@Override
	public Result add(Car car) {
		
		if (!checkIfCarNameOverTwoChar(car.getBrand().getName()) == true
				&& checkIfDailyPriceOverZero(car.getDailyPrice()) == true) {
			this.carDao.save(car);
			return new SuccessResult("Araba eklendi.");
		}
		return new ErrorResult("Belirtilen alanları doldurunuz.");
		
	}

	@Override
	public DataResult<List<Car>> getCarsByBrandId(int brandId) {
		
		return new SuccessDataResult<List<Car>>
		(this.carDao.getCarsByBrandId(brandId),"Markaya göre arabalar listelendi.");
	}

	@Override
	public DataResult<List<Car>> getCarsByColorId(int colorId) {
		
		return new SuccessDataResult<List<Car>>
		(this.carDao.getCarsByColorId(colorId),"Renge göre arabalar listelendi.");
	}
	
	/*@Override
	public DataResult<List<CarDetailsDto>> getCarDetails() {

		return new SuccessDataResult<List<CarDetailsDto>>
		(this.carDao.getCarDetails(),"Araba detayları listelendi.");
	}*/

	@Override
	public Result update(Car car) {
		
		this.carDao.save(car);
		return new SuccessResult("Araba güncellendi.");
	}

	@Override
	public Result delete(Car car) {
		
		this.carDao.delete(car);
		return new SuccessResult("Araba silindi.");
	}
	//----------------------------------------------------
	//---------------- AUTHORIZATION ---------------------
	
	private boolean checkIfCarNameOverTwoChar(String brandName) {
		if (brandName.length() > 2) {
			return true;
		}
		return false;
		
	}
	
	private boolean checkIfDailyPriceOverZero(int dailyPrice) {
		
		if (dailyPrice > 0) {	
			return true;	
		}
		return false;
	}
	
	//---------------- AUTHORIZATION ---------------------
	//----------------------------------------------------
}
