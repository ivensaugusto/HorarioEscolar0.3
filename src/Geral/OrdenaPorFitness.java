package Geral;
import java.util.Comparator;

public final class OrdenaPorFitness implements Comparator<Cromossomo>{
	
	@Override
	public int compare(Cromossomo a, Cromossomo b) 
    { 
        return (a.getFitness() - b.getFitness()); 
    } 
	
	
	
}