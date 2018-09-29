package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import models.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name="ServletLogin", urlPatterns="/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("inputUser");
		String pwd = request.getParameter("inputPassword");
		boolean validaUser = false;
		
		Login lg = new Login();
		lg.setUsername(user);
		lg.setPwd(pwd);
		LoginDAO loginDAO = new LoginDAO();
		validaUser = loginDAO.autenticar(lg);
		
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(validaUser);
		
		PrintWriter out = response.getWriter();
		
		if (validaUser == true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("login", user);

			request.setAttribute("usuario", session.getAttribute("login"));
			request.setAttribute("IdSessao", session.getId());

			response.sendRedirect("views/Home/home.jsp");
		} else {
			out.println("Login ou senha inválidos.");
			response.sendRedirect("login.jsp");
		}
	}

}
