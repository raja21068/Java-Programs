<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('modifier', 'string_format', 'insert/grid.tpl', 28, false),)), $this); ?>
<div class="row-fluid">

    <div class="page-header form-header">
        <h1><?php echo $this->_tpl_vars['Grid']['Title']; ?>
</h1>
    </div>

    <div class="pgui-edit-form">
        <form class="form-horizontal"  enctype="multipart/form-data" method="POST" action="<?php echo $this->_tpl_vars['Grid']['FormAction']; ?>
">

            <div class="form-actions top-actions">

                <div class="btn-toolbar">
                    <div class="btn-group">
                        <button class="btn btn-primary submit-button"
                                onclick="$(this).closest('form').submit(); return false;"
                                ><?php echo $this->_tpl_vars['Captions']->GetMessageString('Save'); ?>
</button>
                        <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li data-value="save"><a href="#" class="save-button"><?php echo $this->_tpl_vars['Captions']->GetMessageString('SaveAndBackToList'); ?>
</a></li>
                            <li data-value="saveinsert"><a href="#" class="saveinsert-button"><?php echo $this->_tpl_vars['Captions']->GetMessageString('SaveAndInsert'); ?>
</a></li>
                            <li data-value="saveedit"><a href="#" class="saveedit-button"><?php echo $this->_tpl_vars['Captions']->GetMessageString('SaveAndEdit'); ?>
</a></li>
                            <?php if (count ( $this->_tpl_vars['Grid']['Details'] ) > 0): ?>
                                <li class="divider"></li>
                            <?php endif; ?>
                            <?php $_from = $this->_tpl_vars['Grid']['Details']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Detail']):
?>
                                <li><a class="save-and-open-details" href="#" data-action="<?php echo $this->_tpl_vars['Detail']['Link']; ?>
"><?php echo ((is_array($_tmp=$this->_tpl_vars['Detail']['Caption'])) ? $this->_run_mod_handler('string_format', true, $_tmp, $this->_tpl_vars['Captions']->GetMessageString('SaveAndOpenDetail')) : smarty_modifier_string_format($_tmp, $this->_tpl_vars['Captions']->GetMessageString('SaveAndOpenDetail'))); ?>
</a></li>
                            <?php endforeach; endif; unset($_from); ?>
                        </ul>
                    </div>

                    <div class="btn-group">
                        <button class="btn" onclick="window.location.href='<?php echo $this->_tpl_vars['Grid']['CancelUrl']; ?>
'; return false;"><?php echo $this->_tpl_vars['Captions']->GetMessageString('Cancel'); ?>
</button>
                    </div>
                </div>
            </div>

            <?php if (! $this->_tpl_vars['Grid']['ErrorMessage'] == ''): ?>
                <div class="alert alert-error">
                    <button class="close" data-dismiss="alert"><i class="icon-remove"></i></button>
                    <strong><?php echo $this->_tpl_vars['Captions']->GetMessageString('ErrorsDuringInsertProcess'); ?>
</strong>
                    <br>
                    <?php echo $this->_tpl_vars['Grid']['ErrorMessage']; ?>

                </div>
            <?php endif; ?>

            <fieldset>
                <input id="submit-action" name="submit1" type="hidden" value="save">
                <?php $_from = $this->_tpl_vars['HiddenValues']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['HiddenValueName'] => $this->_tpl_vars['HiddenValue']):
?>
                    <input type="hidden" name="<?php echo $this->_tpl_vars['HiddenValueName']; ?>
" value="<?php echo $this->_tpl_vars['HiddenValue']; ?>
" />
                <?php endforeach; endif; unset($_from); ?>


            <?php $_from = $this->_tpl_vars['Grid']['Columns']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }$this->_foreach['EditColumns'] = array('total' => count($_from), 'iteration' => 0);
if ($this->_foreach['EditColumns']['total'] > 0):
    foreach ($_from as $this->_tpl_vars['Column']):
        $this->_foreach['EditColumns']['iteration']++;
?>
                <div class="control-group">
                    <div class="label-container">
                        <label class="control-label" for="<?php echo $this->_tpl_vars['Column']['FieldName']; ?>
