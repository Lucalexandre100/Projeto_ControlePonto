package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionariosDAO;
import models.Funcionarios;

@WebServlet(name="ServletConsultaFuncionarios", urlPatterns="/ConsultaFuncionarios.do")
public class ConsultaFuncController extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	FuncionariosDAO funcDAO = new FuncionariosDAO();
    	List<Funcionarios> listaFunc = funcDAO.buscarTodos();
		request.getSession().setAttribute("listaFunc", listaFunc);
		
		response.sendRedirect("views/ConsultaFunc/consultaFunc.jsp");

	}

}
