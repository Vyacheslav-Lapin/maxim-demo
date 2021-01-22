package ru.vlapin.demo.maximdemo.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonExample {

  public static void main(String[] args) {
    JButton jButton = new JButton();

    jButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) /*->*/ {
        System.out.println("button clicked");
      }
    });

    //...
  }
}
