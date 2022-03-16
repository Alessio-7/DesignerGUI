package designer;

import com.formdev.flatlaf.ui.FlatArrowButton;
import com.formdev.flatlaf.ui.FlatRoundBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;


/**
 * Classe per agevolare la scelta di una data che impiega la classe
 * <code>PreferenzeGUI</code>
 */
public class DateChooser extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * calendario
     */
    private final Calendar cal;

    /**
     * giorno scelto
     */
    private int giorno;
    /**
     * mese scelto
     */
    private int mese;
    /**
     * anno scelto
     */
    private int anno;

    /**
     * giorno corrente
     */
    private final int giornoCorrente;
    /**
     * mese corrente
     */
    private final int meseCorrente;
    /**
     * anno corrente
     */
    private final int annoCorrente;

    /**
     * label per la data scelta
     */
    private final JLabel dataLabel;
    /**
     * bottone per la scelta della data
     */
    private final JButton scegliData;

    /**
     * popup per mostrare il calendario
     */
    private final JPopupMenu popup;
    /**
     * layout di tutto il calendario
     */
    private JPanel calendario;
    /**
     * testo del mese
     */
    private JLabel testoMese;
    /**
     * layout dei bottoni del mese
     */
    private JPanel meseLayout;
    /**
     * bottone della giornata corrente
     */
    private JButton bottoneGiornoCorrente;

    public DateChooser() {
        super(new GridBagLayout());

        cal = Calendar.getInstance();

        giornoCorrente = cal.get(Calendar.DATE);
        meseCorrente = cal.get(Calendar.MONTH);
        annoCorrente = cal.get(Calendar.YEAR);

        dataLabel = DesignerGUI.creaJLabel(giornoCorrente + "/" + (meseCorrente + 1) + "/" + annoCorrente + " ");

        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);

        scegliData = DesignerGUI.creaJButton("", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                popup.show(scegliData, 0, scegliData.getHeight() + 3);
            }
        });
        scegliData.setIcon(new ImageIcon("res/icons/calendar.png"));

        add(dataLabel);
        add(scegliData);

        popup = DesignerGUI.creaJPopupMenu();
        popup.setLightWeightPopupEnabled(false);
        generaCalendario();
    }

    /**
     * Ritorna il giorno selezionato
     *
     * @return il giorno selezionato
     */
    public int getGiorno() {
        return giorno;
    }

    /**
     * Ritorna il mese selezionato
     *
     * @return il mese selezionato
     */
    public int getMese() {
        return mese;
    }

    /**
     * Ritorna l'anno selezionato
     *
     * @return l'anno selezionato
     */
    public int getAnno() {
        return anno;
    }

    private void generaCalendario() {
        JPanel lSceltaMese = DesignerGUI.creaBorderLayout();

        String s = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + cal.get(Calendar.YEAR);
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        testoMese = DesignerGUI.creaJLabel(s);

        ArrowButton indietroMese = new ArrowButton(SwingConstants.WEST);
        indietroMese.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaMese(-1);
            }

        });
        ArrowButton avantiMese = new ArrowButton(SwingConstants.EAST);
        avantiMese.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaMese(1);
            }

        });

        lSceltaMese.add(indietroMese, BorderLayout.WEST);
        testoMese.setHorizontalAlignment(SwingConstants.CENTER);
        lSceltaMese.add(testoMese, BorderLayout.CENTER);
        lSceltaMese.add(avantiMese, BorderLayout.EAST);

        calendario = DesignerGUI.creaGridBagLayout();
        calendario.add(lSceltaMese,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
        meseLayout = DesignerGUI.creaGridLayout(6, 7);
        aggiornaMese();
        calendario.add(meseLayout,
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        popup.add(calendario);

        anno = Calendar.getInstance().get(Calendar.YEAR);
        mese = Calendar.getInstance().get(Calendar.MONTH) + 1;
        giorno = Calendar.getInstance().get(Calendar.DATE);
    }

    private void cambiaMese(int i) {

        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + i, 1);
        aggiornaMese();

    }

    private void aggiornaMese() {

        String s = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + cal.get(Calendar.YEAR);
        s = s.substring(0, 1).toUpperCase() + s.substring(1);

        testoMese.setText(s);

        meseLayout.removeAll();
        meseLayout.setLayout(new GridBagLayout());

        String[] giorniNellaSettimana = {"Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"};

        for (int i = 0; i < 7; i++) {
            meseLayout.add(DesignerGUI.creaJLabel(giorniNellaSettimana[i]),
                    new GridBagConstraints(i, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
        }

        int giorniMese = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int giorniPrimaLunedi;

        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            giorniPrimaLunedi = 6;
        } else {
            giorniPrimaLunedi = cal.get(Calendar.DAY_OF_WEEK) - 2;
        }

        for (int i = giorniPrimaLunedi, r = 0, c = 0; i < giorniMese + giorniPrimaLunedi; i++) {

            if (i % 7 == 0 && i != 0) {
                r++;
            }
            c = i - (r * 7);
            int numeroGiorno = i + 1 - giorniPrimaLunedi;

            boolean giornataCorrente = numeroGiorno == giornoCorrente && cal.get(Calendar.MONTH) == meseCorrente
                    && cal.get(Calendar.YEAR) == annoCorrente;

            BottoneCalendario bottoneCalendario = new BottoneCalendario(numeroGiorno, cal.get(Calendar.MONTH), cal.get(Calendar.YEAR),
                    giornataCorrente);

            meseLayout.add(bottoneCalendario, new GridBagConstraints(c, r + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(1, 1, 1, 1), 0, 0));

        }
        if (popup.isShowing()) {

            java.awt.Window w = SwingUtilities.getWindowAncestor(popup);
            w.pack();
            w.validate();
            popup.repaint();
        }

    }

    private class BottoneCalendario extends JButton {

        private final boolean giornataCorrente;

        public BottoneCalendario(int g, int m, int a, boolean giornataCorrente) {
            super(g + "");
            setBorder(new Bordo());
            this.giornataCorrente = giornataCorrente;
            addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    giorno = g;
                    mese = m + 1;
                    anno = a;
                    dataLabel.setText(giorno + "/" + mese + "/" + anno + " ");
                    //((JButton) e.getSource()).setBorder(gui.bordi.bordoInteragibile());
                    popup.setVisible(false);
                }

            });

            if (giornataCorrente) {
                bottoneGiornoCorrente = this;
            }
        }

        @Override
        public boolean isDefaultButton() {
            return giornataCorrente;
        }

        private class Bordo extends FlatRoundBorder {
            public Bordo() {
                super();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                Insets n = new FlatRoundBorder().getBorderInsets(c);
                return new Insets(n.top, n.top, n.top, n.top);
            }
        }

    }

    private class ArrowButton extends FlatArrowButton {
        public ArrowButton(int direzione) {
            super(direzione, UIManager.getString("Component.arrowType"), UIManager.getColor("ComboBox.buttonArrowColor"), UIManager.getColor("ComboBox.buttonDisabledArrowColor"),
                    UIManager.getColor("ComboBox.buttonHoverArrowColor"), null, UIManager.getColor("ComboBox.buttonPressedArrowColor"), null);
        }
    }

}
