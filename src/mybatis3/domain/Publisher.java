package mybatis3.domain;

public class Publisher {
	
	private int id;
	private String name;
	private String phone_number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String toString() {
		return id + "::" + name + "::" + phone_number;
	}
}
