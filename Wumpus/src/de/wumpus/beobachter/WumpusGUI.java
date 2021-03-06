package de.wumpus.beobachter;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem; //import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea; //import javax.swing.JTextField;
import javax.swing.WindowConstants;

import de.wumpus.beobachtet.WumpusWelt;
import de.wumpus.tools.Ablauf;
import de.wumpus.tools.AboutScreen;
import de.wumpus.tools.Benutzerdefiniertes_Feld;
import de.wumpus.tools.Bezeichnungen;
import de.wumpus.tools.GameOver;
import de.wumpus.tools.HelpScreen;
import de.wumpus.tools.NachrichtenObjekt;
import de.wumpus.tools.Position;
import de.wumpus.tools.SchlussfolgerungsHelfer;
import de.wumpus.tools.WDA;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should
 * purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE
 * CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */

/**
 * WumpusGUI ist die Hilfsklasse, die GUI von WumpusWelt darstellt.
 * 
 * @author Benjamin Werker
 * @author Sergey Bagautdinov
 * 
 */

@SuppressWarnings("serial")
public class WumpusGUI extends JFrame implements Observer, ActionListener {
	private WumpusGUI guiFrame;
	private JMenuBar jMenuBar;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	private JMenu fileMenu;
	// private JMenu optionen;
	// private JTextArea jTextArea1;
	// private JTextArea statistik;
	private JMenu help;
	// private JScrollPane ablaufScrollPanel;
	private JScrollPane statistikScrollPanel;
	// private JTextArea ablaufTextArea;
	private JTextArea statistikTextArea;
	private Wumpus_Panel wumpusPanel;
	public WumpusWelt wump;
	private JLabel punkteLabel;
	private JLabel punkteAnzahlLabel;
	private JLabel schritteLabel;
	private JLabel schritteAnzahlLabel;
	// private JLabel jLabel5;
	// private JLabel jLabel6;
	private LinkedList<SchlussfolgerungsHelfer> schlussfolgerungsListe = new LinkedList<SchlussfolgerungsHelfer>();
	GridBagLayout thisLayout = new GridBagLayout();
	private boolean altPressed = false;
	private JTextArea ablaufBewegungAusgabe;
	private JLabel ablaufBewegung;
	private JTextArea ablaufWahrnehmungAusgabe;
	private JLabel ablaufWahrnehmung;
	private JLabel ablaufPosition;
	private JPanel ablaufPanel;
	// private JLabel wissenBasisDesAgentes;
	private JLabel agentSteuerungLabel;
	private JCheckBox jCheckBox1;
	private JButton pfeilNachUnten;
	private JButton pfeilNachRechts;
	private JButton pfeilNachLinks;
	private JButton pfeilNachOben;
	private JLabel pfeilLabel;
	private JPanel emulation_Tastatur_Panel;
	private JTextArea wissensbasisTextArea;
	// private LinkedList<String> ablaufListe = new LinkedList<String>();
	private LinkedList<Ablauf> ablaufListe2 = new LinkedList<Ablauf>();
	// private Ablauf ablaufListe2 = new Ablauf(null,null,null);
	private JButton jButton2;
	private JButton jButton1;
	private JScrollPane jPanel2;
	private WDA wissensbasis;
	// private JPanel jPanel1;
	private boolean shiftPressed = false;
	private int agentSchrittZahler = 0;
	private int gesamtPunktenAnzahl = 10000;
	private int einSchritt_1 = 1;
	private int pfeilBenutzung = 10;
	private boolean pfeil = true;
	private int guiWidth = 0;
	private int guiHeight = 0;
	/* MenuItemLabels */
	private static final String FILEMENUITEM1 = "Feld 4x4  (Alt+1)";
	private static final String FILEMENUITEM2 = "Feld 8x8  (Alt+2)";
	// private static final String FILEMENUITEM3 = "Feld 16x16(Alt+3)";
	private static final String FILEMENUITEM4 = "Def. Feld (Alt+D)";
	private static final String FILEMENUITEM5 = "Exit (Alt+x)";
	private static final String HELPMENUITEM1 = "Hilfe (Alt+H)";
	private static final String HELPMENUITEM2 = "About (Alt+A)";
	private static final String HELPMENUITEM3 = "Debug (Shift+D)";

	public WumpusGUI(Wumpus_Panel panel, WumpusWelt _wump) {
		wumpusPanel = panel;
		wump = _wump;
		initGUI();
		guiFrame = this;
	}

