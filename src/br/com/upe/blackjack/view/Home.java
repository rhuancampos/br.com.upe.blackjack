package br.com.upe.blackjack.view;


import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.upe.blackjack.interfaces.Newgamer;
import br.com.upe.blackjack.interfaces.VCarta;


public class Home extends JFrame implements ActionListener, Runnable{
	
	private ArrayList<JPanel> paineisJogadores;
	private ArrayList<JPanel> paineisInfoJogadores;
	private Newgamer nJogo;
	private int quantidadeJogadores;
	private static final long serialVersionUID = 8674507164768266097L;
	private JPanel contentPane;
	private JPanel panel_menu = new JPanel();
	private JPanel panel_menu_apostas = new JPanel();
	private JPanel panel_menu_opcoes = new JPanel();
	private boolean novojogo = true;
	

	
	
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

	public Home() {
		
		this.quantidadeJogadores = 2;
		this.paineisJogadores = new ArrayList<JPanel>(this.quantidadeJogadores);
		this.paineisInfoJogadores = new ArrayList<JPanel>(this.quantidadeJogadores);

		
		for (int i = 0; i < this.quantidadeJogadores; i++) {
			JPanel painelTemp = new JPanel();
			JPanel painelInfo = new JPanel();
			this.paineisJogadores.add(painelTemp);
			this.paineisInfoJogadores.add(painelInfo);			
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/br/com/upe/blackjack/view/img/favico.png")));
		setTitle("Blacjack UPE 2018.1 POO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nJogo = new Newgamer();
		
		criarPaineis();
		
	}
	
	public void criarPaineis() {		
		this.pan_menu_aposta();
		this.pan_opcoes();
		this.pan_jogadores();
		}
	
	public void pan_menu_aposta() {
		
		//PAINEL APOSTAS
				
		panel_menu.setBounds(23, 462, 532, 78);
		contentPane.add(panel_menu);
		panel_menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		panel_menu.add(panel_menu_apostas);
		
		JButton btnR_aposta_10 = new JButton("R$ 10,00");
		btnR_aposta_10.setEnabled(false);
		btnR_aposta_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aumetarAposta(10);
			}
		});
		panel_menu_apostas.add(btnR_aposta_10);
		
