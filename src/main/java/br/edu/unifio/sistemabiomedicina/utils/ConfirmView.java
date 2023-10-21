package br.edu.unifio.sistemabiomedicina.utils;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ConfirmView {

    public void confirmar() {
        addMessage("Confirmado", "Alterações salvas");
    }

    public void delete() {
        addMessage("Confirmado", "Registro deletado");
    }

    public static void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