	private void initGUI() {
		try {
			{
				setSize(850, 650);
				setTitle("Wumpus Welt");
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
				thisLayout.rowHeights = new int[] { 7, 7, 7, 7, 7, 7, 7, 7 };
				thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1 };
				thisLayout.columnWidths = new int[] { 7, 7, 7, 7, 7 };
				getContentPane().setLayout(thisLayout);
				{
					// WumpusPanel
					wumpusPanel.setPreferredSize(new Dimension(guiWidth / 3 * 2, guiHeight / 6 * 4));
					this.add(wumpusPanel, new GridBagConstraints(0, 0, 3, 6, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				}
				{ /* Statistiklayout */
					statistikScrollPanel = new JScrollPane();
					statistikScrollPanel.setBorder(BorderFactory.createTitledBorder("Statistik"));
					getContentPane().add(statistikScrollPanel, new GridBagConstraints(3, 0, 1, 3, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					statistikScrollPanel.setPreferredSize(new java.awt.Dimension(100, 1));
					{
						statistikTextArea = new JTextArea();
						statistikScrollPanel.setViewportView(statistikTextArea);
						statistikTextArea.setEnabled(false);
						GridBagLayout statistikLayout = new GridBagLayout();
						statistikLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
						statistikLayout.rowHeights = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7 };
						statistikLayout.columnWeights = new double[] { 0.01, 0.1, 0.1, 0.01 };
						statistikLayout.columnWidths = new int[] { 7, 7, 7, 7 };
						statistikTextArea.setLayout(statistikLayout);
						punkteLabel = new JLabel("Punkte");
						punkteAnzahlLabel = new JLabel(String.valueOf(gesamtPunktenAnzahl));
						statistikTextArea.add(punkteLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						statistikTextArea.add(punkteAnzahlLabel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						schritteLabel = new JLabel("Schritte");
						schritteAnzahlLabel = new JLabel(String.valueOf(agentSchrittZahler));
						statistikTextArea.add(schritteLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						statistikTextArea.add(schritteAnzahlLabel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

					}
				}
				{
					// jPanel1 = new JPanel();
					// GridBagLayout jPanel1Layout = new GridBagLayout();
					// getContentPane().add(jPanel1, new GridBagConstraints(3, 3, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					// jPanel1.setPreferredSize(new java.awt.Dimension(100, 1));
					// jPanel1Layout.rowWeights = new double[] { 0.02, 0.1, 0.1, 0.1 };
					// jPanel1Layout.rowHeights = new int[] { 7, 7, 7, 7 };
					// jPanel1Layout.columnWeights = new double[] { 0.01, 0.1, 0.03, 0.1, 0.01 };
					// jPanel1Layout.columnWidths = new int[] { 7, 7, 7, 7, 7 };
					/* WDA */
					wissensbasis = new WDA(wump.anzahl);
					getContentPane().add(wissensbasis, new GridBagConstraints(3, 3, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					wissensbasis.setBorder(BorderFactory.createTitledBorder("Wissenbasis des Agenten"));
					wissensbasis.setPreferredSize(new java.awt.Dimension(100, 1));
					// jPanel1.setLayout(jPanel1Layout);
					// jPanel1.setBorder(BorderFactory.createTitledBorder("Wissenbasis des Agentes"));
					// {
					// wissenBasisDesAgentes = new JLabel();
					// jPanel1.add(wissenBasisDesAgentes, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					// // wissenBasisDesAgentes.setText("Wissenbasis des Agentes");
					// }
				}
				{
					jPanel2 = new JScrollPane();
					jPanel2.setBorder(BorderFactory.createTitledBorder("SchlussFolgerungen des Agentes"));
					// jPanel2.setForeground(Color.yellow);
					// jPanel2.setFont(new java.awt.Font("Arial", 0, 20));
					// jPanel2.setForeground(new Color(255,10,20));
					getContentPane().add(jPanel2, new GridBagConstraints(1, 6, 4, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jPanel2.setPreferredSize(new java.awt.Dimension(100, 1));
					{
						wissensbasisTextArea = new JTextArea();
						wissensbasisTextArea.setWrapStyleWord(true);
						wissensbasisTextArea.setLineWrap(true);
						wissensbasisTextArea.setFont(this.getFont());
						wissensbasisTextArea.setEditable(false);
						wissensbasisTextArea.setFocusable(false);
						// wissensbasisTextArea.setForeground(new Color(255,10,20));
						// Font f = new Font("Dialog", Font.PLAIN, 100);
						jPanel2.setViewportView(wissensbasisTextArea);
						// wissensbasisTextArea.setEnabled(false);
						wissensbasisTextArea.setPreferredSize(new java.awt.Dimension(389, 112));
					}
				}
				{
					emulation_Tastatur_Panel = new JPanel();
					GridBagLayout navigationsPanel = new GridBagLayout();
					navigationsPanel.columnWidths = new int[] { 7, 7, 7, 7, 7 };
					navigationsPanel.rowHeights = new int[] { 7, 7, 7, 7, 7, 7, 7 };
					navigationsPanel.columnWeights = new double[] { 0.02, 0.1, 0.1, 0.1, 0.02 };
					navigationsPanel.rowWeights = new double[] { 0.02, 0.1, 0.1, 0.1, 0.1, 0.02 };
					getContentPane().add(emulation_Tastatur_Panel, new GridBagConstraints(0, 6, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					emulation_Tastatur_Panel.setPreferredSize(new java.awt.Dimension(100, 1));
					emulation_Tastatur_Panel.setLayout(navigationsPanel);
					emulation_Tastatur_Panel.setBorder(BorderFactory.createTitledBorder("Navigation"));
					{
						pfeilNachOben = new JButton();
						emulation_Tastatur_Panel.add(pfeilNachOben, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						pfeilNachOben.setText("\u2191");
						pfeilNachOben.setFocusable(false);
						pfeilNachOben.setFont(new java.awt.Font("Arial", 0, 10));
						pfeilNachOben.setSize(20, 20);
						pfeilNachOben.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								if (jCheckBox1.isSelected()) {
									wump.bewegeAgent(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.UP);
									jCheckBox1.setSelected(false);
									jCheckBox1.setEnabled(false);
								} else
									wump.bewegeAgent(Bezeichnungen.UP);
							}

							@Override
							public void mouseEntered(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
					{
						pfeilNachLinks = new JButton();
						emulation_Tastatur_Panel.add(pfeilNachLinks, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						pfeilNachLinks.setText("\u2190");
						pfeilNachLinks.setFont(new java.awt.Font("Arial", 0, 10));
						pfeilNachLinks.setFocusable(false);
						pfeilNachLinks.setSize(20, 20);
						pfeilNachLinks.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								if (jCheckBox1.isSelected()) {
									wump.bewegeAgent(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.LINKS);
									jCheckBox1.setSelected(false);
									jCheckBox1.setEnabled(false);
								} else
									wump.bewegeAgent(Bezeichnungen.LINKS);
							}

							@Override
							public void mouseEntered(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
					{
						pfeilNachRechts = new JButton();
						emulation_Tastatur_Panel.add(pfeilNachRechts, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						pfeilNachRechts.setText("\u2192");
						pfeilNachRechts.setFont(new java.awt.Font("Arial", 0, 10));
						pfeilNachRechts.setFocusable(false);
						pfeilNachRechts.setSize(20, 20);
						pfeilNachRechts.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								if (jCheckBox1.isSelected()) {
									wump.bewegeAgent(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.RECHTS);
									jCheckBox1.setSelected(false);
									jCheckBox1.setEnabled(false);
								} else
									wump.bewegeAgent(Bezeichnungen.RECHTS);
							}

							@Override
							public void mouseEntered(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
					{
						pfeilNachUnten = new JButton();
						emulation_Tastatur_Panel.add(pfeilNachUnten, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						pfeilNachUnten.setText("\u2193");
						pfeilNachUnten.setFont(new java.awt.Font("Arial", 0, 10));
						pfeilNachUnten.setFocusable(false);
						pfeilNachUnten.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								if (jCheckBox1.isSelected()) {
									wump.bewegeAgent(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.DOWN);
									jCheckBox1.setSelected(false);
									jCheckBox1.setEnabled(false);
								} else
									wump.bewegeAgent(Bezeichnungen.DOWN);
							}

							@Override
							public void mouseEntered(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
					{
						pfeilLabel = new JLabel("Pfeil benutzen");
						emulation_Tastatur_Panel.add(pfeilLabel, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
					{
						jCheckBox1 = new JCheckBox();
						emulation_Tastatur_Panel.add(jCheckBox1, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jCheckBox1.setEnabled(true);
						jCheckBox1.setFocusable(false);
						// jCheckBox1.setText("Ja/Nein");
					}
					{
						agentSteuerungLabel = new JLabel();
						emulation_Tastatur_Panel.add(agentSteuerungLabel, new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						agentSteuerungLabel.setText("Steuerung des Agentes");
					}
					{
						jButton2 = new JButton();
						emulation_Tastatur_Panel.add(jButton2, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButton2.setText(" Next ");
						jButton2.setFocusable(false);
						jButton2.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								wump.bewegeAgentPerTaste();
							}

							@Override
							public void mouseEntered(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
					{
						jButton1 = new JButton();
						emulation_Tastatur_Panel.add(jButton1, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jButton1.setText("Zur�ck");
						jButton1.setFocusable(false);
						jButton1.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {
								wump.schickeAgentZurueck();
							}

							@Override
							public void mouseEntered(MouseEvent e) {
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
				}
				/* Ablauflayout */
				{
					ablaufPanel = new JPanel();
					ablaufPanel.setPreferredSize(new java.awt.Dimension(100, 1));
					GridBagLayout ablaufPanelLayout = new GridBagLayout();
					ablaufPanelLayout.columnWidths = new int[] { 7, 7, 7, 7 };
					ablaufPanelLayout.rowHeights = new int[] { 7, 7, 7, 7, 7, 7 };
					ablaufPanelLayout.columnWeights = new double[] { 0.01, 0.1, 0.1, 0.01 };
					ablaufPanelLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
					getContentPane().add(ablaufPanel, new GridBagConstraints(4, 0, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					ablaufPanel.setBorder(BorderFactory.createTitledBorder("Ablauf"));
					ablaufPanel.setLayout(ablaufPanelLayout);
					{
						ablaufPosition = new JLabel();
						ablaufPanel.add(ablaufPosition, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						ablaufPosition.setText("Position Y,X");
					}
					{
						ablaufWahrnehmung = new JLabel();
						ablaufPanel.add(ablaufWahrnehmung, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						ablaufWahrnehmung.setText("Wahrnehmung(en)");
					}
					{
						ablaufWahrnehmungAusgabe = new JTextArea();
						ablaufWahrnehmungAusgabe.setWrapStyleWord(true);
						ablaufWahrnehmungAusgabe.setLineWrap(true);
						ablaufPanel.add(ablaufWahrnehmungAusgabe, new GridBagConstraints(1, 2, 2, 2, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
						ablaufWahrnehmungAusgabe.setFocusable(false);
						ablaufWahrnehmungAusgabe.setEditable(false);
					}
					{
						ablaufBewegung = new JLabel();
						ablaufPanel.add(ablaufBewegung, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						ablaufBewegung.setText("Letzte Bewegung");
					}
					{
						ablaufBewegungAusgabe = new JTextArea();
						ablaufPanel.add(ablaufBewegungAusgabe, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						ablaufBewegungAusgabe.setEditable(false);
						ablaufBewegungAusgabe.setFocusable(false);
						// ablaufBewegungAusgabe.setText("Ausgabe von lentzten Bewegung");
					}
				}
				/* Menu Initialisierung */
				{
					jMenuBar = new JMenuBar();
					setJMenuBar(jMenuBar);
					{
						fileMenu = new JMenu();
						jMenuBar.add(fileMenu);
						fileMenu.setText("File");
						{
							JMenuItem feld1 = new JMenuItem(FILEMENUITEM1);
							fileMenu.add(feld1);
							feld1.addActionListener(this);
							JMenuItem feld2 = new JMenuItem(FILEMENUITEM2);
							fileMenu.add(feld2);
							feld2.addActionListener(this);
							// JMenuItem feld3 = new JMenuItem(fileMenuItem3);
							// fileMenu.add(feld3);
							// feld3.addActionListener(this);

							jSeparator1 = new JSeparator(); /* Trennlinie */
							fileMenu.add(jSeparator1);

							JMenuItem feld4 = new JMenuItem(FILEMENUITEM4);
							fileMenu.add(feld4);
							feld4.addActionListener(this);

							jSeparator2 = new JSeparator(); /* Trennlinie */
							fileMenu.add(jSeparator2);

							JMenuItem exit = new JMenuItem(FILEMENUITEM5);
							fileMenu.add(exit);
							// exit.addKeyListener(this);
							exit.addActionListener(this);
						}
						// optionen = new JMenu();
						// jMenuBar.add(optionen);
						// optionen.setText("Optionen");
						// {
						// JMenuItem mensch = new JMenuItem(OPTIONMENUITEM1);
						// optionen.add(mensch);
						// JMenuItem ki_agent = new JMenuItem(OPTIONMENUITEM2);
						// optionen.add(ki_agent);
						//
						// // jSeparator1 = new JSeparator(); /* Trennlinie */
						// // optionen.add(jSeparator1);
						// //
						// // JMenuItem geschwindigkeit = new JMenuItem(optionMenuItem3);
						// // optionen.add(geschwindigkeit);
						// }
						help = new JMenu();
						jMenuBar.add(help);
						help.setText("Help");
						{
							JMenuItem hilfe = new JMenuItem(HELPMENUITEM1);
							hilfe.addActionListener(this);
							help.add(hilfe);
							JMenuItem about = new JMenuItem(HELPMENUITEM2);
							about.addActionListener(this);
							help.add(about);
							JMenuItem debug = new JMenuItem(HELPMENUITEM3);
							debug.addActionListener(this);
							help.add(debug);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.addKeyListener(new KeyListener() {

			/*
			 * Realisierung der Tastarur, ganauer gesagt wird die Weltgrosse ueber Tastatur eingegeben, durch Alt+1 usw.
			 */
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ALT) {
					altPressed = true;
				}
				if (arg0.getKeyCode() == KeyEvent.VK_SHIFT) {
					shiftPressed = true;
				}
				if (arg0.getKeyCode() == KeyEvent.VK_B) {
					wump.bewegeAgentPerTaste();
				}
				if (arg0.getKeyCode() == KeyEvent.VK_1 && altPressed) {
					neuesSpiel(4);
				} else if (arg0.getKeyCode() == KeyEvent.VK_2 && altPressed) {
					neuesSpiel(8);
				} else if (arg0.getKeyCode() == KeyEvent.VK_3 && altPressed) {
					// wump.neuesSpiel(16);
					// ablaufTextArea.setText("");
				} else if (arg0.getKeyCode() == KeyEvent.VK_D && altPressed) {
					neuesSpiel(-1);
					altPressed = false;
					// wump.neuesSpiel(16);
					// ablaufTextArea.setText("");
				} else if (arg0.getKeyCode() == KeyEvent.VK_X && altPressed) {
					System.exit(0);
				} else if (arg0.getKeyCode() == KeyEvent.VK_H && altPressed) {
					System.out.println("ALT + H");
					setEnabled(false);
					new HelpScreen(guiFrame);
				} else if (arg0.getKeyCode() == KeyEvent.VK_A && altPressed) {
					System.out.println("ALT + A");
					setEnabled(false);
					new AboutScreen(guiFrame);
				} else if (arg0.getKeyCode() == KeyEvent.VK_Z) {
					wump.schickeAgentZurueck();
				}
				// Abfage der Tastaturpfeile
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT && !shiftPressed) {
					System.out.println("Left");
					wump.bewegeAgent(Bezeichnungen.LINKS);
				} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && !shiftPressed) {
					System.out.println("Right");
					wump.bewegeAgent(Bezeichnungen.RECHTS);
				} else if (arg0.getKeyCode() == KeyEvent.VK_UP && !shiftPressed) {
					System.out.println("Up");
					wump.bewegeAgent(Bezeichnungen.UP);
				} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN && !shiftPressed) {
					System.out.println("Down");
					wump.bewegeAgent(Bezeichnungen.DOWN);
				}
				// Abfrage der Tastaturpfeile zur Verwendung des Pfeiles
				if (arg0.getKeyCode() == KeyEvent.VK_LEFT && shiftPressed && pfeil) {
					System.out.println("Pfeil + Left");
					benutzePfeil(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.LINKS);
				} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT && shiftPressed && pfeil) {
					System.out.println("Pfeil + Right");
					benutzePfeil(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.RECHTS);
				} else if (arg0.getKeyCode() == KeyEvent.VK_UP && shiftPressed && pfeil) {
					System.out.println("Pfeil + Up");
					benutzePfeil(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.UP);
				} else if (arg0.getKeyCode() == KeyEvent.VK_DOWN && shiftPressed && pfeil) {
					System.out.println("Pfeil + Down");
					benutzePfeil(Bezeichnungen.BENUTZE_PFEIL + " " + Bezeichnungen.DOWN);
				} else {
					// TODO: Ausgabe Fenster wenn kein Pfeil mehr verwendbar
				}

				/* Enable or Disable DebugMode for WumpusPanel */
				if (arg0.getKeyCode() == KeyEvent.VK_D && shiftPressed && !wumpusPanel.DEBUG) {
					wumpusPanel.DEBUG = true;
				} else if (arg0.getKeyCode() == KeyEvent.VK_D && shiftPressed && wumpusPanel.DEBUG) {
					wumpusPanel.DEBUG = false;
				}
				if (arg0.getKeyCode() == KeyEvent.VK_G) {
					setEnabled(false);
					new GameOver(guiFrame, "TEST");
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ALT) {
					altPressed = false;
				}
				if (arg0.getKeyCode() == KeyEvent.VK_SHIFT) {
					shiftPressed = false;
				}

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

		});
		// FocusListener damit KeyEvents immer wieder an die GUI gehen
		this.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				requestFocus();
				// System.out.println("FOCUS");
			}
		});

	}
	/**
	 * Diese Methode faengt alle Nachrichten ab, die von WumpusWelt verschickt werden.
	 * @param obj
	 * @param arg Argument
	 */
	public void update(Observable obj, Object arg) {
		if (((NachrichtenObjekt) arg).information == Bezeichnungen.GUI) {
			// System.out.println("update() ist aufgeruffen, fount ist gleich "
			// + ((Integer)arg).intValue());
			System.out.println("Ich bin die GUI \nPosition y: " + ((NachrichtenObjekt) arg).y + " Position x: " + ((NachrichtenObjekt) arg).x + " Wahrnemung: " + ((NachrichtenObjekt) arg).wahrnehmung[0] + " Information: " + ((NachrichtenObjekt) arg).information);
		} else if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.REPAINT)) {
			// System.out.println(" " + Bezeichnungen.REPAINT);
			wumpusPanel.setzeAnzahl();
			validate();
		} else if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.BEWEGE)) {
			/* es werden die Schritte gezahlt und die verbrauchte Punkte(-10 pro Schritt) abgezogen */
			agentSchrittZahler++;
			gesamtPunktenAnzahl = gesamtPunktenAnzahl - einSchritt_1;
			// schritteAnzahlLabel.setText(Integer.toString(agentSchrittZahler));//alternative
			schritteAnzahlLabel.setText(String.valueOf(agentSchrittZahler));
			punkteAnzahlLabel.setText(String.valueOf(gesamtPunktenAnzahl));
		} else if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.WUMPUS_WURDE_GETOETET)) {
			gesamtPunktenAnzahl = gesamtPunktenAnzahl - pfeilBenutzung;
			punkteAnzahlLabel.setText(String.valueOf(gesamtPunktenAnzahl));
			jCheckBox1.setSelected(false);
			jCheckBox1.setEnabled(false);
			pfeil = false;
			ablaufListe2.add(new Ablauf(ablaufListe2.getLast().getPosition(), "Der Agent h�rt den Todesschrei des Wumpus", ((NachrichtenObjekt) arg).nachricht));
			setzteAblauf(ablaufListe2.getLast());

		} else if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.WUMPUS_WURDE_NICHT_GETOETET)) {
			gesamtPunktenAnzahl = gesamtPunktenAnzahl - pfeilBenutzung;
			punkteAnzahlLabel.setText(String.valueOf(gesamtPunktenAnzahl));
			jCheckBox1.setSelected(false);
			jCheckBox1.setEnabled(false);
			pfeil = false;
			ablaufListe2.add(new Ablauf(ablaufListe2.getLast().getPosition(), "Der Agent vernimmt eine ver�ngstigende Stille.", ((NachrichtenObjekt) arg).nachricht));
			setzteAblauf(ablaufListe2.getLast());
		}
		// if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.POSITION)) {
		// // String tempText = "\n" + "Position (" + (((NachrichtenObjekt) arg).y + 1) + "|" + (((NachrichtenObjekt) arg).x + 1) + ")";
		// // ablaufListe.add(tempText);
		// String tempText = "(" + (((NachrichtenObjekt) arg).y + 1) + "|" + (((NachrichtenObjekt) arg).x + 1) + ")";
		// ablaufListe2.add(new Ablauf(tempText,"",""));
		// ablaufTextArea.setText(listToString(ablaufListe));
		// }
		/*
		 * 1 als Agend in dem Feld 2 als Gold in dem Feld 3 als Glitter in nahligenden Felder 4 als Wumpus in dem Feld 5 als Geruch in nahligenden Felder 6 als Pit in dem Feld 7 als Brize ind nahligenden Felder 9 als graues Feld als Besucht
		 * bezeichnet
		 */

		// Wahrnehmung auswerten
		// TODO: �berarbeiten der Ablaufausgabe so dass S�tze zusammen kommen.
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.WAHRNEHMUNGEN)) {
			Ablauf tempAblauf;
			String tempText = "";
			Position tempPosition = new Position((((NachrichtenObjekt) arg).y + 1), (((NachrichtenObjekt) arg).x + 1));
			for (int j = 0, i = 0; i < ((NachrichtenObjekt) arg).wahrnehmung.length; i++) {
				if (((NachrichtenObjekt) arg).wahrnehmung[i] == 1) {
					// Agent
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 2) {
					// Gold
					tempText = tempText.concat("Der Agent sieht das Gold");
					j = 1;
					i = ((NachrichtenObjekt) arg).wahrnehmung.length;
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 3) {
					// Glitter
					tempText = tempText.concat("es glitzert");
					j = 1;
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 4) {
					// Wumpus
					tempText = tempText.concat("Der Agent sieht das Wumpus");
					j = 1;
					i = ((NachrichtenObjekt) arg).wahrnehmung.length;
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 5) {
					// Geruch
					tempText = tempText.concat("es stinkt");
					j = 1;
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 6) {
					// Fallgrube
					tempText = tempText.concat("Der Agent f�llt in die Grube");
					j = 1;
					i = ((NachrichtenObjekt) arg).wahrnehmung.length;
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 7) {
					// Brise
					tempText = tempText.concat("es zieht");
					j = 1;
				} else if (((NachrichtenObjekt) arg).wahrnehmung[i] == 9) {
					// Besuchtes Feld
				}
				if (i + 1 < ((NachrichtenObjekt) arg).wahrnehmung.length && ((NachrichtenObjekt) arg).wahrnehmung[i] != 9 && ((NachrichtenObjekt) arg).wahrnehmung[i] != 2 && ((NachrichtenObjekt) arg).wahrnehmung[i] != 4 && ((NachrichtenObjekt) arg).wahrnehmung[i] != 6 && ((NachrichtenObjekt) arg).wahrnehmung[i] != 1 && ((NachrichtenObjekt) arg).wahrnehmung[i] != 0
						&& ((NachrichtenObjekt) arg).wahrnehmung[i + 1] != 9 && ((NachrichtenObjekt) arg).wahrnehmung[i + 1] != 2 && ((NachrichtenObjekt) arg).wahrnehmung[i + 1] != 4 && ((NachrichtenObjekt) arg).wahrnehmung[i + 1] != 6 && ((NachrichtenObjekt) arg).wahrnehmung[i + 1] != 1 && ((NachrichtenObjekt) arg).wahrnehmung[i + 1] != 0) {
					tempText = tempText.concat(" und ");

				} else if (j != 0) {
					tempText = tempText.concat(".\n");
					break;
				}
			}
			// Warhnehmung wird in Ablaufvariable gesetzt
			// letzte Bewegung wird anhand der letzten Position und der aktuellen Position
			System.out.println("AblaufLsite2 " + ablaufListe2.size());
			if (!ablaufListe2.isEmpty()) {
				Position letztePosition = ablaufListe2.getLast().getPosition();
				String tempRichtung = welcheRichtung(letztePosition, tempPosition);
				tempAblauf = new Ablauf(tempPosition, tempText, tempRichtung);
			} else {
				tempAblauf = new Ablauf(tempPosition, tempText, "");
			}
			ablaufListe2.add(tempAblauf);
			setzteAblauf(ablaufListe2.getLast());
		}
		// if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.ICH_WEISS_WO_IST_WUMPUS)) {
		// String tempText = "\n" + "Position des Wumpus(" + (((NachrichtenObjekt) arg).y + 1) + "|" + (((NachrichtenObjekt) arg).x + 1) + ")" + "\n";
		// ablaufListe.add(tempText);
		// ablaufTextArea.setText(listToString(ablaufListe));
		// }
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.SPIEL_ZU_ENDE_WUMPUS)) {
			if (isEnabled()) {
				new GameOver(guiFrame, "	Agent ist tod, Wumpus hat ihm gefressen.");
			}

		}
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.SPIEL_ZU_ENDE_PIT)) {
			if (isEnabled()) {
				new GameOver(guiFrame, "	Agent ist tod, Agent in Fallgrube gefallen.");
			}
		}
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.SPIEL_ZU_ENDE_GOLD)) {
			if (isEnabled()) {
				new GameOver(guiFrame, "	Agent hat Gold gefunden.");
			}
		}
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.AUSGABE_SCHLUSSFOLGERUNG)) {
			schlussfolgerungAusgeben(((NachrichtenObjekt) arg).nachricht);
		}
		// BUMP geschichte
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.PUNKTE_ZURUECKSETZEN)) {
			if (((NachrichtenObjekt) arg).nachricht.length() <= 6) {
				gesamtPunktenAnzahl = gesamtPunktenAnzahl + einSchritt_1;
				// schritteAnzahlLabel.setText(Integer.toString(agentSchrittZahler));//alternative
				schritteAnzahlLabel.setText(String.valueOf(--agentSchrittZahler));
				punkteAnzahlLabel.setText(String.valueOf(gesamtPunktenAnzahl));
				ablaufListe2.removeLast();
				setzteAblauf(ablaufListe2.getLast());
				schlussfolgerungZurueck();
			} else if (((NachrichtenObjekt) arg).nachricht.charAt(0) == 'B') {
				gesamtPunktenAnzahl = gesamtPunktenAnzahl + pfeilBenutzung;
				punkteAnzahlLabel.setText(String.valueOf(gesamtPunktenAnzahl));
				jCheckBox1.setSelected(false);
				jCheckBox1.setEnabled(true);
				pfeil = true;
				ablaufListe2.removeLast();
				setzteAblauf(ablaufListe2.getLast());
				schlussfolgerungZurueck();
				// TODO: Erst die Pfeilbenutzung als Text reinpacken.
				// ablaufListe.removeLast();
				// ablaufTextArea.setText(listToString(ablaufListe));

			}
		}
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.NEUES_SPIEL)) {
			Position tempPosition = new Position((((NachrichtenObjekt) arg).y + 1), (((NachrichtenObjekt) arg).x + 1));
			ablaufListe2.add(new Ablauf(tempPosition, "", ""));
			setzteAblauf(ablaufListe2.getLast());
		}
		if (((NachrichtenObjekt) arg).information.equals(Bezeichnungen.WDA)) {
			wissensbasis.aendereFeld(((NachrichtenObjekt) arg).wissensbasis);
			System.out.println("GUI WDA");
		}

	}

	@Override
	public void actionPerformed(ActionEvent acev) {
		String actionBefehl = acev.getActionCommand();
		if (actionBefehl.equals(FILEMENUITEM1)) {
			neuesSpiel(4);
		} else if (actionBefehl.equals(FILEMENUITEM2)) {
			neuesSpiel(8);
			// } else if (actionBefehl.equals(fileMenuItem3)) {
			// wump.neuesSpiel(16);
			// gesamtPunktenAnzahl = 10000;
			// punkteAnzahlLabel.setText(gesamtPunktenAnzahl + "");
			// agentSchrittZahler = 0;
			// schritteAnzahlLabel.setText(agentSchrittZahler + "");
			// ablaufListe.clear();
			// ablaufTextArea.setText(listToString(ablaufListe));
		} else if (actionBefehl.equals(FILEMENUITEM4)) {
			setEnabled(false);
			neuesSpiel(-1);
		} else if (actionBefehl.equals(FILEMENUITEM5)) {
			System.exit(0);
		} else if (actionBefehl.equals(HELPMENUITEM1)) {
			setEnabled(false);
			new HelpScreen(guiFrame);
		} else if (actionBefehl.equals(HELPMENUITEM2)) {
			setEnabled(false);
			new AboutScreen(guiFrame);
		} else if (actionBefehl.equals(HELPMENUITEM3)) {
//			setEnabled(false);
			if (!wumpusPanel.DEBUG) {
				wumpusPanel.DEBUG = true;
			} else if (wumpusPanel.DEBUG) {
				wumpusPanel.DEBUG = false;
			}
		}
	}

	private String listToString(LinkedList tempList) {
		String tempText = "";
		Iterator listIterator = tempList.iterator();
		while (listIterator.hasNext()) {
			String temp = listIterator.next().toString();
			if (temp != "") {
				tempText = tempText.concat(temp + "\n");
			}
		}
		return tempText;
	}

	/**
	 * Diese Methode erstellt ein neues Spiel.
	 * @param i die Grosse des Feldes.
	 */
	public void neuesSpiel(int i) {
		{
			wump.schickeAgentZurueck();
			ablaufListe2.clear();			
			schlussfolgerungsListe.clear();
			gesamtPunktenAnzahl = 10000;
			punkteAnzahlLabel.setText(gesamtPunktenAnzahl + "");
			agentSchrittZahler = 0;
			schritteAnzahlLabel.setText(agentSchrittZahler + "");
			jCheckBox1.setEnabled(true);
			pfeil = true;
			wump.leereListe();
		}
		if (i < 0) {
			setEnabled(false);
			new Benutzerdefiniertes_Feld(guiFrame);
		} else {
			wump.neuesSpiel(i);
		}
	}

	/**
	 * Diese Methode bestimmt die Richtung aus zwei Positionen.
	 * 
	 * @param von
	 *            Startposition
	 * @param nach
	 *            Zielposition
	 * @return Richtung(String)
	 */
	private String welcheRichtung(Position von, Position nach) {
		if (von.y == nach.y) {
			if (von.x > nach.x) {
				return Bezeichnungen.LINKS;
			} else if (von.x < nach.x) {
				return Bezeichnungen.RECHTS;
			}
		} else if (von.x == nach.x) {
			if (von.y > nach.y) {
				return Bezeichnungen.UP;
			} else if (von.y < nach.y) {
				return Bezeichnungen.DOWN;
			}
		}
		return "GEH NACH HAUSE!";
	}

	private void setzteAblauf(Ablauf _ablauf) {
		if (_ablauf.getPosition() != null) {
			ablaufPosition.setText("Position " + _ablauf.getPosition().toString());
		}
		if (_ablauf.getWahrnehmung() != "") {
			ablaufWahrnehmungAusgabe.setText(_ablauf.getWahrnehmung());
		} else {
			ablaufWahrnehmungAusgabe.setText("");
		}
		if (_ablauf.getLetzteBewegung() != "") {
			ablaufBewegungAusgabe.setText(_ablauf.getLetzteBewegung());
		} else {
			ablaufBewegungAusgabe.setText("");
		}
	}

	private void schlussfolgerungAusgeben(String element) {
		if (schlussfolgerungsListe.isEmpty()) {
			schlussfolgerungsListe.add(new SchlussfolgerungsHelfer(element, 1));
		} else if (schlussfolgerungsListe.getLast().getNachricht().equalsIgnoreCase(element)) {
			schlussfolgerungsListe.getLast().erhoehen();
		} else {
			schlussfolgerungsListe.add(new SchlussfolgerungsHelfer(element, 1));
		}
		String temp = listToString(schlussfolgerungsListe);
		wissensbasisTextArea.setText(temp);
	}

	private void schlussfolgerungZurueck() {
		if (!schlussfolgerungsListe.isEmpty()) {
			if (schlussfolgerungsListe.getLast().getZaehler() == 1) {
				schlussfolgerungsListe.removeLast();
			} else {
				schlussfolgerungsListe.getLast().verringern();
			}
			String temp = listToString(schlussfolgerungsListe);
			wissensbasisTextArea.setText(temp);
		}
	}
	private void benutzePfeil(String _wahrnehmung){
		jCheckBox1.setSelected(false);
		jCheckBox1.setEnabled(false);
		pfeil = false;
		wump.bewegeAgent(_wahrnehmung);
	}
}
// TODO: Ablauf muss am anfang die Position des Agentes zeigen.
// TODO: Die Listener fertig und funktionierend machen. Focus Listerner auf GUI ist vorhanden