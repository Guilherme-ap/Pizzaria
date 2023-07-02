package testes;
import static org.junit.Assert.assertNotNull;
import java.sql.Connection;
import org.junit.Test;
import Controller.UsuarioController;
import Model.Usuario;
import static org.junit.Assert.assertEquals;
import java.util.List;


public class UsuarioControllerTest {

  @Test
  public void testarConexao() {
    Connection conn = UsuarioController.getConnection();
    assertNotNull(conn);
  }
  
  
 
  public void testarGetAllUsuarios() {
    List<Usuario> usuarios = UsuarioController.getAllUsuarios();
    assertNotNull(usuarios);
    assertEquals(7, usuarios.size()); // Altere o valor esperado de acordo com o número de registros na tabela "usuarios"
    
    // Verifique se os dados dos usuários foram recuperados corretamente
    Usuario usuario1 = usuarios.get(0);
    assertEquals("Guilherme", usuario1.getNome());
    assertEquals("11910576589", usuario1.getTelefone());
    assertEquals("guilherme@kiki.com", usuario1.getEmail());
    assertEquals("kiki", usuario1.getSenha());
    assertEquals("Rua aracilia, 123", usuario1.getEndereco());

  
  }
  
  @Test
  public void testarCriarUsuario() {
    Usuario usuario = new Usuario();
    usuario.setNome("Novo Usuário");
    usuario.setTelefone("1234567890");
    usuario.setEmail("novo@usuario.com");
    usuario.setSenha("senha123");
    usuario.setEndereco("Rua Nova, 123");

    int status = UsuarioController.criarUsuario(usuario);
    assertEquals(1, status);
  }
  
 
}




	


