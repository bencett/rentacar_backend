package kodlamaio.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.rentacar.entities.concretes.Rental;

public interface RentalDao extends JpaRepository<Rental, Integer>{

}
