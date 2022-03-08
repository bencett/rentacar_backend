package kodlamaio.rentacar.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.RentalService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.ErrorDataResult;
import kodlamaio.rentacar.core.utilities.results.ErrorResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.RentalDao;
import kodlamaio.rentacar.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService{
	
	private Rental rentalToChangeActivityOrReturnDate;
	private RentalDao rentalDao;
	
	@Autowired
	public RentalManager(RentalDao rentalDao) {
		super();
		this.rentalDao = rentalDao;
	}

	@Override
	public DataResult<List<Rental>> getAll() {
		
		return new SuccessDataResult<List<Rental>>
		(this.rentalDao.findAll(),"Kiralamalar listelendi.");
	}
	
	@Override
	public DataResult<List<Rental>> getAllActiveRentals() {
		return new SuccessDataResult<List<Rental>>
		(this.rentalDao.getAllActiveRentals(),"Aktif kiralamalar listelendi.");
		
	}
	
	@Override
	public DataResult<Rental> getById(int id) {
	    
		return new SuccessDataResult<Rental>
		(this.rentalDao.findById(id).get(),"Kiralama getirildi.");
	}

	@Override
	public Result add(Rental rental) {
		
		if (rental.getReturnDate() != null) {
			return new ErrorResult("Bu araba kiralanamaz.");
		}else {
			rental.setRentDate(LocalDate.now());
			this.rentalDao.save(rental);
			return new SuccessResult("Araba kiralandı.");
		}
	}

	@Override
	public Result update(Rental rental) {
		
		this.rentalDao.save(rental);
		return new SuccessResult("Kiralama güncellendi.");
	}

	@Override
	public Result deleteById(int id) {
		
		this.rentalDao.deleteById(id);
		return new SuccessResult("Kiralama silindi.");
	}
	

	@Override
	public Result returnRentedCar(int id) {
		
		rentalToChangeActivityOrReturnDate = getById(id).getData();
		rentalToChangeActivityOrReturnDate.setReturnDate(LocalDate.now());
		this.rentalDao.save(rentalToChangeActivityOrReturnDate);
		return new SuccessResult("Araba geri getirildi.");
	}

	@Override
	public Result changeActivity(int id, boolean activity) {
		
	if (getById(id).getData() == null) {
		
		return new ErrorDataResult<>("Böyle bir kiralama yok.");
	}else {
		
		rentalToChangeActivityOrReturnDate = getById(id).getData();
		rentalToChangeActivityOrReturnDate.setActive(activity);
		this.rentalDao.save(rentalToChangeActivityOrReturnDate);
		return new SuccessResult("Kiralama aktifliği değiştirildi.");
	}
	
	}
	
}
