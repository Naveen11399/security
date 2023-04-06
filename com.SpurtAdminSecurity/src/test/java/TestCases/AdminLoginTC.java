package TestCases;


import org.testng.annotations.Test;

import PageObjects.AdminLoginOBJ;

public class AdminLoginTC extends BaseClass {
	@Test
	public void Adminlogin() {
		
	
	al=new AdminLoginOBJ(driver);
	al.UName(adminUname);
	al.pWord(adminPword);
	al.login();
}}
