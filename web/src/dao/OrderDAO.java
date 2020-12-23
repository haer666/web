package dao;

import java.util.List;

import vo.Order;

public interface OrderDAO {
	
	public Order getOrderById(String orderId);
	
	public List<Order> getAllOrder();	
}
