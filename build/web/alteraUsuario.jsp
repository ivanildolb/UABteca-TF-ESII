<%@page import="modelo.livro.Livro"%>
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
                        <a href="cadastroUsuario.jsp" class="list-group-item">Cadastrar usuarios</a>                    
                        <a href="#" class="list-group-item">Relatorios</a>                           
                    </div>
                </div>
                <div class="col-md-9">                    
                    <div class="caption-full">                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Alteração de Usuario</h3>
                            </div>                                       
                            <div class="panel-body">
                                <form role="form" name="altera" action="AlteraUsuario" method="POST" id="form_altera">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="ID" 
                                                   value="<%=request.getParameter("id")%>"
                                                   name="id" type="text" readonly="">
                                        </div>                                        
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Nome" 
                                                   value="<%=request.getParameter("nome")%>"
                                                   name="nome" type="text" required="">
                                        </div>                                        
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Sobrenome"
                                                   value="<%=request.getParameter("sobrenome")%>"
                                                   name="sobrenome" type="text" required="">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="E-mail"
                                                   value="<%=request.getParameter("email")%>"
                                                   name="email" type="text" required="">
                                        </div>                                          
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Matricula"
                                                   value="<%=request.getParameter("matricula")%>"
                                                   name="matricula" type="text" required="">
                                        </div>                                                                                
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Senha"
                                                   value="<%=request.getParameter("senha")%>"
                                                   name="senha" type="text" required="">
                                        </div>    
                                        <div class="form-group">
                                            <label>Tipo de Usuario</label>
                                            <%String tipo = request.getParameter("tipo");
                                                if (tipo.equals("usuario")) {
                                                    tipo = "usuario";%>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" id="usuario" 
                                                           value="usuario" checked="">Usuario
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" value="gerente" id="gerente">Gerente
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" value="administrador" id="administrador">Administrador
                                                </label>
                                            <%} else {
                                                if (tipo.equals("gerente")) {
                                                    tipo = "gerente";%>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" value="usuario" id="usuario">Usuario
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" id="gerente" 
                                                           value="gerente" checked="" >Gerente                                                
                                                </label> 
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" value="administrador" id="administrador">Administrador
                                                </label>
                                            <%} else {
                                                tipo = "administrador";%>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" value="usuario" id="usuario">Usuario
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" value="gerente" id="gerente">Gerente
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="tipo" id="administrador" 
                                                           value="administrador" checked="">Administrador
                                                </label>                                            
                                            <%}
                                                }%>                                                                                       

                                        </div> 
                                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Atualizar">
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
