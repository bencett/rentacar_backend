package kodlamaio.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.rentacar.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
