<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="models.Cargo" %>
<%@ page import="models.Funcionarios" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cadastro de Funcionário | Controle Ponto</title>
    
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

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin.css" rel="stylesheet">
    
</head>
<body class="bg-dark">
	<div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Registro de Funcionário</div>
        <div class="card-body">
          <form action="../../Funcionario.do" method="post">
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-12">
                  <div class="form-label-group">
                    <input type="text" name="nome" class="form-control" tabindex="0">
                    <label for="nome">Nome completo</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
            	<div class="form-row">
            		<div class="col-md-12">
                  		<div class="form-label-group">
                    		<input type="text" name="endereco" class="form-control" tabindex="0">
                    		<label for="endereco">Endereço</label>
                  		</div>
                	</div>
            	</div>
            </div>
            <div class="form-group">
            	<div class="form-row">
            		<div class="col-md-4">
                  		<div class="form-label-group">
                    		<input type="text" name="cep" class="form-control" tabindex="0">
                    		<label for="cep">CEP</label>
                  		</div>
                	</div>
                	<div class="col-md-4">
                  		<div class="form-label-group">
                    		<input type="text" name="cidade" class="form-control" tabindex="0">
                    		<label for="cidade">Cidade</label>
                  		</div>
                	</div>
                	<div class="col-md-4">
                  		<div class="form-label-group">
                    		<select id="iduf" name="iduf">
                    			<c:forEach var="uf" items="${listaEstados}">
                    				<option>${uf.uf}</option>
                    			</c:forEach>
                    		</select>
                  		</div>
                	</div>
            	</div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" name="telefone" class="form-control" tabindex="0">
                    <label for="telefone">Telefone Residencial</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" name="celular" class="form-control" tabindex="0">
                    <label for="celular">Celular</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
            	<div class="form-row">
            		<div class="col-md-12">
            			<div class="form-label-group">
            				<select id="idcargo" name="idcargo">
                    			<c:forEach var="cargo" items="${listaCargos}">
                    				<option>${cargo.cargo}</option>
                    			</c:forEach>
                    		</select>
            			</div>
            		</div>
            	</div>
            </div>
            <input class="btn btn-primary btn-block" type="submit" value="Registrar funcionário">
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
	
</body>
</html>