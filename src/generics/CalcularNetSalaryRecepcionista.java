package generics;

import logneg.Recepcionista;

	public class CalcularNetSalaryRecepcionista<T extends Recepcionista> {
		private T recep;
		
	public CalcularNetSalaryRecepcionista(T recepcionista){
		this.recep= recepcionista;
	
	}
	public T getRecepcionista(){
		return recep;
	}
	
	public double calcularNetSalary(){
		double resultadoSalary= recep.getSueldo()/1.2;
		return resultadoSalary;
}
}
