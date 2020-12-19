package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tools.DBTool;
import vo.OrderWordInfo;

public interface OrderWordInfoDAO {
	
	public OrderWordInfo getOrderById(String orderId);
	
	public OrderWordInfo getAllOrder();
	
//	public OrderWordInfo getById(String orderId) throws ClassNotFoundException, SQLException{
//		OrderWordInfo info=null;
//		DBTool dbc=new DBTool();
//		Connection con;
//		con = dbc.getConnection();
//		try{
//			String sql="select* from order_t where orderId=?";
//			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//			ps.setString(1,orderId);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()){
//				info=new OrderWordInfo(rs.getString("orderId"),rs.getString("begin"),rs.getString("sender"),rs.getString("senderPhone"),
//						rs.getString("senderAddress"),rs.getString("receiver"),rs.getString("receiverPhone"),
//						rs.getString("receiverAddress"),rs.getString("jibaodi"),rs.getString("areaCode"),rs.getInt("count"));
//			}
//			}
//		catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			dbc.close();
//		}
//		return info;
//	}
//	
//	public ArrayList<OrderWordInfo> getAllOrder() throws ClassNotFoundException, SQLException{
//		ArrayList<OrderWordInfo> list = new ArrayList<OrderWordInfo>();
//		DBTool dbc=new DBTool();
//		Connection con=dbc.getConnection();
//		try{
//			String sql="select* from order_t?";
//			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);	
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()){
//				OrderWordInfo wInfo = new OrderWordInfo(
//						rs.getString("orderId"),rs.getString("begin"),rs.getString("sender"),rs.getString("senderPhone"),
//						rs.getString("senderAddress"),rs.getString("receiver"),rs.getString("receiverPhone"),
//						rs.getString("receiverAddress"),rs.getString("jibaodi"),rs.getString("areaCode"),rs.getInt("count"));
//				list.add(wInfo);
//				}
//			}
//		catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			dbc.close();
//		}
//		return list;
//	}
	
	

	
}
