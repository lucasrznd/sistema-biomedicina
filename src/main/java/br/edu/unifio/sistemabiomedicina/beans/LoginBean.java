package br.edu.unifio.sistemabiomedicina.beans;

import br.edu.unifio.sistemabiomedicina.models.entities.Usuario;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private Usuario usuario;

    public void autenticarUsuario(String login, String senha) {

    }
}
