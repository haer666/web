package function;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import vo.Order;


public class MakeOrderFun {
	static public String orderPath = "E:\\data\\orders";
	
	public BufferedImage makeImage(Order order) {
		BufferedImage image = new BufferedImage(444, 650,
				BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = image.getGraphics();
		int width = 443;
		int height = 649;
		int x = 10;
		int y = 12;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		
		g.drawLine(0, 0, width, 0);
		g.drawLine(0, height, width, height);
		g.drawLine(0, 0, 0, height);
		g.drawLine(width, 0, width, height);
		
		// g.setColor(Color.green);
		g.setFont(new Font("黑体", Font.BOLD, 12));
		g.drawString("始发网点："+order.getBegin(), x, y);
		g.drawString("寄件人："+order.getSender()+"  寄件人电话："+order.getSenderPhone(), x, 2 * y);
		g.drawString("寄件公司：", x, 3 * y);
		g.drawString("寄件人地址："+order.getSenderAddress(), x, 4 * y);
		g.setFont(new Font("黑体", Font.BOLD, 20));
		g.drawString("国际件", 360, 2 * y);
		g.drawString("送达", x, 7 * y);
		g.drawString("地址：", x, 7 * y + 20);
		g.setFont(new Font("黑体", Font.BOLD, 12));
		g.drawString("收件人："+order.getReceiver(), 2 * x + 40, 6 * y);
		g.drawString("收件人电话："+order.getReceiverPhone(), 2 * x + 40, 7 * y);
		g.drawString("收件公司：", 2 * x + 40, 8 * y);
		g.drawString("收件地址："+order.getReceiverAddress(), 2 * x + 40, 9 * y);
		g.setFont(new Font("黑体", Font.BOLD, 22));
		g.drawString("集包地："+order.getJibaodi(), x, 11 * y);
		g.drawString(order.getAreaCode(), x + 60, 13 * y);//
		drawDashedLine(g, 0, 13 * y + 85, width, 13 * y + 85);
		drawDashedLine(g, 0, 16 * y + 85, width, 16 * y + 85);
		g.setFont(new Font("黑体", Font.BOLD, 12));
		g.drawString("收件人/签收人", x, 14 * y + 85 + 5);
		g.drawString("签收日期：    年    月    日", (width - 1) / 2, 14 * y + 85 + 5);
		g.drawString("Name of Sign-off", x, 15 * y + 85 + 5);
		g.drawString("数量："+order.getCount(), x, 25 * y);
		g.drawLine(0, 31 * y, width, 31 * y);
		g.drawLine(0, 37 * y, width, 37 * y);
		g.drawString("寄件人："+order.getReceiver(), x, 38 * y);
		g.drawString("寄件公司：", x, 39 * y);
		g.drawString("寄件人地址："+order.getReceiverAddress(), x, 40 * y);
		g.drawLine(0, 41 * y, width, 41 * y);
		g.drawLine(280, 41 * y, 280, height);
		g.drawString("收件人："+order.getReceiver(), x, 43 * y);
		g.drawString("收件人电话："+order.getReceiverPhone(), x, 44 * y);
		g.drawString("收件公司：", x, 45 * y);
		g.drawString("收件地址："+order.getReceiverAddress(), x, 46 * y);
		g.drawLine(0, 49 * y, 280, 49 * y);
		g.setFont(new Font("黑体", Font.BOLD, 9));
		g.drawString("官方网址 http://www.yundaex.com客服热线 955466", x, 52 * y);
		//g.drawString("客服热线  955466", x, 52 * y);

		
		Image Img = null;
		// 插入二维码
		try {
			Img = insertImage("E:\\data\\QRCode\\" + order.getOrderId() + ".jpg", 110, 110, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 305, 42 * y + 6, null);
		// 插入条形码1
		try {
			Img = insertImage("E:\\data\\barCode1\\" + order.getOrderId() + ".jpg", 300, 70, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 14 * x, 14 * y, null);//
		//插入条形码3
		try {
			Img = insertImage("E:\\data\\barCode3\\" + order.getOrderId() + ".jpg", 260, 50, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, x, 32 * y, null);
		// 插入条形码2
		try {
			Img = insertImage("E:\\data\\barCode2\\" + order.getOrderId() + ".jpg", 360, 60, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 7 * x, 24 * y, null);
		// 插入logo
		try {
			Img = insertImage("E:\\data\\input\\logo.jpg", 150, 60, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 28 * x, 32 * y, null);
		return image;
	}

	public Image insertImage(String imgPath, int imgWidth,
			int imgHeight, boolean isCompress) throws Exception {
		File fileimage = new File(imgPath);
		Image src = ImageIO.read(fileimage);
		if (isCompress) {
			Image image = src.getScaledInstance(imgWidth, imgHeight,
					Image.SCALE_SMOOTH);
			return image;
		}
		return src;
	}
	
	//画虚线
	 public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2){
	        Graphics2D g2d = (Graphics2D) g;
	        //float dash[] = {10.0f};
	        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0);
	        
	        g2d.setStroke(dashed);
	        g2d.drawLine(x1, y1, x2, y2);
	    }
	 
	 public BufferedImage getImage(Order order){
			try {
				//三个条形码
				MakeBarCodeFun cb=new MakeBarCodeFun();
				BufferedImage barCode1=cb.getBarcodeWithWords(order.getOrderId());
				ImageIO.write(barCode1, "jpg", new File("E:\\data\\barCode1\\" + order.getOrderId() + ".jpg"));
				
				BufferedImage barCode2=cb.getBarcodeWithWordsCh();
				ImageIO.write(barCode2, "jpg", new File("E:\\data\\barCode2\\" + order.getOrderId() + ".jpg"));
				
				BufferedImage barCode3=cb.getBarcodeWithWords(order.getOrderId());
				ImageIO.write(barCode3, "jpg", new File("E:\\data\\barCode3\\" + order.getOrderId() + ".jpg"));
			
				MakeQRCodeFun cqr=new MakeQRCodeFun();
				BufferedImage qrCode=cqr.getQRcode(order.getOrderId());
				ImageIO.write(qrCode, "jpg", new File("E:\\data\\QRCode\\" + order.getOrderId() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//快递单
		 BufferedImage image=makeImage(order);
		 try {
			ImageIO.write(image, "jpg", new File(orderPath + "\\" + order.getOrderId() +".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return image;
	 }
}
