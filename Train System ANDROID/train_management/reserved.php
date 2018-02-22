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
    
    
    
    class reservedPage extends Page
    {
        protected function DoBeforeCreate()
        {
            $this->dataset = new TableDataset(
                new MyConnectionFactory(),
                GetConnectionOptions(),
                '`reserved`');
            $field = new IntegerField('ticket_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new IntegerField('seat_no');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new StringField('pessanger');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new StringField('train_name');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new DateField('date_of_train');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new StringField('city_from');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new StringField('city_to');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new StringField('bogie_name');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new IntegerField('schedule_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new IntegerField('bogies_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
            $field = new IntegerField('train_id');
            $field->SetIsNotNull(true);
            $this->dataset->AddField($field, true);
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
            if (GetCurrentUserGrantForDataSource('ticket')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Ticket'), 'ticket.php', $this->RenderText('Ticket'), $currentPageCaption == $this->RenderText('Ticket')));
            if (GetCurrentUserGrantForDataSource('train')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Train'), 'train.php', $this->RenderText('Train'), $currentPageCaption == $this->RenderText('Train')));
            if (GetCurrentUserGrantForDataSource('reserved')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Reserved'), 'reserved.php', $this->RenderText('Reserved'), $currentPageCaption == $this->RenderText('Reserved')));
            if (GetCurrentUserGrantForDataSource('train_routes_cross')->HasViewGrant())
                $result->AddPage(new PageLink($this->RenderText('Train Routes Cross'), 'train_routes_cross.php', $this->RenderText('Train Routes Cross'), $currentPageCaption == $this->RenderText('Train Routes Cross')));
            
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
            $grid->SearchControl = new SimpleSearch('reservedssearch', $this->dataset,
                array('ticket_id', 'seat_no', 'pessanger', 'train_name', 'date_of_train', 'city_from', 'city_to', 'bogie_name', 'schedule_id', 'bogies_id', 'train_id'),
                array($this->RenderText('Ticket Id'), $this->RenderText('Seat No'), $this->RenderText('Pessanger'), $this->RenderText('Train Name'), $this->RenderText('Date Of Train'), $this->RenderText('City From'), $this->RenderText('City To'), $this->RenderText('Bogie Name'), $this->RenderText('Schedule Id'), $this->RenderText('Bogies Id'), $this->RenderText('Train Id')),
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
            $this->AdvancedSearchControl = new AdvancedSearchControl('reservedasearch', $this->dataset, $this->GetLocalizerCaptions(), $this->GetColumnVariableContainer(), $this->CreateLinkBuilder());
            $this->AdvancedSearchControl->setTimerInterval(1000);
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('ticket_id', $this->RenderText('Ticket Id')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('seat_no', $this->RenderText('Seat No')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('pessanger', $this->RenderText('Pessanger')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('train_name', $this->RenderText('Train Name')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateDateTimeSearchInput('date_of_train', $this->RenderText('Date Of Train')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('city_from', $this->RenderText('City From')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('city_to', $this->RenderText('City To')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('bogie_name', $this->RenderText('Bogie Name')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('schedule_id', $this->RenderText('Schedule Id')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('bogies_id', $this->RenderText('Bogies Id')));
            $this->AdvancedSearchControl->AddSearchColumn($this->AdvancedSearchControl->CreateStringSearchInput('train_id', $this->RenderText('Train Id')));
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
            // View column for ticket_id field
            //
            $column = new TextViewColumn('ticket_id', 'Ticket Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for ticket_id field
            //
            $editor = new TextEdit('ticket_id_edit');
            $editColumn = new CustomEditColumn('Ticket Id', 'ticket_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for ticket_id field
            //
            $editor = new TextEdit('ticket_id_edit');
            $editColumn = new CustomEditColumn('Ticket Id', 'ticket_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
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
            // View column for pessanger field
            //
            $column = new TextViewColumn('pessanger', 'Pessanger', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for pessanger field
            //
            $editor = new TextEdit('pessanger_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Pessanger', 'pessanger', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for pessanger field
            //
            $editor = new TextEdit('pessanger_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Pessanger', 'pessanger', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_name', 'Train Name', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for train_name field
            //
            $editor = new TextEdit('train_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Train Name', 'train_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for train_name field
            //
            $editor = new TextEdit('train_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Train Name', 'train_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for date_of_train field
            //
            $column = new DateTimeViewColumn('date_of_train', 'Date Of Train', $this->dataset);
            $column->SetDateTimeFormat('Y-m-d H:i:s');
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for date_of_train field
            //
            $editor = new DateTimeEdit('date_of_train_edit', true, 'Y-m-d H:i:s', GetFirstDayOfWeek());
            $editColumn = new CustomEditColumn('Date Of Train', 'date_of_train', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for date_of_train field
            //
            $editor = new DateTimeEdit('date_of_train_edit', true, 'Y-m-d H:i:s', GetFirstDayOfWeek());
            $editColumn = new CustomEditColumn('Date Of Train', 'date_of_train', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_from', 'City From', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for city_from field
            //
            $editor = new TextEdit('city_from_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('City From', 'city_from', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for city_from field
            //
            $editor = new TextEdit('city_from_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('City From', 'city_from', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for city_to field
            //
            $column = new TextViewColumn('city_to', 'City To', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for city_to field
            //
            $editor = new TextEdit('city_to_edit');
            $editor->SetSize(50);
            $editor->SetMaxLength(50);
            $editColumn = new CustomEditColumn('City To', 'city_to', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for city_to field
            //
            $editor = new TextEdit('city_to_edit');
            $editor->SetSize(50);
            $editor->SetMaxLength(50);
            $editColumn = new CustomEditColumn('City To', 'city_to', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_name', 'Bogie Name', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for bogie_name field
            //
            $editor = new TextEdit('bogie_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Bogie Name', 'bogie_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for bogie_name field
            //
            $editor = new TextEdit('bogie_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Bogie Name', 'bogie_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for schedule_id field
            //
            $column = new TextViewColumn('schedule_id', 'Schedule Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for schedule_id field
            //
            $editor = new TextEdit('schedule_id_edit');
            $editColumn = new CustomEditColumn('Schedule Id', 'schedule_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for schedule_id field
            //
            $editor = new TextEdit('schedule_id_edit');
            $editColumn = new CustomEditColumn('Schedule Id', 'schedule_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for bogies_id field
            //
            $column = new TextViewColumn('bogies_id', 'Bogies Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for bogies_id field
            //
            $editor = new TextEdit('bogies_id_edit');
            $editColumn = new CustomEditColumn('Bogies Id', 'bogies_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for bogies_id field
            //
            $editor = new TextEdit('bogies_id_edit');
            $editColumn = new CustomEditColumn('Bogies Id', 'bogies_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetInsertOperationColumn($editColumn);
            /* </inline insert column> */
            $column->SetDescription($this->RenderText(''));
            $column->SetFixedWidth(null);
            $grid->AddViewColumn($column);
            
            //
            // View column for train_id field
            //
            $column = new TextViewColumn('train_id', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            
            /* <inline edit column> */
            //
            // Edit column for train_id field
            //
            $editor = new TextEdit('train_id_edit');
            $editColumn = new CustomEditColumn('Train Id', 'train_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $column->SetEditOperationColumn($editColumn);
            /* </inline edit column> */
            
            /* <inline insert column> */
            //
            // Edit column for train_id field
            //
            $editor = new TextEdit('train_id_edit');
            $editColumn = new CustomEditColumn('Train Id', 'train_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
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
            // View column for ticket_id field
            //
            $column = new TextViewColumn('ticket_id', 'Ticket Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for pessanger field
            //
            $column = new TextViewColumn('pessanger', 'Pessanger', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_name', 'Train Name', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for date_of_train field
            //
            $column = new DateTimeViewColumn('date_of_train', 'Date Of Train', $this->dataset);
            $column->SetDateTimeFormat('Y-m-d H:i:s');
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_from', 'City From', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for city_to field
            //
            $column = new TextViewColumn('city_to', 'City To', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_name', 'Bogie Name', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for schedule_id field
            //
            $column = new TextViewColumn('schedule_id', 'Schedule Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for bogies_id field
            //
            $column = new TextViewColumn('bogies_id', 'Bogies Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
            
            //
            // View column for train_id field
            //
            $column = new TextViewColumn('train_id', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddSingleRecordViewColumn($column);
        }
    
        protected function AddEditColumns(Grid $grid)
        {
            //
            // Edit column for ticket_id field
            //
            $editor = new TextEdit('ticket_id_edit');
            $editColumn = new CustomEditColumn('Ticket Id', 'ticket_id', $editor, $this->dataset);
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
            // Edit column for pessanger field
            //
            $editor = new TextEdit('pessanger_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Pessanger', 'pessanger', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for train_name field
            //
            $editor = new TextEdit('train_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Train Name', 'train_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for date_of_train field
            //
            $editor = new DateTimeEdit('date_of_train_edit', true, 'Y-m-d H:i:s', GetFirstDayOfWeek());
            $editColumn = new CustomEditColumn('Date Of Train', 'date_of_train', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for city_from field
            //
            $editor = new TextEdit('city_from_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('City From', 'city_from', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for city_to field
            //
            $editor = new TextEdit('city_to_edit');
            $editor->SetSize(50);
            $editor->SetMaxLength(50);
            $editColumn = new CustomEditColumn('City To', 'city_to', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for bogie_name field
            //
            $editor = new TextEdit('bogie_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Bogie Name', 'bogie_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for schedule_id field
            //
            $editor = new TextEdit('schedule_id_edit');
            $editColumn = new CustomEditColumn('Schedule Id', 'schedule_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for bogies_id field
            //
            $editor = new TextEdit('bogies_id_edit');
            $editColumn = new CustomEditColumn('Bogies Id', 'bogies_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
            
            //
            // Edit column for train_id field
            //
            $editor = new TextEdit('train_id_edit');
            $editColumn = new CustomEditColumn('Train Id', 'train_id', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddEditColumn($editColumn);
        }
    
        protected function AddInsertColumns(Grid $grid)
        {
            //
            // Edit column for ticket_id field
            //
            $editor = new TextEdit('ticket_id_edit');
            $editColumn = new CustomEditColumn('Ticket Id', 'ticket_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
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
            // Edit column for pessanger field
            //
            $editor = new TextEdit('pessanger_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Pessanger', 'pessanger', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for train_name field
            //
            $editor = new TextEdit('train_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Train Name', 'train_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for date_of_train field
            //
            $editor = new DateTimeEdit('date_of_train_edit', true, 'Y-m-d H:i:s', GetFirstDayOfWeek());
            $editColumn = new CustomEditColumn('Date Of Train', 'date_of_train', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for city_from field
            //
            $editor = new TextEdit('city_from_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('City From', 'city_from', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for city_to field
            //
            $editor = new TextEdit('city_to_edit');
            $editor->SetSize(50);
            $editor->SetMaxLength(50);
            $editColumn = new CustomEditColumn('City To', 'city_to', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for bogie_name field
            //
            $editor = new TextEdit('bogie_name_edit');
            $editor->SetSize(20);
            $editor->SetMaxLength(20);
            $editColumn = new CustomEditColumn('Bogie Name', 'bogie_name', $editor, $this->dataset);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for schedule_id field
            //
            $editor = new TextEdit('schedule_id_edit');
            $editColumn = new CustomEditColumn('Schedule Id', 'schedule_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for bogies_id field
            //
            $editor = new TextEdit('bogies_id_edit');
            $editColumn = new CustomEditColumn('Bogies Id', 'bogies_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
            $validator = new RequiredValidator(StringUtils::Format($this->GetLocalizerCaptions()->GetMessageString('RequiredValidationMessage'), $this->RenderText($editColumn->GetCaption())));
            $editor->GetValidatorCollection()->AddValidator($validator);
            $this->ApplyCommonColumnEditProperties($editColumn);
            $grid->AddInsertColumn($editColumn);
            
            //
            // Edit column for train_id field
            //
            $editor = new TextEdit('train_id_edit');
            $editColumn = new CustomEditColumn('Train Id', 'train_id', $editor, $this->dataset);
            $editColumn->SetAllowSetToDefault(true);
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
            // View column for ticket_id field
            //
            $column = new TextViewColumn('ticket_id', 'Ticket Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for pessanger field
            //
            $column = new TextViewColumn('pessanger', 'Pessanger', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_name', 'Train Name', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for date_of_train field
            //
            $column = new DateTimeViewColumn('date_of_train', 'Date Of Train', $this->dataset);
            $column->SetDateTimeFormat('Y-m-d H:i:s');
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_from', 'City From', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for city_to field
            //
            $column = new TextViewColumn('city_to', 'City To', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_name', 'Bogie Name', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for schedule_id field
            //
            $column = new TextViewColumn('schedule_id', 'Schedule Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for bogies_id field
            //
            $column = new TextViewColumn('bogies_id', 'Bogies Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
            
            //
            // View column for train_id field
            //
            $column = new TextViewColumn('train_id', 'Train Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddPrintColumn($column);
        }
    
        protected function AddExportColumns(Grid $grid)
        {
            //
            // View column for ticket_id field
            //
            $column = new TextViewColumn('ticket_id', 'Ticket Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for seat_no field
            //
            $column = new TextViewColumn('seat_no', 'Seat No', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for pessanger field
            //
            $column = new TextViewColumn('pessanger', 'Pessanger', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for train_name field
            //
            $column = new TextViewColumn('train_name', 'Train Name', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for date_of_train field
            //
            $column = new DateTimeViewColumn('date_of_train', 'Date Of Train', $this->dataset);
            $column->SetDateTimeFormat('Y-m-d H:i:s');
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for city_from field
            //
            $column = new TextViewColumn('city_from', 'City From', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for city_to field
            //
            $column = new TextViewColumn('city_to', 'City To', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for bogie_name field
            //
            $column = new TextViewColumn('bogie_name', 'Bogie Name', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for schedule_id field
            //
            $column = new TextViewColumn('schedule_id', 'Schedule Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for bogies_id field
            //
            $column = new TextViewColumn('bogies_id', 'Bogies Id', $this->dataset);
            $column->SetOrderable(true);
            $grid->AddExportColumn($column);
            
            //
            // View column for train_id field
            //
            $column = new TextViewColumn('train_id', 'Train Id', $this->dataset);
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
        
        public function GetModalGridDeleteHandler() { return 'reserved_modal_delete'; }
        protected function GetEnableModalGridDelete() { return true; }
    
        protected function CreateGrid()
        {
            $result = new Grid($this, $this->dataset, 'reservedGrid');
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
        $Page = new reservedPage("reserved.php", "reserved", GetCurrentUserGrantForDataSource("reserved"), 'UTF-8');
        $Page->SetShortCaption('Reserved');
        $Page->SetHeader(GetPagesHeader());
        $Page->SetFooter(GetPagesFooter());
        $Page->SetCaption('Reserved');
        $Page->SetRecordPermission(GetCurrentUserRecordPermissionsForDataSource("reserved"));
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
	
