import java.awt.*;
import java.awt.event.*;

import java.util.Vector;

import javax.swing.*;

/*
 * FocusTraversalDemo.java requires no other files.
 */
public class FocusTraversalDemo extends JPanel implements ActionListener {

    static JFrame frame;
    JLabel label;
    JCheckBox togglePolicy;
    static MyOwnFocusTraversalPolicy newPolicy;

    public FocusTraversalDemo() {
        super(new BorderLayout());

        JTextField tf1 = new JTextField("Field 1");
        JTextField tf2 = new JTextField("A Bigger Field 2");
        JTextField tf3 = new JTextField("Field 3");
        JTextField tf4 = new JTextField("A Bigger Field 4");
        JTextField tf5 = new JTextField("Field 5");
        JTextField tf6 = new JTextField("A Bigger Field 6");
        JTable table = new JTable(4,3);
        togglePolicy = new JCheckBox("Custom FocusTraversalPolicy");
        togglePolicy.setActionCommand("toggle");
        togglePolicy.addActionListener(this);
        togglePolicy.setFocusable(false);  //Remove it from the focus cycle.
        //Note that HTML is allowed and will break this run of text
        //across two lines.
        label = new JLabel("<html>Use Tab (or Shift-Tab) to navigate from component to component.<p>Control-Tab (or Control-Shift-Tab) allows you to break out of the JTable.</html>");

        JPanel leftTextPanel = new JPanel(new GridLayout(3,2));
        leftTextPanel.add(tf1, BorderLayout.PAGE_START);
        leftTextPanel.add(tf3, BorderLayout.CENTER);
        leftTextPanel.add(tf5, BorderLayout.PAGE_END);
        leftTextPanel.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        JPanel rightTextPanel = new JPanel(new GridLayout(3,2));
        rightTextPanel.add(tf2, BorderLayout.PAGE_START);
        rightTextPanel.add(tf4, BorderLayout.CENTER);
        rightTextPanel.add(tf6, BorderLayout.PAGE_END);
        rightTextPanel.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        JPanel tablePanel = new JPanel(new GridLayout(0,1));
        tablePanel.add(table, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createEtchedBorder());
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        bottomPanel.add(togglePolicy, BorderLayout.PAGE_START);
        bottomPanel.add(label, BorderLayout.PAGE_END);

        add(leftTextPanel, BorderLayout.LINE_START);
        add(rightTextPanel, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.LINE_END);
        add(bottomPanel, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        Vector<Component> order = new Vector<Component>(7);
        order.add(tf1);
        order.add(tf2);
        order.add(tf3);
        order.add(tf4);
        order.add(tf5);
        order.add(tf6);
        order.add(table);
        newPolicy = new MyOwnFocusTraversalPolicy(order);
    }

    //Turn the custom focus traversal policy on/off,
    //according to the checkbox
    public void actionPerformed(ActionEvent e) {
        if ("toggle".equals(e.getActionCommand())) {
            frame.setFocusTraversalPolicy(togglePolicy.isSelected() ?
                    newPolicy : null);
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("FocusTraversalDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new FocusTraversalDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static class MyOwnFocusTraversalPolicy extends FocusTraversalPolicy
    {
        Vector<Component> order;

        public MyOwnFocusTraversalPolicy(Vector<Component> order) {
            this.order = new Vector<Component>(order.size());
            this.order.addAll(order);
        }
        public Component getComponentAfter(Container focusCycleRoot,Component aComponent)
        {
            int idx = (order.indexOf(aComponent) + 1) % order.size();
            return order.get(idx);
        }

        public Component getComponentBefore(Container focusCycleRoot, Component aComponent)
        {
            int idx = order.indexOf(aComponent) - 1;
            if (idx < 0) {
                idx = order.size() - 1;
            }
            return order.get(idx);
        }

        public Component getDefaultComponent(Container focusCycleRoot) {
            return order.get(0);
        }

        public Component getLastComponent(Container focusCycleRoot) {
            return order.lastElement();
        }

        public Component getFirstComponent(Container focusCycleRoot) {
            return order.get(0);
        }
    }
}

