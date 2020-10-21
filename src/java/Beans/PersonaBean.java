/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import CrudDao.PersonaDao;
import Idao.IDAOGENERAL;
import Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author enoc
 */
@ManagedBean(name="PersonaBean")
@RequestScoped
public class PersonaBean {
    private Persona person;
    private List <Persona> userfind;
    private IDAOGENERAL MIDAO;
    private  int clave;
    
    public PersonaBean(){
    person =new Persona();
    userfind=new ArrayList();
    MIDAO= new PersonaDao();
     userfind =MIDAO.readall();
    }
    
    public void sendData(){
    MIDAO.insert(person);
        addMessage("Registrado!!");
    }

    public void delete(){
        System.out.println("delete");
        MIDAO.delete(clave);
        userfind=MIDAO.readall();
        addMessage("ELIMINADO!!");
    }
    public void update(){
        System.out.println("update");
        MIDAO.update(person);
    }
    
   
    public Persona getUser() {
        return person;
    }

    public void setUser(Persona user) {
        this.person = user;
    }

    public List<Persona> getUserfind() {
        return userfind;
    }

    public void setUserfind(List<Persona> userfind) {
        this.userfind = userfind;
    }

    public IDAOGENERAL getMIDAO() {
        return MIDAO;
    }

    public void setMIDAO(IDAOGENERAL MIDAO) {
        this.MIDAO = MIDAO;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
    
       public void REGISTRADO() {
        addMessage("REGISTRADO!!");
    }
       
          public void eliminado() {
        addMessage("ELIMINADO!!");
    }
       
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
