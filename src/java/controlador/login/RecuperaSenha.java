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
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@WebServlet(name = "RecuperaSenha", urlPatterns = {"/RecuperaSenha"})
public class RecuperaSenha extends HttpServlet {

    private String senha = "senha";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecuperaSenha</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecuperaSenha at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

            // buscando os parametros no request
            String matricula = request.getParameter("matricula");
            String email = request.getParameter("email");

            //fazendo busca no banco
            LoginDAO dao = new LoginDAO();
            List<Usuario> listUsuarios = dao.validaLogin();
            for (Usuario usuario : listUsuarios) {
                //validando login e acessando sistema
                if (matricula.equals(usuario.getMatricula())
                        && email.equals(usuario.getEmail())) {

                    SimpleEmail simpleEmail = new SimpleEmail();
                    //simpleEmail.setSSLOnConnect(true);
                    simpleEmail.setHostName("smtp.gmail.com");
                    simpleEmail.setSmtpPort(587);
                    simpleEmail.setAuthenticator(new DefaultAuthenticator("ivanildolb25@gmail.com", senha));
                    simpleEmail.setFrom("ivanildolb25@gmail.com");     
                    simpleEmail.setDebug(true); 
                                                           
                    simpleEmail.addTo(usuario.getEmail()); //destinatário 
                    simpleEmail.setSubject("Senha de Acesso - UABteca"); // assunto do e-mail 
                    simpleEmail.setMsg("Sua senha de acesso ao UABteca é: "); //conteudo do e-mail 
                    
                    simpleEmail.send(); //envia o e-mail

                    //response.sendRedirect("index.jsp");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecuperaSenha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmailException ex) {
            Logger.getLogger(RecuperaSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
