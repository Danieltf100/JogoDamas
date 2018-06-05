package player;

import heuristica.Heuristica;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Cenario;
import factory.FactoryPlayer;
import model.Casa;
import model.Jogada;
import model.Jogo;
import model.Peca;
import model.Player;
import model.TabuleiroFoto;

public class MyPlayer extends Player {

	public MyPlayer(TabuleiroFoto aTabuleiroFoto) {
		super(aTabuleiroFoto);
	}

	@Override
	public Jogada joga(TabuleiroFoto tf) {
		try {
			return Heuristica.getJogada(tf, this.getSide());
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		return new Jogada(0, 0, 0, 0);
	}
	
	public static void main(String[] args) {
		TabuleiroFoto tf = new TabuleiroFoto();
		
		System.out.println("criando jogador 1");
		Player p1 = FactoryPlayer.getPlayer('R', tf);
		System.out.println("criando jogador 2");
		Player p2 = new MyPlayer(tf);
		System.out.println("criando jogo");
		Jogo jogo = new Jogo(p1,p2);
		System.out.println("P1 side is "+p1.getSide());
		System.out.println("P2 side is "+p2.getSide());
		System.out.println("comecando jogo");
		jogo.comeca();
	}	
	

}
