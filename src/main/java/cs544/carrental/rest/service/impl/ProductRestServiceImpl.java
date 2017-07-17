package cs544.carrental.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import cs544.carrental.domain.Product;
import cs544.carrental.rest.RestHttpHeader;
import cs544.carrental.rest.service.ProductRestService;

@Component("MVC")
public class ProductRestServiceImpl  implements ProductRestService {

	@Autowired
	RestHttpHeader remoteApi;
	
	public List<Product> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		List<Product> productList = Arrays.asList(restTemplate.exchange("http://localhost:8080/MemberRest/products/", 
				HttpMethod.GET, remoteApi.getHttpEntity(), Product[].class).getBody());
                               //remoteApi.getHttpEntity() - get HTTP headers [Authentication; JSON ACCEPT]
		return productList;
	}

	public Product findOne(Long index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/MemberRest/products/"+ index, 
 				HttpMethod.GET, remoteApi.getHttpEntity(), Product.class).getBody());
                                                           // Returns Product in Body HTTP Message 
	}
	
	public Product getWithCategory(Long productId) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/MemberRest/products/withCategory/"+ productId, 
 				HttpMethod.GET, remoteApi.getHttpEntity(), Product.class).getBody());
                                                           // Returns Product in Body HTTP Message 
	
	}


	public Product save(Product product) {
		try {

		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/MemberRest/products/add/", 
				        httpEntity, Product.class);
                                     // Product.class - Response type
 		}
		catch (RestClientException exce) {
			System.out.println("ERROR: " + exce.getMessage());
		}
		return null;
	}

}
