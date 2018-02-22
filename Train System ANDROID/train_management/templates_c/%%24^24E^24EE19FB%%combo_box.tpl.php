<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('block', 'style_block', 'editors/combo_box.tpl', 7, false),)), $this); ?>
<?php if ($this->_tpl_vars['RenderText']): ?>
<?php if (! $this->_tpl_vars['ComboBox']->GetReadOnly()): ?><select
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="<?php echo $this->_tpl_vars['ComboBox']->GetFieldName(); ?>
"
    data-editable="true"
    <?php $this->_tag_stack[] = array('style_block', array()); $_block_repeat=true;smarty_block_style_block($this->_tag_stack[count($this->_tag_stack)-1][1], null, $this, $_block_repeat);while ($_block_repeat) { ob_start(); ?>
        <?php echo $this->_tpl_vars['ComboBox']->GetCustomAttributes(); ?>

    <?php $_block_content = ob_get_contents(); ob_end_clean(); $_block_repeat=false;echo smarty_block_style_block($this->_tag_stack[count($this->_tag_stack)-1][1], $_block_content, $this, $_block_repeat); }  array_pop($this->_tag_stack); ?>
    id="<?php echo $this->_tpl_vars['ComboBox']->GetName(); ?>
" name="<?php echo $this->_tpl_vars['ComboBox']->GetName(); ?>
" <?php echo $this->_tpl_vars['Validators']['InputAttributes']; ?>
>
<?php if ($this->_tpl_vars['ComboBox']->ShowEmptyValue()): ?>
    <option value=""><?php echo $this->_tpl_vars['ComboBox']->GetEmptyValue(); ?>
</option>
<?php endif; ?>
<?php if ($this->_tpl_vars['ComboBox']->HasMFUValues()): ?>
<?php $_from = $this->_tpl_vars['ComboBox']->GetMFUValues(); if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Value'] => $this->_tpl_vars['Name']):
?>
<option value="<?php echo $this->_tpl_vars['Value']; ?>
"><?php echo $this->_tpl_vars['Name']; ?>
</option>
<?php endforeach; endif; unset($_from); ?>
<option value="----------" disabled="disabled">----------</option>
<?php endif; ?>
<?php $_from = $this->_tpl_vars['ComboBox']->GetDisplayValues(); if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Value'] => $this->_tpl_vars['Name']):
?>
    <option value="<?php echo $this->_tpl_vars['Value']; ?>
"<?php if ($this->_tpl_vars['ComboBox']->GetSelectedValue() == $this->_tpl_vars['Value']): ?> selected<?php endif; ?>><?php echo $this->_tpl_vars['Name']; ?>
</option>
<?php endforeach; endif; unset($_from); ?>
</select><?php else: ?>
<?php $_from = $this->_tpl_vars['ComboBox']->GetValues(); if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Value'] => $this->_tpl_vars['Name']):
?>
<?php if ($this->_tpl_vars['ComboBox']->GetSelectedValue() == $this->_tpl_vars['Value']): ?>
<span
    data-editor="true"
    data-editor-class="ComboBox"
    data-field-name="<?php echo $this->_tpl_vars['ComboBox']->GetFieldName(); ?>
"
    data-editable="false"
    ><?php echo $this->_tpl_vars['Name']; ?>
</span>

    <?php endif; ?>
<?php endforeach; endif; unset($_from); ?>
<?php endif; ?>
<?php endif; ?>