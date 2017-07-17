package cs544.carrental.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.carrental.dao.VehicleDao;
import cs544.carrental.domain.Vehicle;
import cs544.carrental.service.VehicleService;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public void save(Vehicle vehicle) {
		vehicleDao.save(vehicle);
	}

	@Override
	public List<Vehicle> getAll() {
		return vehicleDao.findAll();
	}

	@Override
	public void delete(long vehicleId) {
		vehicleDao.delete(vehicleId);
		
	}

	@Override
	public void update(Vehicle vehicle) {
		vehicleDao.update(vehicle);
		
	}

	

	@Override
	public List<Vehicle> search(Integer seats, Double minPrice, Double maxPrice, Boolean isAvailable) {
		return vehicleDao.searh(seats,minPrice,maxPrice,isAvailable);
	}

	@Override
	public List<Vehicle> isAvailable(Boolean flag) {
		return vehicleDao.isAvaialble(flag);
	}

	@Override
	public Vehicle findByVehicleId(long vehicleId) {
		return vehicleDao.findOne(vehicleId);
	}

	
}
