package com.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.UsuarioController;
import Model.Usuario;

@WebServlet("/cadastrar")
public class Cadastro extends HttpServlet {
	@Override
		
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String endereco = request.getParameter("endereco");

        // Cria um novo objeto Usuario com os dados do formulário
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setTelefone(telefone);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setEndereco(endereco);

        // Chama o método do controlador para criar o usuário
        int status = UsuarioController.criarUsuario(usuario);

        if (status > 0) {
            // Cadastro realizado com sucesso
            response.sendRedirect("Home.jsp");
        } else {
            // Ocorreu um erro no cadastro
            response.sendRedirect("Cadastro.jsp");
        }
    }
}
