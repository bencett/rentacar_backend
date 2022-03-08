package kodlamaio.rentacar.business.abstracts;

import java.util.List;
import java.util.UUID;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Customer;

public interface CustomerService {
	
	DataResult<List<Customer>> getAll();
	DataResult<Customer> getByCustomerId(UUID id);
	Result add(Customer customer);
	Result update(Customer customer);
	Result deleteByCustomerId(UUID id);
}
