package br.edu.ifsul.controle;

import br.edu.ifsul.dao.EditoraDAO;
import br.edu.ifsul.modelo.Editora;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "controleEditora")
@ViewScoped
public class ControleEditora implements Serializable {

    @EJB
    private EditoraDAO dao;
    private Editora objeto;

    public ControleEditora() {

    }
    
    public String listar(){
        return "/privado/editora/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Editora();
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
            
    

    public EditoraDAO getDao() {
        return dao;
    }

    public void setDao(EditoraDAO dao) {
        this.dao = dao;
    }

    public Editora getObjeto() {
        return objeto;
    }

    public void setObjeto(Editora objeto) {
        this.objeto = objeto;
    }
}
