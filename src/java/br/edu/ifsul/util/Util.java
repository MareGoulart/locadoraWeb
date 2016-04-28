package br.edu.ifsul.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {

    public static void mensagemInformacao(String texto) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public static void mensagemErro(String texto) {
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, "");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }
}
