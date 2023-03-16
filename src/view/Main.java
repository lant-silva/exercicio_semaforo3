package view;
import java.util.concurrent.Semaphore;
import controller.ThreadFormula;

public class Main {
	
	static Semaphore pista;
	static int carro=1;
	
	public static void main(String[] args) {
		pista = new Semaphore(5);
		for(int i=1;i<=7;i++) {
			Thread correr = new ThreadFormula(i, pista, carro);
			correr.start();
		}	
	}	
}
