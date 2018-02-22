<?php require_once(SMARTY_CORE_DIR . 'core.load_plugins.php');
smarty_core_load_plugins(array('plugins' => array(array('modifier', 'escapeurl', 'view/grid.tpl', 31, false),array('modifier', 'string_format', 'view/grid.tpl', 42, false),)), $this); ?>
<div class="page-header">
    <h1><?php echo $this->_tpl_vars['Grid']['Title']; ?>
</h1>
</div>

<div class="container-fluid">

    <br>

    <div class="row-fluid">
        <div class="span6">
            <table class="table pgui-record-card">
                <tbody>
                    <?php $_from = $this->_tpl_vars['Grid']['Row']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Cell']):
?>
                    <tr>
                        <td>
                            <strong><?php echo $this->_tpl_vars['Cell']['Caption']; ?>
</strong>
                        </td>
                        <td>
                            <?php echo $this->_tpl_vars['Cell']['DisplayValue']; ?>

                        </td>
                    </tr>
                    <?php endforeach; endif; unset($_from); ?>
                </tbody>
            </table>
        </div>

    </div>
    <div class="row-fluid">
        <div class="btn-toolbar">
            <div class="btn-group">
                <a class="btn btn-primary" href="<?php echo ((is_array($_tmp=$this->_tpl_vars['Grid']['CancelUrl'])) ? $this->_run_mod_handler('escapeurl', true, $_tmp) : smarty_modifier_escapeurl($_tmp)); ?>
"><?php echo $this->_tpl_vars['Captions']->GetMessageString('BackToList'); ?>
</a>
            </div>

        <?php if (count ( $this->_tpl_vars['Grid']['Details'] ) > 0): ?>
            <div class="btn-group">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <?php echo $this->_tpl_vars['Captions']->GetMessageString('ManageDetails'); ?>

                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <?php $_from = $this->_tpl_vars['Grid']['Details']; if (!is_array($_from) && !is_object($_from)) { settype($_from, 'array'); }if (count($_from)):
    foreach ($_from as $this->_tpl_vars['Detail']):
?>
                    <li><a href="<?php echo ((is_array($_tmp=$this->_tpl_vars['Detail']['Link'])) ? $this->_run_mod_handler('escapeurl', true, $_tmp) : smarty_modifier_escapeurl($_tmp)); ?>
"><?php echo ((is_array($_tmp=$this->_tpl_vars['Detail']['Caption'])) ? $this->_run_mod_handler('string_format', true, $_tmp, $this->_tpl_vars['Captions']->GetMessageString('ManageDetail')) : smarty_modifier_string_format($_tmp, $this->_tpl_vars['Captions']->GetMessageString('ManageDetail'))); ?>
</a></li>
                    <?php endforeach; endif; unset($_from); ?>
                </ul>
            </div>
        <?php endif; ?>

        <?php if ($this->_tpl_vars['Grid']['PrintOneRecord']): ?>
            <div class="btn-group">
                <a class="btn" href="<?php echo ((is_array($_tmp=$this->_tpl_vars['Grid']['PrintRecordLink'])) ? $this->_run_mod_handler('escapeurl', true, $_tmp) : smarty_modifier_escapeurl($_tmp)); ?>
">
                    <i class="pg-icon-print-page icon-white"></i>
                    <?php echo $this->_tpl_vars['Captions']->GetMessageString('PrintOneRecord'); ?>

                </a>
            </div>
        <?php endif; ?>



        </div>
    </div>
</div>
