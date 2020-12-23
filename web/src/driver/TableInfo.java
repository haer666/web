package driver;

import java.util.List;

import service.OrderDBServrice;
import vo.Order;

public class TableInfo {
	static private String[] titles = {"订单号","始发地","发件人","发件人电话","发件人地址","收件人","收件人电话","收件人地址","集包地","订单编码","订单数量","是否生成"};
	
	static private Object[][] orderTable;
	
	static {
		List<Order> orderList = OrderDBServrice.getAllOrder();
		orderTable = new Object[orderList.size()][12];
		int i = 0;
		for (Order order : orderList) {
			orderTable[i][0] = order.getOrderId();
			orderTable[i][1] = order.getBegin();
			orderTable[i][2] = order.getSender();
			orderTable[i][3] = order.getSenderPhone();
			orderTable[i][4] = order.getSenderAddress();
			orderTable[i][5] = order.getReceiver();
			orderTable[i][6] = order.getReceiverPhone();
			orderTable[i][7] = order.getReceiverAddress();
			orderTable[i][8] = order.getJibaodi();
			orderTable[i][9] = order.getAreaCode();
			orderTable[i][10] = order.getCount();
			orderTable[i][11] = false;
			i++;
		}
		
	}
	
	static public String[] getTiles() {
		return titles;
	}
	
	static public Object[][] getOrderTable(){
		return orderTable;
	}
}
