package com.pojo;

public class Accounts {
	private int accno;
	private String accname;
	private double bal;
	private String username;
	private String pwd;
	
	public Accounts(int accno, String name, String pw) {
		super();
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Accounts(int accno, String accname, double bal, String username, String pwd) {
		super();
		this.accno = accno;
		this.accname = accname;
		this.pwd = pwd;
	}
	
	
	

	public void Account(int accno, String accname, double bal,String username, String pwd) {
		this.accno = accno;
		this.accname = accname;
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", accname=" + accname + ", bal=" + bal + ", username=" + username + ", pwd="
				+ pwd + "]";
	}
	
	

}
