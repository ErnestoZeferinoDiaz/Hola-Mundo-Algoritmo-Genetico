
package ag;

import java.util.ArrayList;
import java.util.Random;

public class Ag {
    private int generaciones;
    private int poblacion_size;
    private double porcentaje_mutacion;
    private ArrayList<Cromosoma> poblacion;
    private ArrayList<Cromosoma> ant;
    private ArrayList<Cromosoma> desp;
    private Selection s;
    private Random cin;
    public Ag(int g,int p,double pM){
        this.setGeneraciones(g);
        this.setPoblacion_size(p);
        this.setPorcentaje_mutacion(pM);
        init();
        
    }
    public void init(){
        cin = new Random();
        poblacion = new ArrayList();
        for(int x=0; x<this.poblacion_size; x++){
            poblacion.add(new Cromosoma());
            poblacion.get(x).setAlfabeto("qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM");
            poblacion.get(x).setTotGen(10);
            poblacion.get(x).init();
        }
        ant = new ArrayList(this.poblacion);
        desp = new ArrayList();
    }
    public void mutar(){
        double n=this.poblacion_size*this.porcentaje_mutacion;
        int c;
        for(int x=0; x<n; x++){
            c=cin.nextInt(this.poblacion_size);
            this.desp.get(c).mutar();
        }
    }
    public void searchBetter(){
        int i=0;
        for(int x=0; x<this.ant.size(); x++){
            if(this.ant.get(x).getAptitud()<this.ant.get(i).getAptitud()){
                i=x;
            }
        }
        System.out.println("Mejor en cada generacion:\t"+ant.get(i));
    }
    public void run(){
        ArrayList<Cromosoma> tmp;
        for(int x=0; x<this.generaciones; x++){
            
            for(int y=0; y<this.poblacion_size/2; y++){
                s = new TorneoKL(2,ant);
                s.run();
                tmp=ant.get(s.getSelected().get(0)).cruza(ant.get(s.getSelected().get(1)));
                desp.add(tmp.get(0));
                desp.add(tmp.get(1));
            }
            this.mutar();
            ant=new ArrayList(desp);
            this.searchBetter();
            desp.clear();
        }
        
    }
    public ArrayList<Cromosoma> getAnt(){
        return ant;
    }
    
    
    public int getGeneraciones() {
        return generaciones;
    }

    public void setGeneraciones(int generaciones) {
        this.generaciones = generaciones;
    }

    public int getPoblacion_size() {
        return poblacion_size;
    }

    public void setPoblacion_size(int poblacion_size) {
        this.poblacion_size = poblacion_size;
    }

    public double getPorcentaje_mutacion() {
        return porcentaje_mutacion;
    }

    public void setPorcentaje_mutacion(double porcentaje_mutacion) {
        this.porcentaje_mutacion = porcentaje_mutacion;
    }
    
}
