package ag;

import java.util.ArrayList;
import java.util.Collections;

public class TorneoKL extends Selection{
    private ArrayList<Cromosoma> ks;
    public TorneoKL(int n, ArrayList<Cromosoma> p) {
        super(n, p);
        ks = new ArrayList();
    }
    
    @Override
    public void run() {
        int k=cin.nextInt(10)+this.numSelection;
        int i;
        
        for(int x=0; x<k; x++){
            i=cin.nextInt(this.getPopulationSize()-1);
            
            ks.add(this.pob.get(i));
        }
        
        Collections.sort(ks);
        
        for(int x=0; x<this.numSelection; x++){
            i=this.pob.indexOf(ks.get(x));
            this.indexs.add(i);
        }
        
    }
    
}
