package designer;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.ui.FlatEmptyBorder;
import com.formdev.flatlaf.ui.FlatLineBorder;
import com.formdev.flatlaf.ui.FlatMarginBorder;
import themes.ADarcula;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DesignerGUI {

    public static final Dimension schermo = Toolkit.getDefaultToolkit().getScreenSize();

    public enum Fonts {
        GENERICO(new Font("Segoe UI", Font.PLAIN, 11)),
        TITOLO(new Font("Segoe UI", Font.PLAIN, 23)),
        TITOLO_SECONDARIO(new Font("Segoe UI", Font.PLAIN, 18)),
        TITOLO_TERZIARIO(new Font("Segoe UI", Font.PLAIN, 13));

        private Font f;

        Fonts(Font f) {
            this.f = f;
        }

        public Font getFont() {
            return this.f;
        }
    }

    public static void setupADarcula(){
        //ADarcula.
        ADarcula.setup();
    }

    public static JButton creaJButton(String testo, ActionListener actionListener) {
        JButton b = new JButton(testo);
        b.addActionListener(actionListener);
        return b;
    }
    public static JButton creaDefaultJButton(String testo, ActionListener actionListener) {
        JButton b = new JButton(testo){
            @Override
            public boolean isDefaultButton() {
                return true;
            }
        };
        b.addActionListener(actionListener);
        return b;
    }


    public static JCheckBox creaJCheckBox(String testo, boolean selezionato) {
        return new JCheckBox(testo, selezionato);
    }

    public static JCheckBox creaJCheckBox(String testo) {
        return new JCheckBox(testo, false);
    }

    public static JRadioButton creaJRadioButton(String testo, boolean selezionato) {
        return new JRadioButton(testo, selezionato);
    }

    public static JRadioButton creaJRadioButton(String testo) {
        return new JRadioButton(testo, false);
    }

    public static JLabel creaJLabel(String testo, Font font) {
        JLabel label = new JLabel(testo);
        label.setFont(font);
        return label;
    }

    public static JLabel creaJLabel(String testo) {
        return creaJLabel(testo, Fonts.GENERICO.getFont());
    }

    public static JTextField creaJTextField(int colonne) {
        return new JTextField(colonne);
    }

    public static JTextField creaJTextField(int colonne, String testoDefault) {
        return new JTextField(testoDefault, colonne);
    }

    public static JTextField creaJTextField(String testoDefault) {
        return new JTextField(testoDefault);
    }

    public static JPasswordField creaJPasswordField(int colonne) {
        return new JPasswordField(colonne);
    }

    public static JPasswordField creaJPasswordField(int colonne, String testoDefault) {
        return new JPasswordField(testoDefault, colonne);
    }

    public static JPasswordField creaJPasswordField(String testoDefault) {
        return new JPasswordField(testoDefault);
    }

    public static JTextArea creaJTextArea(String testo, int righe, int colonne, boolean editabile) {
        JTextArea t = new JTextArea();
        t.setText(testo);
        t.setRows(righe);
        t.setColumns(colonne);
        t.setEditable(editabile);
        return t;
    }

    public static JTextArea creaJTextArea(String testo, boolean editabile) {
        return creaJTextArea(testo, 2, testo.length(), editabile);
    }

    public static JTextArea creaJTextArea(int righe, int colonne) {
        return creaJTextArea("", righe, colonne, true);
    }

    public static JComboBox creaJComboBox(Object[] lista) {
        return new JComboBox(lista);
    }

    public static DateChooser creaDateChooser() {
        return new DateChooser();
    }

    public static JPanel creaJPanel(LayoutManager layout) {
        return new JPanel(layout);
    }

    public static JPanel creaJPanelTrasparente(LayoutManager layout) {
        JPanel p = new JPanel(layout);
        p.setBackground(new Color(0f, 0f, 0f, 1f));
        p.setOpaque(true);
        return p;
    }

    public static JPanel creaBorderLayout() {
        return creaJPanel(new BorderLayout());
    }

    public static JPanel creaGridLayout(int righe, int colonne, Component[] componenti) {
        JPanel grid = creaJPanel(new GridLayout(righe, colonne));
        if (componenti != null) {
            for (Component c : componenti) {
                grid.add(c);
            }
        }
        return grid;
    }

    public static JPanel creaGridLayout(int righe, int colonne) {
        return creaGridLayout(righe, colonne, null);
    }

    public static JPanel creaGridBagLayout() {
        return creaJPanel(new GridBagLayout());
    }

    public static GridBagConstraints creaGridBagConstraints(int gridx, int gridy, int anchor, int fill, int topInsets, int leftInsets, int bottomInsets,
                                                            int rightInsets) {
        return creaGridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0, anchor, fill, topInsets, leftInsets, bottomInsets, rightInsets, 0, 0);
    }

    public static GridBagConstraints creaGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor,
                                                            int fill, int topInsets, int leftInsets, int bottomInsets, int rightInsets, int ipadx, int ipady) {
        return new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
                new Insets(topInsets, leftInsets, bottomInsets, rightInsets), ipadx, ipady);
    }

    public static GridBagConstraints creaGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor,
                                                            int fill, Insets insets, int ipadx, int ipady) {
        return new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady);
    }

    public static JPanel creaWrapLayout() {
        return creaJPanel(new WrapLayout());
    }

    public static JPanel creaWrapLayout(int align) {
        return creaJPanel(new WrapLayout(align));
    }

    public static JPanel creaBoxLayout(int axis) {
        JPanel l = new JPanel();
        l.setLayout(new BoxLayout(l, axis));
        return l;
    }

    public static JScrollPane creaJScrollPane(JPanel view) {
        JScrollPane jScrollPane = new JScrollPane(view);
        jScrollPane.setBorder(new FlatEmptyBorder());
        return jScrollPane;
    }


    public static JFrame creaJFrame(String titolo, JPanel child, boolean visibile) {
        return creaJFrame(titolo, child, null, visibile);
    }

    public static JFrame creaJFrame(String titolo, JPanel child, JMenuBar menuBar, boolean visibile) {
        JFrame ritorno = creaJFrame(titolo, schermo.width / 2, schermo.height / 2, child, menuBar, visibile);
        ritorno.setExtendedState(Frame.MAXIMIZED_BOTH);
        return ritorno;
    }

    public static JFrame creaJFrame(String titolo, int larghezza, int altezza, JPanel child, boolean visibile) {
        return creaJFrame(titolo, larghezza, altezza, child, null, visibile);
    }

    public static JFrame creaJFrame(String titolo, int larghezza, int altezza, JPanel child, JMenuBar menuBar, boolean visibile) {
        JFrame ritorno = new JFrame(titolo);
        ritorno.setSize(larghezza, altezza);
        ritorno.setLocation(schermo.width / 2 - ritorno.getWidth(), schermo.height / 2 - ritorno.getHeight());
        ritorno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ritorno.setLayout(new BorderLayout());
        ritorno.add(creaJScrollPane(child), BorderLayout.CENTER);
        ritorno.setVisible(visibile);
        if (menuBar != null) {
            ritorno.setJMenuBar(menuBar);
        }
        return ritorno;
    }

    public static JMenuItem creaJMenuItem(String testo, ActionListener listener) {
        JMenuItem ritorno = new JMenuItem(testo);
        ritorno.addActionListener(listener);
        return ritorno;
    }

    public static JMenuItem creaJMenuItem(String testo, ActionListener listener, Icon icona) {
        JMenuItem ritorno = new JMenuItem(testo, icona);
        ritorno.addActionListener(listener);
        return ritorno;
    }

    public static JMenu creaJMenu(String testo, Component[] componenti) {
        JMenu ritorno = new JMenu(testo);
        for (Component c : componenti) {
            ritorno.add(c);
        }
        return ritorno;
    }

    public static JMenu creaJMenu(String testo, Component[] componenti, Icon icona) {
        JMenu ritorno = creaJMenu(testo, componenti);
        ritorno.setIcon(icona);
        return ritorno;
    }

    public static JSeparator creaJSeparator() {
        return new JSeparator();
    }

    public static JMenuBar creaJMenuBar(Component[] componenti) {
        JMenuBar ritorno = new JMenuBar();
        for (Component c : componenti) {
            ritorno.add(c);
        }
        return ritorno;
    }

    public static JMenuBar creaJMenuBar() {
        return new JMenuBar();
    }

    private static JMenuBar creaMenuBarDaListaOggettiMenuException(ListaOggettiMenu menu) throws WrongValueException {
        JMenuBar ritorno = new JMenuBar();

        for (int i = 0; i < menu.getSize(); i++) {
            Map.Entry<String, Object> entry = menu.getOggetto(i);
            Object item = creaItem(entry.getKey(), entry.getValue());
            if (item instanceof JMenu) {
                ritorno.add((JMenu) item);
            } else if (item instanceof JMenuItem) {
                ritorno.add((JMenuItem) item);
            } else {
                System.out.println("hai sbagliato qualcosa");
            }
        }
        return ritorno;
    }

    private static Object creaItem(String key, Object value) throws WrongValueException {
        Object ritorno = null;

        if (value instanceof ActionListener) {
            JMenuItem item = creaJMenuItem(key, (ActionListener) value);
            ritorno = item;
        } else if (value instanceof ListaOggettiMenu) {
            ArrayList<Component> componenti = new ArrayList<>();
            ListaOggettiMenu listaMenu = (ListaOggettiMenu) value;
            for (int j = 0; j < listaMenu.getSize(); j++) {
                Map.Entry<String, Object> entry = listaMenu.getOggetto(j);
                String keyA = entry.getKey();
                Object valueA = entry.getValue();
                componenti.add((Component) creaItem(keyA, valueA));
            }
            JMenu menu = creaJMenu(key, componenti.toArray(new Component[componenti.size()]), null);
            ritorno = menu;

        } else if (value instanceof JSeparator) {
            ritorno = value;
        } else {
            throw new WrongValueException("Valore designer.ListaOggettiMenu sbagliato\n Valori accettabili: ActionListener, designer.ListaOggettiMenu, Separatore");
        }
        return ritorno;
    }

    public static JMenuBar creaJMenuBarDaListaOggettiMenu(ListaOggettiMenu menu) {
        JMenuBar ritorno = null;
        try {
            ritorno = creaMenuBarDaListaOggettiMenuException(menu);
        } catch (WrongValueException e) {
            e.printStackTrace();
        }
        return ritorno;
    }

    public static JPopupMenu creaJPopupMenu() {
        return new JPopupMenu();
    }

    public static JPopupMenu creaJPopupMenuDaListaOggettiMenu(ListaOggettiMenu menu) {
        JPopupMenu ritorno = creaJPopupMenu();
        for (int i = 0; i < menu.getSize(); i++) {
            Map.Entry<String, Object> entry = menu.getOggetto(i);
            Object item;
            try {
                item = creaItem(entry.getKey(), entry.getValue());
                if (item instanceof JMenu) {
                    ritorno.add((JMenu) item);
                } else if (item instanceof JMenuItem) {
                    ritorno.add((JMenuItem) item);
                } else if (item instanceof JSeparator) {
                    ritorno.add((JSeparator) item);
                }
            } catch (WrongValueException e) {
                e.printStackTrace();
            }
        }
        return ritorno;
    }

    public static JPanel creaLabelComponenteVerticale(String testoLabel, Component componente) {
        return creaLabelComponenteVerticale(creaJLabel(testoLabel), componente);
    }

    public static JPanel creaLabelComponenteVerticale(JLabel label, Component componente) {
        JPanel l = creaGridBagLayout();
        l.add(label, creaGridBagConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, 10, 0, 0, 0));
        l.add(componente, creaGridBagConstraints(0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 5, 0, 5, 0));
        //l.setBorder(bordi.bordoGenerico(0, new Insets(10, 10, 10, 10)));
        return l;
    }

    public static JPanel creaLabelComponenteOrizzontale(String testoLabel, Component componente) {
        return creaLabelComponenteOrizzontale(creaJLabel(testoLabel), componente);
    }

    public static JPanel creaLabelComponenteOrizzontale(JLabel label, Component componente) {
        JPanel l = creaGridBagLayout();
        l.add(label, creaGridBagConstraints(0, 0, 1, 1, 0.1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, 5, 0, 5, 10, 0, 0));
        l.add(componente, creaGridBagConstraints(1, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, 0, 5, 5, 0));
        //l.setBorder(bordi.bordoGenerico(0, new Insets(10, 10, 10, 10)));
        return l;
    }

    public static JPanel creaGruppoLabelComponenteOrizzontale(String[] testoLabel, Component[] componenti) {
        JLabel[] label = new JLabel[testoLabel.length];
        for (int i = 0; i < label.length; i++) {
            label[i] = creaJLabel(testoLabel[i]);
        }
        return creaGruppoLabelComponenteOrizzontale(label, componenti);
    }

    public static JPanel creaGruppoLabelComponenteOrizzontale(JLabel[] label, Component[] componenti) {
        JPanel l = creaGridBagLayout();
        for (int i = 0; i < label.length; i++) {
            l.add(label[i], creaGridBagConstraints(0, i, 1, 1, 0.1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, 5, 0, 5, 10, 0, 0));
            l.add(componenti[i], creaGridBagConstraints(1, i, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 5, 5, 0));
        }
        //l.setBorder(bordi.bordoGenerico(0, new Insets(10, 10, 10, 10)));
        return l;
    }

    public static JPanel creaGruppoLabelComponenteVerticale(String[] testoLabel, Component[] componenti) {
        JLabel[] label = new JLabel[testoLabel.length];
        for (int i = 0; i < label.length; i++) {
            label[i] = creaJLabel(testoLabel[i]);
        }
        return creaGruppoLabelComponenteVerticale(label, componenti);
    }

    public static JPanel creaGruppoLabelComponenteVerticale(JLabel[] label, Component[] componenti) {
        JPanel l = creaGridBagLayout();
        for (int i = 0; i < label.length; i++) {
            l.add(label[i], creaGridBagConstraints(0, 2 * i, GridBagConstraints.WEST, GridBagConstraints.NONE, 10, 0, 0, 0));
            l.add(componenti[i], creaGridBagConstraints(0, (2 * i) + 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 5, 0, 5, 0));
        }
        //l.setBorder(bordi.bordoGenerico(0, new Insets(10, 10, 10, 10)));
        return l;
    }


    public static JPanel creaPasswordFieldSH() {
        return creaPasswordFieldSH(creaJPasswordField(10));
    }

    public static JPanel creaPasswordFieldSH(JPasswordField pswField) {

        JButton sh = new JButton();
        sh.setIcon(new FlatSVGIcon( "com/formdev/flatlaf/demo/icons/show.svg" ));
        sh.addActionListener(new ActionListener() {
            boolean mostra = false;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                mostra = !mostra;
                if (mostra) {
                    pswField.setEchoChar((char) 0);
                } else {
                    pswField.setEchoChar('•');
                }
            }

        });
        JPanel grid = creaGridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        grid.add(pswField);
        grid.add(sh, gbc);
        return grid;
    }

    public static JDialog creaJDialog(JFrame finestra, String titolo, boolean modale, int larghezza, int altezza, JPanel child, JPanel panelloBottoni,
                                      boolean visibile) {
        JDialog dialog = new JDialog(finestra);
        dialog.setTitle(titolo);
        dialog.setModal(modale);
        dialog.setSize(larghezza, altezza);
        dialog.setLocation(schermo.width / 2 - dialog.getWidth(), schermo.height / 2 - dialog.getHeight());
        dialog.add(child, BorderLayout.CENTER);
        dialog.add(panelloBottoni, BorderLayout.SOUTH);
        //dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(visibile);
        return dialog;
    }

    public static JPanel creaPanelloBottoni(JButton[] bottoni) {

        JPanel grid = creaGridLayout(1, bottoni.length);
        //grid.setBackground(colori.suSfondo());
        ((GridLayout) grid.getLayout()).setHgap(5);

        for (JButton element : bottoni) {
            grid.add(element);
        }

        JPanel grid2 = creaGridBagLayout();
        //grid2.setBackground(colori.suSfondo());
        grid2.add(grid, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 5, 10), 0, 0));
        grid.setBackground(UIManager.getColor("MenuBar.background"));
        grid2.setBackground(UIManager.getColor("MenuBar.background"));
        return grid2;
    }

    public static JPanel creaGrigliaBottoni(int righe, int colonne, JButton[] bottoni, int Hgap, int Vgap) {
        JPanel gBottoni = creaGridLayout(righe, colonne);
        ((GridLayout) gBottoni.getLayout()).setHgap(Hgap);
        ((GridLayout) gBottoni.getLayout()).setVgap(Vgap);

        for (JButton element : bottoni) {
            gBottoni.add(element);
        }

        return gBottoni;
    }

    /*
        public static JButton creaBottoneCambiaTemaChiaroScuro() {
            return creaBottoneCambiaTemaChiaroScuro(new PreferenzeGUI(TEMA_CHIARO), new PreferenzeGUI(TEMA_SCURO));
        }

        public static JButton creaBottoneCambiaTemaChiaroScuro(PreferenzeGUI temaChiaro, PreferenzeGUI temaScuro) {
            return creaBottoneCambiaTemaChiaroScuro("<html>&#9728;</html>", "<html>&#127769;</html>", true, temaChiaro, temaScuro);
        }

        public static JButton creaBottoneCambiaTemaChiaroScuro(String testoTemaChiaro, String testoTemaScuro, boolean testoEmoji, PreferenzeGUI temaChiaro,
                                                               PreferenzeGUI temaScuro) {

            JButton ritorno = creaJButton(testoTemaChiaro, new ActionListener() {

                boolean temaScuroBool = false;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (temaScuroBool) {
                        cambiaGUI(temaChiaro);
                        ((Bottone) e.getSource()).setText(testoTemaChiaro);
                    } else {
                        cambiaGUI(temaScuro);
                        ((Bottone) e.getSource()).setText(testoTemaScuro);
                    }
                    temaScuroBool = !temaScuroBool;
                }
            });
            if (testoEmoji) {
                ritorno.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 11));
                ritorno.setName("bottone emoji");
            }

            return ritorno;
        }
    */
    public static Form creaForm() {
        return new Form();
    }

    public static Form creaForm(HashMap<String, Component> parametri) {
        return new Form(parametri);
    }

    public static Form creaForm(String[] parametri, Component[] campiParametri) {
        return new Form(parametri, campiParametri);
    }
}
