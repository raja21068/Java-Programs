  import javax.swing.*;
    import javax.swing.event.ChangeListener;
    import javax.swing.plaf.ActionMapUIResource;
    import java.awt.event.*;
    import java.awt.*;

    /**
    * Maintenance tip - There were some tricks to getting this code
    * working:
    *
    * 1. You have to overwite addMouseListener() to do nothing
    * 2. You have to add a mouse event on mousePressed by calling
    * super.addMouseListener()
    * 3. You have to replace the UIActionMap for the keyboard event
    * "pressed" with your own one.
    * 4. You have to remove the UIActionMap for the keyboard event
    * "released".
    * 5. You have to grab focus when the next state is entered,
    * otherwise clicking on the component won't get the focus.
    * 6. You have to make a TristateDecorator as a button model that
    * wraps the original button model and does state management.
    */
    public class TristateCheckBox extends JCheckBox{
    private final TristateDecorator model;

    public TristateCheckBox(String text, Icon icon, Boolean initial){
    super(text, icon);
    // Add a listener for when the mouse is pressed
    super.addMouseListener(new MouseAdapter(){
    public void mousePressed(MouseEvent e){
    grabFocus();
    model.nextState();
    }
    });