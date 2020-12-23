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
//		OrderWordInfo wordInfo = new OrderWordInfo("7700000068784","aaaaaaaaaa", "zhangsan", "1111111111", "bbbbbbbbbbbbbb", "lisi", "2222222222", "ccccccccccccc", "̫ԭ", "330-39E-1233", 12);
//		CreateImageFun image = new CreateImageFun();
//		image.getImage(wordInfo);
		
		//new ActionHandl();
	}

}

class  ActionHandl{
	private JFrame frame = new JFrame("��������");
	
	private JButton submit = new JButton("���ɶ���");
	private JButton reset = new JButton("���");
	private JLabel orderLab = new JLabel("������:");
	private JLabel infoJLabe = new JLabel("");
	private JTextField orderIdField = new JTextField();
	
	public ActionHandl() {
		//����orderLab������
		Font font = new Font("Serief",Font.BOLD,12);
		orderLab.setFont(font);
		
		//���ð�ť�ļ�����,�ڲ������ʽ
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				if (arg0.getSource() == submit) {
					String orderId = orderIdField.getText();
					Order order = OrderDBServrice.getOrder(orderId);
					new MakeOrderFun().getImage(order);
					infoJLabe.setText("�������ɳɹ�!");
				}
				
			}
		});
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				if (arg0.getSource() == reset) {
					orderIdField.setText("");
					infoJLabe.setText("");
				}
				
			}
		});
		
		frame.setLayout(null);//ʹ�þ��Զ�λ
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
//	private String[] titles = {"������","ʼ����","������","�����˵绰","�����˵�ַ","�ռ���","�ռ��˵绰","�ռ��˵�ַ","������","��������","��������","�Ƿ�����"};
//	
//	private Object[][] orderTable = new Object[1][12];
//	
//	public void setOrderTable(Object[][] orderTable) {
//		this.orderTable = orderTable;
//	}
//	
//	@Override
//	public int getColumnCount() {
//		// TODO �Զ����ɵķ������
//		return 0;
//	}
//
//	@Override
//	public int getRowCount() {
//		// TODO �Զ����ɵķ������
//		return 0;
//	}
//
//	@Override
//	public Object getValueAt(int arg0, int arg1) {
//		// TODO �Զ����ɵķ������
//		return this.orderTable[arg0][arg1];
//	}
//
//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		// TODO �Զ����ɵķ������
//		return this.getValueAt(0, columnIndex).getClass();
//	}
//
//	@Override
//	public String getColumnName(int column) {
//		// TODO �Զ����ɵķ������
//		return this.titles[column];
//	}
//
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		// TODO �Զ����ɵķ������
//		return true;
//	}
//
//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		// TODO �Զ����ɵķ������
//		this.orderTable[rowIndex][columnIndex] = aValue;
//	}
//}

