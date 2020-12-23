package driver;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import function.MakeOrderFun;
import service.OrderDBServrice;
import vo.Order;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		OrderWordInfoDAO dao = new OrderWordInfoDAO();
//		OrderWordInfo wordInfo = dao.getById("7700000068784");
//		OrderGraphCode path = new OrderGraphCode();
//		CreateImageService code = new CreateImageService();
//		code.getImage(wordInfo);
		
//		OrderWordInfo wordInfo = OrderDBServrice.getOrderWInfo("7700000068784");
//		CreateImageFun code = new CreateImageFun();
//		code.getImage(wordInfo);
		
//		List<Order> list = OrderDBServrice.getAllOrder();
//		for (Order orderWordInfo : list) {
//			MakeOrderFun imageFun = new MakeOrderFun();
//			imageFun.getImage(orderWordInfo);
//		}
//		OrderWordInfo wordInfo = new OrderWordInfo("7700000068784","aaaaaaaaaa", "zhangsan", "1111111111", "bbbbbbbbbbbbbb", "lisi", "2222222222", "ccccccccccccc", "太原", "330-39E-1233", 12);
//		CreateImageFun image = new CreateImageFun();
//		image.getImage(wordInfo);
		
		//new ActionHandl();
	}

}

class  ActionHandl{
	private JFrame frame = new JFrame("物流订单");
	
	private JButton submit = new JButton("生成订单");
	private JButton reset = new JButton("清空");
	private JLabel orderLab = new JLabel("订单号:");
	private JLabel infoJLabe = new JLabel("");
	private JTextField orderIdField = new JTextField();
	
	public ActionHandl() {
		//设置orderLab的字体
		Font font = new Font("Serief",Font.BOLD,12);
		orderLab.setFont(font);
		
		//设置按钮的监听器,内部类的形式
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (arg0.getSource() == submit) {
					String orderId = orderIdField.getText();
					Order order = OrderDBServrice.getOrder(orderId);
					new MakeOrderFun().getImage(order);
					infoJLabe.setText("订单生成成功!");
				}
				
			}
		});
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (arg0.getSource() == reset) {
					orderIdField.setText("");
					infoJLabe.setText("");
				}
				
			}
		});
		
		frame.setLayout(null);//使用绝对定位
		orderLab.setBounds(5, 5, 60, 20);
		orderIdField.setBounds(65, 5, 150, 20);
		reset.setBounds(215, 5, 60, 20);
		submit.setBounds(60, 30, 80, 20 );
		infoJLabe.setBounds(50, 80, 100, 20);
		
		frame.add(orderLab);
		frame.add(orderIdField);
		frame.add(reset);
		frame.add(submit);
		frame.add(infoJLabe);
		frame.setLocation(200,100);
		frame.setSize(400,300);
		frame.setVisible(true);
		
	}
}

//class DefaultTable extends AbstractTableModel {
//	private String[] titles = {"订单号","始发地","发件人","发件人电话","发件人地址","收件人","收件人电话","收件人地址","集包地","订单编码","订单数量","是否生成"};
//	
//	private Object[][] orderTable = new Object[1][12];
//	
//	public void setOrderTable(Object[][] orderTable) {
//		this.orderTable = orderTable;
//	}
//	
//	@Override
//	public int getColumnCount() {
//		// TODO 自动生成的方法存根
//		return 0;
//	}
//
//	@Override
//	public int getRowCount() {
//		// TODO 自动生成的方法存根
//		return 0;
//	}
//
//	@Override
//	public Object getValueAt(int arg0, int arg1) {
//		// TODO 自动生成的方法存根
//		return this.orderTable[arg0][arg1];
//	}
//
//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		// TODO 自动生成的方法存根
//		return this.getValueAt(0, columnIndex).getClass();
//	}
//
//	@Override
//	public String getColumnName(int column) {
//		// TODO 自动生成的方法存根
//		return this.titles[column];
//	}
//
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		// TODO 自动生成的方法存根
//		return true;
//	}
//
//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		// TODO 自动生成的方法存根
//		this.orderTable[rowIndex][columnIndex] = aValue;
//	}
//}

