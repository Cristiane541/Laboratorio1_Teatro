package view;

import javax.swing.JOptionPane;

import model.Vendas;

public class Main {
	public static void main(String[] args) {
		Vendas vendas;
		int fileira;
		int assento;
		int inteira;
		boolean vendeu;
		
		vendas = new Vendas();
		
		do {
			JOptionPane.showMessageDialog(null, "Venda de ingressos", "Ingressos do Teatro POO",
					JOptionPane.INFORMATION_MESSAGE);
			fileira = Integer.parseInt(JOptionPane.showInputDialog("Fileira"));
			assento = Integer.parseInt(JOptionPane.showInputDialog("Cadeira"));
			inteira = JOptionPane.showConfirmDialog(null, "Ingresso preço cheio?", "Ingressos do Teatro POO",
					JOptionPane.YES_NO_OPTION);
			if (inteira == JOptionPane.YES_OPTION) {
				vendeu = vendas.novaVenda(fileira, assento, Vendas.INTEIRA);
			} else {
				vendeu = vendas.novaVenda(fileira, assento, Vendas.MEIA);
			}
			if (!vendeu) {
				JOptionPane.showMessageDialog(null, "Cadeira ocupada", "Ingresso do Teatro POO",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Bom espetáculo", "Ingresso do Teatro POO",
						JOptionPane.WARNING_MESSAGE);
			}
		} while (JOptionPane.showConfirmDialog(null, "Deseja encerrar o sistema?", "Ingressos do Teatro POO",
				JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
		
		JOptionPane.showMessageDialog(null, "Total de vendas: R$" + vendas.valorArrecadado(),
				"Teatro POO", JOptionPane.INFORMATION_MESSAGE);

	}
}
