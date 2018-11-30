package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cargo;

/**
 * Servlet implementation class CargoController
 */
@WebServlet(name="ServletCargos", urlPatterns="/Cargo.do")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cargo> lista = Cargo.buscarTodos();
		request.getSession().setAttribute("listaCargos", lista);
		response.sendRedirect("views/ConsultaCargo/consulta-cargo.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cargo cargos = new Cargo(request.getParameter("cargo"), Double.parseDouble(request.getParameter("salario").replaceAll(",", ".")), request.getParameter("cargaHoraria"));
		
		Cargo.cadastrar(cargos);
		
		doGet(request, response);
	}
}
