package kodlamaio.rentacar.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.RentalService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.ErrorResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.RentalDao;
import kodlamaio.rentacar.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService{
	
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
	public Result delete(Rental rental) {
		
		this.rentalDao.delete(rental);
		return new SuccessResult("Kiralama silindi.");
	}
}
