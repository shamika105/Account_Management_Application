package com.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Accounts;
import com.util.Dbutil;

public class AccountDao {
	private Connection con;
	
//	constructor
	public AccountDao() {
	 con=Dbutil.getConnection();
	 
	 System.out.println("Connected.....");
	 System.out.println("AccountDao created.....");
	
	}

	
//	insert 
	public void insertAcc(Accounts acc) throws SQLException {
	    String sql = "insert into Account (id, name) values (?, ?)";
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Act", "root", "root");
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setInt(1, acc.getAccno());  // This line might be causing the error
	        pstmt.setString(2, acc.getAccname());
	        pstmt.setString(3, acc.getUsername());
	        pstmt.setString(4, acc.getPwd());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
//	update
	public int editAcc(Accounts obj) {
		try {
			String str1="update Account set accname=?,pwd=? where accno=? ";
			
			PreparedStatement pst1 =con.prepareStatement(str1);
			pst1.setInt(1, obj.getAccno());
			pst1.setString(2, obj.getAccname());
			pst1.setString(5, obj.getPwd());
			
//			execute it on db side
			int i=pst1.executeUpdate();
			System.out.println("Updated"+i+ "rows.....");
			return i;
		}
	catch(SQLException e) {
		e.printStackTrace();
	}

		return 0;
		
	}
//	delete
	public int deleteAcc(Accounts obj) {
		try {
			String str2="delete from Account where accno=?";
			
			PreparedStatement pst2 =con.prepareStatement(str2);
			pst2.setInt(1, obj.getAccno());
			pst2.setString(2, obj.getAccname());
			pst2.setDouble(3, obj.getBal());
			pst2.setString(4, obj.getUsername());
			pst2.setString(5, obj.getPwd());
			
//			execute it on db side
			int i=pst2.executeUpdate(str2);
			System.out.println("Inserted"+i+ "rows.....");
			return i;
		}
	catch(SQLException e) {
		e.printStackTrace();
	}

		return 0;
		
	}
	
//	select
	public List<Accounts>getAllAccounts(){
		try {
			List<Accounts>actList=new ArrayList<Accounts>();
			String str3="select * from account";
			PreparedStatement pst3 =con.prepareStatement(str3);
			
			ResultSet rs= pst3.executeQuery(str3);
			
			while(rs.next()) {
				Accounts act=new Accounts(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
				actList.add(act);
			}
			rs.close();
			return actList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
//	get account by id
		public Accounts getAccountById(int id) {
		String str4="select * from account where accno=?";
	try {
			PreparedStatement pst4 =con.prepareStatement(str4);
		
			ResultSet rs= pst4.executeQuery(str4);
			
			if(rs.next()) {
				System.out.println("Account is present....");
			
				Accounts accobj =new Accounts(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
				return accobj;
			}
			else {
				System.out.println("Invalid Account Id......");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void deleteAcc(int id1) {
		// TODO Auto-generated method stub
		
	}
//	public void insertAcc(Accounts act) {
//		// TODO Auto-generated method stub
//		
//		}
}
	

