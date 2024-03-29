package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public static void main(String[] args) {
        //setting up main Frame
        JFrame frame = new JFrame();
        frame.setSize(750, 500);
        JPanel center = new JPanel();
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel left = new JPanel();
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel right = new JPanel();
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.setLayout(new GridLayout(0, 3, 0, 0));
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(left);
        frame.add(center);
        frame.add(right);

        //left side
        //left buttons
        JButton addHour = new JButton("Add Hours");

        //left inputs
        JLabel freeHoursLabel = new JLabel("Free Hours");
        JLabel enterFreeHours = new JLabel("Enter your Free Hours: 24:00");
        JTextField freeHours = new JTextField(50);
        freeHours.setMaximumSize(freeHours.getPreferredSize());
        JCheckBox mon = new JCheckBox("Monday");
        JCheckBox tues = new JCheckBox("Tuesday");
        JCheckBox wed = new JCheckBox("Wednesday");
        JCheckBox thur = new JCheckBox("Thursday");
        JCheckBox fri = new JCheckBox("Friday");
        JCheckBox sat = new JCheckBox("Saturday");
        JCheckBox sun = new JCheckBox("Sunday");
        JLabel yourFreeHours = new JLabel("Your Free Hours:");

        //left layout
        left.setLayout(new BorderLayout());
        JPanel leftNorth = new JPanel();
        JPanel leftCenter = new JPanel();

        leftNorth.setPreferredSize(new Dimension(30, 40));
        left.add(leftNorth, BorderLayout.NORTH);
        Color custOrange = new Color(223, 116, 12);
        leftNorth.setBackground(custOrange);
        leftNorth.add(freeHoursLabel);

        left.add(leftCenter, BorderLayout.CENTER);
        Color custBase = new Color(230, 255, 255);
        leftCenter.setBackground(custBase);
        leftCenter.setLayout(new BoxLayout(leftCenter, BoxLayout.PAGE_AXIS));
        leftCenter.add(enterFreeHours);
        leftCenter.add(freeHours);
        freeHours.setMaximumSize(freeHours.getPreferredSize());
        leftCenter.add(mon);
        leftCenter.add(tues);
        leftCenter.add(wed);
        leftCenter.add(thur);
        leftCenter.add(fri);
        leftCenter.add(sat);
        leftCenter.add(sun);
        leftCenter.add(Box.createRigidArea(new Dimension(0, 10)));
        leftCenter.add(addHour);
        leftCenter.add(yourFreeHours);

        //center
        //center labels
        JLabel timelineLabel = new JLabel("Timeline");

        //center layout
        center.setLayout(new BorderLayout());
        JPanel centerNorth = new JPanel();
        JPanel centerCenter = new JPanel();
        centerCenter.setBackground(custBase);
        centerNorth.setPreferredSize(new Dimension(30, 40));
        center.add(centerNorth, BorderLayout.NORTH);
        Color custCyan = new Color(111, 195, 223);
        centerNorth.setBackground(custCyan);
        centerNorth.add(timelineLabel);
        center.add(centerCenter, BorderLayout.CENTER);


        //right side
        //right buttons
        JButton addEvent = new JButton("Add Event");

        //right inputs
        // event input
        JLabel eventNameLabel = new JLabel("Event Name Here");
        JTextField eventName = new JTextField(50);
        eventName.setMaximumSize(eventName.getPreferredSize());
        // location input
        JLabel locationLabel = new JLabel("Event Location Here");
        JTextField location = new JTextField(50);
        location.setMaximumSize(location.getPreferredSize());
        // time input
        JLabel timeLabel = new JLabel("Event Time Here: MM-DD-YYYY & 24:00");
        JTextField time = new JTextField(50);
        time.setMaximumSize(time.getPreferredSize());

        //otherLabels
        JLabel createAnEvent = new JLabel("Create an Event");

        //right layout
        right.setLayout(new BorderLayout());
        Color custYellow = new Color(255, 230, 77);
        JPanel rightNorth = new JPanel();
        rightNorth.setBackground(custYellow);
        JPanel rightCenter = new JPanel();
        rightCenter.setBackground(custBase);
        rightNorth.setPreferredSize(new Dimension(30, 40));
        right.add(rightNorth, BorderLayout.NORTH);
        rightNorth.add(createAnEvent);


        right.add(rightCenter, BorderLayout.CENTER);
        rightCenter.setLayout(new BoxLayout(rightCenter, BoxLayout.PAGE_AXIS));
        rightCenter.add(eventNameLabel);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        rightCenter.add(eventName);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        rightCenter.add(locationLabel);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        rightCenter.add(location);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        rightCenter.add(timeLabel);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        rightCenter.add(time);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        rightCenter.add(addEvent);
        rightCenter.add(Box.createRigidArea(new Dimension(0, 5)));
        

        //Add Event Functionality
        addEvent.addActionListener(e -> {
            String data = "Event: " + eventName.getText() + "    " + " Time: " + time.getText();
            try {
                JTextField event = new JTextField(20);
                JLabel eventNameHolder = new JLabel(location.getText());
                centerCenter.add(eventNameHolder);
                centerCenter.add(event);

                // voting button labels
                JLabel upV = new JLabel("Upvote");
                JLabel downV = new JLabel("Downvote");

                // up/downvote buttons
                JButton upVote = new JButton();
                JButton downVote = new JButton();
                // makes upvote green, downvote red
                upVote.setForeground(Color.GREEN);
                downVote.setForeground(Color.RED);

                // upvoting button and labels
                centerCenter.add(upV);
                centerCenter.add(upVote);
                upVote.setText("0");

                // downvoting button and labels
                centerCenter.add(downV);
                centerCenter.add(downVote);
                downVote.setText("0");

                // prints values of the event
                event.setText(data);
                event.setEditable(false);

                // reset text values after adding event
                eventName.setText("");
                time.setText("");
                location.setText("");

                // upvote counter
                upVote.addActionListener(new ActionListener() {
                    int count = 1;

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        upVote.setText(Integer.toString(count++));
                    }

                });

                // downvote counter
                downVote.addActionListener(new ActionListener() {
                    int count = -1;

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        downVote.setText(Integer.toString(count--));
                    }

                });

                frame.setVisible(true);

            } catch (Exception exception) {
                // do nothing
            }
        });

        addHour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String avaliTimes = freeHours.getText();
                JLabel print = new JLabel();
                if (mon.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(M)";
                }
                if (tues.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(T)";
                }
                if (wed.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(W)";
                }
                if (thur.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(Th)";
                }
                if (fri.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(F)";
                }
                if (sat.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(S)";
                }
                if (sun.isSelected()) {
                    avaliTimes = avaliTimes + " " + "(Su)";
                }
                print.setText(avaliTimes);
                //print.setMaximumSize(print.getPreferredSize());
                //print.setLineWrap(true);
                leftCenter.add(print);
                frame.setVisible(true);
            }
        });

        // Basic stuff here
        frame.setTitle("Down4That");
        frame.setPreferredSize(new Dimension(900, 900));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
