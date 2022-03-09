package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getAllActiveRentals")
	public DataResult<List<Rental>> getAllActiveRentals() {
		return this.rentalService.getAllActiveRentals();
	}
	
	@GetMapping("/getById/{id}")
	public DataResult<Rental> getById(@RequestParam int id) {
		return this.rentalService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@ModelAttribute Rental rental) {
		return this.rentalService.add(rental);
	}
	
	@PostMapping("/update")
	public Result update(@ModelAttribute Rental rental) {
		return this.rentalService.update(rental);
	}
	
	@DeleteMapping("/deleteById")
	public Result delete(@RequestParam int id) {
		return this.rentalService.deleteById(id);
	}
	
	@PostMapping("/returnRentedCar/{id}")
	public Result returnRentedCar(@RequestParam int id) {
		return this.rentalService.returnRentedCar(id);
	}
	
	@PostMapping("/changeActivity")
	public Result changeActivity(@RequestParam int id,@RequestParam boolean activity) {
		return this.rentalService.changeActivity(id,activity);
	}
}
