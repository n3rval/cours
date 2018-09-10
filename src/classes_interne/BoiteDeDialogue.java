package classes_interne;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class BoiteDeDialogue extends JDialog {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private class IncrementerAction extends AbstractAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncrementerAction() {
      super("Incrémenter");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      incrementer();
    }
  }

  private class DecrementerAction extends AbstractAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DecrementerAction() {
      super("Décrémenter");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      decrementer();
    }
  }

  private JLabel label;
  private int valeur;

  @Override
  protected void dialogInit() {
    super.dialogInit();
    this.setLayout(new FlowLayout());
    this.label = new JLabel(Integer.toString(this.valeur));
    this.add(this.label);
    this.add(new JButton(new IncrementerAction()));
    this.add(new JButton(new DecrementerAction()));
    this.pack();
  }

  private void incrementer() {
    label.setText(Integer.toString(++this.valeur));
  }

  private void decrementer() {
    label.setText(Integer.toString(--this.valeur));
  }

  public static void main(String[] args) {
    BoiteDeDialogue boiteDeDialogue = new BoiteDeDialogue();
    boiteDeDialogue.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    boiteDeDialogue.setVisible(true);
  }

}