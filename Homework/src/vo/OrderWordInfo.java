package vo;

public class OrderWordInfo {
	private String orderId;
	private String begin;
	private String sender;
	private String senderPhone;
	private String senderAddress;
	private String receiver;
	private String receiverPhone;
	private String receiverAddress;
	private String jibaodi;
	private String areaCode;
	private int count;
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getJibaodi() {
		return jibaodi;
	}
	public void setJibaodi(String jibaodi) {
		this.jibaodi = jibaodi;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public OrderWordInfo(String orderId, String begin, String sender, String senderPhone, String senderAddress,
			String receiver, String receiverPhone, String receiverAddress, String jibaodi, String areaCode, int count) {
		super();
		this.orderId = orderId;
		this.begin = begin;
		this.sender = sender;
		this.senderPhone = senderPhone;
		this.senderAddress = senderAddress;
		this.receiver = receiver;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.jibaodi = jibaodi;
		this.areaCode = areaCode;
		this.count = count;
	}
	@Override
	public String toString() {
		return "OrderWordInfo [orderId=" + orderId + ", begin=" + begin + ", sender=" + sender + ", senderPhone="
				+ senderPhone + ", senderAddress=" + senderAddress + ", receiver=" + receiver + ", receiverPhone="
				+ receiverPhone + ", receiverAddress=" + receiverAddress + ", jibaodi=" + jibaodi + ", areaCode="
				+ areaCode + ", count=" + count + "]";
	}
	
	
}
