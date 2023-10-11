package br.edu.unifio.sistemabiomedicina.controllers;

import br.edu.unifio.sistemabiomedicina.models.entities.Usuario;
import br.edu.unifio.sistemabiomedicina.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Data
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    public void autenticarUsuario() {
        //System.out.println(usuario);
        if (usuario == null || usuario.getLogin() == null || usuario.getSenha() == null) {
            Messages.addFlashGlobalError("Erro de entrada");
        }

        Usuario user = autenticarLoginSenha(usuario);

        /* Se o user for diferente de null o usuário está autenticado */
        if (user != null) {
            Messages.addFlashGlobalInfo("Autenticado com sucesso.");
        } else {
            Messages.addFlashGlobalError("Usuário ou senha incorreta.");
        }
    }

    /* Itera a lista de usuários do banco e retorna o usuário se login e senha coincidirem */
    public Usuario autenticarLoginSenha(Usuario usuario) {
        for (Usuario user : usuarios) {
            if (usuario.getLogin().equals(user.getLogin()) && usuario.getSenha().equals(user.getSenha())) {
                return user;
            }
        }
        return null;
    }

    @PostConstruct
    public List<Usuario> getUsuariosCadastrados() {
        usuarios = usuarioRepository.getAll();
        return usuarios;
    }
}
