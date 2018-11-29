<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="models.ApontamentoHoras" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>Consulta Apontamentos | Controle de Ponto</title>
  <!-- Favicon -->
  <link href="../assets/img/brand/favicon.png" rel="icon" type="image/png">
  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <!-- Icons -->
  <link href="../assets/vendor/nucleo/css/nucleo.css" rel="stylesheet">
  <link href="../assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
  <!-- Argon CSS -->
  <link type="text/css" href="../assets/css/argon.css?v=1.0.0" rel="stylesheet">
  	<%
     if (session.getAttribute("login") == null){
       response.sendRedirect("../../login.jsp");
     }
 	%>
</head>

<body class="bg-default">
  <div class="main-content">
    <!-- Navbar -->
    <nav class="navbar navbar-top navbar-horizontal navbar-expand-md navbar-dark">
      <div class="container px-4">
        <a class="navbar-brand" href="#">
          <img src="../Imagens/logo2.png" />
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar-collapse-main">
          <!-- Collapse header -->
          <div class="navbar-collapse-header d-md-none">
            <div class="row">
              <div class="col-6 collapse-brand">
                <a href="#">
                  <img src="../Imagens/logo2.png" />
                </a>
              </div>
              <div class="col-6 collapse-close">
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                  <span></span>
                  <span></span>
                </button>
              </div>
            </div>
          </div>
          <!-- Navbar items -->
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link nav-link-icon" href="../ConsultaApontamento/consulta-apontamento.jsp">
                <i class="ni ni-planet"></i>
                <span class="nav-link-inner--text">Home</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link nav-link-icon" href="../opcao-cargo.html">
                <i class="ni ni-badge"></i>
                <span class="nav-link-inner--text dropdown">Cargo</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link nav-link-icon" href="../opcao-funcionario.html">
                <i class="ni ni-badge"></i>
                <span class="nav-link-inner--text">Funcionário</span>
              </a>
            </li>
			<li class="nav-item">
              <a class="nav-link nav-link-icon" href="../opcao-apontamento.html">
                <i class="ni ni-time-alarm"></i>
                <span class="nav-link-inner--text">Apontamento</span>
              </a>
            </li>
			<li class="nav-item">
              <a class="nav-link nav-link-icon" href="../opcao-relatorios.jsp">
                <i class="ni ni-chart-pie-35"></i>
                <span class="nav-link-inner--text">Relatórios</span>
              </a>
            </li>
			<li class="nav-item">
              <a class="nav-link nav-link-icon" href="../../logoff.do">
                <i class="ni ni-button-power"></i>
                <span class="nav-link-inner--text">Logoff</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header -->
    <div class="header bg-gradient-primary py-7 py-lg-8">
      <div class="container">
        <div class="header-body text-center mb-7">
          <div class="row justify-content-center">
            <div class="col-lg-5 col-md-6">
              <h1 class="text-white">CONTROLE DE PONTO</h1>
              <p class="text-lead text-light">Consulta de Apontamentos de Horas</p>
            </div>
          </div>
        </div>
      </div>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </div>
    <!-- Page content -->
	<div class="container-fluid mt--7">
		<div class="row">
			<div class="col">
				<div class="card shadow">
					<div class="card-header border-0">
						<h3 class="mb-0">Apontamentos</h3>
					</div>
				<div class="table-responsive">
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col">Data Cadastro</th>
								<th scope="col">Hora Entrada</th>
								<th scope="col">Hora Saída Almoço</th>
								<th scope="col">Hora Volta Almoço</th>
								<th scope="col">Hora Saída</th>
								<th scope="col">Id Func</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="apont" items="${listaApont}">
								<tr>
 									<td>${apont.dataCad}</td>
 									<td>${apont.hrEntrada}</td>
 									<td>${apont.hrSaidaAlmoco}</td>
 									<td>${apont.hrVoltaAlmoco}</td>
 									<td>${apont.hrSaida}</td>
 									<td>${apont.idFunc}</td>
 								</tr>
 							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Rodapé Table -->
				<div class="card-footer py-4">
              <nav aria-label="...">
                <ul class="pagination justify-content-end mb-0">
                  <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">
                      <i class="fas fa-angle-left"></i>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
                  <li class="page-item active">
                    <a class="page-link" href="#">1</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">
                      <i class="fas fa-angle-right"></i>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
                </ul>
                <p><strong>
                Total de horas do mês: <c:set var="h" value="${h}"></c:set>
                <c:out value="${h}"></c:out>
                </strong></p>
              </nav>
            </div>
				<!-- Rodapé Table -->
			</div>
			</div>
		</div>
	</div>
    </div>
  </div>
  <!-- Footer -->
  <footer class="py-5">
    <div class="container">
      <div class="row align-items-center justify-content-xl-between">
        <div class="col-xl-6">
          <div class="copyright text-center text-xl-left text-muted">
            &copy; 2018 <a href="https://www.creative-tim.com" class="font-weight-bold ml-1" target="_blank">Creative Tim</a>
          </div>
        </div>
        <div class="col-xl-6">
          <ul class="nav nav-footer justify-content-center justify-content-xl-end">
            <li class="nav-item">
              <a href="https://www.creative-tim.com" class="nav-link" target="_blank">Creative Tim</a>
            </li>
            <li class="nav-item">
              <a href="https://www.creative-tim.com/presentation" class="nav-link" target="_blank">About Us</a>
            </li>
            <li class="nav-item">
              <a href="http://blog.creative-tim.com" class="nav-link" target="_blank">Blog</a>
            </li>
            <li class="nav-item">
              <a href="https://github.com/creativetimofficial/argon-dashboard/blob/master/LICENSE.md" class="nav-link" target="_blank">MIT License</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="../assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Argon JS -->
  <script src="../assets/js/argon.js?v=1.0.0"></script>
</body>

</html>