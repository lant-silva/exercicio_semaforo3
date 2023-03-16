package controller;
import java.util.concurrent.Semaphore;

public class ThreadFormula extends Thread{

	int carro;
	int i;
	Semaphore pista;
	
	public ThreadFormula(int i, Semaphore pista, int carro) {
		this.i = i;
		this.pista = pista;
		this.carro = carro;
	}
	
	@Override
	public void run() {
		prepararPista();
	}
	
	public void prepararPista() {
		for(int car=1;car<=2;car++) {		
			try {
				pista.acquire();
				iniciarTreino();
			} catch (Exception e) {

			} finally {
				pista.release();
			}
		}
	}
	
	public void iniciarTreino() {
		int tempoVolta=(int)((Math.random()*3000)+2000);
		int tempoTotal=0;
		
		System.out.println("Carro "+carro+" da Escuderia "+i+" entrou na pista");
		
		for(int volta=1; volta<=3; volta++) {
			System.out.println("Carro "+carro+" Escuderia "+i+": Volta "+volta);
			try {
				Thread.sleep(tempoVolta);
			} catch (Exception e) {
			
			}
			tempoTotal += tempoVolta;
			System.out.println("Tempo da volta: "+(double)tempoVolta/1000);
			
		}
		System.out.println("Tempo final :"+(double)tempoTotal/1000);
		System.out.println("Carro "+carro+" Escuderia "+i+" retornou");
		carro++;
	}
}
