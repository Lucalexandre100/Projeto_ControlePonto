package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CargoDAO;
import dao.FuncionariosDAO;
import dao.UFDAO;
import models.Cargo;
import models.Funcionarios;
import models.UF;

@WebServlet(name="ServletFuncionarios", urlPatterns="/Funcionario.do")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UFDAO ufDAO = new UFDAO();
    	List<UF> listaEstados = ufDAO.buscarEstados();
    	CargoDAO cargoDAO = new CargoDAO();
		List<Cargo> listaCargos = cargoDAO.buscarTodos();
		
		request.getSession().setAttribute("listaEstados", listaEstados);
		request.getSession().setAttribute("listaCargos", listaCargos);
		response.sendRedirect("views/CadastroFunc/cadFunc.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String uf = request.getParameter("iduf");
		String cargo = request.getParameter("idcargo");
		int iduf;
		int idcargo;
		
		UFDAO ufDAO = new UFDAO();
		CargoDAO cargoDAO = new CargoDAO();
		iduf = ufDAO.buscarPorSigla(uf);
		idcargo = cargoDAO.buscaPorDesc(cargo);
		
		// Model
		Funcionarios func = new Funcionarios();
		func.setNome(nome);
		func.setEndereco(endereco);
		func.setCep(cep);
		func.setCidade(cidade);
		func.setTelefone(telefone);
		func.setCelular(celular);
		func.setIduf(iduf);
		func.setIdcargo(idcargo);
		
		System.out.println(func.getNome());
		System.out.println(func.getIduf());
		System.out.println(func.getIdcargo());
		
		FuncionariosDAO funcDAO = new FuncionariosDAO();
		funcDAO.cadastrar(func);
		
		List<Funcionarios> listaFunc = funcDAO.buscarTodos();
		request.getSession().setAttribute("listaFunc", listaFunc);
		
		response.sendRedirect("views/ConsultaFunc/consultaFunc.jsp");
	}

}
