
    import java.awt.BorderLayout;
    import java.awt.Component;
    import javax.swing.JCheckBox;
    import javax.swing.JPanel;
    import javax.swing.JTree;
    import javax.swing.tree.TreeCellRenderer;
    import javax.swing.tree.TreePath;

    public class CheckTreeCellRenderer extends JPanel implements TreeCellRenderer{ 
    private CheckTreeSelectionModel selectionModel; 
    private TreeCellRenderer delegate; 
    private TristateCheckBox checkBox = new TristateCheckBox(); 
    public CheckTreeCellRenderer(TreeCellRenderer delegate, CheckTreeSelectionModel selectionModel){ 
    this.delegate = delegate; 
    this.selectionModel = selectionModel; 
    setLayout(new BorderLayout()); 
    setOpaque(false); 
    checkBox.setOpaque(false); 
    } 


    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean  selected, boolean expanded, boolean leaf, int row, boolean hasFocus){ 
    Component renderer = delegate.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);  
    TreePath path = tree.getPathForRow(row); 
    if(path!=null){ 
    if(selectionModel.isPathSelected(path, true)) 
    checkBox.setState(Boolean.TRUE); 
    else 
    checkBox.setState(selectionModel.isPartiallySelected(path) ? null : Boolean.FALSE); 
    } 
    removeAll(); 
    add(checkBox, BorderLayout.WEST); 
    add(renderer, BorderLayout.CENTER); 
    return this; 
    ![enter image description here][1]} 
    }
    // Reset the keyboard action map
    ActionMap map = new ActionMapUIResource();
    map.put("pressed", new AbstractAction(){      //NOI18N
    public void actionPerformed(ActionEvent e){
    grabFocus();
    model.nextState();
    }
    });
    map.put("released", null);                     //NOI18N
    SwingUtilities.replaceUIActionMap(this, map);
    // set the model to the adapted model
    model = new TristateDecorator(getModel());
    setModel(model);
    setState(initial);
    }

    public TristateCheckBox(String text, Boolean initial){
    this(text, null, initial);
    }

    public TristateCheckBox(String text){
    this(text, null);
    }

    public TristateCheckBox(){
    this(null);
    }

    /** No one may add mouse listeners, not even Swing! */
    public void addMouseListener(MouseListener l){}

    /**
    * Set the new state to either SELECTED, NOT_SELECTED or
    * DONT_CARE.  If state == null, it is treated as DONT_CARE.
    */
    public void setState(Boolean state){
    model.setState(state);
    }

    /** Return the current state, which is determined by the
    * selection status of the model. */
    public Boolean getState(){
    return model.getState();
    }

    /**
    * Exactly which Design Pattern is this?  Is it an Adapter,
    * a Proxy or a Decorator?  In this case, my vote lies with the
    * Decorator, because we are extending functionality and
    * "decorating" the original model with a more powerful model.
    */
    private class TristateDecorator implements ButtonModel{
    private final ButtonModel other;
    private TristateDecorator(ButtonModel other){
    this.other = other;
    }

    private void setState(Boolean state){
    if(state==Boolean.FALSE){
    other.setArmed(false);
    setPressed(false);
    setSelected(false);
    } else if(state==Boolean.TRUE){
    other.setArmed(false);
    setPressed(false);
    setSelected(true);
    }
    else{
    other.setArmed(true);
    setPressed(true);
    setSelected(true);
    }
    }

    /**
    * The current state is embedded in the selection / armed
    * state of the model.
    *
    * We return the SELECTED state when the checkbox is selected
    * but not armed, DONT_CARE state when the checkbox is
    * selected and armed (grey) and NOT_SELECTED when the
    * checkbox is deselected.
    */
    private Boolean getState(){
    if(isSelected() && !isArmed()){
    // normal black tick
    return Boolean.TRUE;
    } else if(isSelected() && isArmed()){
    // don't care grey tick
    return null;
    } else{
    // normal deselected
    return Boolean.FALSE;
    }
    }

    /** We rotate between NOT_SELECTED, SELECTED and DONT_CARE.*/
    private void nextState(){
    Boolean current = getState();
    if(current == Boolean.FALSE){
    setState(Boolean.TRUE);
    } else if(current == Boolean.TRUE){
    setState(null);
    } else if(current == null){
    setState(Boolean.FALSE);
    }
    }

    /** Filter: No one may change the armed status except us. */
    public void setArmed(boolean b){
    }
    public boolean isFocusTraversable() {
    return isEnabled();
    }

    /** We disable focusing on the component when it is not
    * enabled. */
    public void setEnabled(boolean b){
    //            setFocusable(b);
    other.setEnabled(b);
    }


    /** All these methods simply delegate to the "other" model
    * that is being decorated. */
    public boolean isArmed(){return other.isArmed();
    }
    public boolean isSelected(){return other.isSelected();
    }
    public boolean isEnabled(){return other.isEnabled();
    }
    public boolean isPressed(){return other.isPressed();
    }
    public boolean isRollover(){return other.isRollover();
    }
    public void setSelected(boolean b){other.setSelected(b);
    }
    public void setPressed(boolean b){other.setPressed(b);
    }
    public void setRollover(boolean b){other.setRollover(b);
    }
    public void setMnemonic(int key){other.setMnemonic(key);
    }
    public int getMnemonic(){return other.getMnemonic();
    }
    public void setActionCommand(String s){other.setActionCommand(s);
    }
    public String getActionCommand(){return other.getActionCommand();
    }
    public void setGroup(ButtonGroup group){other.setGroup(group);
    }
    public void addActionListener(ActionListener l){other.addActionListener(l);
    }
    public void removeActionListener(ActionListener l){other.removeActionListener(l);
    }
    public void addItemListener(ItemListener l){other.addItemListener(l);
    }
    public void removeItemListener(ItemListener l){other.removeItemListener(l);
    }
    public void addChangeListener(ChangeListener l){other.addChangeListener(l);
    }
    public void removeChangeListener(ChangeListener l){other.removeChangeListener(l);
    }
    public Object[] getSelectedObjects(){return other.getSelectedObjects();
    }
    }