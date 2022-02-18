package kodlamaio.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.rentacar.entities.concretes.CarImage;

public interface CarImageDao extends JpaRepository<CarImage, Integer>{

}
