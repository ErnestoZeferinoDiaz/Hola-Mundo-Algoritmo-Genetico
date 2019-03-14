package ag;

import java.util.ArrayList;

public class Ruleta extends Selection{
    private double frecuenciaEsperadaTotal = 0;//f
    private ArrayList<Double> valoresEsperados;//Ve
    private double r;//Numero pseudoAleatorio7
    private double t;
    
    public Ruleta(int n, ArrayList<Cromosoma> p) {
        super(n, p);
        this.valoresEsperados = new ArrayList();
        
    }

    private void calcFrecuenciaEsperadaTotal(){
        double s=0;
        for(int x=0; x<this.getPopulationSize(); x++){
            s=s+this.fitness.get(x);
        }
        frecuenciaEsperadaTotal=s/this.getPopulationSize();
    }
    private void calcValoresEsperados(){
        t=0;
        for(int x=0; x<this.getPopulationSize(); x++){
            valoresEsperados.add(this.fitness.get(x)*this.getFrecuenciaEsperadaTotal());
            t=t+valoresEsperados.get(x);
        }
    }
    private void calcR(){
        double n=cin.nextInt((int)t);
        this.r=n;
    }
    private void calcIndividuo(){
        int x;
        double tmp=0;
        x=0;
        do{
            tmp=tmp+valoresEsperados.get(x);
            if(tmp>r){
                this.indexs.add(x);
            }
            x++;
        }while(x<this.getPopulationSize() && tmp<r);
    }
    public double getFrecuenciaEsperadaTotal() {
        return frecuenciaEsperadaTotal;
    }
    @Override
    public void run() {
        calcFrecuenciaEsperadaTotal();
        // calcular valores esperados
        calcValoresEsperados();        
        // Generar valor aleatorio entre 0 y T = r
        for(int x=0; x<this.numSelection; x++){
            calcR();
            // comparar r con los valores esperados
            calcIndividuo();
        }
    }
    
}
