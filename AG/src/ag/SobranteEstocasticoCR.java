package ag;

import java.util.ArrayList;

public class SobranteEstocasticoCR extends Selection{
    
    private ArrayList<Double> valoresEsperados;
    private ArrayList<Double> parteFraccionaria;
    private ArrayList<Double> prob;
    private double frecuenciaEsperada;
    private double frecuenciaProb;
    public SobranteEstocasticoCR(int n, ArrayList<Cromosoma> p) {
        super(n, p);
        valoresEsperados = new ArrayList();
        parteFraccionaria = new ArrayList();
        prob = new ArrayList();
    }

    private void calcFrecuenciaEsperadaTotal(){
        double s=0;
        for(int x=0; x<this.getPopulationSize(); x++){
            s=s+this.fitness.get(x);
        }
        frecuenciaEsperada=s/this.getPopulationSize();
    }
    private void calcValoresEsperados(){
        frecuenciaProb=0;
        for(int x=0; x<this.getPopulationSize(); x++){
            valoresEsperados.add(this.fitness.get(x)/this.frecuenciaEsperada);
            parteFraccionaria.add(valoresEsperados.get(x)-Math.floor(valoresEsperados.get(x)));
            frecuenciaProb=frecuenciaProb+parteFraccionaria.get(x);
        }
    }
    private void calcIndividuo(){        
        double r;
        double ant,desp;
        for(int x=0; x<this.getPopulationSize(); x++){
            prob.add(parteFraccionaria.get(x)/frecuenciaProb);
            
        }
        while(this.indexs.size()<this.numSelection){
            r=cin.nextInt(100)/100.0;
            ant=0;
            desp=0;
            for(int y=0; y<this.getPopulationSize(); y++){
                desp=desp+prob.get(y);
                if(r>=ant && r<=desp){
                    this.indexs.add(y);
                    break;
                }
                ant=ant+prob.get(y);
            }
        }
    }
    public void run() {
        // promedio = frecuencia esperada total
        calcFrecuenciaEsperadaTotal();
        // calcular valores esperados
        calcValoresEsperados();        
        // Generar valor aleatorio entre 0 y T = r
        calcIndividuo();
    }
    
}
