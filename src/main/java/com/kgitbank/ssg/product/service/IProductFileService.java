package com.kgitbank.ssg.product.service;

import org.springframework.web.multipart.MultipartFile;

public interface IProductFileService {

	public String IMAGE_REPO = "c:/sg_images";
	public String saveFile(MultipartFile file);
	public String getMessage(String msg, String url);
}
