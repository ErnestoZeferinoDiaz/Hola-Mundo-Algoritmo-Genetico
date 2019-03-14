package ag;

import java.util.ArrayList;
import java.util.Random;

public abstract class Selection {
    public int numSelection;
    public ArrayList<Cromosoma> pob;
    public ArrayList<Integer> indexs;
    public ArrayList<Double> fitness;
    protected Random cin;
    private int populationSize;
    
    public Selection(int n,ArrayList<Cromosoma> p){
        this.numSelection=n;
        this.pob=p;
        populationSize=p.size();
        cin=new Random();
        indexs = new ArrayList<Integer>();
        fitness = new ArrayList();
        for(int x=0; x<populationSize; x++){
            fitness.add(this.pob.get(x).getAptitud());
        }
    }
    public abstract void  run();
    public ArrayList<Integer> getSelected(){
        return indexs;
    }
    public int getPopulationSize(){
        return this.populationSize;
    }
}
