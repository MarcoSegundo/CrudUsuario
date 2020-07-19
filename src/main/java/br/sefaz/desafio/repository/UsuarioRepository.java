package br.sefaz.desafio.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import br.sefaz.desafio.model.UsuarioModel;
import br.sefaz.desafio.entity.UsuarioEntity;
import br.sefaz.desafio.utils.Utils;
 
 
public class UsuarioRepository implements Serializable {
 
	@Inject
	UsuarioEntity usuarioEntity;
 
	EntityManager entityManager;
	
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity validarUsuario(UsuarioModel usuarioModel){
 
		try {
 
			Query query = Utils.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			query.setParameter("nome", usuarioModel.getNome());
			query.setParameter("senha", usuarioModel.getSenha());
 
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
	}
	
	public void inserir(UsuarioModel usuarioModel){
		 
		entityManager =  Utils.JpaEntityManager();
 
		usuarioEntity = new UsuarioEntity();
		usuarioEntity.setNome(usuarioModel.getNome());
		usuarioEntity.setEmail(usuarioModel.getEmail());
		usuarioEntity.setSenha(usuarioModel.getSenha());
 
		entityManager.persist(usuarioEntity);
 
	}
}
