package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.OrderDAO;
import tools.MybatisUtils;
import vo.Order;

public class OrderDBServrice {
	static public Order getOrder(String orderId) {
		SqlSession session = MybatisUtils.getSqlSession();
		OrderDAO dao= session.getMapper(OrderDAO.class);
		Order order = dao.getOrderById(orderId);
		session.close();
		return order;
	}
	
	static public List<Order> getAllOrder(){
		SqlSession session = MybatisUtils.getSqlSession();
		OrderDAO dao= session.getMapper(OrderDAO.class);
		List<Order> list = dao.getAllOrder();
		session.close();
		return list;
	}

}
