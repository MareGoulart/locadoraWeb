package br.edu.ifsul.controle;

import br.edu.ifsul.dao.GravadoraDAO;
import br.edu.ifsul.modelo.Gravadora;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleGravadora")
@ViewScoped
public class ControleGravadora implements Serializable {

    @EJB
    private GravadoraDAO dao;
    private Gravadora objeto;

    public ControleGravadora() {

    }
    
    public String listar(){
        return "/privado/gravadora/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Gravadora();
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            UtilMensagens.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao persistir objeto: "+e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);            
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }
            
    

    public GravadoraDAO getDao() {
        return dao;
    }

    public void setDao(GravadoraDAO dao) {
        this.dao = dao;
    }

    public Gravadora getObjeto() {
        return objeto;
    }

    public void setObjeto(Gravadora objeto) {
        this.objeto = objeto;
    }
}
