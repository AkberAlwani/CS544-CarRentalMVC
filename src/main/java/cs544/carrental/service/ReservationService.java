package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Reservation;


public interface ReservationService {
	void save(Reservation reservation);
	List<Reservation> getAll();
	
	void delete(long id);
	Reservation findById(long id);
	void update(Reservation res);
	Reservation findById(int id);
	
}
