import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Search1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con;
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbase?user=root","root","Mirdula@1567");
		
		Statement stmt;
		
			stmt = con.createStatement();
		int i=Integer.parseInt(request.getParameter("ProductID"));
		String s="select * from productdetails where ProductID ="+i+"";
		ResultSet r=stmt.executeQuery(s);
		while(r.next())
		{
				out.println("ID= " + r.getInt(1)+"\n"+ "ProductName= " + r.getString(2));
		}
		}
		catch (Exception e)
		{
			PrintWriter out=response.getWriter();
			out.println(e);
		}
		doGet(request, response);
	}

}
