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
import kodlamaio.rentacar.business.abstracts.BrandService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Brand>> getAll(){
		return this.brandService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@ModelAttribute Brand brand) {
		return this.brandService.add(brand);
	}
	
	@PostMapping("/update")
	public Result update(@ModelAttribute Brand brand) {
		return this.brandService.update(brand);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Result delete(@RequestParam int id) {
		return this.brandService.deleteById(id);
	}
}
