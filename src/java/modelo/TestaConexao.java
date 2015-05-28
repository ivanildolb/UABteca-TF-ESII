package modelo;

import java.sql.Connection;
import java.sql.SQLException;



public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        try (Connection connection = new ConexaoBD().getConnection()) {
            System.out.println("Conexao aberta!");
            connection.close();
            System.out.println("Conexao fechada!");
        }
    }
}
