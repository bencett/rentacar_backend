package kodlamaio.rentacar.dataAccess.abstracts;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.rentacar.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	@Modifying
	@Transactional
	@Query(value="DELETE FROM Customer c WHERE c.id = :id")
	void deleteByCustomerId(UUID id);
	
	@Query("SELECT c FROM Customer c WHERE c.id = :id")
	Customer getByCustomerId(UUID id);
	/*
	@Query("SELECT new kodlamaio.rentacar.entities.dtos.CustomerDetailsDto"
			+ "(c.customerId, c.companyId, r.rental)")
	Customer getCustomerWithRentals();*/
}
