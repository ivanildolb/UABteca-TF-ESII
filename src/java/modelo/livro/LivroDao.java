package modelo.livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexaoBD;

public class LivroDao {

    // a conexao com o banco de dados
    private Connection connection;

    public LivroDao() throws ClassNotFoundException {
        this.connection = new ConexaoBD().getConnection();
    }

    public void adiciona(Livro livro) {
        String sql = "insert into livros "
                + "(titulo,autor,editora,edicao)" 
                + " values (?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, livro.getTitulo());            
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getEdicao());
                        
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }    
    
        
    public List<Livro> getLista() {
        try {
            List<Livro> livrosList = new ArrayList<Livro>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from livros order by id");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto produto
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));                
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setEdicao(rs.getInt("edicao"));
                               
                // adicionando o objeto � lista
                livrosList.add(livro);
            }
            rs.close();
            stmt.close();
            return livrosList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void altera(Livro livro) {
        String sql = "update livros set titulo=?,"
                + "autor=?, editora=?,edicao=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());            
            stmt.setInt(4, livro.getEdicao());
            stmt.setInt(5, livro.getId());
            
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
