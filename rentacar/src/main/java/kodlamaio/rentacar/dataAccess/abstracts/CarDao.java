package kodlamaio.rentacar.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.rentacar.entities.concretes.Car;
import kodlamaio.rentacar.entities.dtos.CarDetailsDto;

public interface CarDao extends JpaRepository<Car, Integer>{
	
	List<Car> getCarsByBrandId(int brandId);
	
	List<Car> getCarsByColorId(int colorId);
	
	@Query("Select new kodlamaio.rentacar.entities.dtos.CarDetailsDto"
			+ "(c.description, b.name, cl.name, c.dailyPrice )"
			+ "From Car c Inner Join c.brand b Inner Join c.color cl")
	List<CarDetailsDto> getCarDetails();
}
