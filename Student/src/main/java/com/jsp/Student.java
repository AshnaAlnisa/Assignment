package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/save")
public class Student extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id =Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		
		try {
			PreparedStatement ps = CreateConnection.getConnection().prepareStatement("insert into student values(?, ?, ?, ?, ?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setLong(4, phone);
			ps.setString(5, password);
			
			int executeUpdate = ps.executeUpdate();
			
			PrintWriter p = resp.getWriter();
			if(executeUpdate>0)
			{
				p.write("<html><body>");
				p.write("<h2>User Updated</h2>");
				p.write("</body></html>");
			}
			else
			{
				p.write("<html><body>");
				p.write("<h2>User not Updated</h2>");
				p.write("</body></html>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}

