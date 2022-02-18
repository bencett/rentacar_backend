package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentacar.business.abstracts.CarImageService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.CarImage;

@RestController
@RequestMapping("/api/carImages")
public class CarImagesController {

	private CarImageService carImageService;
	
	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CarImage>> getAll(){
		return this.carImageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CarImage carImage) {
		return this.carImageService.add(carImage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CarImage carImage) {
		return this.carImageService.update(carImage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody CarImage carImage) {
		return this.carImageService.delete(carImage);
	}
}
