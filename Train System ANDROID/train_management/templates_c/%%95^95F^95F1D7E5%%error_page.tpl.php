<?php ob_start(); ?>
    <?php echo $this->_tpl_vars['PageList']; ?>

<?php $this->_smarty_vars['capture']['default'] = ob_get_contents();  $this->assign('SideBar', ob_get_contents());ob_end_clean(); ?>

<?php ob_start(); ?>

<div class="alert alert-error">
<h3><?php echo $this->_tpl_vars['Captions']->GetMessageString('ErrorsDuringDataRetrieving'); ?>
</h3>
<?php echo $this->_tpl_vars['ErrorMessage']; ?>


<?php if (( $this->_tpl_vars['DisplayDebugInfo'] == 1 )): ?>
<hr/>
<h3>Additional exception info:</h3>
<strong>File:</strong> <?php echo $this->_tpl_vars['File']; ?>
 <br/>
<strong>Line:</strong> <?php echo $this->_tpl_vars['Line']; ?>
 <br/>
<strong>Trace:</strong> <?php echo $this->_tpl_vars['Trace']; ?>

<?php endif; ?>

</div>
<?php $this->_smarty_vars['capture']['default'] = ob_get_contents();  $this->assign('ContentBlock', ob_get_contents());ob_end_clean(); ?>

<?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "common/layout.tpl", 'smarty_include_vars' => array()));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>