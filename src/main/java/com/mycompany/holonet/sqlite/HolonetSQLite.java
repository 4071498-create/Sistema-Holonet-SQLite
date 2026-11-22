/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.holonet.sqlite;
import controlador.HoloNetControl;

/**
 *
 * @author prato
 */
public class HolonetSQLite {

    public static void main(String[] args) {
        HoloNetControl control = new HoloNetControl();
        System.out.println("Sistema HoloNet inicializado correctamente.");
        
        HoloNetControl.getSessionFactory().close();
    }
}
