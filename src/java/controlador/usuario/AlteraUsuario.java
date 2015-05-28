package controlador.usuario;

import controlador.livro.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.livro.Livro;
import modelo.livro.LivroDao;
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDao;

/**
 *
 * @author Ivanildo
 */
@WebServlet(name = "AlteraUsuario", urlPatterns = {"/AlteraUsuario"})
public class AlteraUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        Usuario usuario = new Usuario();
        
        usuario.setId(Integer.parseInt(request.getParameter("id").trim()));
        usuario.setNome(request.getParameter("nome"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setMatricula(request.getParameter("matricula"));
        usuario.setSenha(request.getParameter("senha"));
        
        String tipo = request.getParameter("tipo");
        if (tipo.equals("usuario")) {
            tipo = "usuario";
        } else {
            if (tipo.equals("gerente")) {
                tipo = "gerente";
            } else {
                tipo = "administrador";
            }
        }
        usuario.setTipo(tipo);
        
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.altera(usuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlteraUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("consultaUsuario.jsp");
    }
}
