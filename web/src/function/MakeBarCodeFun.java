package function;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class MakeBarCodeFun {
	

    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;
        {
            // ���ñ��뷽ʽ
            put(EncodeHintType.CHARACTER_SET, "utf-8");
            // �ݴ��� ����ѡ�����H����
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            put(EncodeHintType.MARGIN, 1);
        }
    };
	
	public static BufferedImage getBarCode(String orderId,int WIDTH,int HEIGHT){
		try{
			Code128Writer writer=new Code128Writer();
			//�������ݣ��������ͣ���ȣ��߶ȣ����ò���
			BitMatrix bitMatrix = writer.encode(orderId, BarcodeFormat.CODE_128, WIDTH, HEIGHT, hints);
			return MatrixToImageWriter.toBufferedImage(bitMatrix);
		}catch(WriterException e){
			e.printStackTrace();
		}
		return null;
	}
	//�����������������
	public BufferedImage insertWords(BufferedImage image, String words,int WIDTH,int HEIGHT,int WORD_HEIGHT){
		//�µ�ͼƬ���Ѵ�logo�������������������
			BufferedImage outImage = new BufferedImage(WIDTH, WORD_HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d=outImage.createGraphics();
            // �����
            setGraphics2D(g2d);
            // ���ð�ɫ
            setColorWhite(g2d);
            //�������뵽�µ����
            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            //�����ֵ��µ����
            Color color=new Color(0,0,0);
            g2d.setColor(color);
            //���塢���͡��ֺ�
            g2d.setFont(new Font("����",Font.PLAIN,14));
            //���ֳ���
            int strWidth=g2d.getFontMetrics().stringWidth(words);
            //�ܳ��ȼ�ȥ���ֳ��ȵ�һ�루������ʾ��
            int wordStartX=(WIDTH-strWidth)/2;
            int wordStartY=HEIGHT+15;
            g2d.drawString(words, wordStartX, wordStartY);
            g2d.dispose();
            outImage.flush();
            return outImage;
		
	}
	//�����

    private void setGraphics2D(Graphics2D g2d) {
        // ������ͼ���
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // �������־��
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);
        Stroke s = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(s);
    }
    
    //����Ϊ��ɫ
    private void setColorWhite(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        //���������Ļ
        g2d.fillRect(0, 0, 400, 60);
        //���ñ�ˢ
        g2d.setColor(Color.BLACK);
    }
    
    public BufferedImage getBarcodeWithWords(String orderId){;
    	BufferedImage image = insertWords(getBarCode(orderId,400,40),orderId,400,40,60);
    	return image;
    }
    
    public BufferedImage getBarcodeWithWordsCh(){
    	LocalDateTime now=LocalDateTime.now();
    	//������ʱ�������
    	String s=now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    	int i=(int)(Math.random()*900)+100; 
        s += String.valueOf(i);
    	BufferedImage image = insertWords(getBarCode(s,400,40),s,400,40,60);
    	return image;
    }
}
