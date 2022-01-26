package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentacar.business.abstracts.CarService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Car;

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
	public Result add(@RequestBody Car car) {
		return this.carService.add(car);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Car car) {
		return this.carService.update(car);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Car car) {
		return this.carService.delete(car);
	}
	
	@GetMapping("/getCarsByBrandId")
	public DataResult<List<Car>> getCarsByBrandId(int id) {
		return this.carService.getCarsByBrandId(id);
	}
	
	@GetMapping("/getCarsByColorId")
	public DataResult<List<Car>> getCarsByColorId(int id) {
		return this.carService.getCarsByColorId(id);
	}
}
