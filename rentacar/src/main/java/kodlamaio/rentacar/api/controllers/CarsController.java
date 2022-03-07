package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentacar.business.abstracts.CarService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Car;
import kodlamaio.rentacar.entities.dtos.CarDetailsDto;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	
	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Car>> getAll(){
		return this.carService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@ModelAttribute Car car) {
		return this.carService.add(car);
	}
	
	@PostMapping("/update")
	public Result update(@ModelAttribute Car car) {
		return this.carService.update(car);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Result deleteById(@RequestParam int id) {
		return this.carService.deleteById(id);
	}
	
	@GetMapping("/getCarsByBrandId")
	public DataResult<List<Car>> getCarsByBrandId(int id) {
		return this.carService.getCarsByBrandId(id);
	}
	
	@GetMapping("/getCarsByColorId")
	public DataResult<List<Car>> getCarsByColorId(int id) {
		return this.carService.getCarsByColorId(id);
	}
	
	@GetMapping("/getCarDetails")
	public DataResult<List<CarDetailsDto>> getCarDetails() {
		return this.carService.getCarDetails();
	}
}
