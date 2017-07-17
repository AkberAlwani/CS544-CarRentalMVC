package cs544.carrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs544.carrental.dao.PersonDao;
import cs544.carrental.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
// 	@Autowired
// 	@Qualifier("MVC")
//	private ProductRestService productRestService;

	@Autowired
	PersonDao personDao;
	
 

}
