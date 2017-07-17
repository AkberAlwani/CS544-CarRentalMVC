package cs544.carrental.service;

import java.util.List;

import cs544.carrental.domain.Payment;
import cs544.carrental.domain.Reservation;


public interface PaymentService {
	public void addPayment(Payment payment, Reservation reservation);

	public List<Payment> findPaymentByID(String paymentId);

	public List<Payment> findAllPayment();

	public void cancelPayment(String paymentId);

	public Payment getPaymentObject(String paymentId);

	public void paymentUpdated(Payment payment, double amount);

	public double findTotalAmount(List<Payment> list);

	public List<Payment> searchPaymentByCustomerName(String customerName);
}
