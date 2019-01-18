package employee.vo;

import java.util.Date;

public class EmployeeVo {

	private long no;
	private String name;
	private String email;
	private String cell;
	private Date hire;
	private int money;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public Date getHire() {
		return hire;
	}
	public void setHire(Date hire) {
		this.hire = hire;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return name + email + cell + hire;
	}
	
}
