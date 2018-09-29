package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import models.Login;

@WebServlet(name="ServletCadastroLogin", urlPatterns="/CadastroLogin.do")
public class CadastroLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("txtUsuario");
		String senha = request.getParameter("txtSenha");
		String cSenha = request.getParameter("txtConfirmaSenha");
		
		if (senha.equals(cSenha)) {
			Login l = new Login();
			l.setUsername(usuario);
			l.setPwd(senha);
			LoginDAO lg = new LoginDAO();
			lg.cadastrar(l);
			
			response.sendRedirect("login.jsp");
		} else {
			response.getWriter().append("Senhas não conferem. Tente novamente.");
			response.sendRedirect("views/CadastroUsuario/cadUser.jsp");
		}
	}

}
