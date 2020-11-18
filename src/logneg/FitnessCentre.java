package logneg;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FitnessCentre {
	
	private ConcurrentLinkedQueue<UsuarioGym> usuariosGym;
	private boolean using;
	private static FitnessCentre fitnessCentre;
	
	private FitnessCentre(){
		usuariosGym=new ConcurrentLinkedQueue<>();
	}
	public static FitnessCentre getInstancia() {
			if(fitnessCentre==null) {
				fitnessCentre=new FitnessCentre();
			}
			return fitnessCentre;
		}
	public void setEnServicio(boolean enServicio) {
		this.using = enServicio;
	}
	public boolean isEnServicio() {
		return using;
	}
	
	
}
