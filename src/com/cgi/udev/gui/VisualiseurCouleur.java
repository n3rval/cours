package com.cgi.udev.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class VisualiseurCouleur extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 7317908519895663599L;
private JPanel colorPanel;

  @Override
  protected void frameInit() {
    super.frameInit();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setTitle("Selecteur de couleur");

    this.setJMenuBar(new JMenuBar());
    this.getJMenuBar().add(createMenu());

    this.colorPanel = new JPanel();
    this.add(this.colorPanel);
    this.setSize(800, 600);;
  }

  private JMenu createMenu() {
    JMenu menu = new JMenu("Couleur");
    menu.add(new JMenuItem("Couleur de fond...")).addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        chooseColor();
      }
    });
    menu.addSeparator();
    menu.add(new JMenuItem("Fermer")).addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    return menu;
  }

  private void chooseColor() {
    Color newColor = JColorChooser.showDialog(this, "Choisissez la couleur de fond",
                                              colorPanel.getBackground());
    this.colorPanel.setBackground(newColor);
  }

  public static void main(String[] args) {
    JFrame window = new VisualiseurCouleur();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

}