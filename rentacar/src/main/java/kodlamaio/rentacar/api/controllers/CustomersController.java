package kodlamaio.rentacar.api.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getByCustomerId/{id}")
	public DataResult<Customer> getByCustomerId(@RequestParam UUID id){
		return this.customerService.getByCustomerId(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Customer customer) {
		return this.customerService.add(customer);
	}
	
	@PostMapping("/update")
	public Result update(@ModelAttribute Customer customer) {
		return this.customerService.update(customer);
	}

	@DeleteMapping("/deleteByCustomerId/{id}")
	public Result delete(@RequestParam("id") UUID id) {
		return this.customerService.deleteByCustomerId(id);
	}

}
