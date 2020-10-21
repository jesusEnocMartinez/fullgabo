/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idao;

import CrudDao.PersonaDao;
import Modelo.Persona;
import java.util.List;

/**
 *
 * @author enoc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IDAOGENERAL midao= new PersonaDao();
        List <Persona> users = midao.readall();
        
        
        for(Persona person: users){
            System.out.println(person.toString());
        }
        
    }
    
}
