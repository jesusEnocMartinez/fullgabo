/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import CrudDao.Daouserlogin;
import Modelo.usuario;
import Beans.NewHibernateUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



/**
 *
 * @author enoc
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    private Daouserlogin daologin;
    private usuario user;
    
    public LoginBean() {
      daologin= new Daouserlogin();
        user = new usuario();
    }

    public usuario getUser() {
        return user;
    }

    public void setUser(usuario user) {
        this.user = user;
    }
  
 
    
    public String checarUsuario() {
       usuario usu;
       String r = "";
        System.out.println(user.getClave());
      usu = daologin.ChecarDatos(user);
     if(usu!=null){
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usu);
      r = "lista";
       addMessage("Se inicio sesion");
     } else {
      r = "index";
       addMessage("Error usuario no encontrado");
    }
return r;
}
    
    
    
    
   
        
    public void checarsession() {
      usuario user =(usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if(user==null){
          try {
              FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
          } catch (IOException ex) {
              Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
     public String cerrar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/index.xhtml?faces-redirect=true" ;
        
           }
    
     public void insert() {
        daologin.registroNuevo(this.user);
        this.user = new usuario();
        NewHibernateUtil.getSessionFactory();
         addMessage("Se registro");
    }
      public String navegaNuevo() {
        return "registro.xhtml";
    }
    
    public String navegaPrincipal() {
        return "index.xhtml";
    }
    
      public void REGISTRADO() {
        addMessage("Se Registro");
    }
        public void INICIO() {
        addMessage("Error usuario no encontrado");
    }
          public void salir() {
        addMessage("session cerrada");
    }
    
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}