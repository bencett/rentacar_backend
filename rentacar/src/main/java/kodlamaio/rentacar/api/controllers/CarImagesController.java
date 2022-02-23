package kodlamaio.rentacar.api.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.rentacar.business.abstracts.CarImageService;
import kodlamaio.rentacar.core.services.CloudinaryService;
import kodlamaio.rentacar.core.utilities.results.DataResult;
import kodlamaio.rentacar.core.utilities.results.ErrorResult;
import kodlamaio.rentacar.core.utilities.results.Result;
import kodlamaio.rentacar.core.utilities.results.SuccessResult;
import kodlamaio.rentacar.entities.concretes.CarImage;

@RestController
@RequestMapping("/api/carImages")
@CrossOrigin
public class CarImagesController {

	private CarImageService carImageService;
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	/*
	@SuppressWarnings("unchecked")
	@PostMapping("/upload")
	public ResponseEntity<?> upload(int carId, @RequestPart MultipartFile multipartFile) throws IOException {
		BufferedImage bImage = ImageIO.read(multipartFile.getInputStream());
		if (bImage == null) {
			return new ResponseEntity(new ErrorResult("Fotoğraf yok."),HttpStatus.BAD_REQUEST);
		}
		Map result = cloudinaryService.upload(carId, multipartFile);
		CarImage carImage = new CarImage((String)result.get("url"));
		carImageService.add(carImage);
		return new ResponseEntity(new SuccessResult("Resim yüklendi."),HttpStatus.OK);
	}
	*/
	@DeleteMapping("/deleteImage/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException {
		Map result = cloudinaryService.delete(id);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CarImage>> getAll(){
		return this.carImageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam("carImage") CarImage carImage, @RequestPart("multipartFile") MultipartFile multipartFile) {
		return this.carImageService.add(carImage, multipartFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CarImage carImage) {
		return this.carImageService.update(carImage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody CarImage carImage) {
		return this.carImageService.delete(carImage);
	}
}
