package kodlamaio.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.rentacar.entities.concretes.Color;

public interface ColorDao extends JpaRepository<Color, Integer>{

}
