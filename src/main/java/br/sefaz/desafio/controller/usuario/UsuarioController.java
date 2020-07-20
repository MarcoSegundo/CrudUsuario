package br.sefaz.desafio.controller.usuario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.sefaz.desafio.converter.UsuarioConverter;
import br.sefaz.desafio.entity.UsuarioEntity;
import br.sefaz.desafio.model.UsuarioModel;
import br.sefaz.desafio.repository.UsuarioRepository;

@Named(value="usuarioController")
@RequestScoped
public class UsuarioController {
 
	@Inject transient
	UsuarioModel usuarioModel;
	
	@Produces
	List<UsuarioModel> listaUsuarios;
 
	@Inject transient
	UsuarioRepository usuarioRepository;
 
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	public List<UsuarioModel> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<UsuarioModel> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	@PostConstruct
	public void init(){
		
		this.listaUsuarios = UsuarioConverter.toListModel(usuarioRepository.listarTodos());
	}
	
	public void carregarEdicao(UsuarioModel usuarioModel){		 
		
		this.usuarioModel = usuarioModel;
	}
	
	public void alterar(){
		 
		UsuarioEntity usuarioEntity = UsuarioConverter.toEntity(getUsuarioModel());
		
		usuarioRepository.salvar(usuarioEntity);
 
		this.init();
	}
	
	public void excluir(UsuarioModel usuarioModel) {
		UsuarioEntity usuarioEntity = usuarioRepository.obterPorCodigo(usuarioModel.getCodigo());
		
		usuarioRepository.remover(usuarioEntity);
		
		this.listaUsuarios.remove(usuarioModel);
	}
}
