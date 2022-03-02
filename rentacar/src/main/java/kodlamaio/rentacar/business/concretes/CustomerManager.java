package kodlamaio.rentacar.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentacar.business.abstracts.CustomerService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.CustomerDao;
import kodlamaio.rentacar.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	
	@Autowired
	public CustomerManager(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		
		return new SuccessDataResult<List<Customer>>
		(this.customerDao.findAll(),"Müşteriler listelendi.");
	}

	@Override
	public Result add(Customer customer) {
		
		this.customerDao.save(customer);
		return new SuccessResult("Müşteri eklendi.");
	}

	@Override
	public Result update(Customer customer) {
		
		this.customerDao.save(customer);
		return new SuccessResult("Müşteri güncellendi.");
	}

	@Override
	public Result delete(Customer customer) {
		
		this.customerDao.delete(customer);
		return new SuccessResult("Müşteri silindi.");
	}
}
