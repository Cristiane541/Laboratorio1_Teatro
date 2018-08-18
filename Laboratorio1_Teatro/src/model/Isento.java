package model;

public class Isento extends Ingresso{

	public Isento(Cadeira cadeira) {
		super(cadeira);
	}

	@Override
	public double getValor() {
		return this.precoNormal * 0;
	}

}
