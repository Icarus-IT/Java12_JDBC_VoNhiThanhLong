package cybersoft.java12.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.jsp.dbconnection.MySqlConnection;

@WebServlet(name = "healthCheckServlet", urlPatterns = "/health")
public class HealthCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection testConnection = MySqlConnection.getConnection();
		if (testConnection!=null) {
			try {
				testConnection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			resp.getWriter().append("Data connection ok");
		} else {
			resp.getWriter().append("Data connection fail");
		}
		
	}

}
