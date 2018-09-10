package com.cgi.udev.gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class ExempleComposant extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JTabbedPane tabbedPane;

  @Override
  protected void frameInit() {
    super.frameInit();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setName("Exemple composants");
    tabbedPane = new JTabbedPane();
    this.add(tabbedPane);

    addComponent("Label",
                 new JLabel(UIManager.getIcon("FileView.computerIcon")),
                 new JLabel("Libellé avec du texte"));

    addComponent("Text field", new JTextField("champ de texte"));
    addComponent("Text area", new JTextArea("zone de texte"));
    addComponent("Combo box", new JComboBox<String>(new String[] {"Bleu", "Rouge", "Vert"}));
    addComponent("Check box", new JCheckBox("une boite à cocher"));
    addComponent("Spinner", new JSpinner());
    addComponent("Editor", new JEditorPane("text/html", "<p>Un éditeur de texte <strong>riche</strong></p>"));
    JProgressBar progressBar = new JProgressBar();
    progressBar.setValue(60);
    addComponent("Progress bar", progressBar);
    addComponent("Button", new JButton("Un bouton"));
  }

  private void addComponent(String titre, JComponent... components) {
      JPanel panel = new JPanel();
      for (JComponent component : components) {
        panel.add(component);
      }
      tabbedPane.add(titre, panel);
  }

  public static void main(String[] args) {
    JFrame window = new ExempleComposant();
    window.setSize(500, 400);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

}