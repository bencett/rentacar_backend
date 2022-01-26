package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentacar.business.abstracts.ColorService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Color;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

	private ColorService colorService;
	
	public ColorsController(ColorService colorService) {
	super();
	this.colorService = colorService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Color>> getAll(){
		return this.colorService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Color color) {
		return this.colorService.add(color);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Color color) {
		return this.colorService.update(color);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Color color) {
		return this.colorService.delete(color);
	}
}
