package br.com.upe.blackjack.interfaces;

import br.com.upe.blackjack.table.Carta;
import br.com.upe.blackjack.view.CardView;

public class VCarta extends Carta{

	private String img;
	private CardView cv = new CardView();
	
	public VCarta(String naipe, int valor, String face, String img) {
		super(naipe, valor, face);
		this.setImg(img);
	}

	public String getImg(boolean facedown) {
		if (facedown) {
			return "/br/com/upe/blackjack/view/img/carta_virada.png";
		} 
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public CardView getCv(boolean facedown) {
		cv.gerarImg(getImg(facedown));
		return cv;
	}

	public void setCv(CardView cv) {
		this.cv = cv;
	}
	

}
