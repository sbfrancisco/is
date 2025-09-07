package org.example;

import org.example.push.concrete.ControllerChromecast;
import org.example.push.concrete.Phone;
import org.example.push.concrete.TV;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // simulation of scene, up the volume of chromecast, and up volume of tv and phone view
    public static void main(String[] args) {
        ControllerChromecast control = new ControllerChromecast();
        Phone p =  new Phone(control);
        TV tv = new TV(control);
        control.changeVolume(45);
        tv.getVolume();
        p.getVolume();
        control.removeObserver(p);
        // off phone
        control.changeVolume(35);
        tv.getVolume();
        p.getVolume();
    }
}