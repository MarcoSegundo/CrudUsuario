package br.sefaz.desafio.repository;

import java.util.List;

import br.sefaz.desafio.entity.UsuarioEntity;

public interface IUsuarioRepository {
	
	UsuarioEntity salvar(UsuarioEntity usuario);
	
	void remover(UsuarioEntity usuario);
	
	List<UsuarioEntity> listarTodos();
	
	UsuarioEntity obterPorCodigo(Integer codigo);
	
	UsuarioEntity validarUsuario(String nome, String senha);
}
