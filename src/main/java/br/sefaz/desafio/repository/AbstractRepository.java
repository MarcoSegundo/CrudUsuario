package br.sefaz.desafio.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sefaz.desafio.entity.AbstractEntity;
import br.sefaz.desafio.utils.JPAUtil;

public abstract class AbstractRepository<Entity extends AbstractEntity, PK extends Number> {
	
	private Class<Entity> entityClass;
	
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		this.em = JPAUtil.JpaEntityManager();
		
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<Entity>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	public Entity salvar(Entity e) {
		if (e.getCodigo() != 0)
			return em.merge(e);
		else {
			em.persist(e);
			return e;
		}
	}

	public void remover(Entity e) {
		em.remove(e);
	}
	
	public Entity obterPorCodigo(PK codigo) { 
		return em.find(entityClass, codigo); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Entity> listarTodos() {
		Query query = em.createQuery("SELECT o FROM "+entityClass.getName() + " o");
		return (List<Entity>) query.getResultList(); 
	}

}
