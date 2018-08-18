package model;

public class Teatro {
	private final int fileiras = 10;
	private final int cadeiras = 20;
	private Cadeira[] assentos;
	
	public Teatro() {
		try {
			int posicao;
			
			assentos = new Cadeira[tamanhoTeatro()];
			
			posicao = 0;
			for(int i = 1; i < fileiras; i++) {			
				for(int j = 1; i < cadeiras; i++) {
					assentos[posicao] = new Cadeira(i, j);
					posicao += 1;				
				}
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Indice fora de alcance. Valor do Indice: " + e.getMessage());
			
		}catch (Exception e) {
			System.err.println("Ocorreu um Erro Inesperado!" + e.getMessage());
			
		}
	}

	protected int tamanhoTeatro() {
		return 0;
	}
	
	public int qtdeCadeirasDisponiveis() {
		
		int qtdCadeirasDisp = 0;		
		Cadeira cadeira = null;
		
		for(int i = 1; i < fileiras; i++) {			
			for(int j = 1; i < cadeiras; i++) {
				cadeira = buscaCadeira(i, j);
				if(cadeira.estaLivre()) {
					qtdCadeirasDisp += 1;	
				}
							
			}
		}
		return qtdCadeirasDisp;
	}
	
	public boolean vender(int fila, int assento) {
		Cadeira cadeira;
		boolean deuCerto = false;
		cadeira = buscaCadeira(fila, assento);
		try {
			if (cadeira.estaLivre()) {
				cadeira.ocupar();
				deuCerto = true;
			}
		}catch(NullPointerException e) {
			System.err.println("Cadeira já ocupada ");
		}catch (Exception e) {
			System.err.println("Ocorreu um Erro Inesperado!");
			
		}
		
		return deuCerto;
	}
	
	public Cadeira buscaCadeira(int fila, int assento) {
		Cadeira cadeira = null;
		int i = 0;
		while (cadeira == null && i < tamanhoTeatro()) {
			if (assentos[i].getFileira() == fila) {
				if (assentos[i].getAssento() == assento) {
					cadeira = assentos[i];
				}
			}
			i++;
		}
		return cadeira;
	}

}
