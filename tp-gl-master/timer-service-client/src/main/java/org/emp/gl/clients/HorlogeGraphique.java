package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class HorlogeGraphique extends JFrame implements TimerChangeListener {

    private final JLabel labelHeure = new JLabel("00:00:00", SwingConstants.CENTER);
    private final TimerService timer;

    public HorlogeGraphique(TimerService timer) {
        this.timer = timer;
        this.timer.addTimeChangeListener(this);

        setTitle("Horloge Graphique");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelHeure.setFont(new Font("Consolas", Font.BOLD, 36));
        add(labelHeure);

        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            SwingUtilities.invokeLater(() -> {
                String heure = String.format("%02d:%02d:%02d",
                        timer.getHeures(),
                        timer.getMinutes(),
                        timer.getSecondes());
                labelHeure.setText(heure);
            });
        }
    }
}
