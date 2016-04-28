package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaDAO implements Serializable {

    @PersistenceContext(unitName = "LocadoraWebPU")
    private EntityManager em;
    private List<Pessoa> listarTodos;

    public PessoaDAO() {

    }

    public void persist(Pessoa obj) throws Exception {
        em.persist(obj);
    }

    public void merge(Pessoa obj) throws Exception {
        em.merge(obj);
    }

    public void remove(Pessoa obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }

    public Pessoa getObjectById(Integer id) throws Exception {
        return em.find(Pessoa.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Pessoa> getListarTodos() {
        return em.createQuery("from Pessoa order by nome").getResultList();
    }

    public void setListarTodos(List<Pessoa> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
