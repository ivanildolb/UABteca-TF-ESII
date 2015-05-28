<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="cabecalho.html" />

        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <p class="lead">Serviços</p>
                    <div class="list-group"> 
                        <a href="consultaLivros.jsp" class="list-group-item">Consultar livros</a>
                        <a href="cadastroLivro.jsp" class="list-group-item">Cadastrar livros</a>                    
                        <a href="consultaUsuario.jsp" class="list-group-item">Consultar usuarios</a>
                        <a href="cadastroUsuario.jsp" class="list-group-item active">Cadastrar usuarios</a>                    
                        <a href="#" class="list-group-item">Relatorios</a>                           
                    </div>
                </div>

                <div class="col-md-9">                    
                    <div class="caption-full">                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Cadastro de Usuarios</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form" name="login" action="AdicionaUsuario" method="POST" id="form_login">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Nome" name="nome" type="text" required="nome">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Sobrenome" name="sobrenome" type="text" required="sobrenome">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="E-mail" name="email" type="email" required="email">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Matricula" name="matricula" type="text" required="matricula">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Senha" name="senha" type="password" value="" required="senha">
                                        </div>   
                                        <div class="form-group">
                                            <label>Tipo de Usuario</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="tipo" id="usuario" value="usuario">Usuario
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="tipo" id="gerente" value="gerente">Gerente
                                            </label>                                            
                                            <label class="radio-inline">
                                                <input type="radio" name="tipo" id="administrador" value="administrador">Administrador
                                            </label>                                            
                                        </div>  
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Cadastrar">
                                        <!--<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>-->                      
                                    </fieldset>
                                </form>
                            </div>
                        </div>                 
                    </div>                    
                </div>

            </div>
            <!-- /.container -->

            <div class="container">
                <!-- Footer -->
                <footer>
                    <div class="row">
                        <div class="col-lg-12">
                            <p>Copyright &copy; Your Website 2014</p>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.container -->           
            <!-- jQuery -->
            <script src="js/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="js/bootstrap.min.js"></script>
        </div>
    </body>
</html>
