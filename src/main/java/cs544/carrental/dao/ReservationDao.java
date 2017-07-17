package cs544.carrental.dao;


import java.util.Date;
import java.util.List;


import cs544.carrental.domain.Reservation;


public interface ReservationDao extends  GenericDao<Reservation> {

	Reservation findByReservationId(int id);
//	@Transactional
//	@Modifying
//	@Query("Update Reservation Set reservationDateTime = :resDT, pickUpDateTime = :pUDT, returnDateTime = :rDT Where reservationId = :id")
//	void update(@Param("resDT") Date resDateTime,@Param("pUDT") Date date,@Param("rDT") Date date2,@Param("id") int reservationId);
//	
	
//	@Query("select r from Reservation r order by reservation_id Desc ")
	List<Reservation> findAllOrderbyreservationIdDesc();

	void update(Date date, Date pickUpDateTime, Date returnDateTime, long reservationId);
}
