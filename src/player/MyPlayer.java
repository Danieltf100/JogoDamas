package player;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import factory.FactoryPlayer;
import model.Cenario;
import model.Jogada;
import model.Jogo;
import model.Player;
import model.TabuleiroFoto;

public class MyPlayer extends Player {

	public MyPlayer(TabuleiroFoto aTabuleiroFoto) {
		super(aTabuleiroFoto);
	}

	@Override
	public Jogada joga(TabuleiroFoto tf) {
		try {
			Heuristica h = new Heuristica(5, tf);
			return h.getMelhorJogada();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	private class Heuristica {
				
		public Cenario cenarioAtual;
		public int quantidadeDeCenarios;
		private Jogada melhorJogada;
		private TabuleiroFoto tf;
		
		/**
		 * 
		 * @param Int quantidadeDeCenarios
		 * @param TabuleiroFoto tf
		 * @throws QuantidadeDeCenariosMenorQueUmException
		 */
		public Heuristica(int quantidadeDeCenarios, TabuleiroFoto tf) throws QuantidadeDeCenariosMenorQueUmException {
			if (quantidadeDeCenarios<1) throw new QuantidadeDeCenariosMenorQueUmException();
			cenarioAtual = new Cenario(tf);
			this.quantidadeDeCenarios = quantidadeDeCenarios;
			this.tf = tf;
			this.doSearch();
		}
		
		private void doSearch() {
			
		}
		
		private ArrayList<Cenario> geraFilhos(TabuleiroFoto tf) {
			ArrayList<Cenario> filhos = new ArrayList<>();
						
			return filhos;
		}
		
		/**
		 * @return retorna a melhor posiçao para se jogar
		 */
		public Jogada getMelhorJogada() {
			return this.melhorJogada;
		}
		/**
		 * 
		 * Disparado quando se tenta usar predição menor que 1 grau de profundidade.
		 *
		 */
		public class QuantidadeDeCenariosMenorQueUmException extends Exception {
			
			public QuantidadeDeCenariosMenorQueUmException() {
				super("O valor não pode ser menor do que 1");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		TabuleiroFoto tf = new TabuleiroFoto();
		
		System.out.println("criando jogador 1");
		Player p1 = FactoryPlayer.getPlayer('R', tf);
		System.out.println("criando jogador 2");
		Player p2 = FactoryPlayer.getPlayer('R', tf);
		System.out.println("criando jogo");
		Jogo jogo = new Jogo(p1,p2);
		System.out.println("comecando jogo");
		jogo.comeca();
	}	
	

}
