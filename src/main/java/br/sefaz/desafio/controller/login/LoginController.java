package br.sefaz.desafio.controller.login;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.sefaz.desafio.model.UsuarioModel;
import br.sefaz.desafio.repository.UsuarioRepository;
import br.sefaz.desafio.entity.UsuarioEntity;
import br.sefaz.desafio.utils.Utils;

@Named(value="loginController")
@SessionScoped
public class LoginController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject
	private UsuarioModel usuarioModel;
 
	@Inject
	private UsuarioRepository usuarioRepository;
 
	@Inject
	private UsuarioEntity usuarioEntity;
 
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
	public UsuarioModel GetUsuarioSession(){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		return (UsuarioModel)facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}
 
	public String logout(){
 
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
 
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String efetuarLogin(){
 
		if(validarCamposLogin(usuarioModel.getNome(), usuarioModel.getSenha()))
		{	
 
			usuarioEntity = usuarioRepository.validarUsuario(usuarioModel);
 
			if(usuarioEntity!= null){
 
				usuarioModel.setSenha(null);
				usuarioModel.setCodigo(usuarioEntity.getCodigo());
 
 
				FacesContext facesContext = FacesContext.getCurrentInstance();
 
				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);
 
 
				return "sistema/home?faces-redirect=true";
			}
			else{
 
				Utils.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}
		
		return null;
	}
	
	private boolean validarCamposLogin(String nome, String senha) {
		if(StringUtils.isEmpty(nome) || StringUtils.isBlank(nome)){
			 
			Utils.Mensagem("Favor informar o login!");
			return false;
		}
		else if(StringUtils.isEmpty(senha) || StringUtils.isBlank(senha)){
 
			Utils.Mensagem("Favor informara senha!");
			return false;
		}
		
		return true;
	}
 
}
