package player;

import factory.FactoryPlayer;
import model.Jogada;
import model.Jogo;
import model.Player;
import model.TabuleiroFoto;

public class MyPlayer extends Player {

	public MyPlayer(TabuleiroFoto aTabuleiroFoto) {
		super(aTabuleiroFoto);
	}

	@Override
	public Jogada joga(TabuleiroFoto arg0) {
		return null;
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
