package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Gravadora;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GravadoraDAO implements Serializable {

    @PersistenceContext(unitName = "LocadoraWebPU")
    private EntityManager em;
    private List<Gravadora> listarTodos;

    public GravadoraDAO() {

    }

    public void persist(Gravadora obj) throws Exception {
        em.persist(obj);
    }

    public void merge(Gravadora obj) throws Exception {
        em.merge(obj);
    }

    public void remove(Gravadora obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }

    public Gravadora getObjectById(Integer id) throws Exception {
        return em.find(Gravadora.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Gravadora> getListarTodos() {
        return em.createQuery("from Gravadora order by nome").getResultList();
    }

    public void setListarTodos(List<Gravadora> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
