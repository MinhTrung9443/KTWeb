package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.model.Author_22110446;
import vn.iotstar.model.Book_22110446;
import vn.iotstar.model.User_22110446;
import vn.iotstar.service.UserService_22110446;
import vn.iotstar.service.authorService_22110446;
import vn.iotstar.service.bookService_22110446;
import vn.iotstar.serviceImpl.UserServiceImpl_22110446;
import vn.iotstar.serviceImpl.authorSeviceImpl_22110446;
import vn.iotstar.serviceImpl.bookServiceImpl_22110446;



@WebServlet(urlPatterns = {"/userhome", "/register", "/login"})
public class UserController_22110446 extends HttpServlet {
	private UserService_22110446 ucs = new UserServiceImpl_22110446();
	private authorService_22110446 auser = new authorSeviceImpl_22110446();
	private bookService_22110446 bookser = new bookServiceImpl_22110446();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("userhome"))
		{
			Map<Author_22110446, List<Book_22110446>> map = new HashMap<>();
			List<Author_22110446> authors = auser.getAuthor();
			for (Author_22110446 author : authors)
			{
				List<Book_22110446> books = bookser.getBookByAuthorId(author.getAuthorId());
				map.put(author, books);
			}
			req.setAttribute("map", map);
			req.getRequestDispatcher("/views/user/home_22110446.jsp").forward(req, resp);
		}
		else if (url.contains("login"))
		{
			HttpSession session = req.getSession(false);
			if (session != null)
			{
				User_22110446 user = (User_22110446)session.getAttribute("account");
				req.setAttribute("account", user);
			}
			
			req.getRequestDispatcher("/views/login_22110446.jsp").forward(req, resp);
		}
		else if (url.contains("register"))
		{
			req.getRequestDispatcher("/views/register_22110446.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("register"))
		{
			User_22110446 nu = new User_22110446();
			nu.setFullName(req.getParameter("fullname"));
			nu.setEmail(req.getParameter("email"));
			nu.setPhone(Integer.parseInt(req.getParameter("phone")));
			nu.setPassword(req.getParameter("password"));
			int result = ucs.register(nu);
			if (result == 1)
			{
				req.setAttribute("message", "Email da ton tai");
			}
			else if (result == 2)
			{
			
				req.setAttribute("message", "Phone da ton tai");
			}
			else 
			{
				req.setAttribute("message", "Dang ky thanh cong");
				HttpSession session = req.getSession(true);
				session.setAttribute("account", nu);
				Cookie cookie = new Cookie("account", nu.getEmail());
				cookie.setMaxAge(30*60);
				resp.addCookie(cookie);
				resp.sendRedirect("/KTGiuaKy/userhome");
				return;
			}
			req.getRequestDispatcher("/views/register_22110446.jsp").forward(req, resp);
		}
		else if (url.contains("login"))
		{
			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			int result = ucs.login(email, pass);
			if (result == 1)
			{	
				String check = req.getParameter("remember");
				User_22110446 nu = ucs.getUser(email);
				if (check != null) {
					HttpSession session = req.getSession(true);
					session.setAttribute("account", nu);
					Cookie cookie = new Cookie("account", nu.getEmail());
					cookie.setMaxAge(30*60);
					resp.addCookie(cookie);
					req.setAttribute("message", "Dang nhap thanh cong");
				}
				if (nu.isAdmin())
				{
					resp.sendRedirect("/KTGiuaKy/admin/home");
				}
				else 
				{
					resp.sendRedirect("/KTGiuaKy/userhome");
				}
			}
			else 
			{
				req.setAttribute("message", "Email hoac mat khau khong dung");
				req.getRequestDispatcher("/views/login_22110446.jsp").forward(req, resp);
			}
			
		}
	}
	
}
