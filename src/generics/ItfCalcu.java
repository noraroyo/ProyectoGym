package generics;

import java.util.ArrayList;

import logneg.TrabajadorGym;

public interface ItfCalcu <T extends TrabajadorGym>{
	public abstract ArrayList<Integer> calcu (ArrayList<T>arrayT);
	

}
