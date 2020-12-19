package service;

import org.apache.ibatis.session.SqlSession;

import dao.OrderWordInfoDAO;
import tools.MybatisUtils;
import vo.OrderWordInfo;

public class OrderDBServrice {
	static public OrderWordInfo getOrderWInfo(String orderId) {
		SqlSession session = MybatisUtils.getSqlSession();
		OrderWordInfoDAO dao= session.getMapper(OrderWordInfoDAO.class);
		OrderWordInfo wordInfo = dao.getOrderById(orderId);
		return wordInfo;
		
	}

}
