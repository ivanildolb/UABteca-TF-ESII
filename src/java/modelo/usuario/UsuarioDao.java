package modelo.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexaoBD;

public class UsuarioDao {

    // a conexao com o banco de dados
    private Connection connection;

    public UsuarioDao() throws ClassNotFoundException {
        this.connection = new ConexaoBD().getConnection();
    }      

    public void adiciona(Usuario usuario) {
        String sql = "insert into usuarios "
                + "(nome,sobrenome,email,matricula,senha,tipo)" 
                + " values (?,?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getMatricula());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getTipo());
                        
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }    
            
    public List<Usuario> getLista() {
        try {
            String sql = "select * from usuarios order by id";
            List<Usuario> usuariosList = new ArrayList<Usuario>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto produto
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));                
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
                               
                // adicionando o objeto � lista
                usuariosList.add(usuario);
            }
            rs.close();
            stmt.close();
            return usuariosList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Usuario usuario) {
        String sql = "update usuarios set nome=?, sobrenome=?,"
                + "email=?, matricula=?, senha=?, tipo=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());            
            stmt.setString(4, usuario.getMatricula());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getTipo());
            stmt.setInt(7, usuario.getId());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    public void remove(Livro produto) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from produto where codigo=?");

            stmt.setInt(1, produto.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}