		JButton btnR_aposta_50 = new JButton("R$ 50,00");
		btnR_aposta_50.setEnabled(false);
		btnR_aposta_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aumetarAposta(50);
			}
		});
		panel_menu_apostas.add(btnR_aposta_50);
		
		JButton btnR_aposta_100 = new JButton("R$ 100,00");
		btnR_aposta_100.setEnabled(false);
		btnR_aposta_100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aumetarAposta(100);
			}
		});
		panel_menu_apostas.add(btnR_aposta_100);
		
	}
	
	private void pan_opcoes() {
		//PAINEL OPÇÕES
		
				panel_menu.add(panel_menu_opcoes);
				
				JButton btnPegarCarta = new JButton("Pegar Carta");
				btnPegarCarta.setEnabled(false);
				btnPegarCarta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						pegarCartas();
					}
				});
				panel_menu_opcoes.add(btnPegarCarta);
				
				JButton btnParar = new JButton("Parar");
				btnParar.setEnabled(false);
				btnParar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						pararPegarCartas();
					}
				});
				panel_menu_opcoes.add(btnParar);
				
				JButton btnNewGame = new JButton("Novo jogo");
				btnNewGame.addActionListener(new ActionListener() {


					public void actionPerformed(ActionEvent arg0) {
						if (novojogo) {
							novoJogador ();
						}
						novoJogo();
					}
				});
				panel_menu_opcoes.add(btnNewGame);
				
					//SAIR
				
				JButton btnQuit = new JButton("Sair");
				btnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				panel_menu_opcoes.add(btnQuit);
	}
	
	private void pan_jogadores() {
		int WidthInfo = 600;
		int HeighInfo = 25;
		int WidthPainel = 600;
		int HeighPainel = 120;
		int y = 0;
		
		for (int i = 0; i < quantidadeJogadores; i++) {
			JPanel painelInfoJogador = this.paineisInfoJogadores.get(i);
			JPanel painelJogador = this.paineisJogadores.get(i);
			
			
			painelInfoJogador.add(new JLabel(" "));  //nome getComponent(0)
			painelInfoJogador.add(new JLabel(" ")); //Estado getComponent(1)
			painelInfoJogador.add(new JLabel(" ")); //aposta getComponent(2)
			painelInfoJogador.add(new JLabel(" "));	//Pontos getComponent(3)
			
			
			painelInfoJogador.setBounds(0, y, WidthInfo, HeighInfo);
			y = y + HeighInfo;
			painelJogador.setBounds(0, y, WidthPainel, HeighPainel);
			y = y + HeighPainel + 10;
		
			
			getContentPane().add(paineisInfoJogadores.get(i));
			getContentPane().add(this.paineisJogadores.get(i));
			
			
			
			
		}
	
		JLabel label = (JLabel) this.paineisInfoJogadores.get(0).getComponent(2);
		label.setText("");
		JPanel geral = new JPanel();
		getContentPane().add(geral);
		
	}
		
	public void novoJogo() {
		
		this.desativarOpcoes();
		
		this.ativarApostas();
		
		nJogo.entregarCartas();
		
		this.atualizarDados();
		
		this.imprimirMaoCartaPainel(true);
		this.imprimirMaoCartaPainel(false);
		
		if (nJogo.getVBanca().vinteeum()) {
			this.bancaGanhou();
		}
		
		this.estadoJogar(false);
		this.estadoJogar(true);
		

	}
		
	
	
	public void imprimirMaoCartaPainel(boolean banca) {
		
		if (banca) {
						
			JPanel painelJogador = this.paineisJogadores.get(0);		//add a carta nova
			JLabel cartaNova1 = new JLabel();
			VCarta vcarta1 = nJogo.getVBanca().getMao().get(0);
			cartaNova1.setIcon(vcarta1.getCv(false).getIcon());
			painelJogador.add(cartaNova1);
			
			JLabel cartaNova2 = new JLabel();
			VCarta vcarta2 = nJogo.getVBanca().getMao().get(1);
			cartaNova2.setIcon(vcarta2.getCv(true).getIcon());
			painelJogador.add(cartaNova2);

			
		} else {
			JPanel painelJogador = this.paineisJogadores.get(1);		//add a carta nova
			

			for (int i = 0; i < 2; i ++) {
				JLabel cartaNova = new JLabel();
				VCarta vcarta = nJogo.getJogadores().get(0).getMao().get(i);
				cartaNova.setIcon(vcarta.getCv(false).getIcon());
				painelJogador.add(cartaNova);

			}
		}
		
	}
	
	public void adicionarCartaPainel() {
		JPanel painelJogador = this.paineisJogadores.get(1);
		JLabel cartaNova = new JLabel();
		VCarta vcarta = nJogo.getJogadores().get(0).getMao().get(nJogo.getJogadores().get(0).getMao().size()-1);
		cartaNova.setIcon(vcarta.getCv(false).getIcon());
		painelJogador.add(cartaNova);

	}
	
	public void pararPegarCartas() {
		JLabel j = (JLabel) this.paineisInfoJogadores.get(1).getComponent(1);
		j.setText(" ESPERANDO ");
		this.estadoJogar(true);
		nJogo.getJogadores().get(0).setParou(true);
		if (nJogo.getJogadores().get(0).getPontos() >= nJogo.getVBanca().getPontos()) {
			jogadorGanhou();
		}
		if (nJogo.getVBanca().getPontos() > 21) {
			bancaGanhou();
		}
	}
	
	public void pegarCartas() {
		nJogo.getJogadores().get(0).novaCarta(nJogo.getVbaralho().retiraPrimeiraCartaDoBaralho());
		adicionarCartaPainel();
		atualizarPonto();
		
		if (nJogo.getJogadores().get(0).getPontos() > 21) {
			jogadorEstourou();
		}
		
		if (nJogo.getJogadores().get(0).getPontos() == 21) {
			jogadorGanhou();
		}
				
	}
	
	public void aumetarAposta(float valor) {
		nJogo.getJogadores().get(0).getBanco().apostar(valor);
		this.atualizarCarteira();
		this.desativarApostas();
	}
	
	public void estadoJogar(boolean banca) {
		if (banca) {
			nJogo.getVBanca().geraValorDasCartas();
			JLabel j = (JLabel) this.paineisInfoJogadores.get(0).getComponent(1);
			j.setText(" JOGANDO ");
			nJogo.getVBanca().getEstado().jogar(nJogo.getVBanca(), nJogo.getVbaralho());
			j.setText(" ESPERANDO ");
		} else {
			JLabel j = (JLabel) this.paineisInfoJogadores.get(1).getComponent(1);
			j.setText(" JOGANDO ");
			
			this.ativarOpcoes();
					
		}
	}
	
	private void bancaGanhou() {
		JOptionPane.showMessageDialog( null , " BANCA GANHOU!" , " " , JOptionPane.WARNING_MESSAGE ); 
		 
        this.desativarOpcoes();
         
        Component[] com = panel_menu_opcoes.getComponents();
 		
 		JButton b = (JButton)com[2];
 		this.limpar();
 		
 		b.setEnabled(true);
         
	}
	
	private void atualizarDados() {
		this.atualizarPonto();
		this.atualizarCarteira();
		this.atualizarNome();
	}
	
	public void ativarApostas () {
		Component[] com = panel_menu_apostas.getComponents();
		
		JButton b = (JButton)com[0];
		b.setEnabled(true);
		
		b = (JButton)com[1];
		b.setEnabled(true);
		
		b = (JButton)com[2];
		b.setEnabled(true);
	}
	
	public void desativarApostas () {
		Component[] com = panel_menu_apostas.getComponents();
		
		JButton b = (JButton)com[0];
		b.setEnabled(false);
		
		b = (JButton)com[1];
		b.setEnabled(false);
		
		b = (JButton)com[2];
		b.setEnabled(false);
	}
	
	public void ativarOpcoes() {
		Component[] com = panel_menu_opcoes.getComponents();
		
		JButton b = (JButton)com[0];
		b.setEnabled(true);
		
		b = (JButton)com[1];
		b.setEnabled(true);
	}
	
	public void desativarOpcoes() {
		Component[] com = panel_menu_opcoes.getComponents();
		
		JButton b = (JButton)com[0];
		b.setEnabled(false);
		
		b = (JButton)com[1];
		b.setEnabled(false);
		
		b = (JButton)com[2];
		b.setEnabled(false);
	}
		
	public void atualizarPonto() {
		/*nJogo.getVBanca().geraValorDasCartas();
		JLabel j = (JLabel) this.paineisInfoJogadores.get(0).getComponent(3);
		j.setText("Pontos: " + nJogo.getVBanca().getPontos());*/
		
		for (int i = 0; i < this.quantidadeJogadores - 1; i++) {
			nJogo.getJogadores().get(i).geraValorDasCartas();
			JLabel a = (JLabel) this.paineisInfoJogadores.get(i+1).getComponent(3);
			a.setText("Pontos: " + nJogo.getJogadores().get(i).getPontos());
			nJogo.getJogadores().get(i).geraValorDasCartas();
		}
	}
	
	public void atualizarCarteira() {
		for (int i = 0; i < this.quantidadeJogadores - 1; i++) {
			nJogo.getJogadores().get(i).geraValorDasCartas();
			JLabel a = (JLabel) this.paineisInfoJogadores.get(i+1).getComponent(2);
			a.setText("R$: " + nJogo.getJogadores().get(i).getDinheiro());
			System.out.println( nJogo.getJogadores().get(i).getDinheiro());
		}
	}

	public void atualizarNome() {
		nJogo.getVBanca().geraValorDasCartas();
		JLabel j = (JLabel) this.paineisInfoJogadores.get(0).getComponent(0);
		j.setText("BANCA ");
		
		for (int i = 0; i < this.quantidadeJogadores - 1; i++) {
			nJogo.getJogadores().get(i).geraValorDasCartas();
			JLabel a = (JLabel) this.paineisInfoJogadores.get(i+1).getComponent(0);
			a.setText(nJogo.getJogadores().get(i).getNome() + " ");
		}
	}
	
	private void jogadorEstourou() {
		JOptionPane.showMessageDialog( null , " VOCÊ ESTOUROU!" , " " , JOptionPane.WARNING_MESSAGE ); 
		 
        this.desativarOpcoes();
         
        Component[] com = panel_menu_opcoes.getComponents();
 		
 		JButton b = (JButton)com[2];
 		this.limpar();
 		b.setEnabled(true);
 		
	}
	
	private void jogadorGanhou() {
		JOptionPane.showMessageDialog( null , " VOCÊ GANHOU!" , " " , JOptionPane.WARNING_MESSAGE ); 
		 
        this.desativarOpcoes();
         
        Component[] com = panel_menu_opcoes.getComponents();
 		
 		JButton b = (JButton)com[2];
 		this.limpar();
 		b.setEnabled(true);
		nJogo.getJogadores().get(0).getBanco().premioGanhador(nJogo.getJogadores().get(0), nJogo.getJogadores().get(0).vinteeum());
	}

	
	private void novoJogador() {
		String nome = null;
	    while (nome == null || nome.equals("")) {
	      nome = JOptionPane.showInputDialog("Qual o seu nome?");
	    }
	    nJogo.novoJogador(nome);
	}
	
	private void limpar () {
		novojogo = false;
		nJogo.getVBanca().getMao().clear();
		nJogo.getJogadores().get(0).getMao().clear();
	
		this.paineisJogadores.get(0).removeAll();
		this.paineisJogadores.get(1).removeAll();
		this.repaint();
		    
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
