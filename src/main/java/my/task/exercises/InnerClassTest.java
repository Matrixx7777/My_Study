package my.task.exercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class InnerClassTest {
    public static void main(String[] args) {

        var clock = new TakingClock(1000,true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Do you want close your program ?");
        System.exit(0);
    }
}

class TakingClock {

    private final int interval;
    private final boolean beep;

    public TakingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements  ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("When you hear this sound, then time will : "
                    + Instant.ofEpochMilli(actionEvent.getWhen()));
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}