package org.example.push.concrete;

import org.example.push.interfaces.Observer;
import org.example.push.interfaces.Subject;

public class Phone implements Observer {
    Subject subject;
    int volume;
    public Phone(ControllerChromecast subject) {
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
        System.out.println("the volume registered on the phone is: %" + volume);
    }



}
