package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ApontamentoHoras;
import models.Funcionarios;
import models.ValidacaoDataHora;

/**
 * Servlet implementation class CadastroApontamentoController
 */
@WebServlet(name="ServletApontamento", urlPatterns="/CadastroApontamento.do")
public class CadastroApontamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Funcionarios> listaFunc = Funcionarios.buscarTodos();
		request.getSession().setAttribute("listaFunc", listaFunc);
		response.sendRedirect("views/CadastroApontamento/cadastro-apontamento.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApontamentoHoras apont = new ApontamentoHoras(new Date(ValidacaoDataHora.retornaData(request.getParameter("dataCad")).getTime()), ValidacaoDataHora.retornaHora(request.getParameter("hrEntrada")), ValidacaoDataHora.retornaHora(request.getParameter("hrSaidaAlmoco")), ValidacaoDataHora.retornaHora(request.getParameter("hrVoltaAlmoco")), ValidacaoDataHora.retornaHora(request.getParameter("hrSaida")), Funcionarios.buscarIdFuncionario(request.getParameter("idfunc")));
		
		ApontamentoHoras.cadastrar(apont);
		
		List<ApontamentoHoras> listaApont = ApontamentoHoras.buscarTodos();
		request.setAttribute("listaApont", listaApont);
		
		response.sendRedirect("views/ConsultaApontamento/consulta-apontamento.jsp");
	}

}
