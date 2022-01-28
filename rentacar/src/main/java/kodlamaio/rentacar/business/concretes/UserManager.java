package kodlamaio.rentacar.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.rentacar.business.abstracts.UserService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessDataResult;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.dataAccess.abstracts.UserDao;
import kodlamaio.rentacar.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"User'lar listelendi.");
	}

	@Override
	public Result add(User user) {
		
		this.userDao.save(user);
		return new SuccessResult("User eklendi.");
	}

	@Override
	public Result update(User user) {
		
		this.userDao.save(user);
		return new SuccessResult("User güncellendi.");
	}

	@Override
	public Result delete(User user) {
		
		this.userDao.delete(user);
		return new SuccessResult("User silindi.");
	}
}
