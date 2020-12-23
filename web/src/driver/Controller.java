package driver;

import javax.swing.JTable;

import function.MakeOrderFun;
import vo.Order;

public class Controller {
	static public void orderGenerator(JTable oT) {
		MakeOrderFun m = new MakeOrderFun();
		int rowCount = oT.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			if((Boolean)oT.getValueAt(i, 11)&&(Boolean)oT.getValueAt(i, 11)!=null)
				m.getImage(new Order((String)oT.getValueAt(i,0),(String)oT.getValueAt(i,1),(String)oT.getValueAt(i,2),
						(String)oT.getValueAt(i,3),(String)oT.getValueAt(i,4),(String)oT.getValueAt(i,5),(String)oT.getValueAt(i,6),
						(String)oT.getValueAt(i,7),(String)oT.getValueAt(i,8),(String)oT.getValueAt(i,9),(int)oT.getValueAt(i,10)));
		}
	}
	
	static public void setState(JTable table,Boolean state) {
		for(int i = 0; i < table.getRowCount(); i++) {
			table.setValueAt(state, i, 11);
		}
	}
}
