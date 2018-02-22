<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('block', 'style_block', 'editors/time_edit.tpl', 6, false),)), $this); ?>
<input
    data-editor="true"
    data-editor-class="TimeEdit"
    data-field-name="<?php echo $this->_tpl_vars['Editor']->GetFieldName(); ?>
"
    data-editable="true"
    <?php $this->_tag_stack[] = array('style_block', array()); $_block_repeat=true;smarty_block_style_block($this->_tag_stack[count($this->_tag_stack)-1][1], null, $this, $_block_repeat);while ($_block_repeat) { ob_start(); ?>
        <?php echo $this->_tpl_vars['Editor']->GetCustomAttributes(); ?>

    <?php $_block_content = ob_get_contents(); ob_end_clean(); $_block_repeat=false;echo smarty_block_style_block($this->_tag_stack[count($this->_tag_stack)-1][1], $_block_content, $this, $_block_repeat); }  array_pop($this->_tag_stack); ?>
    id="<?php echo $this->_tpl_vars['Editor']->GetName(); ?>
"
    name="<?php echo $this->_tpl_vars['Editor']->GetName(); ?>
"
    value="<?php echo $this->_tpl_vars['Editor']->GetValue(); ?>
"
    timeedit="true"
    <?php echo $this->_tpl_vars['Validators']['InputAttributes']; ?>

>