<%@page import="java.util.List"%>
<%@page import="modelo.livro.Livro"%>
<%@page import="modelo.livro.LivroDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> </head>
    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:import url="cabecalho.html" />

        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <p class="lead">Serviços</p>
                    <div class="list-group"> 
                        <a href="consultaLivros.jsp" class="list-group-item active">Consultar livros</a>
                        <a href="cadastroLivro.jsp" class="list-group-item">Cadastrar livros</a>                    
                        <a href="consultaUsuario.jsp" class="list-group-item">Consultar usuarios</a>
                        <a href="cadastroUsuario.jsp" class="list-group-item">Cadastrar usuarios</a>                    
                        <a href="#" class="list-group-item">Relatorios</a>                           
                    </div>
                </div>

                <div class="col-md-9">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Livros cadastrados</div>
                        <div class="row">      
                            <div class="col-md-6">
                                <table class="table table-striped table-bordered">
                                    <tbody><tr>                                       
                                            <th>ID</th>
                                            <th>Titulo</th>                                                                                                               
                                            <th>Autor</th>
                                            <th>Editora</th>
                                            <th>Edição</th>
                                            <th>Editar</th>                                            
                                        </tr>

                                        <%
                                            LivroDao dao = new LivroDao();
                                            List<Livro> listLivros = dao.getLista();
                                            for (Livro livro : listLivros) {
                                        %>  

                                        <tr>                                            
                                            <td><%=livro.getId()%></td>                                            
                                            <td><%=livro.getTitulo()%></td>                                                                                                                                   
                                            <td><%=livro.getAutor()%></td>
                                            <td><%=livro.getEditora()%></td>
                                            <td><%=livro.getEdicao()%></td>
                                            
                                            <td><a href="alteraLivro.jsp?id=<%=livro.getId()%>
                                            &titulo=<%=livro.getTitulo()%>&autor=<%=livro.getAutor()%>
                                            &editora=<%=livro.getEditora()%>&edicao=<%=livro.getEdicao()%>">
                                            <input type="button" class="btn-success" name="editar" value="Editar">
                                            </a></td>
                                            
                                        </tr>

                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:import url="rodape.html" />
    </body>
</html>
