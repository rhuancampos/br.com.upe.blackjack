package br.com.upe.blacjack.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8674507164768266097L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_banca = new JPanel();
		panel_banca.setBounds(5, 39, 532, 178);
		contentPane.add(panel_banca);
		panel_banca.setLayout(null);
		
		JPanel panel_jogador = new JPanel();
		panel_jogador.setBounds(5, 264, 532, 181);
		contentPane.add(panel_jogador);
		panel_jogador.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(515, 0, 17, 181);
		panel_jogador.add(scrollBar);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(68, 462, 404, 78);
		contentPane.add(panel_menu);
		panel_menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_menu_sup = new JPanel();
		panel_menu.add(panel_menu_sup);
		
		JButton btnR_aposta_10 = new JButton("R$ 10,00");
		panel_menu_sup.add(btnR_aposta_10);
		
		JButton btnR_aposta_50 = new JButton("R$ 50,00");
		panel_menu_sup.add(btnR_aposta_50);
		
		JButton btnR_aposta_100 = new JButton("R$ 100,00");
		panel_menu_sup.add(btnR_aposta_100);
		
		JPanel panel_menu_inferior = new JPanel();
		panel_menu.add(panel_menu_inferior);
		
		JButton btnPegarCarta = new JButton("Pegar Carta");
		panel_menu_inferior.add(btnPegarCarta);
		
		JButton btnParar = new JButton("Parar");
		panel_menu_inferior.add(btnParar);
		
		JButton btnQuit = new JButton("Quit");
		panel_menu_inferior.add(btnQuit);
		
		JButton btnNewGame = new JButton("New Game");
		panel_menu_inferior.add(btnNewGame);
	}
}
