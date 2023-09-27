package dev.ez.MTproj;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RunnableObject implements Runnable {

    String name;

    public RunnableObject(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        System.out.println(ldt.format(formatter) + " Started thread " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ldt = LocalDateTime.now();
        System.out.println(ldt.format(formatter) + "  Ended thread " + name);
    }
}
