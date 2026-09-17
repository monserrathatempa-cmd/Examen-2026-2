/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.Examen2026.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.Examen2026.persistence.dao.AdministradorDAO;
import mx.Examen2026.persistence.dao.ProfesorDAO;
import mx.Examen2026.persistence.dao.UnidadDAO;
import mx.Examen2026.persistence.persistence.HibernateUtil;


/**
 *
 * @author total
 */
public class ServiceLocator {

    private static ProfesorDAO profesorDAO;
    private static UnidadDAO unidadDAO;
    private static AdministradorDAO administradorDAO;

    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }

    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO(getEntityManager());
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UnidadDAO getInstanceUnidadDAO(){
        if(unidadDAO == null){
            unidadDAO = new UnidadDAO(getEntityManager());
            return unidadDAO;
        } else{
            return unidadDAO;
        }
    }


    public static AdministradorDAO getInstanceAdministradorDAO(){
        if(administradorDAO == null){
            administradorDAO = new AdministradorDAO(getEntityManager());
            return administradorDAO;
        } else{
            return administradorDAO;
        }
    }
    
}
