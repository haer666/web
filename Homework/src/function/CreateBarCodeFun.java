package function;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateBarCodeFun {
	

    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;
        {
            // 设置编码方式
            put(EncodeHintType.CHARACTER_SET, "utf-8");
            // 容错级别 这里选择最高H级别
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            put(EncodeHintType.MARGIN, 1);
        }
    };
	
	public static BufferedImage getBarCode(String vaNumber,int WIDTH,int HEIGHT){
		try{
			Code128Writer writer=new Code128Writer();
			//编码内容，编码类型，宽度，高度，设置参数
			BitMatrix bitMatrix = writer.encode(vaNumber, BarcodeFormat.CODE_128, WIDTH, HEIGHT, hints);
			return MatrixToImageWriter.toBufferedImage(bitMatrix);
		}catch(WriterException e){
			e.printStackTrace();
		}
		return null;
	}
	//条形码下面加上文字
	public BufferedImage insertWords(BufferedImage image, String words,int WIDTH,int HEIGHT,int WORD_HEIGHT){
		//新的图片，把带logo的条形码下面加上文字
			BufferedImage outImage = new BufferedImage(WIDTH, WORD_HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d=outImage.createGraphics();
            // 抗锯齿
            setGraphics2D(g2d);
            // 设置白色
            setColorWhite(g2d);
            //画条形码到新的面板
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            //画文字到新的面板
            Color color=new Color(0,0,0);
            g2d.setColor(color);
            //字体、字型、字号
            g2d.setFont(new Font("黑体",Font.PLAIN,14));
            //文字长度
            int strWidth=g2d.getFontMetrics().stringWidth(words);
            //总长度减去文字长度的一半（居中显示）
            int wordStartX=(WIDTH-strWidth)/2;
            int wordStartY=HEIGHT+15;
            //time 文字长度
			int timeWidth=1;
			//WORDS文字长度
			int WordsWidth = WIDTH - g2d.getFontMetrics().stringWidth(words);

            g2d.drawString(words, wordStartX, wordStartY);
      //      g2d.drawString(time, timeWidth, wordStartY + 18);
      //      g2d.drawString(WORDS, WordsWidth, wordStartY + 18);
            g2d.dispose();
            outImage.flush();
            return outImage;
		
	}
	//抗锯齿

    private void setGraphics2D(Graphics2D g2d) {
        // 消除画图锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 消除文字锯齿
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        Stroke s = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(s);
    }
    //背景为白色

    private void setColorWhite(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        //填充整个屏幕
        g2d.fillRect(0, 0, 400, 60);
        //设置笔刷
        g2d.setColor(Color.BLACK);
    }
    
    public BufferedImage getBarcode1(String vaNumber){;
    	BufferedImage image = insertWords(getBarCode(vaNumber,300,45),vaNumber,300,45,80);
    	return image;
    }
    
    public BufferedImage getBarcode2(){
    	LocalDateTime now=LocalDateTime.now();
    	//年月日时分秒毫秒
    	String s=now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    	 int i=(int)(Math.random()*900)+100; 
    	 String ss=String.valueOf(i);
         s=s+ss;
    	BufferedImage image = insertWords(getBarCode(s,400,40),s,400,40,60);
    	return image;
    }
    
    public BufferedImage getBarcode3(String vaNumber){
    	BufferedImage image = insertWords(getBarCode(vaNumber,400,40),vaNumber,400,40,60);
    	return image;
    }
}
