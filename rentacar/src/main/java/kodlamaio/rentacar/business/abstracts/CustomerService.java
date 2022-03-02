package kodlamaio.rentacar.business.abstracts;

import java.util.List;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Customer;

public interface CustomerService {
	
	DataResult<List<Customer>> getAll();
	Result add(Customer customer);
	Result update(Customer customer);
	Result delete(Customer customer);
}
