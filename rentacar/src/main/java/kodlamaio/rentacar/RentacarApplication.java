package kodlamaio.rentacar;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;

@SpringBootApplication
@EnableSwagger2
public class RentacarApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RentacarApplication.class, args);
		/*
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "db7go4lqw",
				"api_key", "573672573687662",
				"api_secret", "Y2THdkEe_TM461pJ9843wP-v2jA",
				"secure", true));
		
		File file = new File("golf_1.jpg");
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		*/
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamaio.rentacar"))                          
          .build();                                           
    }
}
