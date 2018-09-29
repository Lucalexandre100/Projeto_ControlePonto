package controllers;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CargoDAO;
import models.Cargo;

/**
 * Servlet implementation class CargoController
 */
@WebServlet(name="ServletCargos", urlPatterns="/Cargo.do")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		CargoDAO cargoDAO = new CargoDAO();
		
		List<Cargo> lista = cargoDAO.buscarTodos();
		request.getSession().setAttribute("listaCargos", lista);
		response.sendRedirect("views/ListarCargos/listarCargo.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Recebe da View cadCargo.jsp */
		String cargo = request.getParameter("txtCargoFunc");
		Double salario_base = Double.parseDouble(request.getParameter("txtSalario").replaceAll(",", "."));
		//String str = request.getParameter("txtCargaH") + "00";
		String str = request.getParameter("txtCargaH");
		//SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
		Date data = null;
		try {
			data = (Date) formatador.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Time carga_horaria = new Time(data.getTime());
		
		/* Model */
		Cargo cargos = new Cargo();
		cargos.setCargo(cargo);
		cargos.setCarga_horaria(carga_horaria);
		cargos.setSalario_base(salario_base);
		
		/*
		System.out.println(cargos.getCargo());
		System.out.println(cargos.getCarga_horaria());
		System.out.println(cargos.getSalario_base());
		*/
		/* DAO */
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.cadastrar(cargos);
		
		doGet(request, response);
	}
}
