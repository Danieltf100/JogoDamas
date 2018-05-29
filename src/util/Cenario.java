package util;

import java.util.ArrayList;

import model.Jogada;
import model.TabuleiroFoto;

public class Cenario {
	
	private long pontuacao;
	private ArrayList<Cenario> filhos;
	private TabuleiroFoto tf;
	private Jogada jogada;
	private boolean viceKing;
	
	public Cenario(TabuleiroFoto tf) {
		this.setPontuacao(0);
		this.setFilhos(new ArrayList<>());
		this.setTf(tf);
		this.setJogada(new Jogada(0, 0));
		this.setViceKing(false);
	}

	public long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public ArrayList<Cenario> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Cenario> filhos) {
		this.filhos = filhos;
	}

	public TabuleiroFoto getTf() {
		return tf;
	}

	public void setTf(TabuleiroFoto tf) {
		this.tf = tf;
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	public boolean isViceKing() {
		return viceKing;
	}

	public void setViceKing(boolean hasViceKing) {
		this.viceKing = hasViceKing;
	}

	@Override
	public String toString() {
		return "*****\nCenario [pontuacao=" + pontuacao + ", filhos=" + filhos.toString()
				+ ", \ntf=\n" + tf.toString() + ", jogada=" + jogada.toString() + ", viceKing="
				+ viceKing + "]\n*****\n";
	}
	
	
	
}
