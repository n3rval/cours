package com.cgi.udev.gui;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExempleOptionPane extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 5875356294327792747L;
private static final String APP_TITLE = "Exemple OptionPane";

  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Bonjour", APP_TITLE, JOptionPane.PLAIN_MESSAGE);
    JOptionPane.showMessageDialog(null, "Ceci est un message", APP_TITLE, JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "Ceci est un avertissement", APP_TITLE, JOptionPane.WARNING_MESSAGE);
    JOptionPane.showMessageDialog(null, "Ceci est une erreur", APP_TITLE, JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null, "On passe � la suite ?", APP_TITLE, JOptionPane.QUESTION_MESSAGE);

    int jouer = JOptionPane.showConfirmDialog(null, "Voulez-vous jouer ?", APP_TITLE, JOptionPane.YES_NO_OPTION);
    if (jouer == JOptionPane.YES_OPTION) {
      Random random = new Random();
      do {
        int bonneResponse = random.nextInt(20) + 1;

        String reponse = JOptionPane.showInputDialog(null, "Donnez un nombre entre 1 et 20 :",
                                                     APP_TITLE, JOptionPane.QUESTION_MESSAGE);

        if (reponse == null) {
          break;
        }

        try {
          int valeur = Integer.valueOf(reponse);
          if (valeur == bonneResponse) {
            JOptionPane.showMessageDialog(null, "Bravo vous avez gagn� !",
                                          APP_TITLE, JOptionPane.INFORMATION_MESSAGE);
          } else {
            JOptionPane.showMessageDialog(null, "Perdu ! La bonne r�ponse �tait " + bonneResponse + ".",
                                          APP_TITLE, JOptionPane.WARNING_MESSAGE);
          }
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "'" + reponse + "' n'est pas un nombre !",
                                        APP_TITLE, JOptionPane.ERROR_MESSAGE);
        }

      } while (JOptionPane.showConfirmDialog(null, "Voulez-vous rejouer ?",
                                             APP_TITLE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);


      JOptionPane.showMessageDialog(null, "Au revoir...", APP_TITLE, JOptionPane.PLAIN_MESSAGE);
    }
  }

}