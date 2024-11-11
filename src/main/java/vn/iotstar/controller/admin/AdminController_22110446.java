package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.model.User_22110446;
import vn.iotstar.service.UserService_22110446;
import vn.iotstar.serviceImpl.UserServiceImpl_22110446;

@WebServlet(urlPatterns = { "/admin/home", "/admin/users", "/admin/user/update", "/admin/user/delete","/admin/user/insert","/admin/user/save" })
public class AdminController_22110446 extends HttpServlet {
	private UserService_22110446 userser = new UserServiceImpl_22110446();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("home")) {
			req.getRequestDispatcher("/views/admin/home_22110446.jsp").forward(req, resp);
		} else if (url.contains("users")) {
			List<User_22110446> list = new ArrayList<>();
			int currentPage = 1;
			int numOfItems = 3;

			String selectPage = req.getParameter("page");
			if (selectPage != null) {
				currentPage = Integer.parseInt(selectPage);
			}

			list = userser.getUserPage(currentPage - 1, numOfItems);
			int totalUser = userser.countAllUser();
			int totalPages = (int) Math.ceil((double) totalUser / numOfItems);

			req.setAttribute("users", list);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("totalPages", totalPages);
			req.getRequestDispatcher("/views/admin/userManager/list_22110446.jsp").forward(req, resp);
		} else if (url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			userser.deleteUser(id);
			resp.sendRedirect("/KTGiuaKy/admin/users");
		}
		else if (url.contains("update"))
		{
			String email = req.getParameter("email");
			User_22110446 user = userser.getUser(email);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/views/admin/userManager/save_22110446.jsp").forward(req, resp);
		}
		else if (url.contains("insert"))
		{
			User_22110446 user = null;
			req.setAttribute("user", user);
			req.getRequestDispatcher("/views/admin/userManager/save_22110446.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("save")) {
			User_22110446 user = new User_22110446();
			String id = req.getParameter("id");

			String email = req.getParameter("email");
			String fullName = req.getParameter("fullname");
			String phoneStr = req.getParameter("phone");
			String password = req.getParameter("passwd");
			boolean isAdmin = req.getParameter("is_admin") != null;
			
			user.setEmail(email);
		    user.setFullName(fullName);
		    user.setPassword(password);
		    user.setPhone(Integer.parseInt(phoneStr));
		    
		    user.setAdmin(isAdmin);
		    
			if (id != null) {
				user.setId(Integer.parseInt(id));
				userser.updateUser(user);
				resp.sendRedirect("/KTGiuaKy/admin/users");
			} else {
				userser.insertUser(user);
				resp.sendRedirect("/KTGiuaKy/admin/users");
			}
		}
	}

}
