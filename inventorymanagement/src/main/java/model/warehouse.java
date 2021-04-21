package model;

public class warehouse {

	private int warehouesid;
	private String warehouesname;
	private String warehoueslocation;
	private String warehouesitems;
	
	public int getWarehouesid() {
		return warehouesid;
	}
	public void setWarehouesid(int warehouesid) {
		this.warehouesid = warehouesid;
	}
	public String getWarehouesname() {
		return warehouesname;
	}
	public void setWarehouesname(String warehouesname) {
		this.warehouesname = warehouesname;
	}
	public String getWarehoueslocation() {
		return warehoueslocation;
	}
	public void setWarehoueslocation(String warehoueslocation) {
		this.warehoueslocation = warehoueslocation;
	}
	public String getWarehouesitems() {
		return warehouesitems;
	}
	public void setWarehouesitems(String warehouesitems) {
		this.warehouesitems = warehouesitems;
	}
	@Override
	public String toString() {
		return "warehouse [warehouesid=" + warehouesid + ", warehouesname=" + warehouesname + ", warehoueslocation="
				+ warehoueslocation + ", warehouesitems=" + warehouesitems + "]";
	}
	
}
