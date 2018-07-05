package br.com.upe.blackjack.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardView extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon icon;
	
	public void gerarImg (String caminho) {
		getImagem (caminho);
		setIcon (this.icon);
		setBackground (Color.white);
		setOpaque(true);
	}

	private void getImagem (String caminho) {
		java.net.URL url = this.getClass().getResource(caminho);
		this.icon = new ImageIcon(url);
	}
	
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
