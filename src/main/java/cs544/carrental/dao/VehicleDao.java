package cs544.carrental.dao;

import java.util.List;

import cs544.carrental.domain.Vehicle;


public interface VehicleDao extends GenericDao<Vehicle> {


/*	List<Vehicle> findByBrandIgnoringCaseLikeAndTypeIgnoringCaseLikeAndVehiclePlateNumberIgnoringCaseLikeAndNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualOrderByVehicleIdDesc(
			String brand, String type, String VehiclePlateNumber, Integer NumberOfSeatsGreater, Double DailyPrice);

	List<Vehicle> findByBrandIgnoringCaseLikeAndTypeIgnoringCaseLikeAndVehiclePlateNumberIgnoringCaseLikeAndNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndIsAvailableOrderByVehicleIdDesc(
			String brand, String type, String VehiclePlateNumber, Integer NumberOfSeatsGreater, Double DailyPrice,
			Boolean isAvailable);
*/
	List<Vehicle> findByNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndDailyPriceGreaterThanEqualAndIsAvailableOrderByVehicleIdDesc(
			int seats, double maxDailyPrice, double minDailyPrice, boolean avaliable);

	List<Vehicle> findByNumberOfSeatsGreaterThanEqualAndDailyPriceLessThanEqualAndDailyPriceGreaterThanEqualOrderByVehicleIdDesc(
			int seats, double maxDailyPrice, double minDailyPrice);
	
//	@Modifying
//	@Query("update Vehicle v set v.brand = ?1, v.type = ?2, v.vehiclePlateNumber = ?3, v.model = ?4, v.numberOfSeats = ?5, v.dailyPrice = ?6, v.isAvailable = ?7 where v.vehicleId = ?8")

//	void setVehicleByVehicleId(String brand, String type, String vehiclePlateNumber, int model, int numberOfSeats,
//			double dailyPrice, Boolean isAvailable, int vehicleId);
	List<Vehicle> isAvaialble(Boolean flag);

	List<Vehicle> searh(Integer seats, Double minPrice, Double maxPrice, Boolean isAvailable);
}
