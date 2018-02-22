
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends javax.swing.JFrame{
    TicTacInterface server;
    public Client()throws Exception {
        initComponents();
        
        setSize(600,600);
        server = (TicTacInterface)Naming.lookup("rmi://localhost:1099/server");
        System.out.println("server object is accepted...");
        //UnicastRemoteObject.exportObject(this);
        //System.out.println("client object is exported");
        //Naming.rebind("rmi://localhost:1099/client", this);
        //System.out.println("Client object is rebinded with registry..");
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

        setTitle("Client");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        button1.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button1);

        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        button2.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button2);

        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        button3.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button3);

        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        button4.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button4);
        
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        button5.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button5);


        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        button6.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button6);
    
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        button7.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button7);        

        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        button8.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button8);

        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });
        button9.setFont(new java.awt.Font("arial",java.awt.Font.BOLD,20));
        getContentPane().add(button9);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
                server.setButton("X",1);
                button1.setText("X");
                button1.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
           
                server.setButton("X",2);
                button2.setText("X");
                button2.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}

    }
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {
          try{
                server.setButton("X",3);
                button3.setText("X");
                button3.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
        
    }    
    private void button4ActionPerformed(java.awt.event.ActionEvent evt) { 
          try{
                server.setButton("X",4);
                button4.setText("X");
                button4.setEnabled(false);
                check();
          }catch(Exception ex){ex.printStackTrace();}
        
    }
    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {
          try{
            
                server.setButton("X",5);
                button5.setText("X");
                button5.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
        
    }
    private void button6ActionPerformed(java.awt.event.ActionEvent evt) { 
          try{    
                server.setButton("X",6);
                button6.setText("X");
                button6.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
        
    }
    private void button7ActionPerformed(java.awt.event.ActionEvent evt) { 
          try{
                server.setButton("X",7);
                button7.setText("X");
                button7.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
        
    }
    private void button8ActionPerformed(java.awt.event.ActionEvent evt) { 
          try{
                server.setButton("X",8);
                button8.setText("X");
                button8.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
        
    }

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) { 
         try{
                server.setButton("X",9);
                button9.setText("X");
                button9.setEnabled(false);
                check();
        }catch(Exception ex){ex.printStackTrace();}
        
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws Exception {        
        Client c = new Client();
        c.setVisible(true);
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

    public void winMessage(String s)throws RemoteException{
          javax.swing.JOptionPane.showMessageDialog(null, "\" "+s+" \" won the Game(Client)");
    }
    
    public void check(){
        if(button1.getText().equals("X")&&button2.getText().equals("X")&&button3.getText().equals("X")){msg("X");return;}
        else if(button4.getText().equals("X")&&button5.getText().equals("X")&&button6.getText().equals("X")){msg("X");return;}
        else if(button7.getText().equals("X")&&button8.getText().equals("X")&&button9.getText().equals("X")){msg("X");return;}
        
        else if(button1.getText().equals("X")&&button4.getText().equals("X")&&button7.getText().equals("X")){msg("X");return;}
        else if(button2.getText().equals("X")&&button5.getText().equals("X")&&button8.getText().equals("X")){msg("X");return;}
        else if(button3.getText().equals("X")&&button6.getText().equals("X")&&button9.getText().equals("X")){msg("X");return;}
        
        else if(button1.getText().equals("X")&&button5.getText().equals("X")&&button9.getText().equals("X")){msg("X");return;}
        else if(button3.getText().equals("X")&&button5.getText().equals("X")&&button7.getText().equals("X")){msg("X");return;}
        
    }
    public void msg(String s){
        javax.swing.JOptionPane.showMessageDialog(null, "\" "+s+" \" won the Game");
        try{
            server.winMessage(s);
        }catch(Exception ex){ex.printStackTrace();}
    }
}
