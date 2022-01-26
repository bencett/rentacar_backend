package kodlamaio.rentacar.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.BrandService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.BrandDao;
import kodlamaio.rentacar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandDao brandDao;
	
	public BrandManager (BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}
	
	@Override
	public DataResult <List<Brand>> getAll() {
		
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(),"Markalar listelendi.");
	}

	@Override
	public Result add(Brand brand) {
		
		this.brandDao.save(brand);
		return new SuccessResult("Marka eklendi.");
	}

	@Override
	public Result update(Brand brand) {
		
		this.brandDao.save(brand);
		return new SuccessResult("Marka güncellendi.");
	}

	@Override
	public Result delete(Brand brand) {
		
		this.brandDao.delete(brand);
		return new SuccessResult("Marka silindi.");
	}

}
