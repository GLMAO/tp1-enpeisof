package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;

/**
 * Programme principal pour tester les horloges
 */
public class App {

    public static void main(String[] args) {
        testDuTimeService();
    }

    private static void testDuTimeService() {
        // 1. Créer une instance du DummyTimeServiceImpl
        TimerService timerService = new DummyTimeServiceImpl();

        // 2. Créer plusieurs horloges
        Horloge horloge1 = new Horloge("Horloge 1");
        Horloge horloge2 = new Horloge("Horloge 2");
        Horloge horloge3 = new Horloge("Horloge 3");

        // 3. Injecter le service de temps dans chaque horloge
        horloge1.setTimerService(timerService);
        horloge2.setTimerService(timerService);
        horloge3.setTimerService(timerService);

        // 4. Laisser tourner le test pendant un moment
        try {
            Thread.sleep(15000); // 15 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTest terminé !");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
