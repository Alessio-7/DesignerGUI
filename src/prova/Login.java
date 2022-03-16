package prova;

import designer.DesignerGUI;
import designer.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login {

    public static void main(String[] args) {

        DesignerGUI.setupADarcula();

        System.out.println(UIManager.get("Button.textShiftOffset"));

        Form form = DesignerGUI.creaForm();
        form.aggiungiParametro("User name:", DesignerGUI.creaJTextField(""));
        form.aggiungiParametro("Password:", DesignerGUI.creaJPasswordField(""));
        form.aggiungiParametro("Data di nascita:", DesignerGUI.creaDateChooser());
        form.aggiungiParametro("Mantieni accesso", DesignerGUI.creaJRadioButton("", false));
        //form.aggiungiParametro("Tema:", DesignerGUI.creaBottoneCambiaTemaChiaroScuro());

        JPanel l = DesignerGUI.creaWrapLayout();
        l.add(form.getFormOrizzontale());
        JFrame f = DesignerGUI.creaJFrame("Login", 300, 310, l, false);
        f.setResizable(false);

        f.add(DesignerGUI.creaPanelloBottoni(new JButton[]{DesignerGUI.creaDefaultJButton("Ok", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                f.dispose();
                System.out.println("User name: " + form.getParametroTesto("User name:"));
                System.out.println("Password: " + form.getParametroTesto("Password:"));
                System.out.println("Data di nascita: " + form.getParametroTesto("Data di nascita:"));
                System.out.println("Mantieni accesso: " + form.getParametroBooleano("Mantieni accesso:"));
            }

        }), DesignerGUI.creaJButton("Cancella", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                f.dispose();
                System.out.println("Operazione annullata");
            }

        })}), BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