_edit">
                            <?php echo $this->_tpl_vars['Column']['Caption']; ?>

                            <?php if ($this->_tpl_vars['Column']['Required']): ?><span class="required-mark">*</span><?php endif; ?>
                        </label>
                        <?php $_smarty_tpl_vars = $this->_tpl_vars;
$this->_smarty_include(array('smarty_include_tpl_file' => "edit_field_options.tpl", 'smarty_include_vars' => array('Column' => $this->_tpl_vars['Column'])));
$this->_tpl_vars = $_smarty_tpl_vars;
unset($_smarty_tpl_vars);
 ?>
                    </div>
                    <div class="controls">
                        <?php echo $this->_tpl_vars['Column']['Editor']; ?>

                    </div>
                </div>
            <?php endforeach; endif; unset($_from); ?>

                <div class="control-group">
                    <div class="controls">
                        <span class="required-mark">*</span> - <?php echo $this->_tpl_vars['Captions']->GetMessageString('RequiredField'); ?>

                    </div>
                </div>
            </fieldset>


            <div class="error-container"></div>

            <div class="form-actions">

                <div class="btn-toolbar">
                    <div class="btn-group">

                        <button id="submit-button"
                                class="btn btn-primary submit-button"
                                onclick="$(this).closest('form').submit(); return false;"
                                ><?php echo $this->_tpl_vars['Captions']->GetMessageString('Save'); ?>
</button>

                        <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li data-value="save"><a href="#" class="save-button"><?php echo $this->_tpl_vars['Captions']->GetMessageString('SaveAndBackToList'); ?>
</a></li>
                            <li data-value="saveinsert"><a href="#" class="saveinsert-button"><?php echo $this->_tpl_vars['Captions']->GetMessageString('SaveAndInsert'); ?>
</a></li>
                            <li data-value="saveedit"><a href="#" class="saveedit-button"><?php echo $this->_tpl_vars['Captions']->GetMessageString('SaveAndEdit'); ?>
</a></li>
                            <?php if (count ( $this->_tpl_vars['Grid']['Details'] ) > 0): ?>
                                <li class="divider"></li>
                            <?php endif; ?>
                            <?php $_from = $this->_tpl_vars['Grid']['Details']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Detail']):
?>
                                <li><a class="save-and-open-details" href="#" data-action="<?php echo $this->_tpl_vars['Detail']['Link']; ?>
"><?php echo ((is_array($_tmp=$this->_tpl_vars['Detail']['Caption'])) ? $this->_run_mod_handler('string_format', true, $_tmp, $this->_tpl_vars['Captions']->GetMessageString('SaveAndOpenDetail')) : smarty_modifier_string_format($_tmp, $this->_tpl_vars['Captions']->GetMessageString('SaveAndOpenDetail'))); ?>
</a></li>
                            <?php endforeach; endif; unset($_from); ?>
                        </ul>
                    </div>

                    <div class="btn-group">
                        <button class="btn" onclick="window.location.href='<?php echo $this->_tpl_vars['Grid']['CancelUrl']; ?>
'; return false;"><?php echo $this->_tpl_vars['Captions']->GetMessageString('Cancel'); ?>
</button>
                    </div>
                </div>
            </div>

        </form>

        <script type="text/javascript">
            <?php echo '
            $(function() {
                    $(\'.dropdown-toggle\').dropdown();

                    $(\'.save-and-open-details\').click(function(e) {
                        e.preventDefault();
                        $(\'form\').attr(\'action\', $(this).attr(\'data-action\'));
                        $(\'#submit-button\').click();
                    });

                    $(\'a.save-button\').click(function() {
                        $(\'#submit-action\').val(\'save\');
                        $(\'#submit-button\').click();
                    });

                    $(\'a.saveedit-button\').click(function() {
                        $(\'#submit-action\').val(\'saveedit\');
                        $(\'#submit-button\').click();
                    });
                    $(\'a.saveinsert-button\').click(function() {
                        $(\'#submit-action\').val(\'saveinsert\');
                        $(\'#submit-button\').click();
                    });
                });
            function InsertForm_initd(editors) {
                '; ?>
<?php echo $this->_tpl_vars['Grid']['OnLoadScript']; ?>
<?php echo ';
            }
            '; ?>

        </script>
    </div>
</div>