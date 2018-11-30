package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Login;

@WebServlet(name="ServletCadastroLogin", urlPatterns="/CadastroLogin.do")
public class CadastroLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String cSenha = request.getParameter("confirmaSenha");
		
		if (senha.equals(cSenha)) {
			Login l = new Login(usuario, senha, 0);
			Login.cadastrar(l);
			
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("views/CadastroLogin/cadastro-login.jsp");
		}
	}

}
