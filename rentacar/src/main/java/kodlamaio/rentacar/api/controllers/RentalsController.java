package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentacar.business.abstracts.RentalService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Rental;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

	private RentalService rentalService;
	
	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Rental>> getAll(){
		return this.rentalService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Rental rental) {
		return this.rentalService.add(rental);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Rental rental) {
		return this.rentalService.update(rental);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Rental rental) {
		return this.rentalService.delete(rental);
	}
}
