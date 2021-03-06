package kodlamaio.rentacar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/* -------------------------
	@Column(name="brand_id")
	private int brandId;
	
	@Column(name="color_id")
	private int colorId;
	----------------------------*/
	
	@Column(name="model_year")
	private int modelYear;
	
	@Column(name="daily_price")
	private int dailyPrice;
	
	@Column(name="description")
	private String description;
	
		@OneToMany
		@Column(name = "car_image_id")
		private List<CarImage> images;
	
		@ManyToOne
		@JoinColumn(name = "brand_id")
		private Brand brand;
	
		@ManyToOne//(cascade = CascadeType.ALL)
		@JoinColumn(name = "color_id")
		private Color color;
}
