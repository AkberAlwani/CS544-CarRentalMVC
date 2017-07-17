package cs544.carrental.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs544.carrental.dao.ReservationDao;
import cs544.carrental.domain.Person;
import cs544.carrental.domain.Reservation;

@SuppressWarnings("unchecked")
@Repository
public class ReservationDaoImpl extends GenericDaoImpl<Reservation> implements ReservationDao {

	public ReservationDaoImpl() {
		super.setDaoType(Reservation.class );
	}

	@Override
	public Reservation findByReservationId(int id) {
		Query query = entityManager.createQuery("select r from Reservation r  where r.reservationId=:id");
		return (Reservation) query.setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Reservation> findAllOrderbyreservationIdDesc() {
		Query query = entityManager.createQuery("select r from Reservation r  order by r.reservationId desc");
		return  query.getResultList();
	}

	@Override
	public void update(Date date, Date pickUpDateTime, Date returnDateTime, long reservationId) {
		Query query = entityManager.createQuery("Update Reservation set ");
		//return  query.getResultList();
		
		
	}
	
	
}
