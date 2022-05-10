package pl.bonus;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

public class MyFrame extends JFrame {


    //Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    private String time;
    private String day;
    private String date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Debil Clock");
        this.setLayout(new FlowLayout());
        this.setSize(300, 300);
        this.setResizable(true);

        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //'a' bedeutet AM/PM
        dayFormat = new SimpleDateFormat("EEEE"); //'a' bedeutet AM/PM
        dateFormat = new SimpleDateFormat("dd. MMMMMM, yyyy");

        //der Bildschrim
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 50));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 50));


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true); // zeigt den Bildschrim

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(this.time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(this.day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(this.date);

            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
