package br.sefaz.desafio.controller.usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.sefaz.desafio.converter.UsuarioConverter;
import br.sefaz.desafio.entity.UsuarioEntity;
import br.sefaz.desafio.model.UsuarioModel;
import br.sefaz.desafio.repository.UsuarioRepository;
import br.sefaz.desafio.utils.MessageUtil;

@Named(value="cadastrarUsuarioController")
@RequestScoped
public class CadastrarUsuarioController {
 
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
		
		UsuarioEntity usuarioEntity = UsuarioConverter.toEntity(getUsuarioModel());
		
		usuarioRepository.salvar(usuarioEntity);
 
		this.usuarioModel = null;
 
		MessageUtil.MensagemInfo("Registro cadastrado com sucesso");
 
	}
}
