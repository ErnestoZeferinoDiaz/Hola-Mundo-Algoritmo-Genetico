package ag;

import java.util.ArrayList;
import java.util.Random;

public class Cromosoma implements Comparable<Cromosoma>{
    private String cromo;
    private static int totGen;
    private static String alfabeto;
    private static Random cin;
    private double fit;
    public Cromosoma(){
        cin = new Random();
    }
    public void init(){
        int index;
        cromo="";
        for (int i = 0; i < 10; i++) {
            index=cin.nextInt(alfabeto.length()-1);
            cromo+=alfabeto.charAt(index);
        }
        this.runFit();
    }
    private void runFit(){
        this.fit=Fitness.fitness(this);
    }
    public double getAptitud(){
        return this.fit;
    }
    public ArrayList<Cromosoma> cruza(Cromosoma a){
        ArrayList<Cromosoma> hijos = new ArrayList();
        int corte = cin.nextInt(totGen);     
        hijos.add(new Cromosoma());
        hijos.add(new Cromosoma());
        hijos.get(0).setCromo(this.getCromo().substring(0,corte)+a.getCromo().substring(corte));
        hijos.get(1).setCromo(a.getCromo().substring(0,corte)+this.getCromo().substring(corte));        
        return hijos;
    }
    
    public void mutar(){
        String cad="";
        int i=cin.nextInt(alfabeto.length());
        int j=cin.nextInt(totGen);
        cad=cromo.substring(0,j)+alfabeto.charAt(i)+cromo.substring(j+1);
        this.setCromo(cad);
    }
    public String getCromo() {
        return cromo;
    }
    public void setCromo(String cromo) {
        this.cromo = cromo;
        this.runFit();
    }
    public int getTotGen() {
        return totGen;
    }
    public void setTotGen(int totGen) {
        this.totGen = totGen;
    }
    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }
    public String toString(){
        return cromo+": "+this.getAptitud()+"";
    }

    
    public int compareTo(Cromosoma o) {
        int r;
        if(this.getAptitud()>o.getAptitud()){
            r=1;
        }else if(this.getAptitud()<o.getAptitud()){
            r=-1;
        }else{
            r=0;
        }
        return r;
    }
    
    
   
}
