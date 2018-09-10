package com.cgi.udev.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ExempleGridBagLayout extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = -7423940698510412469L;

@Override
  protected void frameInit() {
    super.frameInit();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setTitle("Exemple grid bag layout");
    this.getContentPane().setLayout(new GridBagLayout());

    int rowIndex = 0;
    addRow(rowIndex++, "Civilit�", new JComboBox<String>(new String[] {"Madame", "Monsieur"}));
    addRow(rowIndex++, "Nom", new JTextField());
    addRow(rowIndex++, "Pr�nom", new JTextField());
    addRow(rowIndex++, "Addresse", new JTextArea(10, 20));
    addButtons(rowIndex++, new JButton("Ok"), new JButton("Annuler"));
    this.pack();
    this.setResizable(false);
  }

  private void addRow(int rowIndex, String titre, JComponent component) {
    // cr�ation des contraintes de positionnement
    GridBagConstraints cst = new GridBagConstraints();
    // le composant doit occuper tout l'espace horizontal de sa case
    cst.fill = GridBagConstraints.HORIZONTAL;
    // le composant doit �tre align� sur le haut de la case
    cst.anchor = GridBagConstraints.NORTH;
    // on d�finit la marge en pixels pour le haut, la gauche, le bas et la droite
    cst.insets = new Insets(5, 20, 5, 20);
    // on d�finit la position verticale
    cst.gridy = rowIndex;
    // on d�finit la position horizontale
    cst.gridx = 0;
    // poids relatif � l'horizontal
    cst.weightx = .3;

    JLabel label = new JLabel(titre);
    label.setLabelFor(component);
    this.add(label, cst);

    // on d�finit la position horizontale
    cst.gridx = 1;
    // poids relatif � l'horizontal
    cst.weightx = .7;
    this.add(component, cst);
  }

  private void addButtons(int rowIndex, JButton...buttons) {
    JPanel panel = new JPanel();
    for (JButton button : buttons) {
      panel.add(button);
    }
    // cr�ation des contraintes de positionnement
    GridBagConstraints cst = new GridBagConstraints();
    // on d�finit la marge en pixels pour le haut, la gauche, le bas et la droite
    cst.insets = new Insets(5, 10, 0, 0);
    // le composant doit occuper tout l'espace horizontal de sa case
    cst.fill = GridBagConstraints.HORIZONTAL;
    // on d�finit la position verticale
    cst.gridy = rowIndex;
    // on d�finit la position horizontale
    cst.gridx = 0;
    // le composant s'�tend � l'horizontal sur deux cases de la grille
    cst.gridwidth = 2;
    this.add(panel, cst);
  }

  public static void main(String[] args) {
    JFrame window = new ExempleGridBagLayout();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

}