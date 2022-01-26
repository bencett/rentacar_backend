package kodlamaio.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.rentacar.entities.concretes.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{

}
