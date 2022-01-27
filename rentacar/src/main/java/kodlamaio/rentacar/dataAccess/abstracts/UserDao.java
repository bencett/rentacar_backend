package kodlamaio.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.rentacar.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
