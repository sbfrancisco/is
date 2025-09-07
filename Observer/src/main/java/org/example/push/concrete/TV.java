package org.example.push.concrete;

import org.example.push.interfaces.Observer;
import org.example.push.interfaces.Subject;

import javax.naming.ldap.Control;

public class TV implements Observer {
    Subject subject;
    int volume;
    public TV(ControllerChromecast subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(Object o) {
        this.volume = (Integer) o;
    }

    public void getVolume() {
        if (!subject.containsObserver(this)){
            System.out.println("the tv is off");
            return;
        }
       System.out.println("the volume registered on the TV is: %" + volume);
    }
}
