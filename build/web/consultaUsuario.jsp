<%@page import="modelo.usuario.Usuario"%>
<%@page import="modelo.usuario.UsuarioDao"%>
<%@page import="java.util.List"%>
<%@page import="modelo.livro.Livro"%>
<%@page import="modelo.livro.LivroDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
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
                        <a href="consultaUsuario.jsp" class="list-group-item active">Consultar usuarios</a>
                        <a href="cadastroUsuario.jsp" class="list-group-item">Cadastrar usuarios</a>                    
                        <a href="#" class="list-group-item">Relatorios</a>                           
                    </div>
                </div>

                <div class="col-md-9">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Usuarios cadastrados</div>
                        <div class="row">      
                            <div class="col-md-6">
                                <table class="table table-striped table-bordered">
                                    <tbody><tr>                                       
                                            <th>ID</th>
                                            <th>Nome</th>                                                                                                               
                                            <th>Sobrenome</th>
                                            <th>Email</th>
                                            <th>Matricula</th>
                                            <th>Senha</th>                                            
                                            <th>Tipo</th>  
                                            <th>Editar</th>                                            
                                        </tr>

                                        <%
                                            UsuarioDao dao = new UsuarioDao();
                                            List<Usuario> listUsuarios = dao.getLista();
                                            for (Usuario usuario : listUsuarios) {
                                        %>  

                                        <tr>                                            
                                            <td><%=usuario.getId()%></td>                                            
                                            <td><%=usuario.getNome()%></td>                                                                                                                                   
                                            <td><%=usuario.getSobrenome()%></td>
                                            <td><%=usuario.getEmail()%></td>
                                            <td><%=usuario.getMatricula()%></td>
                                            <td><%=usuario.getSenha()%></td>                                            
                                            <td><%=usuario.getTipo()%></td>
                                            
                                            <td><a href="alteraUsuario.jsp?id=<%=usuario.getId()%>
                                            &nome=<%=usuario.getNome()%>&sobrenome=<%=usuario.getSobrenome()%>
                                            &email=<%=usuario.getEmail()%>&matricula=<%=usuario.getMatricula()%>
                                            &senha=<%=usuario.getSenha()%>&tipo=<%=usuario.getTipo()%>">
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
