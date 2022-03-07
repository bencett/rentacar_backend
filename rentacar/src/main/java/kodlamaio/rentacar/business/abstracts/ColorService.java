package kodlamaio.rentacar.business.abstracts;


import java.util.List;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Color;

public interface ColorService {

	DataResult<List<Color>> getAll();
	Result add(Color color);
	Result update(Color color);
	Result deleteById(int id);
}
