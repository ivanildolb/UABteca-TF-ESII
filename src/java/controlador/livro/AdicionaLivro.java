package controlador.livro;

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

@WebServlet(name = "AdicionaLivro", urlPatterns = {"/AdicionaLivro"})
public class AdicionaLivro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        // buscando os parametros no request
        String titulo = request.getParameter("titulo");        
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        Integer edicao = Integer.parseInt(request.getParameter("edicao"));
        
        // monta um objeto livro
        Livro livro = new Livro();

        livro.setTitulo(titulo);        
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setEdicao(edicao);
        
        // salva o livro
        LivroDao dao;

        try {
            dao = new LivroDao();
            dao.adiciona(livro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdicionaLivro.class.getName()).log(Level.SEVERE, null, ex);
        }              
        response.sendRedirect("index.jsp");        
    }
}
