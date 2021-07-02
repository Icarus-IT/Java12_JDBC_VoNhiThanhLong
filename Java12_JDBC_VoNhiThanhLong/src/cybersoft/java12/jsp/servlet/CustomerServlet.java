package cybersoft.java12.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.jsp.model.Customer;
import cybersoft.java12.jsp.service.CustomerService;
import cybersoft.java12.jsp.util.PathUtils;
import cybersoft.java12.jsp.util.UrlUtils;

@WebServlet(name = "customerServlet", urlPatterns = { UrlUtils.CUSTOMER_DASHBOARD, UrlUtils.CUSTOMER_ADD,
		UrlUtils.CUSTOMER_UPDATE, UrlUtils.CUSTOMER_DELETE })
public class CustomerServlet extends HttpServlet {
	private CustomerService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		switch (path) {
		case UrlUtils.CUSTOMER_DASHBOARD:
			List<Customer> customers = service.findAllCustomers();

			req.setAttribute("customers", customers);

			req.getRequestDispatcher(PathUtils.CUSTOMER_DASHBOARD).forward(req, resp);
			break;

		case UrlUtils.CUSTOMER_ADD:
			req.getRequestDispatcher(PathUtils.CUSTOMER_ADD).forward(req, resp);
			break;

		case UrlUtils.CUSTOMER_UPDATE:

			int codeToUpdate =Integer.parseInt(req.getParameter("code")) ;
			Customer customerToUpdate = service.findCustomerByCode(codeToUpdate);
			req.setAttribute("customer", customerToUpdate);

			req.getRequestDispatcher(PathUtils.CUSTOMER_UPDATE).forward(req, resp);
			break;

		case UrlUtils.CUSTOMER_DELETE:
			int codeToBeDeleted = Integer.parseInt(req.getParameter("code")) ;
			
				service.deleteCustomerByCode(codeToBeDeleted);

			
			// List<Customer> updatedList = service.findAllCustomers();

//			req.setAttribute("customers", updatedList);
//			req.getRequestDispatcher(PathUtils.CUSTOMER_DASHBOARD)
//			.forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/customer");
			// System.out.println(req.getContextPath()+"/customer");
			break;

		default:

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		switch (path) {
		case UrlUtils.CUSTOMER_ADD:
			Customer newCus = new Customer();		
			newCus.setName(req.getParameter("name"));
			newCus.setAddress(req.getParameter("address"));
			newCus.setEmail(req.getParameter("email"));
			service.addNewCustomer(newCus);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
		case UrlUtils.CUSTOMER_UPDATE:
			int codeToUpdate = Integer.parseInt(req.getParameter("code")) ;
Customer customerToUpdate = service.findCustomerByCode(codeToUpdate);
			customerToUpdate.setName(req.getParameter("name"));
			customerToUpdate.setAddress(req.getParameter("address"));
			customerToUpdate.setEmail(req.getParameter("email"));
			service.update(customerToUpdate, codeToUpdate);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;

		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
		service = new CustomerService();
	}
}