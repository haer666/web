package function;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class MakeQRCodeFun {
	public static BufferedImage createQRCode(String contents,int width,int height,int margin){
		//二维码基本参数设置
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 设置编码字符集utf-8
		 hints.put(EncodeHintType.CHARACTER_SET, CharacterSetECI.UTF8);
		/* 设置纠错等级L/M/Q/H,当二维码被损毁一部分时，纠错等级越高，越可能读取成功；
		 同样的，纠错等级越高，单位面积内点阵的点越多，机器扫描时，识别所需时间越长，当前设置等级为最高等级H*/
		 hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 可设置范围为0-10，但仅四个变化0 1(2) 3(4 5 6) 7(8 9 10)
		 hints.put(EncodeHintType.MARGIN, margin);
	       // 生成图片类型为QRCode
	     BarcodeFormat format = BarcodeFormat.QR_CODE;
	        // 创建位矩阵对象
	     BitMatrix matrix = null;
	     try {
	            // 生成二维码对应的位矩阵对象
	            matrix = new MultiFormatWriter().encode(contents, format, width, height, hints);
	        } catch (WriterException e) {
	            e.printStackTrace();
	        }
	        // 设置位矩阵转图片的参数
	      MatrixToImageConfig config = new MatrixToImageConfig(Color.black.getRGB(), Color.white.getRGB());
	        // 位矩阵对象转BufferedImage对象
	      BufferedImage qrcode = MatrixToImageWriter.toBufferedImage(matrix, config);
	      return qrcode;
	}

	public BufferedImage getQRcode(String orderId){
        int width = 220;// 二维码宽度
        int height = 220;// 二维码高度
        int margin = 0;// 二维码边距
		//生成二维码
		BufferedImage qrcode =createQRCode(orderId,width,height,margin);
		return qrcode;
	}
}
