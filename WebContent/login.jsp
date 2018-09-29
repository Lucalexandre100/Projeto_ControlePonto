<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login | Controle de Ponto</title>

	<link rel="icon" href="views/Imagens/icon-clock-2.png">
    <!-- Bootstrap core CSS-->
    <link href="views/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="views/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="views/css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-dark">
	<div class="container">
      <div class="card card-login mx-auto mt-5">
      <div align ="center"><img src="views/Imagens/logo.jpeg" width="200px" height="250px"></div>
        <div class="card-header">Login <strong>| Controle de Ponto</strong></div>
        <div class="card-body">
          <form action="Login.do" method="post">
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="inputUser" name="inputUser" class="form-control" tabindex="0">
                <label for="inputUser">Username</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" id="inputPassword" name="inputPassword" class="form-control" tabindex="0">
                <label for="inputPassword">Password</label>
              </div>
            </div>
            <div class="form-group">
            	<input class="btn btn-primary btn-block" type="submit" value="Login">
            	<a href="views/CadastroUsuario/cadUser.jsp">Ainda não é cadastrado? Cadastre-se agora.</a>
            </div>
           </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="views/vendor/jquery/jquery.min.js"></script>
    <script src="views/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="views/vendor/jquery-easing/jquery.easing.min.js"></script>
	
</body>
</html>