package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import java.util.ArrayList;
import Model.Usuario;


public class UsuarioController {
	

	public static Connection getConnection() {
	    Connection conn = null;
	    String URL = "jdbc:mysql://localhost:3306/cafeteria";
	    String USUARIO = "root";
	    String SENHA = "admin";

	    try {
	        conn = DriverManager.getConnection(URL, USUARIO, SENHA);
	    } catch (SQLException e) {
	       System.out.println(e);
	    }

	    return conn;
	}

    	
	public static List<Usuario> getAllUsuarios(){
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEndereco(rs.getString("endereco"));
			list.add(usuario);
			
			
			    		}
		
		
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
    	
    
    public static int criarUsuario(Usuario usuario) {
        int status = 0;

   
            try {
            	 Connection conn = getConnection();
            	 String sql = "INSERT INTO usuarios (nome, telefone, email, senha, endereco) VALUES (?, ?, ?, ?, ?)";
                 PreparedStatement ps  = (PreparedStatement) conn.prepareStatement(sql);
                 ps.setString(1, usuario.getNome());
                 ps.setString(2, usuario.getTelefone());
                 ps.setString(3, usuario.getEmail());
                 ps.setString(4, usuario.getSenha());
                 ps.setString(5, usuario.getEndereco());
                 status = ps.executeUpdate();
           
            }catch (Exception e) {
             System.out.println(e);
            }
            
            return status;
              
}
}
