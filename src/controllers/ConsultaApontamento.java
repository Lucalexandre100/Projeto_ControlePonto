package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ApontamentoHoras;

/**
 * Servlet implementation class ConsultaApontamento
 */
@WebServlet(name="ServletConsultaApontamento", urlPatterns="/ConsultaApontamento.do")
public class ConsultaApontamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ApontamentoHoras> lista = ApontamentoHoras.buscarTodos();
		request.getSession().setAttribute("listaApont", lista);
		request.getSession().setAttribute("h", ApontamentoHoras.retornaHorasPorMes());
		response.sendRedirect("views/ConsultaApontamento/consulta-apontamento.jsp");
	}

}
