package cs544.carrental.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.VehicleDao;
import cs544.carrental.domain.Vehicle;
@SuppressWarnings("unchecked")
@Repository
public class VehicleDaoImpl extends GenericDaoImpl<Vehicle> implements VehicleDao {

	@Override
	public List<Vehicle> findByNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndDailyPriceGreaterThanEqualAndIsAvailableOrderByVehicleIdDesc(
			int seats, double maxDailyPrice, double minDailyPrice, boolean avaliable) {
		Query query = entityManager.createQuery("select v from Vehicle v where p.numberOfSeats >=:seats and p.maxPrice>=maxDailyPrice and p.minPrice>=minDailyPrice and p.isAvailable=avaliable" );
		return query.setParameter("seats", seats).setParameter("maxDailyPrice", maxDailyPrice)
				.setParameter("minDailyPrice", minDailyPrice).setParameter("avaliable", avaliable)
				.getResultList();
		}

	@Override
	public List<Vehicle> findByNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndDailyPriceGreaterThanEqualOrderByVehicleIdDesc(
			int seats, double maxDailyPrice, double minDailyPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
