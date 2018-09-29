<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="models.Funcionarios" %>
<%@ page import="java.util.List" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Lista de Funcionários | Controle de Ponto</title>

	<%
     if (session.getAttribute("login") == null){
       response.sendRedirect("../../login.jsp");
     }
 	%>

	<link rel="icon" href="../Imagens/icon-clock-2.png">
    <!-- Bootstrap core CSS-->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin.css" rel="stylesheet">
</head>
<body id="page-top">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="../Home/home.jsp"><img src="../Imagens/logo.jpeg" width="50px" height="50px"> Controle de Ponto</a>

    </nav>

    <div id="wrapper">

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              Lista de funcionários
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                  	<tr>
                      <th>ID</th>
                      <th>Nome</th>
                      <th>Endereço</th>
                      <th>CEP</th>
                      <th>Cidade</th>
                      <th>UF</th>
                      <th>Telefone</th>
                      <th>Celular</th>
                      <th>Cargo</th>
                    </tr>
                  </thead>
                  	<c:forEach var="func" items="${listaFunc}">
 						<tr>
  							<td>${func.id}</td>
  							<td>${func.nome}</td>
  							<td>${func.endereco}</td>
  							<td>${func.cep}</td>
  							<td>${func.cidade}</td>
  							<td>${func.iduf}</td>
  							<td>${func.telefone}</td>
  							<td>${func.celular}</td>
  							<td>${func.idcargo}</td>
 						</tr> 
 					</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
        <!-- /.container-fluid -->

		<!-- /#wrapper content-->
    	</div>
    <!-- /#wrapper -->
    </div>
    <footer>
      	<div align="center">
          	Copyright © ILW Tech 2018
      	</div>
   	</footer>
 

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="../vendor/datatables/jquery.dataTables.js"></script>
    <script src="../vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="../js/demo/datatables-demo.js"></script>
	
</body>
</html>