package com.kgitbank.ssg.product.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductFileService implements IProductFileService{

	@Override
	public String saveFile(MultipartFile file) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss-");
		Date date = new Date();
		String fileName = sdf.format(date);
		fileName += file.getOriginalFilename();
		
		File saveFile = new File(IMAGE_REPO+"/"+fileName);
		
		try {
			file.transferTo(saveFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return fileName;
	}

	@Override
	public String getMessage(String msg, String url) {
		String message = "<script>alert('"+msg+"');";
		message += "location.href='"+url+"';";
		message += "</script>";
		
		return message;
	}

	@Override
	public void imageFileDelete(String imageFileName) {
		File file = new File(IMAGE_REPO + "/" + imageFileName);
		file.delete();
	}
	
	
}
