package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cargo;
import models.Funcionarios;
import models.UF;

@WebServlet(name="ServletFuncionarios", urlPatterns="/Cadastro-Funcionario.do")
public class CadastroFuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	List<UF> listaEstados = UF.buscarEstados();
    	List<Cargo> listaCargos = Cargo.buscarTodos();
		
		request.getSession().setAttribute("listaEstados", listaEstados);
		request.getSession().setAttribute("listaCargos", listaCargos);
		response.sendRedirect("views/CadastroFuncionario/cadastro-funcionario.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Funcionarios func = new Funcionarios(request.getParameter("nome"), request.getParameter("endereco"), request.getParameter("cep"), request.getParameter("cidade"), request.getParameter("telefone"), request.getParameter("celular"), UF.buscarPorSigla(request.getParameter("iduf")), Cargo.buscaPorDesc(request.getParameter("idcargo")));

		Funcionarios.cadastrar(func);
		
		List<Funcionarios> listaFunc = Funcionarios.buscarTodos();
		request.getSession().setAttribute("listaFunc", listaFunc);
		
		response.sendRedirect("views/ConsultaFuncionario/consulta-funcionario.jsp");
	}

}
