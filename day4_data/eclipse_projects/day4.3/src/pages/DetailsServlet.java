package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Customer;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
		pw.print("from 2nd page");
			pw.print("<h4>Login Successful</h4>");
			// get cust dtls from request scope
			Customer c123 = (Customer) request.getAttribute("cust_details");
			if (c123 != null) {
				pw.print("Hello , " + c123.getEmail() + "<br>");
				pw.print("Details " + c123);
			}
		}
	}

}
