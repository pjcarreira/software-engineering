package ist.es.puzzles;


public class InstanceInitializer {
	public int i = 10;

	InstanceInitializer() {
		i = 20;
	}
	
	{
		i = 30;
	}

	public static void main(String[] args) {
		InstanceInitializer instancia = new InstanceInitializer();
		
		/*
		 * Qual o a valor de 'i'?
		 */
		System.out.println(instancia.i);
	}
}

