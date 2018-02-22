/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmfapplication;

import javax.media.CaptureDeviceManager;

/**
 *
 * @author Raja Kumar
 */
public class JMFApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TransmitVideo("localhost",10000 ,false).start();
    }
}
