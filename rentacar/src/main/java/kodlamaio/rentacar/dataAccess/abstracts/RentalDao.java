package kodlamaio.rentacar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.rentacar.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer>{

	@Query("From Rental where isActive = true")
	List<Rental> getAllActiveRentals();
}
