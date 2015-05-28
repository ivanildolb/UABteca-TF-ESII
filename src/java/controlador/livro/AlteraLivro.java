package controlador.livro;

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

/**
 *
 * @author Ivanildo
 */
@WebServlet(name = "AlteraLivro", urlPatterns = {"/AlteraLivro"})
public class AlteraLivro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        Livro livro = new Livro();
        
        livro.setId(Integer.parseInt(request.getParameter("id").trim()));
        livro.setTitulo(request.getParameter("titulo"));
        livro.setAutor(request.getParameter("autor"));
        livro.setEditora(request.getParameter("editora"));
        livro.setEdicao(Integer.parseInt(request.getParameter("edicao").trim()));
        
        LivroDao dao;
        try {
            dao = new LivroDao();
            dao.altera(livro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlteraLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("consultaLivros.jsp");
    }
}
