package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.domain.Product;
import cs544.carrental.rest.service.ProductRestService;
import cs544.carrental.rest.service.impl.ProductRestServiceImpl;
import cs544.carrental.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
 	@Qualifier("MVC")
	private ProductRestService productRestService;

	public List<Product> findAll() {
		return productRestService.findAll();
	}

 
 	public void addProduct(Product product) {
 		productRestService.save(product);
	}
	
	public Product findOne(long productID) {
		return productRestService.findOne(productID);
	}


	@Override
	public Product getWithCategory(Long productId) {
		return productRestService.getWithCategory(productId);
 	}

 

}
