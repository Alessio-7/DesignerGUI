package designer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Form {

    private HashMap<String, Component> parametri;
    private ArrayList<String> ordineParametri;

    public Form() {
        parametri = new HashMap<String, Component>();
        ordineParametri = new ArrayList<String>();
    }

    public Form(HashMap<String, Component> parametri) {
        this.parametri = parametri;
        ordineParametri = new ArrayList<String>();
    }

    public Form(String[] parametri, Component[] campiParametri) {
        this.parametri = new HashMap<String, Component>();
        ordineParametri = new ArrayList<String>();
        for (int i = 0; i < parametri.length; i++) {
            this.parametri.put(parametri[i], campiParametri[i]);
        }
    }

    public void aggiungiParametro(String parametro, Component campoParametro) {
        ordineParametri.add(parametro);
        parametri.put(parametro, campoParametro);
    }

    public String getParametroTesto(String parametro) {
        Component campoParametro = parametri.get(parametro);

        if (campoParametro instanceof JTextField) {
            return ((JTextField) campoParametro).getText();
        } else if (campoParametro instanceof JTextArea) {
            return ((JTextArea) campoParametro).getText();
        } else if (campoParametro instanceof JPasswordField) {
            return ((JPasswordField) campoParametro).getPassword().toString();
        } else if (campoParametro instanceof DateChooser) {
            return ((DateChooser) campoParametro).getGiorno() + "/" + ((DateChooser) campoParametro).getMese() + "/"
                    + ((DateChooser) campoParametro).getAnno();
        }

        return "";
    }

    public boolean getParametroBooleano(String parametro) {
        Component campoParametro = parametri.get(parametro);

        if (campoParametro instanceof JCheckBox) {
            return ((JCheckBox) campoParametro).isSelected();
        } else if (campoParametro instanceof JRadioButton) {
            return ((JRadioButton) campoParametro).isSelected();
        }

        return false;
    }

    public Component getCampoParametro(String parametro) {
        return parametri.get(parametro);
    }

    public JPanel getFormOrizzontale() {

        String[] labels = ordineParametri.toArray(new String[ordineParametri.size()]);
        Component[] campiParametri = new Component[ordineParametri.size()];

        for (int i = 0; i < labels.length; i++) {
            if (parametri.get(labels[i]) instanceof JPasswordField) {
                campiParametri[i] = DesignerGUI.creaPasswordFieldSH((JPasswordField) parametri.get(labels[i]));
            } else {
                campiParametri[i] = parametri.get(labels[i]);
            }
        }

        return DesignerGUI.creaGruppoLabelComponenteOrizzontale(labels, campiParametri);
    }

    public JPanel getFormVerticale() {
        String[] labels = ordineParametri.toArray(new String[ordineParametri.size()]);
        Component[] campiParametri = new Component[ordineParametri.size()];

        for (int i = 0; i < labels.length; i++) {
            if (parametri.get(labels[i]) instanceof JPasswordField) {
                campiParametri[i] = DesignerGUI.creaPasswordFieldSH((JPasswordField) parametri.get(labels[i]));
            } else {
                campiParametri[i] = parametri.get(labels[i]);
            }
        }

        return DesignerGUI.creaGruppoLabelComponenteVerticale(labels, campiParametri);
    }

}
