package vo;

public class OrderGraphCode {
	private String barCode1;
	private String barCode2;
	private String barCode3;
	private String qrCode;
	private int flag;
	public OrderGraphCode(String barCode1, String barCode2, String barCode3, String qrCode,int flag) {
		super();
		this.barCode1 = barCode1;
		this.barCode2 = barCode2;
		this.barCode3 = barCode3;
		this.qrCode = qrCode;
		this.flag=flag;
	}
	public OrderGraphCode() {
		super();
	}
	public String getBarCode1() {
		return barCode1;
	}
	public void setBarCode1(String barCode1) {
		this.barCode1 = barCode1;
	}
	public String getBarCode2() {
		return barCode2;
	}
	public void setBarCode2(String barCode2) {
		this.barCode2 = barCode2;
	}
	public String getBarCode3() {
		return barCode3;
	}
	public void setBarCode3(String barCode3) {
		this.barCode3 = barCode3;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Path [barCode1=" + barCode1 + ", barCode2=" + barCode2
				+ ", barCode3=" + barCode3 + ", qrCode=" + qrCode + ", flag=" + flag +"]";
	}
	
}
