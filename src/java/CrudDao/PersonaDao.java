/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudDao;

import Beans.NewHibernateUtil;
import Idao.IDAOGENERAL;
import Modelo.Persona;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author enoc
 */
public class PersonaDao implements IDAOGENERAL<Persona, Integer>{
    
private SessionFactory factory;
   private Session session;
   private Persona userone;
   private List<Persona>userfill;
   
   public PersonaDao(){
       factory =NewHibernateUtil.getSessionFactory();
   }
    @Override
    public void insert(Persona entity) {
         session= factory.openSession();
         session.beginTransaction();
         session.save(entity);
         session.getTransaction().commit();
         session.close();
       
        
    }

    @Override
    public void delete(Integer clave) {
        session=factory.openSession();
        session.beginTransaction();
        session.delete(new Persona(clave));
        session.getTransaction().commit();
        session.close();
    }   
    @Override
    public void update(Persona  persona) {
       session= factory.openSession();
       session.beginTransaction();
       session.update(persona);
       session.getTransaction();
       session.close();
    }

    @Override
    public List<Persona> readall() {
     session= factory.openSession();
     Query query = session.createQuery("from persona");
     List list=query.list();
     session.close();
     return list;
    }

    @Override
    public Persona readone(Integer clave) {
     session= factory.openSession();
     session.beginTransaction();
     Persona user = (Persona) session.get(Persona.class, clave);
     session.getTransaction();
     session.close();
     return user;
     
    }
    
}