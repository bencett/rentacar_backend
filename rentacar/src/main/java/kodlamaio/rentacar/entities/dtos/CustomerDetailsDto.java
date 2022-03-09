package kodlamaio.rentacar.entities.dtos;

import java.util.List;
import java.util.UUID;

import kodlamaio.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDto {

	private UUID customerId;
	private String companyName;
	private List<Rental> rentals;
}
