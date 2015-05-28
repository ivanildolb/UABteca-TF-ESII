package controlador.usuario;

import modelo.livro.Livro;
import modelo.livro.LivroDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDao;

/**
 *
 * @author Ivanildo
 */
@WebServlet(name = "AdicionaUsuario", urlPatterns = {"/AdicionaUsuario"})
public class AdicionaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        // buscando os parametros no request
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String email = request.getParameter("email");
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        
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
        
        // monta um objeto usuario
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setEmail(email);
        usuario.setMatricula(matricula);
        usuario.setSenha(senha);
        usuario.setTipo(tipo);
        
        // salva o livro
        UsuarioDao dao;

        try {
            dao = new UsuarioDao();
            dao.adiciona(usuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }              
        response.sendRedirect("index.jsp");        
    }
}
