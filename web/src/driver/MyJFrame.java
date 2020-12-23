package driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import function.MakeOrderFun;

public class MyJFrame implements ActionListener,ItemListener{//ʵ���¼�����
	private JFrame jFrame;//ʵ�����������
	private JTable table;				//����JTable����
	private DefaultTableModel tableModel;//����DefaultTableModel����
	
	private TableRowSorter<DefaultTableModel> sorter;	//������
	private JButton addRowBtn;
	private JButton removeRowBtn;       
	private JTextField filterText;
	private JTextField statusText;
	private JTextField orderPath;
	private JTextField defaultOrderPath = new JTextField(MakeOrderFun.orderPath);
	private JButton browseBtn;
	private JButton orderMakeBtn;
	private JRadioButton allSelectBox = new JRadioButton("ȫѡ");
	private JRadioButton allEmptyBox = new JRadioButton("���");
	private JCheckBox checkBox = new JCheckBox("Ĭ��·��:");
	

	
	public MyJFrame() {
		// TODO �Զ����ɵĹ��캯�����
		jFrame = new JFrame("������");
		tableModel = new DefaultTableModel(TableInfo.getOrderTable(),TableInfo.getTiles());
		//tableModel.getColumnClass(columnIndex)
		table = new JTable(tableModel);//����tableModel��ʾ����
		sorter = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(sorter);		//Ϊ�����ӹ���
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //When selection changes, provide user with row numbers for
        //both view and model.
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = table.getSelectedRow();
                        if (viewRow < 0) {
                            //Selection got filtered away.
                            statusText.setText("");
                        } else {
                            int modelRow = 
                                table.convertRowIndexToModel(viewRow);
                            statusText.setText(
                                String.format("Selected Row in view: %d. ", 
                                    viewRow, modelRow));
                        }
                    }
                }
        );
		TableColumn tc = table.getColumnModel().getColumn(11);//Ϊ������һ�����ø�ѡ��
		tc.setCellEditor(table.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		
		addRowBtn = new JButton("������");
		removeRowBtn = new JButton("ɾ����");
		JLabel orderLabel = new JLabel("����·��:");
		browseBtn = new JButton("���");
		orderMakeBtn = new JButton("���ɶ���");
		orderPath = new JTextField();
		
		              //�������,���ڶ���
//		northBar.add(addRowBtn);
//		northBar.add(removeRowBtn);//�������Ӱ�ť
//		northBar.add(allEmptyBox);
//		northBar.add(allSelectBox);
		ButtonGroup buttonGroup = new ButtonGroup();//��������ѡ����뵽һ����ť������
		buttonGroup.add(allEmptyBox);
		buttonGroup.add(allSelectBox);
		//northBar.setBounds(0, 0, 960,40);
		addRowBtn.setBounds(5,5,80,30);
		removeRowBtn.setBounds(70,5,80,30);
		allEmptyBox.setBounds(840,5,60,30);
		allSelectBox.setBounds(900,5,60,30);
		
		JScrollPane scr = new JScrollPane(table);//Ϊ�����ӹ���������������
		scr.setBounds(0, 40, 960, 300);
		//label.setBounds(50, 600, 60, 20);
		//orderPath.setBounds(110, 600, 180, 20);
		//browse.setBounds(290, 600, 60, 20);
		
		JLabel filterLabel = new JLabel("�����ı�:");
		filterText = new JTextField();
		JLabel sLabel = new JLabel("�����ı�:");
		statusText = new JTextField();
		//Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
        
        filterLabel.setBounds(240,370,60,25);
		filterText.setBounds(300,370,180,25);
		sLabel.setBounds(480,370,60,25);
		statusText.setBounds(540,370,180,25);
		
		
//		JPanel southBar = new JPanel();
//		southBar.setLayout(null);
		checkBox.setBounds(220,425,80,25);
		defaultOrderPath.setBounds(300,425,180,25);
		defaultOrderPath.setEditable(false);
		orderLabel.setBounds(240,460,60,25);
		orderPath.setBounds(300,460,180,25);
		browseBtn.setBounds(480,460,60,25);
		orderMakeBtn.setBounds(460,520,100,25);
//		southBar.add(label);
//		southBar.add(orderPath);
//		southBar.add(browse);
		//allCheck.setBounds(550,550,10,10);
		
		
		jFrame.setLayout(null);
		jFrame.add(addRowBtn);
		jFrame.add(removeRowBtn);
		jFrame.add(allEmptyBox);
		jFrame.add(allSelectBox);
		
//		jFrame.add(northBar,BorderLayout.NORTH);//�������뵽����
//		jFrame.add(scr,BorderLayout.CENTER);   //�������뵽����
//		jFrame.add(southBar,BorderLayout.SOUTH);
//		jFrame.add(northBar);//�������뵽����
		jFrame.add(scr);   //�������뵽����
		
		jFrame.add(filterLabel);
		jFrame.add(filterText);
		jFrame.add(sLabel);
		jFrame.add(statusText);
		//jFrame.add(southBar);
		jFrame.add(checkBox);
		jFrame.add(defaultOrderPath);
		jFrame.add(orderLabel);
		jFrame.add(orderPath);
		jFrame.add(browseBtn);
		jFrame.add(orderMakeBtn);
		jFrame.setSize(980,600);
		jFrame.setVisible(true);
		
		addRowBtn.addActionListener(this);
		removeRowBtn.addActionListener(this);
		browseBtn.addActionListener(this);
		orderMakeBtn.addActionListener(this);
		allSelectBox.addActionListener(this);
		allEmptyBox.addActionListener(this);
		checkBox.addItemListener(this);
		//filterText.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getActionCommand().equals("ȫѡ")) {
			Controller.setState(table, true);
		}else if(e.getActionCommand().equals("���")){
			Controller.setState(table, false);
		}
		
		if (e.getSource() == addRowBtn) {			//������
			tableModel.addRow(new Object[]{});
		}
		
		if (e.getSource() == removeRowBtn) {
			int rowCount = tableModel.getRowCount() - 1;
			
			if (rowCount >= 0) {
				tableModel.removeRow(rowCount);
				tableModel.setRowCount(rowCount);
			}
		}
		
		if (e.getSource() == browseBtn) {
			JFileChooser jfc=new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
			jfc.setDialogTitle("ѡ�񶩵����Ŀ¼");
			//jfc.showOpenDialog(this.jFrame);
			jfc.showDialog(new JLabel(), "ѡ��");
			File file=jfc.getSelectedFile();
			if(file.isDirectory()){
				orderPath.setText(file.getAbsolutePath());
				MakeOrderFun.orderPath = orderPath.getText();
			}
		}
		
		if (e.getSource() == orderMakeBtn) {
			Controller.orderGenerator(table);
		}
		
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			defaultOrderPath.setEditable(false);
			orderPath.setEditable(true);
			browseBtn.setEnabled(true);
		}else if (e.getStateChange() == ItemEvent.SELECTED) {
			orderPath.setEditable(false);
			browseBtn.setEnabled(false);
			defaultOrderPath.setEditable(true);
		}
	}
	
	private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
	}
	
}