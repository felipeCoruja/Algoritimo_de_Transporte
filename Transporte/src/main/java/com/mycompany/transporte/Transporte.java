/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transporte;

import Classes.CantoNoroeste2;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class Transporte {

    public static void main(String[] args) {
        CantoNoroeste2 cantoNoroeste = new CantoNoroeste2();
        cantoNoroeste.setCaminhoArquivo("C:\\Users\\felipe\\Documents\\NetBeansProjects\\AlgoritimoTransporteCantoNoroeste\\src\\main\\java\\com\\mycompany\\algoritimotransportecantonoroeste\\arquivo.csv");
        try {
            cantoNoroeste.loadArquivo();
            System.out.println("\n ========== Matriz de Custos =========");
            cantoNoroeste.printMatrixCusto();
            System.out.println("\n======================");
            
            cantoNoroeste.start();
            
        } catch (IOException ex) {
           
        }
    }
}
