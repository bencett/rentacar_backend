package kodlamaio.rentacar.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.ColorService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.ColorDao;
import kodlamaio.rentacar.entities.concretes.Color;

@Service
public class ColorManager implements ColorService{

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}
	
	@Override
	public DataResult<List<Color>> getAll() {
		
		return new SuccessDataResult<List<Color>>
		(this.colorDao.findAll(),"Renkler listelendi.");
	}

	@Override
	public Result add(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("Renk eklendi.");
	}

	@Override
	public Result update(Color color) {
		
		this.colorDao.save(color);
		return new SuccessResult("Renk güncellendi.");
	}

	@Override
	public Result deleteById(int id) {

		this.colorDao.deleteById(id);
		return new SuccessResult("Renk silindi.");
	}

}
