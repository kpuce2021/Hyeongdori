package com.kpu.main;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/main")
public class HomeController {
	
	@Autowired
	private DataSource dataSource;

	@GetMapping("home")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	
	@RequestMapping("/dbTest.do")
	public String dbTest(Model model) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = dataSource.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select now() as now;");
			
			while(rs.next()) {
				model.addAttribute("serverTime", rs.getString("now"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st != null) st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return "home";
	}
	
	
}
