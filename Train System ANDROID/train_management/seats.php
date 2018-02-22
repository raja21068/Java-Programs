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
    
    
    
    class seatsPage extends Page
    {
        protected function DoBeforeCreate()
        {
            $this->dataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`seats`');
            $field = new IntegerField('seat_id', null, null, true);
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new IntegerField('bogie_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $field = new StringField('seat_type');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $field = new IntegerField('seat_no');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $field = new IntegerField('remarks');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, false);
            $this->dataset->AddLookupField('bogie_id', 'bogies', new IntegerField('bogies_id', null, null, true), new StringField('bogie_name', 'bogie_id_bogie_name', 'bogie_id_bogie_name_bogies'), 'bogie_id_bogie_name_bogies');
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
            $grid->SearchControl = new SimpleSearch('seatsssearch', $this->dataset,
                array('seat_id', 'bogie_id_bogie_name', 'seat_type', 'seat_no', 'remarks'),
                array($this->RenderText('Seat Id'), $this->RenderText('Bogie Id'), $this->RenderText('Seat Type'), $this->RenderText('Seat No'), $this->RenderText('Remarks')),
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
            $this->AdvancedSearchControl = new AdvancedSearchControl('seatsasearch', $this->dataset, $this->GetLocalizerCaptions(), $this->GetColumnVariableContainer(), $this->CreateLinkBuilder());
            $this->AdvancedSearchControl->setTimerInterval(1000);
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('seat_id', $this->RenderText('Seat Id')));
            
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`bogies`');
            $field = new IntegerField('bogies_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('bogie_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateLookupSearchInput('bogie_id', $this->RenderText('Bogie Id'), $lookupDataset, 'bogies_id', 'bogie_name', false));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('seat_type', $this->RenderText('Seat Type')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('seat_no', $this->RenderText('Seat No')));
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
            // View column for seat_id field
            //
            $column = new TextViewColumn('seat_id', 'Seat Id', $this->dataset);
            $column->SetOrderable(true);
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_id_bogie_name', 'Bogie Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for bogie_id field
            //
            $editor = new ComboBox('bogie_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`bogies`');
            $field = new IntegerField('bogies_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('bogie_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('bogie_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Bogie Id', 
                'bogie_id', 
                $editor, 
                $this->dataset, 'bogies_id', 'bogie_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for bogie_id field
            //
            $editor = new ComboBox('bogie_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`bogies`');
            $field = new IntegerField('bogies_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('bogie_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('bogie_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Bogie Id', 
                'bogie_id', 
                $editor, 
                $this->dataset, 'bogies_id', 'bogie_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for seat_type field
            //
            $column = new TextViewColumn('seat_type', 'Seat Type', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for seat_type field
            //
            $editor = new TextEdit('seat_type_edit');
            $editor->SetSize(25);
            $editor->SetMaxLength(25);
            $editColumn = new CustomEditColumn('Seat Type', 'seat_type', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for seat_type field
            //
            $editor = new TextEdit('seat_type_edit');
            $editor->SetSize(25);
            $editor->SetMaxLength(25);
            $editColumn = new CustomEditColumn('Seat Type', 'seat_type', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for seat_no field
            //
            $editor = new TextEdit('seat_no_edit');
            $editColumn = new CustomEditColumn('Seat No', 'seat_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for seat_no field
            //
            $editor = new TextEdit('seat_no_edit');
            $editColumn = new CustomEditColumn('Seat No', 'seat_no', $editor, $this->dataset);
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
            // View column for seat_id field
            //
            $column = new TextViewColumn('seat_id', 'Seat Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_id_bogie_name', 'Bogie Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for seat_type field
            //
            $column = new TextViewColumn('seat_type', 'Seat Type', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
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
            // Edit column for bogie_id field
            //
            $editor = new ComboBox('bogie_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`bogies`');
            $field = new IntegerField('bogies_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('bogie_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('bogie_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Bogie Id', 
                'bogie_id', 
                $editor, 
                $this->dataset, 'bogies_id', 'bogie_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for seat_type field
            //
            $editor = new TextEdit('seat_type_edit');
            $editor->SetSize(25);
            $editor->SetMaxLength(25);
            $editColumn = new CustomEditColumn('Seat Type', 'seat_type', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for seat_no field
            //
            $editor = new TextEdit('seat_no_edit');
            $editColumn = new CustomEditColumn('Seat No', 'seat_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for remarks field
            //
            $editor = new TextEdit('remarks_edit');
            $editColumn = new CustomEditColumn('Remarks', 'remarks', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
        }
    
        protected function AddInsertColumns(Grid $grid)
        {
            //
            // Edit column for bogie_id field
            //
            $editor = new ComboBox('bogie_id_edit', $this->GetLocalizerCaptions()->GetMessageString('PleaseSelect'));
            $lookupDataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`bogies`');
            $field = new IntegerField('bogies_id', null, null, true);
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, true);
            $field = new StringField('bogie_name');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $field = new StringField('remarks');
            $field->SetIsNotNull(true);
            $lookupDataset->AddField($field, false);
            $lookupDataset->SetOrderBy('bogie_name', GetOrderTypeAsSQL(otAscending));
            $editColumn = new LookUpEditColumn(
                'Bogie Id', 
                'bogie_id', 
                $editor, 
                $this->dataset, 'bogies_id', 'bogie_name', $lookupDataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for seat_type field
            //
            $editor = new TextEdit('seat_type_edit');
            $editor->SetSize(25);
            $editor->SetMaxLength(25);
            $editColumn = new CustomEditColumn('Seat Type', 'seat_type', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for seat_no field
            //
            $editor = new TextEdit('seat_no_edit');
            $editColumn = new CustomEditColumn('Seat No', 'seat_no', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for remarks field
            //
            $editor = new TextEdit('remarks_edit');
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
            // View column for seat_id field
            //
            $column = new TextViewColumn('seat_id', 'Seat Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_id_bogie_name', 'Bogie Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for seat_type field
            //
            $column = new TextViewColumn('seat_type', 'Seat Type', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
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
            // View column for seat_id field
            //
            $column = new TextViewColumn('seat_id', 'Seat Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_id_bogie_name', 'Bogie Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for seat_type field
            //
            $column = new TextViewColumn('seat_type', 'Seat Type', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
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
        
        public function GetModalGridDeleteHandler() { return 'seats_modal_delete'; }
        protected function GetEnableModalGridDelete() { return true; }
    
        protected function CreateGrid()
        {
            $result = new Grid($this, $this->dataset, 'seatsGrid');
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
        $Page = new seatsPage("seats.php", "seats", GetCurrentUserGrantForDataSource("seats"), 'UTF-8');
        $Page->SetShortCaption('Seats');
        $Page->SetHeader(GetPagesHeader());
        $Page->SetFooter(GetPagesFooter());
        $Page->SetCaption('Seats');
        $Page->SetRecordPermission(GetCurrentUserRecordPermissionsForDataSource("seats"));
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
	
