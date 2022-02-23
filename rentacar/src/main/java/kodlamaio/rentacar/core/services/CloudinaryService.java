package kodlamaio.rentacar.core.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {

	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();
	
	public CloudinaryService () {
		
		valuesMap.put("cloud_name", "db7go4lqw");
		valuesMap.put("api_key", "573672573687662");
		valuesMap.put("api_secret", "Y2THdkEe_TM461pJ9843wP-v2jA");
		cloudinary = new Cloudinary(valuesMap); 
	}
	
	@SuppressWarnings("rawtypes")
	public Map upload(MultipartFile multipartFile) throws IOException {
		
		File file = convertFile(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public Map delete(String id) throws IOException {
		
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}
	
	private File convertFile(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;
	}
}
