package model;

public class Vendas {
	
	public static final int INTEIRA = 1;
	public static final int MEIA = 2;
	
	private Teatro teatro;
	
	private Ingresso[] ingressos;
	private int ultimaVenda;

	public Vendas() {
		this.teatro = new Teatro();
		ultimaVenda = -1;
		ingressos = new Ingresso[teatro.tamanhoTeatro()];
	}
	
	public boolean novaVenda(int fila, int assento, int tipoIngresso) {
		boolean deuCerto = false;
		Ingresso ingresso;
		Cadeira cadeira;
		if (teatro.vender(fila, assento)) {
			cadeira = teatro.buscaCadeira(fila, assento);
			if (tipoIngresso == INTEIRA)
				ingresso = new Normal(cadeira);
			else
				ingresso = new Meia(cadeira);
			ultimaVenda += 1;
			ingressos[ultimaVenda] = ingresso;
			deuCerto = true;
		}
		return deuCerto;
	}
	
	public double valorArrecadado() {
		int i = 0;
		double soma = 0;
		for (i = 0; i <= ultimaVenda; i++) {
			soma += ingressos[i].getValor();
		}
		return soma;
	}
	
}
