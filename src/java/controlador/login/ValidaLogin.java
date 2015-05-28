package controlador.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.login.LoginDAO;
import modelo.usuario.Usuario;


@WebServlet(name = "ValidaLogin", urlPatterns = {"/ValidaLogin"})
public class ValidaLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            // buscando os parametros no request
            String matricula = request.getParameter("matricula");
            String senha = request.getParameter("senha");

            //fazendo busca no banco
            LoginDAO dao = new LoginDAO();
            List<Usuario> listUsuarios = dao.validaLogin();
            for (Usuario usuario : listUsuarios) {
                //validando login e acessando sistema
                if (matricula.equals(usuario.getMatricula())
                        && senha.equals(usuario.getSenha())) {

                    response.sendRedirect("index.jsp");
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"login.htmal\"><input id = \"b1\" type = \"button\" value = \"Voltar\"></a>");
            out.println("<h3> Dados incorretos, tente novamente! </h3>");
            out.println("</body>");
            out.println("</html>");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
