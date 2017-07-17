package cs544.carrental.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;

import cs544.carrental.dao.ReservationDao;
import cs544.carrental.domain.Reservation;
import cs544.carrental.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired 
	ReservationDao reservationDAO;
	
	@Override
	public void save(Reservation reservation) {
		
		reservation.setReservationDateTime(new Date());
		reservationDAO.save(reservation);
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return reservationDAO.findAllOrderbyreservationIdDesc();
	}

	
	@Override
	public void delete(long id) {
		reservationDAO.delete(id);
	}

	@Override
	public Reservation findById(int id) {
		return reservationDAO.findByReservationId(id);
	}

	@Override
	public void update(Reservation res) {
		java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(res.getPickUpDateTime());
		sdf.format( res.getReturnDateTime());
		
		reservationDAO.update(new Date(),res.getPickUpDateTime(),res.getReturnDateTime(),res.getReservationId());
	}

	@Override
	public Reservation findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
