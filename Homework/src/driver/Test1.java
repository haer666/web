package driver;

import java.sql.SQLException;

import dao.OrderWordInfoDAO;
import function.CreateImageFun;
import service.OrderDBServrice;
import vo.OrderWordInfo;
import vo.OrderGraphCode;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		OrderWordInfoDAO dao = new OrderWordInfoDAO();
//		OrderWordInfo wordInfo = dao.getById("7700000068784");
//		OrderGraphCode path = new OrderGraphCode();
//		CreateImageService code = new CreateImageService();
//		code.getImage(wordInfo);
		
		OrderWordInfo wordInfo = OrderDBServrice.getOrderWInfo("7700000068784");
		CreateImageFun code = new CreateImageFun();
		code.getImage(wordInfo);
	}

}
