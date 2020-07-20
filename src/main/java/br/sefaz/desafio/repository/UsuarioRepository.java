package br.sefaz.desafio.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.sefaz.desafio.entity.UsuarioEntity;
import br.sefaz.desafio.utils.JPAUtil;
 
 
public class UsuarioRepository extends AbstractRepository<UsuarioEntity, Integer> implements IUsuarioRepository, Serializable {
 
	@Inject
	UsuarioEntity usuarioEntity;
	
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity validarUsuario(String nome, String senha){
 
		try {
 
			Query query = JPAUtil.JpaEntityManager().createQuery("SELECT u FROM UsuarioEntity u WHERE upper(u.nome) = upper(:nome) AND u.senha = :senha");
 
			query.setParameter("nome", nome);
			query.setParameter("senha", senha);
 
			return (UsuarioEntity)query.getSingleResult();
 
		}catch(NoResultException e) {
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
 
	}
}
