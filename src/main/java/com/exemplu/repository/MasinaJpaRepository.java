package com.exemplu.repository;

import com.exemplu.Masina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class MasinaJpaRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Masina> findAll(){
        TypedQuery<Masina> query = em.createQuery("from Masina", Masina.class);
        return query.getResultList();
    }
    public Masina findByNrInmatriculare(String NrInmatriculare){
        return em.find(Masina.class, NrInmatriculare);
    }
    public void deleteByNrInmatriculare(String NrInmatriculare){
        Masina masina=em.find(Masina.class, NrInmatriculare);
        em.remove(masina);
    }
    public Masina insert(Masina masina){
        return em.merge(masina);
    }
    public Masina update(Masina masina){
        return em.merge(masina);
    }
}
