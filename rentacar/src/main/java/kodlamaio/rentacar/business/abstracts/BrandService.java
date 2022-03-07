package kodlamaio.rentacar.business.abstracts;

import java.util.List;

import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Brand;

public interface BrandService {

	DataResult <List<Brand>> getAll();
	Result add(Brand brand);
	Result update(Brand brand);
	Result deleteById(int id);
}
