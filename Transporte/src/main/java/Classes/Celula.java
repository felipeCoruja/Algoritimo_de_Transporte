/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class Celula {

   
    private int custo;
    private int valor;
    private int demanda;
    private int producao;
    
    
    public Celula(){
        this.custo = -1;
        this.valor = -1;
        this.demanda = -1;
        this.producao = -1;
        
    }
    
    //RECEBE UMA LINHA DE CSV E RETORNA UM ARRAY DE CELULAS PREENCHIDAS
    public ArrayList<Celula> montarLinhaMatriz(String linhaLida, boolean ultimaLinha){
        ArrayList lista = new ArrayList<>();
        String[] vet = linhaLida.split(";");
        Celula c1 = new Celula();
        Celula c2 = new Celula();
        Celula c3 = new Celula();
        Celula demandaProducao = new Celula();
        
        if(ultimaLinha){
            c1.setProducao(Integer.parseInt(vet[0]));
            c2.setProducao(Integer.parseInt(vet[1]));
            c3.setProducao(Integer.parseInt(vet[2]));

            
        }else{
            c1.setCusto(Integer.parseInt(vet[0]));
            c2.setCusto(Integer.parseInt(vet[1]));
            c3.setCusto(Integer.parseInt(vet[2]));

            demandaProducao.setDemanda(Integer.parseInt(vet[3]));

        }
        
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(demandaProducao);
        
        return lista;
    }
    
     /**
     * @return the custo
     */
    public int getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(int custo) {
        this.custo = custo;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the demanda
     */
    public int getDemanda() {
        return demanda;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    /**
     * @return the producao
     */
    public int getProducao() {
        return producao;
    }

    /**
     * @param producao the producao to set
     */
    public void setProducao(int producao) {
        this.producao = producao;
    }
}
