package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Funcionarios;

@WebServlet("/relatorios.do")
public class RelatoriosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param;
		
		param = Integer.parseInt(request.getParameter("expFunc"));
		
		System.out.println(param);
		
		if (param == 1) {
			Funcionarios.exportData();
		}
		
		response.sendRedirect("views/msg-exportacao.jsp");
	}

}
