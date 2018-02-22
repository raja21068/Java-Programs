<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('block', 'style_block', 'editors/text_edit.tpl', 10, false),)), $this); ?>
<?php if (! $this->_tpl_vars['Editor']['ReadOnly']): ?>
    <input
        id="<?php echo $this->_tpl_vars['Editor']['Name']; ?>
"
        name="<?php echo $this->_tpl_vars['Editor']['Name']; ?>
"
        value="<?php echo $this->_tpl_vars['Editor']['DisplayValue']; ?>
"
        class="input-xlarge"
        <?php echo $this->_tpl_vars['Editor']['ControllerAttributes']; ?>

        <?php echo $this->_tpl_vars['Editor']['AdditionalAttributes']; ?>

        <?php echo $this->_tpl_vars['Validators']['InputAttributes']; ?>

        <?php $this->_tag_stack[] = array('style_block', array()); $_block_repeat=true;smarty_block_style_block($this->_tag_stack[count($this->_tag_stack)-1][1], null, $this, $_block_repeat);while ($_block_repeat) { ob_start(); ?>
            <?php echo $this->_tpl_vars['Editor']['CustomStyle']; ?>

            width: auto;
        <?php $_block_content = ob_get_contents(); ob_end_clean(); $_block_repeat=false;echo smarty_block_style_block($this->_tag_stack[count($this->_tag_stack)-1][1], $_block_content, $this, $_block_repeat); }  array_pop($this->_tag_stack); ?>
    >
<?php else: ?>
    <?php if (! $this->_tpl_vars['Editor']['PasswordMode']): ?>
        <span <?php echo $this->_tpl_vars['Editor']['ControllerAttributes']; ?>
><?php echo $this->_tpl_vars['Editor']['Value']; ?>
</span>
    <?php else: ?>
        <span <?php echo $this->_tpl_vars['Editor']['ControllerAttributes']; ?>
>*************</span>
    <?php endif; ?>
<?php endif; ?>