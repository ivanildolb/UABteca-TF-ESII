package modelo.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexaoBD;
import modelo.usuario.Usuario;

public class LoginDAO {
    // a conexao com o banco de dados
    private Connection connection;

    public LoginDAO() throws ClassNotFoundException {
        this.connection = new ConexaoBD().getConnection();
    }
    
    public List<Usuario> validaLogin(){
        String sql = "SELECT nome, email, matricula, senha FROM usuarios";
        try {
            List<Usuario> listUsuarios = new ArrayList<Usuario>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto produto
                Usuario usuario = new Usuario();
                //setando valores
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setSenha(rs.getString("senha"));          
                                
                // adicionando o objeto a lista
                listUsuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            return listUsuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
