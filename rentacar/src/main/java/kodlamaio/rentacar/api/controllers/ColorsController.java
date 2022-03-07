package kodlamaio.rentacar.api.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Result add(@ModelAttribute Color color) {
		return this.colorService.add(color);
	}
	
	@PostMapping("/update")
	public Result update(@ModelAttribute Color color) {
		return this.colorService.update(color);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Result delete(@RequestParam int id) {
		return this.colorService.deleteById(id);
	}
}
