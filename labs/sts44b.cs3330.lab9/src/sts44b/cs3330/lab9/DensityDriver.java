/*
 * Name : Seanmichael Stanley
 * Lab 9
 * Section: D
 * TA : Matt English
 * Labcode: HW3 SUCKS
 */

package sts44b.cs3330.lab9;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class DensityDriver extends JFrame implements WindowListener,
                                ActionListener {
                JTextField text1 = new JTextField(20);
                JTextField text2 = new JTextField(20);
                JTextField text3 = new JTextField(20);
                JTextField text4 = new JTextField(20);
                JTextField text5 = new JTextField(20);
                JLabel label1 = new JLabel("Enter the elevation (in feet) of the airpart:",JLabel.CENTER);
                JLabel label2 = new JLabel("Enter the outside temperature at the airport (in Celcius):",JLabel.CENTER);
                JLabel label3 = new JLabel("Enter the current air pressureEnter the current air pressure at the airport: at the airport:",JLabel.CENTER);
                JLabel label4 = new JLabel("Enter the length of the runway at the airport:",JLabel.CENTER);
                JLabel label5 = new JLabel("Enter the STD takeoff distance (0 elevation) for your plane:",JLabel.CENTER);
                JButton calculate;


                public static void main(String[] args) {
                                DensityDriver myWindow = new DensityDriver("AIRPORT TAKEOFF");
                                myWindow.setSize(375, 300);
                                myWindow.setVisible(true);
                }

                public DensityDriver(String title) {

                                super(title);
                                setLayout(new FlowLayout());
                                addWindowListener(this);
                               calculate = new JButton("Calculate");
                                add(label1);
                                add(text1);
                                add(label2);
                                add(text2);
                                add(label3);
                                add(text3);
                                add(label4);
                                add(text4);
                                add(label5);
                                add(text5);
                                add(calculate);
                                calculate.addActionListener(this);
                }

                public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                }

                public void windowClosing(WindowEvent e) {
                                dispose();
                                System.exit(0);
                }

                public void windowOpened(WindowEvent e) {
                }

                public void windowActivated(WindowEvent e) {
                }

                public void windowIconified(WindowEvent e) {
                }

                public void windowDeiconified(WindowEvent e) {
                }

                public void windowDeactivated(WindowEvent e) {
                }

                public void windowClosed(WindowEvent e) {
                }

}
