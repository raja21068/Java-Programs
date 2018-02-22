import java.rmi.Naming;
import java.rmi.server.*;
public class Server extends javax.swing.JFrame{

    TicTacImp server;
    public Server()throws Exception{
        initComponents();
        setBounds(0,0,600,600);
        server = new TicTacImp(this);
        UnicastRemoteObject.exportObject(server);
        System.out.println("Object is exported..");
        Naming.rebind("rmi://localhost:1099/server", server);
        System.out.println("Server is started...");
        Thread.sleep(10000);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();

        setSize(600,600);
        setTitle("Server");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));
        
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1);

        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2);

        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        getContentPane().add(button3);


        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        getContentPane().add(button4);
        
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        getContentPane().add(button5);

        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        getContentPane().add(button6);
    
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        getContentPane().add(button7);        

        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        getContentPane().add(button8);

        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });
        getContentPane().add(button9);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            button1.setText("0");
            button1.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
        
    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            button2.setText("0");
            button2.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            button3.setText("0");
            button3.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }    
    private void button4ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            button4.setText("0");
            button4.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {
         try{
            button5.setText("0");
            button5.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void button6ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            button6.setText("0");
            button6.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void button7ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            button7.setText("0");
            button7.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void button8ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            button8.setText("0");
            button8.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
            button9.setText("0");
            button9.setEnabled(false);
            check();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void check(){
             if(button1.getText().equals("0")&&button2.getText().equals("0")&&button3.getText().equals("0")){msg("0");return;}
        else if(button4.getText().equals("0")&&button5.getText().equals("0")&&button6.getText().equals("0")){msg("0");return;}
        else if(button7.getText().equals("0")&&button8.getText().equals("0")&&button9.getText().equals("0")){msg("0");return;}
        
        else if(button1.getText().equals("0")&&button4.getText().equals("0")&&button7.getText().equals("0")){msg("0");return;}
        else if(button2.getText().equals("0")&&button5.getText().equals("0")&&button8.getText().equals("0")){msg("0");return;}
        else if(button3.getText().equals("0")&&button6.getText().equals("0")&&button9.getText().equals("0")){msg("0");return;}
        
        else if(button1.getText().equals("0")&&button5.getText().equals("0")&&button9.getText().equals("0")){msg("0");return;}
        else if(button3.getText().equals(0)&&button5.getText().equals("0")&&button7.getText().equals("0")){msg("0");return;}
    }
    public void msg(String s){
        try{
            javax.swing.JOptionPane.showMessageDialog(null, "\" "+s+" \" won the Game");
        }catch(Exception ex){ex.printStackTrace();}
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws Exception {
        new Server().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton button1;
    public javax.swing.JButton button2;
    public javax.swing.JButton button3;
    public javax.swing.JButton button4;
    public javax.swing.JButton button5;
    public javax.swing.JButton button6;
    public javax.swing.JButton button7;
    public javax.swing.JButton button8;
    public javax.swing.JButton button9;
    // End of variables declaration//GEN-END:variables
}
