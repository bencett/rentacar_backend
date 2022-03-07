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
import kodlamaio.rentacar.business.abstracts.UserService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@ModelAttribute User user) {
		return this.userService.add(user);
	}
	
	@PostMapping("/update")
	public Result update(@ModelAttribute User user) {
		return this.userService.update(user);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public Result delete(@RequestParam int id) {
		return this.userService.deleteById(id);
	}
}
