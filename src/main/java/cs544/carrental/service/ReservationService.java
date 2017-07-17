package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Reservation;


public interface ReservationService {
	void save(Reservation reservation);
	List<Reservation> getAll();
	void delete(Reservation reservation);
	void delete(int id);
	Reservation findById(int id);
	void update(Reservation res);
	
}
