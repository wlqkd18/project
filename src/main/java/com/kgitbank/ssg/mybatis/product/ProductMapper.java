package com.kgitbank.ssg.mybatis.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kgitbank.ssg.product.dto.ProductDTO;

public interface ProductMapper {

	public List<ProductDTO> getProduct(String productType);
	public int productSave(ProductDTO dto);
	public List<ProductDTO> getProductList();
	public ProductDTO getProductInfo(int productNo);
	public int productDelete(int productNo);
	public int productModify(ProductDTO dto);
	public ArrayList<ProductDTO> getProductBasket(ArrayList basketNo);
}
