<?php
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                   ATTENTION!
 * If you see this message in your browser (Internet Explorer, Mozilla Firefox, Google Chrome, etc.)
 * this means that PHP is not properly installed on your web server. Please refer to the PHP manual
 * for more details: http://php.net/manual/install.php 
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */


    include_once dirname(__FILE__) . '/' . 'components/utils/check_utils.php';
    CheckPHPVersion();
    CheckTemplatesCacheFolderIsExistsAndWritable();


    include_once dirname(__FILE__) . '/' . 'phpgen_settings.php';
    include_once dirname(__FILE__) . '/' . 'database_engine/mysql_engine.php';
    include_once dirname(__FILE__) . '/' . 'components/page.php';


    function GetConnectionOptions()
    {
        $result = GetGlobalConnectionOptions();
        $result['client_encoding'] = 'utf8';
        GetApplication()->GetUserAuthorizationStrategy()->ApplyIdentityToConnectionOptions($result);
        return $result;
    }

    
    
    // OnBeforePageExecute event handler
    
    
    
    class routPage extends Page
    {
        protected function DoBeforeCreate()
        {
            $this->dataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`rout`');
            $field = new IntegerField('city_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $field = new IntegerField('rout_id', null, null, true);
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new IntegerField('train_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $field = new IntegerField('junction_no');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $this->dataset->AddLookupField('city_id', 'city', new IntegerField('city_id', null, null, true), new StringField('city_from', 'city_id_city_from', 'city_id_city_from_city'), 'city_id_city_from_city');
            $this->dataset->AddLookupField('train_id', 'train', new IntegerField('train_id', null, null, true), new StringField('train_name', 'train_id_train_name', 'train_id_train_name_train'), 'train_id_train_name_train');
        }
    
        protected function CreatePageNavigator()
        {
            $result = new CompositePageNavigator($this);
            
            $partitionNavigator = new PageNavigator('pnav', $this, $this->dataset);
            $partitionNavigator->SetRowsPerPage(20);
            $result->AddPageNavigator($partitionNavigator);
            
            return $result;
        }
    
        public function GetPageList()
        {
            $currentPageCaption = $this->GetShortCaption();
            $result = new PageList($this);
            if (GetCurrentUserGrantForDataSource('admin')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Admin'), 'admin.php', $this->RenderText('Admin'), $currentPageCaption == $this->RenderText('Admin')));
            if (GetCurrentUserGrantForDataSource('bogies')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Bogies'), 'bogies.php', $this->RenderText('Bogies'), $currentPageCaption == $this->RenderText('Bogies')));
            if (GetCurrentUserGrantForDataSource('city')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('City'), 'city.php', $this->RenderText('City'), $currentPageCaption == $this->RenderText('City')));
            if (GetCurrentUserGrantForDataSource('days')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Days'), 'days.php', $this->RenderText('Days'), $currentPageCaption == $this->RenderText('Days')));
            if (GetCurrentUserGrantForDataSource('rout')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Rout'), 'rout.php', $this->RenderText('Rout'), $currentPageCaption == $this->RenderText('Rout')));
            if (GetCurrentUserGrantForDataSource('schedule')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Schedule'), 'schedule.php', $this->RenderText('Schedule'), $currentPageCaption == $this->RenderText('Schedule')));
            if (GetCurrentUserGrantForDataSource('schedule_detail')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Schedule Detail'), 'schedule_detail.php', $this->RenderText('Schedule Detail'), $currentPageCaption == $this->RenderText('Schedule Detail')));
            if (GetCurrentUserGrantForDataSource('seats')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Seats'), 'seats.php', $this->RenderText('Seats'), $currentPageCaption == $this->RenderText('Seats')));
            if (GetCurrentUserGrantForDataSource('ticket')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Ticket'), 'ticket.php', $this->RenderText('Ticket'), $currentPageCaption == $this->RenderText('Ticket')));
            if (GetCurrentUserGrantForDataSource('train')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Train'), 'train.php', $this->RenderText('Train'), $currentPageCaption == $this->RenderText('Train')));
            
            if ( HasAdminPage() && GetApplication()->HasAdminGrantForCurrentUser() )
              $result->AddPage(new PageLink($this->GetLocalizerCaptions()->GetMessageString('AdminPage'), 'phpgen_admin.php', $this->GetLocalizerCaptions()->GetMessageString('AdminPage'), false, true));
            return $result;
        }
    
        protected function CreateRssGenerator()
        {
            return null;
        }
    
        protected function CreateGridSearchControl(Grid $grid)
        {
            $grid->UseFilter = true;
            $grid->SearchControl = new SimpleSearch('routssearch', $this->dataset,
                array('city_id_city_from', 'rout_id', 'train_id_train_name', 'junction_no', 'remarks'),
                array($this->RenderText('City Id'), $this->RenderText('Rout Id'), $this->RenderText('Train Id'), $this->RenderText('Junction No'), $this->RenderText('Remarks')),
                array(
                    '=' => $this->GetLocalizerCaptions()->GetMessageString('equals'),
                    '<>' => $this->GetLocalizerCaptions()->GetMessageString('doesNotEquals'),
                    '<' => $this->GetLocalizerCaptions()->GetMessageString('isLessThan'),
                    '<=' => $this->GetLocalizerCaptions()->GetMessageString('isLessThanOrEqualsTo'),
                    '>' => $this->GetLocalizerCaptions()->GetMessageString('isGreaterThan'),
                    '>=' => $this->GetLocalizerCaptions()->GetMessageString('isGreaterThanOrEqualsTo'),
                    'ILIKE' => $this->GetLocalizerCaptions()->GetMessageString('Like'),
                    'STARTS' => $this->GetLocalizerCaptions()->GetMessageString('StartsWith'),
                    'ENDS' => $this->GetLocalizerCaptions()->GetMessageString('EndsWith'),
                    'CONTAINS' => $this->GetLocalizerCaptions()->GetMessageString('Contains')
                    ), $this->GetLocalizerCaptions(), $this, 'CONTAINS'
                );
        }
    
        protected function CreateGridAdvancedSearchControl(Grid $grid)
        {
            $this->AdvancedSearchControl = new AdvancedSearchControl('routasearch', $this->dataset, $this->GetLocalizerCaptions(), $this->GetColumnVariableContainer(), $this->CreateLinkBuilder());
            $this->AdvancedSearchControl->setTimerInterval(1000);
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`city`');
            $field = new IntegerField('city_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('city_from');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('city_to');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateLookupSearchInput('city_id', $this->RenderText('City Id'), $lookupDataset, 'city_id', 'city_from', false));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('rout_id', $this->RenderText('Rout Id')));
            
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`train`');
            $field = new IntegerField('train_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('train_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateLookupSearchInput('train_id', $this->RenderText('Train Id'), $lookupDataset, 'train_id', 'train_name', false));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('junction_no', $this->RenderText('Junction No')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('remarks', $this->RenderText('Remarks')));
        }
    
        protected function AddOperationsColumns(Grid $grid)
        {
            $actionsBandName = 'actions';
            $grid->AddBandToBegin($actionsBandName, $this->GetLocalizerCaptions()->GetMessageString('Actions'), true);
            if ($this->GetSecurityInfo()->HasViewGrant())
            {
                $column = new RowOperationByLinkColumn($this->GetLocalizerCaptions()->GetMessageString('View'), OPERATION_VIEW, $this->dataset);
                $grid->AddViewColumn($column, $actionsBandName);
            }
            if ($this->GetSecurityInfo()->HasEditGrant())
            {
                $column = new RowOperationByLinkColumn($this->GetLocalizerCaptions()->GetMessageString('Edit'), OPERATION_EDIT, $this->dataset);
                $grid->AddViewColumn($column, $actionsBandName);
                $column->OnShow->AddListener('ShowEditButtonHandler', $this);
            }
            if ($this->GetSecurityInfo()->HasDeleteGrant())
            {
                $column = new RowOperationByLinkColumn($this->GetLocalizerCaptions()->GetMessageString('Delete'), OPERATION_DELETE, $this->dataset);
                $grid->AddViewColumn($column, $actionsBandName);
                $column->OnShow->AddListener('ShowDeleteButtonHandler', $this);
            $column->SetAdditionalAttribute("data-modal-delete", "true");
            $column->SetAdditionalAttribute("data-delete-handler-name", $this->GetModalGridDeleteHandler());
            }
            if ($this->GetSecurityInfo()->HasAddGrant())
            {
                $column = new RowOperationByLinkColumn($this->GetLocalizerCaptions()->GetMessageString('Copy'), OPERATION_COPY, $this->dataset);
                $grid->AddViewColumn($column, $actionsBandName);
            }
        }
    
        protected function AddFieldColumns(Grid $grid)
        {
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_id_city_from', 'City Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for city_id field
            //
            $editor = new ComboBox('city_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`city`');
            $field = new IntegerField('city_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('city_from');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('city_to');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('city_from', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'City Id', 
                'city_id', 
                $editor, 
                $this->dataset, 'city_id', 'city_from', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for city_id field
            //
            $editor = new ComboBox('city_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`city`');
            $field = new IntegerField('city_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('city_from');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('city_to');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('city_from', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'City Id', 
                'city_id', 
                $editor, 
                $this->dataset, 'city_id', 'city_from', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for rout_id field
            //
            $column = new TextViewColumn('rout_id', 'Rout Id', $this->dataset);
            $column->SetOrderable(true);
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_id_train_name', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for train_id field
            //
            $editor = new ComboBox('train_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`train`');
            $field = new IntegerField('train_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('train_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('train_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Train Id', 
                'train_id', 
                $editor, 
                $this->dataset, 'train_id', 'train_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for train_id field
            //
            $editor = new ComboBox('train_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`train`');
            $field = new IntegerField('train_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('train_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('train_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Train Id', 
                'train_id', 
                $editor, 
                $this->dataset, 'train_id', 'train_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for junction_no field
            //
            $column = new TextViewColumn('junction_no', 'Junction No', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for junction_no field
            //
            $editor = new TextEdit('junction_no_edit');
            $editColumn = new CustomEditColumn('Junction No', 'junction_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for junction_no field
            //
            $editor = new TextEdit('junction_no_edit');
            $editColumn = new CustomEditColumn('Junction No', 'junction_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for remarks field
            //
            $column = new TextViewColumn('remarks', 'Remarks', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for remarks field
            //
            $editor = new TextEdit('remarks_edit');
            $editor->SetSize(30);
            $editor->SetMaxLength(30);
            $editColumn = new CustomEditColumn('Remarks', 'remarks', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for remarks field
            //
            $editor = new TextEdit('remarks_edit');
            $editor->SetSize(30);
            $editor->SetMaxLength(30);
            $editColumn = new CustomEditColumn('Remarks', 'remarks', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
        }
    
        protected function AddSingleRecordViewColumns(Grid $grid)
        {
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_id_city_from', 'City Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for rout_id field
            //
            $column = new TextViewColumn('rout_id', 'Rout Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_id_train_name', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for junction_no field
            //
            $column = new TextViewColumn('junction_no', 'Junction No', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for remarks field
            //
            $column = new TextViewColumn('remarks', 'Remarks', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
        }
    
        protected function AddEditColumns(Grid $grid)
        {
            //
            // Edit column for city_id field
            //
            $editor = new ComboBox('city_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`city`');
            $field = new IntegerField('city_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('city_from');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('city_to');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('city_from', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'City Id', 
                'city_id', 
                $editor, 
                $this->dataset, 'city_id', 'city_from', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for train_id field
            //
            $editor = new ComboBox('train_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`train`');
            $field = new IntegerField('train_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('train_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('train_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Train Id', 
                'train_id', 
                $editor, 
                $this->dataset, 'train_id', 'train_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for junction_no field
            //
            $editor = new TextEdit('junction_no_edit');
            $editColumn = new CustomEditColumn('Junction No', 'junction_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for remarks field
            //
            $editor = new TextEdit('remarks_edit');
            $editor->SetSize(30);
            $editor->SetMaxLength(30);
            $editColumn = new CustomEditColumn('Remarks', 'remarks', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
        }
    
        protected function AddInsertColumns(Grid $grid)
        {
            //
            // Edit column for city_id field
            //
            $editor = new ComboBox('city_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`city`');
            $field = new IntegerField('city_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('city_from');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('city_to');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('city_from', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'City Id', 
                'city_id', 
                $editor, 
                $this->dataset, 'city_id', 'city_from', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for train_id field
            //
            $editor = new ComboBox('train_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`train`');
            $field = new IntegerField('train_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('train_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('train_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Train Id', 
                'train_id', 
                $editor, 
                $this->dataset, 'train_id', 'train_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for junction_no field
            //
            $editor = new TextEdit('junction_no_edit');
            $editColumn = new CustomEditColumn('Junction No', 'junction_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for remarks field
            //
            $editor = new TextEdit('remarks_edit');
            $editor->SetSize(30);
            $editor->SetMaxLength(30);
            $editColumn = new CustomEditColumn('Remarks', 'remarks', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            if ($this->GetSecurityInfo()->HasAddGrant())
            {
                $grid->SetShowAddButton(true);
                $grid->SetShowInlineAddButton(false);
            }
            else
            {
                $grid->SetShowInlineAddButton(false);
                $grid->SetShowAddButton(false);
            }
        }
    
        protected function AddPrintColumns(Grid $grid)
        {
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_id_city_from', 'City Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for rout_id field
            //
            $column = new TextViewColumn('rout_id', 'Rout Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_id_train_name', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for junction_no field
            //
            $column = new TextViewColumn('junction_no', 'Junction No', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for remarks field
            //
            $column = new TextViewColumn('remarks', 'Remarks', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
        }
    
        protected function AddExportColumns(Grid $grid)
        {
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_id_city_from', 'City Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for rout_id field
            //
            $column = new TextViewColumn('rout_id', 'Rout Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_id_train_name', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for junction_no field
            //
            $column = new TextViewColumn('junction_no', 'Junction No', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for remarks field
            //
            $column = new TextViewColumn('remarks', 'Remarks', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
        }
    
        public function GetPageDirection()
        {
            return null;
        }
    
        protected function ApplyCommonColumnEditProperties(CustomEditColumn $column)
        {
            $column->SetShowSetToNullCheckBox(false);
    		$column->SetVariableContainer($this->GetColumnVariableContainer());
        }
    
        function GetCustomClientScript()
        {
            return ;
        }
        
        function GetOnPageLoadedClientScript()
        {
            return ;
        }
        public function ShowEditButtonHandler(&$show)
        {
            if ($this->GetRecordPermission() != null)
                $show = $this->GetRecordPermission()->HasEditGrant($this->GetDataset());
        }
        public function ShowDeleteButtonHandler(&$show)
        {
            if ($this->GetRecordPermission() != null)
                $show = $this->GetRecordPermission()->HasDeleteGrant($this->GetDataset());
        }
        
        public function GetModalGridDeleteHandler() { return 'rout_modal_delete'; }
        protected function GetEnableModalGridDelete() { return true; }
    
        protected function CreateGrid()
        {
            $result = new Grid($this, $this->dataset, 'routGrid');
            if ($this->GetSecurityInfo()->HasDeleteGrant())
               $result->SetAllowDeleteSelected(false);
            else
               $result->SetAllowDeleteSelected(false);   
            
            ApplyCommonPageSettings($this, $result);
            
            $result->SetUseImagesForActions(false);
            $result->SetUseFixedHeader(false);
            
            $result->SetShowLineNumbers(false);
            
            $result->SetHighlightRowAtHover(false);
            $result->SetWidth('');
            $this->CreateGridSearchControl($result);
            $this->CreateGridAdvancedSearchControl($result);
            $this->AddOperationsColumns($result);
            $this->AddFieldColumns($result);
            $this->AddSingleRecordViewColumns($result);
            $this->AddEditColumns($result);
            $this->AddInsertColumns($result);
            $this->AddPrintColumns($result);
            $this->AddExportColumns($result);
    
            $this->SetShowPageList(true);
            $this->SetHidePageListByDefault(false);
            $this->SetExportToExcelAvailable(false);
            $this->SetExportToWordAvailable(false);
            $this->SetExportToXmlAvailable(false);
            $this->SetExportToCsvAvailable(false);
            $this->SetExportToPdfAvailable(false);
            $this->SetPrinterFriendlyAvailable(false);
            $this->SetSimpleSearchAvailable(true);
            $this->SetAdvancedSearchAvailable(false);
            $this->SetFilterRowAvailable(false);
            $this->SetVisualEffectsEnabled(true);
            $this->SetShowTopPageNavigator(true);
            $this->SetShowBottomPageNavigator(true);
    
            //
            // Http Handlers
            //
    
            return $result;
        }
        
        public function OpenAdvancedSearchByDefault()
        {
            return false;
        }
    
        protected function DoGetGridHeader()
        {
            return '';
        }
    }



    try
    {
        $Page = new routPage("rout.php", "rout", GetCurrentUserGrantForDataSource("rout"), 'UTF-8');
        $Page->SetShortCaption('Rout');
        $Page->SetHeader(GetPagesHeader());
        $Page->SetFooter(GetPagesFooter());
        $Page->SetCaption('Rout');
        $Page->SetRecordPermission(GetCurrentUserRecordPermissionsForDataSource("rout"));
        GetApplication()->SetEnableLessRunTimeCompile(GetEnableLessFilesRunTimeCompilation());
        GetApplication()->SetCanUserChangeOwnPassword(
            !function_exists('CanUserChangeOwnPassword') || CanUserChangeOwnPassword());
        GetApplication()->SetMainPage($Page);
        GetApplication()->Run();
    }
    catch(Exception $e)
    {
        ShowErrorPage($e->getMessage());
    }
	
