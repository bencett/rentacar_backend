package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentacar.business.abstracts.CustomerService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

	private CustomerService customerService;
	
	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Customer>> getAll(){
		return this.customerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Customer customer) {
		return this.customerService.add(customer);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Customer customer) {
		return this.customerService.update(customer);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Customer customer) {
		return this.customerService.delete(customer);
	}
}
