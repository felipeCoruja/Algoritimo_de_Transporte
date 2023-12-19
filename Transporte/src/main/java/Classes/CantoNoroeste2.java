/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class CantoNoroeste2 {

    private ArrayList<Celula> linha1;
    private ArrayList<Celula> linha2;
    private ArrayList<Celula> linha3;
    private ArrayList<Celula> linha4;

    private String caminhoArquivo;

    public CantoNoroeste2() {
        this.linha1 = new ArrayList<>();
        this.linha2 = new ArrayList<>();
        this.linha3 = new ArrayList<>();
        this.linha4 = new ArrayList<>();
    }

    public void start() {
        boolean continua = true;
        int idLinha = 0;
        int idColuna = 0;
        ArrayList<Celula> linhaAux = new ArrayList<>();
        
        String[] vet = null;

        while (continua) {

            if (idLinha == 0) {
                linhaAux = this.getLinha1();
            } else if (idLinha == 1) {
                linhaAux = this.getLinha2();
            } else if (idLinha == 2) {
                linhaAux = this.getLinha3();
            } else if (idLinha == 3) {
                linhaAux = this.getLinha4();
            }
            calcula(linhaAux, idColuna, idLinha);
            System.out.println("\n===========\n");
            
            printMatrixValores();
            vet = getProximaPosicao(idLinha,idColuna);
            
            if(vet == null){
                
                break;
            }
            System.out.println("Proxima posicao"+vet[0]+"-"+vet[1]);
            
            idLinha = Integer.parseInt(vet[0]);
            idColuna = Integer.parseInt(vet[1]);
            
            continua = verificaSeAcabou();
            
           
        }
        
        System.out.println("\n O valor total da solução Z é: "+valorSolucao());
    }

    private String[] getProximaPosicao(int linhaAtual,int colunaAtual){
        
        String[] vet = null;
       
        for(int k=0;k<3;k++){
            
            if(this.linha1.get(k).getValor()== -1){
                return ("0-"+k).split("-");
                
            }
            if(this.linha2.get(k).getValor()== -1){
                return ("1-"+k).split("-");
            }
            
            if(this.linha3.get(k).getValor()== -1){
                return ("2-"+k).split("-");
            }
            
           
        }
        return vet;
    }
    
     private int valorSolucao(){
        int valor = 0;
        int custo = 0;
        int somatorio = 0;
        for(int k=0;k<3;k++){
            
            if(this.linha1.get(k).getValor()> 0){
                custo = this.linha1.get(k).getCusto();
                valor = this.linha1.get(k).getValor();
                somatorio = somatorio + (custo*valor);
                
            }
            if(this.linha2.get(k).getValor() >0){
                custo = this.linha2.get(k).getCusto();
                valor = this.linha2.get(k).getValor();
                somatorio = somatorio + (custo*valor);
            }
            
            if(this.linha3.get(k).getValor() >0){
                custo = this.linha3.get(k).getCusto();
                valor = this.linha3.get(k).getValor();
                somatorio = somatorio + (custo*valor);
            }
            
           
        }
        return somatorio;
    }
    
    
    public void calcula(ArrayList<Celula> linha, int coluna, int idLinha) {

        int producao = this.linha4.get(coluna).getProducao();
        int demanda = linha.get(3).getDemanda();

        System.out.println("Producao: " + producao);
        System.out.println("Demanda: " + demanda);

        if (demanda >= producao) {

            
            if (idLinha == 0) {

                this.linha1.get(coluna).setValor(producao);
                this.linha1.get(3).setDemanda(demanda - producao);
                this.linha4.get(coluna).setProducao(0);
                zeraColuna(coluna);
                
            } else if (idLinha == 1) {
                this.linha2.get(coluna).setValor(producao);
                this.linha2.get(3).setDemanda(demanda - producao);
                this.linha4.get(coluna).setProducao(0);
                zeraColuna(coluna);
            } else if (idLinha == 2) {
                this.linha3.get(coluna).setValor(producao);
                this.linha3.get(3).setDemanda(demanda - producao);
                this.linha4.get(coluna).setProducao(0);
                zeraColuna(coluna);
            } 

        }else {//producao > demanda
                System.out.println("Entrou em prod > dem");
                if (idLinha == 0) {

                    this.linha1.get(coluna).setValor(demanda);
                    this.linha4.get(coluna).setProducao(producao - demanda);
                    this.linha1.get(3).setDemanda(0);
                    zeraLinha(idLinha);
                    printMatrixValores();
                } else if (idLinha == 1) {
                    this.linha2.get(coluna).setValor(demanda);
                    this.linha4.get(coluna).setProducao(producao - demanda);
                    this.linha2.get(3).setDemanda(0);
                    zeraLinha(idLinha);
                } else if (idLinha == 2) {
                    this.linha3.get(coluna).setValor(demanda);
                    this.linha4.get(coluna).setProducao(producao - demanda);
                    this.linha3.get(3).setDemanda(0);
                    zeraLinha(idLinha);
                }
            }
    }
    
    
    public void zeraLinha(int linha){
        if(linha == 0){
            if(this.linha1.get(0).getValor() == -1){
                this.linha1.get(0).setValor(0);
            }
            if(this.linha1.get(1).getValor() == -1){
                this.linha1.get(1).setValor(0);
            }
            if(this.linha1.get(2).getValor() == -1){
                this.linha1.get(2).setValor(0);
            }
        }else if(linha == 1){
            if(this.linha2.get(0).getValor() == -1){
                this.linha2.get(0).setValor(0);
            }
            if(this.linha2.get(1).getValor() == -1){
                this.linha2.get(1).setValor(0);
            }
            if(this.linha2.get(2).getValor() == -1){
                this.linha2.get(2).setValor(0);
            }
        }else if(linha == 2){
            if(this.linha3.get(0).getValor() == -1){
                this.linha3.get(0).setValor(0);
            }
            if(this.linha3.get(1).getValor() == -1){
                this.linha3.get(1).setValor(0);
            }
            if(this.linha3.get(2).getValor() == -1){
                this.linha3.get(2).setValor(0);
            }
        }
        
        
    }
    
    public void zeraColuna(int coluna){
        
        if(this.linha1.get(coluna).getValor() == -1){
            this.linha1.get(coluna).setValor(0);
        }
        if(this.linha2.get(coluna).getValor() == -1){
            this.linha2.get(coluna).setValor(0);
        }
        if(this.linha3.get(coluna).getValor() == -1){
             this.linha3.get(coluna).setValor(0);
        }
    }

    public boolean verificaSeAcabou() {
        boolean flag = false;

        for (int i = 0; i < 3; i++) {
            if (this.linha1.get(i).getValor() == -1) {
                return true;
            } else if (this.getLinha2().get(i).getValor() == -1) {
                return true;
            } else if (this.getLinha3().get(i).getValor() == -1) {
                return true;
            }

        }

        return flag;
    }

    public void loadArquivo() throws FileNotFoundException, IOException {
        FileReader f = new FileReader(this.caminhoArquivo);
        Scanner arquivoLido = new Scanner(f);
        arquivoLido.useDelimiter("\n");

        String linhaLida = arquivoLido.nextLine();//pulando o cabeçalho

        int indiceUltimaLinha = 5;
        boolean ultimaLinha = false;

        int linha = 0;
        while (arquivoLido.hasNext()) {

            Celula c = new Celula();

            //(-2) pois sao 5 linhas com cabeçalho, indice de linhas validas variando de 0 a 3
            if (linha == indiceUltimaLinha - 2) {
                ultimaLinha = true;

            }

            if (linha == 0) {
                this.setLinha1(c.montarLinhaMatriz(arquivoLido.nextLine(), ultimaLinha));

            } else if (linha == 1) {
                this.setLinha2(c.montarLinhaMatriz(arquivoLido.nextLine(), ultimaLinha));
            } else if (linha == 2) {
                this.setLinha3(c.montarLinhaMatriz(arquivoLido.nextLine(), ultimaLinha));
            } else if (linha == 4) {
                this.setLinha4(c.montarLinhaMatriz(arquivoLido.nextLine(), ultimaLinha));
            }

            linha++;

        }
        arquivoLido.close();
        f.close();
    }

    public void printMatrixCusto() {

        for (int i = 0; i < 4; i++) {
            System.out.println("\n");
            for (int k = 0; k < 4; k++) {
                if (i == 0) {
                    if (k == 3) {
                        System.out.print("->[" + this.getLinha1().get(k).getDemanda() + "]");
                    } else {
                        System.out.print("[" + this.getLinha1().get(k).getCusto() + "]");
                    }

                } else if (i == 1) {
                    if (k == 3) {
                        System.out.print(" ->[" + this.getLinha2().get(k).getDemanda() + "]");
                    } else {
                        System.out.print("[" + this.getLinha2().get(k).getCusto() + "]");
                    }
                } else if (i == 2) {
                    if (k == 3) {
                        System.out.print("->[" + this.getLinha3().get(k).getDemanda() + "]");
                    } else {
                        System.out.print("[" + this.getLinha3().get(k).getCusto() + "]");
                    }
                } else if (i == 3) {
                    if (k != 3) {

                        System.out.print("[" + this.getLinha4().get(k).getProducao() + "]");
                    }
                }
            }
        }
    }

    public void printMatrixValores() {

        for (int i = 0; i < 4; i++) {
            System.out.println("\n");
            for (int k = 0; k < 4; k++) {
                if (i == 0) {
                    if (k == 3) {
                        System.out.print("->[" + this.getLinha1().get(k).getDemanda() + "]");
                    } else {
                        System.out.print("[" + this.getLinha1().get(k).getValor() + "]");
                    }

                } else if (i == 1) {
                    if (k == 3) {
                        System.out.print(" ->[" + this.getLinha2().get(k).getDemanda() + "]");
                    } else {
                        System.out.print("[" + this.getLinha2().get(k).getValor() + "]");
                    }
                } else if (i == 2) {
                    if (k == 3) {
                        System.out.print("->[" + this.getLinha3().get(k).getDemanda() + "]");
                    } else {
                        System.out.print("[" + this.getLinha3().get(k).getValor() + "]");
                    }
                } else if (i == 3) {
                    if (k != 3) {

                        System.out.print("[" + this.getLinha4().get(k).getProducao() + "]");
                    }
                }
            }
        }
    }

    /**
     * @return the linha1
     */
    public ArrayList<Celula> getLinha1() {
        return linha1;
    }

    /**
     * @param linha1 the linha1 to set
     */
    public void setLinha1(ArrayList<Celula> linha1) {
        this.linha1 = linha1;
    }

    /**
     * @return the linha2
     */
    public ArrayList<Celula> getLinha2() {
        return linha2;
    }

    /**
     * @param linha2 the linha2 to set
     */
    public void setLinha2(ArrayList<Celula> linha2) {
        this.linha2 = linha2;
    }

    /**
     * @return the linha3
     */
    public ArrayList<Celula> getLinha3() {
        return linha3;
    }

    /**
     * @param linha3 the linha3 to set
     */
    public void setLinha3(ArrayList<Celula> linha3) {
        this.linha3 = linha3;
    }

    /**
     * @return the linha4
     */
    public ArrayList<Celula> getLinha4() {
        return linha4;
    }

    /**
     * @param linha4 the linha4 to set
     */
    public void setLinha4(ArrayList<Celula> linha4) {
        this.linha4 = linha4;
    }

    /**
     * @return the caminhoArquivo
     */
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    /**
     * @param caminhoArquivo the caminhoArquivo to set
     */
    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }
}
