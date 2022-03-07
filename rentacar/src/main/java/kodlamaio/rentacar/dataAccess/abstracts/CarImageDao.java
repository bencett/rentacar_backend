package kodlamaio.rentacar.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.rentacar.entities.concretes.CarImage;

@Repository
public interface CarImageDao extends JpaRepository<CarImage, Integer>{
	
	List<CarImage> getCarImagesByCarId(int carId);
}
