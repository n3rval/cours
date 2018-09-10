package com.cgi.udev.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ExempleActionListener extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 3592153030767765995L;
private JComboBox<String> civilite;
  private JTextField nom;
  private JTextField prenom;
  private JTextArea adresse;

  @Override
  protected void frameInit() {
    super.frameInit();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setTitle("Exemple Listeners");
    this.getContentPane().setLayout(new GridBagLayout());

    int rowIndex = 0;
    civilite = new JComboBox<String>(new String[] {"Madame", "Monsieur"});
    nom = new JTextField();
    prenom = new JTextField();
    adresse = new JTextArea(10, 20);

    addRow(rowIndex++, "Civilité", civilite);
    addRow(rowIndex++, "Nom", nom);
    addRow(rowIndex++, "Prénom", prenom);
    addRow(rowIndex++, "Addresse", adresse);

    JButton okButton = new JButton("Ok");
    okButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onOk();
      }
    });
    JButton cancelButton = new JButton("Annuler");
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        onCancel();
      }
    });
    addButtons(rowIndex++, okButton, cancelButton);

    this.pack();
    this.setResizable(false);
  }

  private void onOk() {
    // On affiche le contenu du formulaire sur la sortie standard
    System.out.println(String.format("%1$s %2$s %3$s résidant au %4$s",
                       civilite.getSelectedItem(), prenom.getText(), nom.getText(), adresse.getText()));
  }

  private void onCancel() {
    // on cache la fenêtre
    this.setVisible(false);
    // on supprime la fenêtre
    this.dispose();
  }

  private void addRow(int rowIndex, String titre, JComponent component) {
    GridBagConstraints cst = new GridBagConstraints();
    cst.fill = GridBagConstraints.HORIZONTAL;
    cst.anchor = GridBagConstraints.NORTH;
    cst.insets = new Insets(5, 20, 5, 20);
    cst.gridy = rowIndex;
    cst.gridx = 0;
    cst.weightx = .3;

    JLabel label = new JLabel(titre);
    label.setLabelFor(component);
    this.add(label, cst);

    cst.gridx = 1;
    cst.weightx = .7;
    this.add(component, cst);
  }

  private void addButtons(int rowIndex, JButton...buttons) {
    JPanel panel = new JPanel();
    for (JButton button : buttons) {
      panel.add(button);
    }
    GridBagConstraints cst = new GridBagConstraints();
    cst.insets = new Insets(5, 10, 0, 0);
    cst.fill = GridBagConstraints.HORIZONTAL;
    cst.gridy = rowIndex;
    cst.gridx = 0;
    cst.gridwidth = 2;
    this.add(panel, cst);
  }

  public static void main(String[] args) {
    JFrame window = new ExempleActionListener();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

}