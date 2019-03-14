package ag;
public class Fitness{
    private static String obj="Hola mundo";
    
    public static double fitness(Cromosoma a){
        double r=0,dif;
        
        for(int x=0; x<a.getTotGen(); x++){
            dif=obj.codePointAt(x)-a.getCromo().codePointAt(x);
            r=r+Math.pow(dif,2);
        }
        r=Math.sqrt(r);
        return r;
    }
}
