package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name="ServletLogin", urlPatterns="/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("usuario");
		String pwd = request.getParameter("senha");

		Login lg = new Login(user, pwd);
		
		if (Login.autenticar(lg) == true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("login", user);

			request.setAttribute("usuario", session.getAttribute("login"));
			request.setAttribute("IdSessao", session.getId());

			response.sendRedirect("views/ConsultaApontamento/consulta-apontamento.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	
	}

}
