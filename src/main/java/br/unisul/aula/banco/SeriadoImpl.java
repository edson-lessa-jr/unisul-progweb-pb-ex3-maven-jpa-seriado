package br.unisul.aula.banco;

import br.unisul.aula.model.Seriado;

import javax.persistence.EntityManager;
import java.util.List;

public class SeriadoImpl implements Banco<Seriado>{
    @Override
    public void insert(Seriado seriado) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(seriado);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Seriado seriado) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(seriado);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Seriado seriado) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(seriado);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Seriado> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();

        return entityManager
                .createQuery("SELECT s FROM Seriado s", Seriado.class)
                .getResultList();
    }

    @Override
    public Seriado findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.getReference(Seriado.class, id);
    }
}
