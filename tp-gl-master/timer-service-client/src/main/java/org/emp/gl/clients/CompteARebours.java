package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private int valeur;                // le compteur
    private final String name;         // nom du compte à rebours
    private final TimerService timer;  // référence au service de temps

    // Constructeur
    public CompteARebours(String name, int valeurInitiale, TimerService timer) {
        this.name = name;
        this.valeur = valeurInitiale;
        this.timer = timer;

        // On s’abonne au service de temps
        timer.addTimeChangeListener(this);
        System.out.println("⏳ CompteARebours " + name + " initialisé à " + valeurInitiale);
    }


    public void propertyChange(PropertyChangeEvent evt) {
        // On ne réagit qu’au changement de seconde
        if (SECONDE_PROP.equals(evt.getPropertyName())) {
            valeur--;
            System.out.println("🔹 " + name + " : " + valeur);

            // Si on atteint 0, on se désinscrit
            if (valeur <= 0) {
                timer.removeTimeChangeListener(this);
                System.out.println("✅ " + name + " terminé et désinscrit !");
            }
        }
    }
}
