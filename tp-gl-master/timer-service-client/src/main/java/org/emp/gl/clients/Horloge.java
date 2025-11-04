package org.emp.gl.clients ; 

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ;

import java.beans.PropertyChangeEvent;


public class Horloge implements TimerChangeListener{

    String name; 
    TimerService timerService ; 


    public Horloge (String name) {
        this.name = name ; 

        System.out.println ("Horloge "+name+" initialized!") ;
    }

    public void afficherHeure () {
        if (timerService != null)
            System.out.println (name + " affiche " + 
                                timerService.getHeures() +":"+
                                timerService.getMinutes()+":"+
                                timerService.getSecondes()) ;
    }
    public void setTimerService(TimerService timerService) {
        this.timerService = timerService;
    
        this.timerService.addTimeChangeListener(this);
    }

     public void propertyChange(PropertyChangeEvent evt) {
         if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
             afficherHeure();
         }
     }
}
