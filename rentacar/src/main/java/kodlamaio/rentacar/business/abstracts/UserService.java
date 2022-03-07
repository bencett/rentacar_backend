package kodlamaio.rentacar.business.abstracts;

import java.util.List;

import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	Result add(User user);
	Result update(User user);
	Result deleteById(int id);
}
