package heuristica;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Cenario;
import model.Jogada;
import model.Peca;
import model.TabuleiroFoto;

public class Heuristica {
	
	private static char VAZIO = '_';
	
	private static ArrayList<Cenario> getCenariosPossiveis(TabuleiroFoto tf, char side) {
		
		ArrayList<Cenario> casosPossiveis = new ArrayList<Cenario>();
		
		
		for(int x = 0; x < TabuleiroFoto.SIZE; x++) {
			
			for(int y = 0; y < TabuleiroFoto.SIZE; y++) {
				
				if (Peca.isSameSide(side, tf.foto[x][y])) {
					if (Peca.direcao(side) < 0) {
						if (x-1 >= 0 && y-1 >= 0) {
							if (tf.foto[x-1][y-1] == VAZIO) {
								casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x-1, y-1, side);
							}
							if (x-2 >= 0 && y-2 >= 0) {
								if (tf.foto[x-2][y-2] == VAZIO && Peca.isOtherSide(side, tf.foto[x-1][y-1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x-2, y-2, x-1, y-1, side);
								}
							}
						}
						if (x+1 < TabuleiroFoto.SIZE && y-1 >= 0) {
							if (tf.foto[x+1][y-1] == VAZIO) {
								casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x+1, y-1, side);
							}
							if (x+2 < TabuleiroFoto.SIZE && y-2 >= 0) {
								if (tf.foto[x+2][y-2] == VAZIO && Peca.isOtherSide(side, tf.foto[x+1][y-1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x+2, y-2, x+1, y-1, side);
								}
							}
						}
						if (x-1 >= 0 && y+1 < TabuleiroFoto.SIZE) {
							if (x-2 >= 0 && y+2 < TabuleiroFoto.SIZE) {
								if (tf.foto[x-2][y+2] == VAZIO && Peca.isOtherSide(side, tf.foto[x-1][y+1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x-2, y+2, x-1, y+1, side);
								}
							}
						}
						if (x+1 < TabuleiroFoto.SIZE && y+1 < TabuleiroFoto.SIZE) {
							if (x+2 < TabuleiroFoto.SIZE && y+2 < TabuleiroFoto.SIZE) {
								if (tf.foto[x+2][y+2] == VAZIO && Peca.isOtherSide(side, tf.foto[x+1][y+1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x+2, y+2, x+1, y+1, side);
								}
							}
						}
					}
					else {
						if (x-1 >= 0 && y+1 < TabuleiroFoto.SIZE) {
							if (tf.foto[x-1][y+1] == VAZIO) {							
								casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x-1, y+1, side);
							}
							if (x-2 >= 0 && y+2 < TabuleiroFoto.SIZE) {
								if (tf.foto[x-2][y+2] == VAZIO && Peca.isOtherSide(side, tf.foto[x-1][y+1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x-2, y+2, x-1, y+1, side);
								}
							}
						}
						if (x+1 < TabuleiroFoto.SIZE && y+1 < TabuleiroFoto.SIZE) {
							if (tf.foto[x+1][y+1] == VAZIO) {
								casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x+1, y+1, side);
							}
							if (x+2 < TabuleiroFoto.SIZE && y+2 < TabuleiroFoto.SIZE) {
								if (tf.foto[x+2][y+2] == VAZIO && Peca.isOtherSide(side, tf.foto[x+1][y+1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x+2, y+2, x+1, y+1, side);
								}
							}
						}
						if (x-1 >= 0 && y-1 >= 0) {
							if (x-2 >= 0 && y-2 >= 0) {
								if (tf.foto[x-2][y-2] == VAZIO && Peca.isOtherSide(side, tf.foto[x-1][y-1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x-2, y-2, x-1, y-1, side);
								}
							}
						}
						if (x+1 < TabuleiroFoto.SIZE && y-1 >= 0) {
							if (x+2 < TabuleiroFoto.SIZE && y-2 >= 0) {
								if (tf.foto[x+2][y-2] == VAZIO && Peca.isOtherSide(side, tf.foto[x+1][y-1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, x+2, y-2, x+1, y-1, side);
								}
							}
						}
					}
					if (Peca.isKing(tf.foto[x][y])) {
						int tempX = x;
						int tempY = y;
						//  diagonal principal para cima
						while(tempX >= 0 && tempY < TabuleiroFoto.SIZE) {
							if (tempX-2 >= 0 && tempY+2 < TabuleiroFoto.SIZE) {
								if (tf.foto[tempX-2][tempY+2] == VAZIO && Peca.isOtherSide(side, tf.foto[tempX-1][tempY+1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, tempX-2, tempY+2, tempX-1, tempY+1, side);
								}
							}
							tempX--; tempY++;
						}
						tempX = x;
						tempY = y;
						// diagonal principal para baixo
						while(tempX < TabuleiroFoto.SIZE && tempY >= 0) {
							if (tempX+2 < TabuleiroFoto.SIZE && tempY-2 >= 0) {
								if (tf.foto[tempX+2][tempY-2] == VAZIO && Peca.isOtherSide(side, tf.foto[tempX+1][tempY-1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, tempX+2, tempY-2, tempX+1, tempY-1, side);
								}
							}
							tempX++; tempY--;
						}
						tempX = x;
						tempY = y;
						// diagonal secundaria para cima
						while(tempX < TabuleiroFoto.SIZE && tempY < TabuleiroFoto.SIZE) {
							if (tempX+2 < TabuleiroFoto.SIZE && tempY+2 < TabuleiroFoto.SIZE) {
								if (tf.foto[tempX+2][tempY+2] == VAZIO && Peca.isOtherSide(side, tf.foto[tempX+1][tempY+1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, tempX+2, tempY+2, tempX+1, tempY+1, side);
								}
							}
							tempX++; tempY++;
						}
						tempX = x;
						tempY = y;
						// diagonal secundaria para baixo
						while(tempX >= 0 && tempY >= 0) {
							if (tempX-2 >= 0 && tempY-2 >= 0) {
								if (tf.foto[tempX-2][tempY-2] == VAZIO && Peca.isOtherSide(side, tf.foto[tempX-1][tempY-1])) {
									casosPossiveis = keepAndAdd(casosPossiveis, tf, x, y, tempX-2, tempY-2, tempX-1, tempY-1, side);
								}
							}
							tempX--; tempY--;
						}
					}			
				}				
			}
			
		}
		
		
		return casosPossiveis;
		
	}
	
	private static ArrayList<Cenario> keepAndAdd(ArrayList<Cenario> cenarios, TabuleiroFoto tf, int xOriginal, int yOriginal, int xFinal, int yFinal, char side) {
		ArrayList<Cenario> casosPossiveis = cenarios;
		
		TabuleiroFoto auxTf = new TabuleiroFoto(tf);
		char peca = auxTf.foto[xOriginal][yOriginal];
		auxTf.foto[xOriginal][yOriginal] = VAZIO;
		auxTf.foto[xFinal][yFinal] = peca;
		casosPossiveis.add(new Cenario(auxTf));
		casosPossiveis.get(casosPossiveis.size()-1).setJogada(new Jogada(xOriginal, yOriginal, xFinal, yFinal));
		if (yFinal == TabuleiroFoto.SIZE-1) {
			casosPossiveis.get(casosPossiveis.size()-1).setViceKing(true);
		}
		casosPossiveis.get(casosPossiveis.size()-1).setPontuacao(calculaPontos(casosPossiveis.get(casosPossiveis.size()-1), tf, side));
		
		return casosPossiveis;
	}
	
	private static ArrayList<Cenario> keepAndAdd(ArrayList<Cenario> cenarios, TabuleiroFoto tf, int xOriginal, int yOriginal, int xFinal, int yFinal, int xEnemy, int yEnemy, char side) {
		ArrayList<Cenario> casosPossiveis = cenarios;
		
		TabuleiroFoto auxTf = new TabuleiroFoto(tf);
		char peca = auxTf.foto[xOriginal][yOriginal];
		auxTf.foto[xOriginal][yOriginal] = VAZIO;
		auxTf.foto[xEnemy][yEnemy] = VAZIO;
		auxTf.foto[xFinal][yFinal] = peca;
		casosPossiveis.add(new Cenario(auxTf));
		casosPossiveis.get(casosPossiveis.size()-1).setJogada(new Jogada(xOriginal, yOriginal, xFinal, yFinal));
		if (yFinal == TabuleiroFoto.SIZE-1) {
			casosPossiveis.get(casosPossiveis.size()-1).setViceKing(true);
		}
		casosPossiveis.get(casosPossiveis.size()-1).setPontuacao(calculaPontos(casosPossiveis.get(casosPossiveis.size()-1), tf, side));
		
		return casosPossiveis;
	}
	
	public static Jogada getJogada(TabuleiroFoto tf, char side) {
		ArrayList<Cenario> cenarios = getCenariosPossiveis(tf, side);
		Jogada melhor = new Jogada(0, 0);
		if (!cenarios.isEmpty()) {
			melhor = cenarios.get(0).getJogada();
			long points = cenarios.get(0).getPontuacao();
			for(Cenario c : cenarios) {
				if (points < c.getPontuacao()) {
					points = c.getPontuacao();
					melhor = c.getJogada();
				}
			}
		}
		return melhor;
	}
	
	private static long calculaPontos(Cenario cenario, TabuleiroFoto original, char side) {
		int points = 0;
		long r = 0L;
		
		if (cenario.getTf().getCount(side) >= original.getCount(side)) points++;
		if (cenario.getTf().getCount(Peca.otherSide(side)) < original.getCount(Peca.otherSide(side))) points+=5;
		if (cenario.isViceKing()) points+=3;
		if (cenario.getTf().getCount(Peca.otherSide(side)) == 0) points+=10;
		
		r = (long) Math.pow(points, 10);
		
		return r;
	}

}
