package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Editora;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EditoraDAO implements Serializable {

    @PersistenceContext(unitName = "LocadoraWebPU")
    private EntityManager em;
    private List<Editora> listarTodos;

    public EditoraDAO() {

    }

    public void persist(Editora obj) throws Exception {
        em.persist(obj);
    }

    public void merge(Editora obj) throws Exception {
        em.merge(obj);
    }

    public void remove(Editora obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }

    public Editora getObjectById(Integer id) throws Exception {
        return em.find(Editora.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Editora> getListarTodos() {
        return em.createQuery("from Editora order by nome").getResultList();
    }

    public void setListarTodos(List<Editora> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
