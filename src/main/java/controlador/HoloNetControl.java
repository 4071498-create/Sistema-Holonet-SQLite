/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Collections;
import java.util.List;

import ut4.sqlite.modelo.Nave;
import ut4.sqlite.modelo.CazaLigero;


public class HoloNetControl {
    // Inicialización del SessionFactory de Hibernate
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    public static SessionFactory getSessionFactory() {
        return sf;
    }
    
    //Operacion 1
    public void registrarNuevaNave(Nave nave) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.persist(nave);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    //Operacion 2
    public void actualizarEstadoDesconectado(Nave naveModificada) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.merge(naveModificada);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    //Operacion 3
    public List<CazaLigero> obtenerCazasPorPotenciaMinima(int potenciaMinima) {
        try (Session session = sf.openSession()) {
            String hql = "SELECT c FROM CazaLigero c "
                       + "JOIN FETCH c.planetaOrigen "
                       + "WHERE c.potenciaFuego >= :potenciaMinima";
            return session.createQuery(hql, CazaLigero.class)
                          .setParameter("potenciaMinima", potenciaMinima)
                          .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
    //Operacion 4
    public boolean darDeBajaNave(int idNave) {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            Nave nave = session.find(Nave.class, idNave);
            if (nave != null) {
                session.remove(nave);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
    
}
