package br.sefaz.desafio.controller.usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.sefaz.desafio.model.UsuarioModel;
import br.sefaz.desafio.repository.UsuarioRepository;
import br.sefaz.desafio.utils.Utils;

@Named(value="usuarioController")
@RequestScoped
public class UsuarioController {
 
	@Inject
	UsuarioModel usuarioModel;
 
	@Inject
	UsuarioRepository usuarioRepository;
 
 
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
	public void inserirUsuario(){
 
		usuarioRepository.inserir(this.usuarioModel);
 
		this.usuarioModel = null;
 
		Utils.MensagemInfo("Registro cadastrado com sucesso");
 
	}
 
}
