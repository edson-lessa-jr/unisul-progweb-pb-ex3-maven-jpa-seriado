package br.unisul.aula.banco;

import br.unisul.aula.model.Episodio;
import br.unisul.aula.model.Temporada;

import javax.persistence.EntityManager;
import java.util.List;

public class EpisodioImpl implements Banco<Episodio> {
    @Override
    public void insert(Episodio episodio) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(episodio);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Episodio episodio) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(episodio);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Episodio episodio) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(episodio);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Episodio> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();

        return entityManager
                .createQuery("SELECT e FROM Episodio e", Episodio.class)
                .getResultList();
    }

    @Override
    public Episodio findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.getReference(Episodio.class, id);
    }
}