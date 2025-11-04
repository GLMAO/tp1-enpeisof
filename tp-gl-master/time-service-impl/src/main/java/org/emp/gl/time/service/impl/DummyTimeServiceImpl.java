package org.emp.gl.time.service.impl;

import java.beans.PropertyChangeListener;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.beans.PropertyChangeSupport;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class DummyTimeServiceImpl implements TimerService {

    private int dixiemeDeSeconde;
    private int secondes;
    private int minutes;
    private int heures;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    // ------------------------------------
    // Constructor
    // ------------------------------------
    public DummyTimeServiceImpl() {
        setTimeValues();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timeChanged();
            }
        };
        timer.scheduleAtFixedRate(task, 100, 100); // every 0.1 second
    }

    // ------------------------------------
    // Time value initialization
    // ------------------------------------
    private void setTimeValues() {
        LocalTime localTime = LocalTime.now();

        setHeures(localTime.getHour());
        setMinutes(localTime.getMinute());
        setSecondes(localTime.getSecond());
        setDixiemeDeSeconde(localTime.getNano() / 100_000_000);
    }

    private void timeChanged() {
        setTimeValues();
    }

    // ------------------------------------
    // Listener management
    // ------------------------------------
    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        pcs.addPropertyChangeListener((PropertyChangeListener) pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        pcs.removePropertyChangeListener((PropertyChangeListener) pl);
    }

    // ------------------------------------
    // Setters with event notification
    // ------------------------------------
    public void setDixiemeDeSeconde(int newValue) {
        if (dixiemeDeSeconde == newValue) return;
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = newValue;
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, newValue);
    }

    public void setSecondes(int newValue) {
        if (secondes == newValue) return;
        int oldValue = secondes;
        secondes = newValue;
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue, newValue);
    }

    public void setMinutes(int newValue) {
        if (minutes == newValue) return;
        int oldValue = minutes;
        minutes = newValue;
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue, newValue);
    }

    public void setHeures(int newValue) {
        if (heures == newValue) return;
        int oldValue = heures;
        heures = newValue;
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue, newValue);
    }

    // ------------------------------------
    // Getters
    // ------------------------------------
    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }
}
