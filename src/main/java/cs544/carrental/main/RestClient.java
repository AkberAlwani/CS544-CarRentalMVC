package cs544.carrental.main;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import cs544.carrental.rest.RestHttpHeader;
import cs544.carrental.service.ProductService;

@Component
public class RestClient
{
	@Autowired
	RestHttpHeader remoteApi;

	@Autowired
	ProductService productService;
	

	public static void main(String[] args)
	{
 	    final ApplicationContext applicationContext =
	            new ClassPathXmlApplicationContext("context/applicationContext.xml");
 	 
		applicationContext.getBean(RestClient.class).mainInternal(applicationContext);
	      }
	
	        private void mainInternal(ApplicationContext applicationContext) {
 
/*	  	   		Product product = productService.findOne(1);
	   	   		System.out.println();
	  	   		System.out.println("single Product " + product.getName()); 
	  	   		System.out.println(); 


  	   		List<Product> products = productService.findAll();
 	        for (Product productTemp : products) {
	    		System.out.println("Product " + productTemp.getName());
 		    		System.out.println("       Category " + productTemp.getCategory().getName());

 	        }
  	   		System.out.println(); 
	        
*/  	   		
  		    Category category = new Category();
  		    category.setName("Recreation");
  		    
  		 
  		    Product product = new Product();
  		    product.setName("Frisbee");
  		    product.setDescription("Woo Hoo!");
  		    product.setPrice(2.0F);
//  		    product.addCategory(category);
  		    
 // 		    category2.addProduct(product);

  		  productService.addProduct(product);
  		  
 //   		product = productService.findOne(1);   // LAZY category == category is null
      		product = productService.getWithCategory(1L);   //Loaded CATEGORY
	   		System.out.println();
	   		System.out.println("single Product " + product.getName()); 
    		System.out.println("       Category " + product.getCategories().get(0).getName());
	   		System.out.println(); 	  
 
/*  		List<Product>  products = productService.findAll();
 	        for (Product productt : products) {
	    		System.out.println("Product " + productt.getName());
	    		System.out.println("       Category " + productt.getCategory().getName());


	        }*/
 
	}
}
