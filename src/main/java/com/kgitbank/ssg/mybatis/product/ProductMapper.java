package com.kgitbank.ssg.mybatis.product;

import java.util.List;

import com.kgitbank.ssg.product.dto.ProductDTO;

public interface ProductMapper {

	public List<ProductDTO> getOuterType();
	public int productSave(ProductDTO dto);
	public List<ProductDTO> getProductList();
}
