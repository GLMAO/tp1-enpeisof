package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

import java.util.Random;

/**
 * Programme principal pour tester les horloges et les comptes à rebours
 */
public class App {

    public static void main(String[] args) {
        //System.out.println("=== TEST DES HORLOGES ===");
        //testDesHorloges();

        System.out.println("\n=== TEST DES COMPTES À REBOURS ===");
        testDesComptesARebours();

        System.out.println("\nTous les tests sont terminés !");
    }

    /**
     * Test pour afficher l'heure avec plusieurs horloges
     */
    private static void testDesHorloges() {
        // 1. Créer une instance du service de temps
        TimerService timerService = new DummyTimeServiceImpl();

        // 2. Créer plusieurs horloges
        Horloge horloge1 = new Horloge("Horloge 1");
        Horloge horloge2 = new Horloge("Horloge 2");
        Horloge horloge3 = new Horloge("Horloge 3");

        // 3. Injecter le service de temps
        horloge1.setTimerService(timerService);
        horloge2.setTimerService(timerService);
        horloge3.setTimerService(timerService);

        // 4. Laisser tourner pendant 10 secondes
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFin du test des horloges !");
    }

    /**
     * Test pour le fonctionnement du compte à rebours
     */
    private static void testDesComptesARebours() {
        // 1. Créer une instance du même service de temps
        TimerService timerService = new DummyTimeServiceImpl();

        // 2. Un compte à rebours simple de 5 secondes
        CompteARebours c1 = new CompteARebours("C1", 5, timerService);

        // 3. Créer plusieurs comptes à rebours aléatoires entre 10 et 20
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            int valeurInit = 10 + random.nextInt(11); // [10, 20]
            new CompteARebours("C" + (i + 1), valeurInit, timerService);
        }

        // 4. Laisser tourner pendant 25 secondes
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFin du test des comptes à rebours !");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
