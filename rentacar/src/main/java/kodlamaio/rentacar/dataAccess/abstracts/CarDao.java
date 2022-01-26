package kodlamaio.rentacar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.rentacar.entities.concretes.Car;

public interface CarDao extends JpaRepository<Car, Integer>{
	
	List<Car> getCarsByBrandId(int brandId);
	List<Car> getCarsByColorId(int colorId);
}
