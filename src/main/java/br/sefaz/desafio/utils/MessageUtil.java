package br.sefaz.desafio.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtil {
	public static void Mensagem(String mensagem){
		 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage("Alerta",mensagem));
	}
 
	public static void MensagemAtencao(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
	}
 
	public static void MensagemInfo(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}
}
