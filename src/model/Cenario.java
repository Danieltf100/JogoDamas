package model;

import java.util.ArrayList;

public class Cenario {
	
	private int pontuacao;
	private ArrayList<Cenario> filhos;
	private TabuleiroFoto tf;
	
	public Cenario(TabuleiroFoto tf) {
		this.setPontuacao(0);
		this.setFilhos(new ArrayList<>());
		this.setTf(tf);
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
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
	
}
