package clonevideoreceiving;

import java.awt.*;
import javax.swing.*;

/**
 * Title:        Clone Video Receing System
 * Description:  This Program will receies simultanously videos from different locations
 * Copyright:    Copyright (c) 2005
 * Company:      IIT, University of Sindh, Jamshoro
 * @author Sachal Joyo
 * @version 1.0
 */

public class CloneReceivingFrame extends JFrame {
  JLabel headingLabel = new JLabel();

  public CloneReceivingFrame() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    CloneReceivingFrame cloneReceivingFrame = new CloneReceivingFrame();
  }

  private void jbInit() throws Exception {
    headingLabel.setFont(new java.awt.Font("Serif", 1, 20));
    headingLabel.setText("Clone Video Transmission Services");
    headingLabel.setBounds(new Rectangle(33, 16, 311, 26));
    this.getContentPane().setLayout(null);
    this.getContentPane().add(headingLabel, null);

    new MediaRecieverServer().start();

    this.setBounds(0,0,400,300);
    this.show();
  }
}