/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service;

/**
 *
 * @author tina
 */


import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {

    String DIXEME_DE_SECONDE_PROP = "dixieme";
    String SECONDE_PROP = "seconde";
    String MINUTE_PROP = "minute";
    String HEURE_PROP = "heure";
}

