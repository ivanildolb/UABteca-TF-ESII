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
                                <h3 class="panel-title">Alteração de Livro</h3>
                            </div>                                       
                            <div class="panel-body">
                                <form role="form" name="altera" action="AlteraLivro" method="POST" id="form_altera">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="ID" 
                                                   value="<%=request.getParameter("id")%>"
                                                   name="id" type="text" readonly="">
                                        </div>                                        
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Titulo" 
                                                   value="<%=request.getParameter("titulo")%>"
                                                   name="titulo" type="text" required="titulo">
                                        </div>                                        
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Autor"
                                                   value="<%=request.getParameter("autor")%>"
                                                   name="autor" type="text" required="autor">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Editora"
                                                   value="<%=request.getParameter("editora")%>"
                                                   name="editora" type="text" required="editora">
                                        </div>                                          
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Edição"
                                                   value="<%=request.getParameter("edicao")%>"
                                                   name="edicao" type="number" required="edicao">
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
