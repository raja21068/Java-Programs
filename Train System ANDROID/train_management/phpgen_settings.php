<?php

//  define('SHOW_VARIABLES', 1);
//  define('DEBUG_LEVEL', 1);

//  error_reporting(E_ALL ^ E_NOTICE);
//  ini_set('display_errors', 'On');

set_include_path('.' . PATH_SEPARATOR . get_include_path());


include_once dirname(__FILE__) . '/' . 'components/utils/system_utils.php';

//  SystemUtils::DisableMagicQuotesRuntime();

SystemUtils::SetTimeZoneIfNeed('America/Los_Angeles');

function GetGlobalConnectionOptions()
{
    return array(
  'server' => 'localhost',
  'port' => '3306',
  'username' => 'root',
  'database' => 'train_reservation'
);
}

function HasAdminPage()
{
    return false;
}

function GetPageInfos()
{
    $result = array();
    $result[] = array('caption' => 'Admin', 'short_caption' => 'Admin', 'filename' => 'admin.php', 'name' => 'admin');
    $result[] = array('caption' => 'Bogies', 'short_caption' => 'Bogies', 'filename' => 'bogies.php', 'name' => 'bogies');
    $result[] = array('caption' => 'City', 'short_caption' => 'City', 'filename' => 'city.php', 'name' => 'city');
    $result[] = array('caption' => 'Days', 'short_caption' => 'Days', 'filename' => 'days.php', 'name' => 'days');
    $result[] = array('caption' => 'Rout', 'short_caption' => 'Rout', 'filename' => 'rout.php', 'name' => 'rout');
    $result[] = array('caption' => 'Schedule', 'short_caption' => 'Schedule', 'filename' => 'schedule.php', 'name' => 'schedule');
    $result[] = array('caption' => 'Schedule Detail', 'short_caption' => 'Schedule Detail', 'filename' => 'schedule_detail.php', 'name' => 'schedule_detail');
    $result[] = array('caption' => 'Seats', 'short_caption' => 'Seats', 'filename' => 'seats.php', 'name' => 'seats');
    $result[] = array('caption' => 'Ticket', 'short_caption' => 'Ticket', 'filename' => 'ticket.php', 'name' => 'ticket');
    $result[] = array('caption' => 'Train', 'short_caption' => 'Train', 'filename' => 'train.php', 'name' => 'train');
    return $result;
}

function GetPagesHeader()
{
    return
    '';
}

function GetPagesFooter()
{
    return
        ''; 
    }

function ApplyCommonPageSettings(Page $page, Grid $grid)
{
    $page->SetShowUserAuthBar(false);
    $grid->BeforeUpdateRecord->AddListener('Global_BeforeUpdateHandler');
    $grid->BeforeDeleteRecord->AddListener('Global_BeforeDeleteHandler');
    $grid->BeforeInsertRecord->AddListener('Global_BeforeInsertHandler');
}

/*
  Default code page: 1252
*/
function GetAnsiEncoding() { return 'windows-1252'; }

function Global_BeforeUpdateHandler($page, $rowData, &$cancel, &$message, $tableName)
{

}

function Global_BeforeDeleteHandler($page, $rowData, &$cancel, &$message, $tableName)
{

}

function Global_BeforeInsertHandler($page, $rowData, &$cancel, &$message, $tableName)
{

}

function GetDefaultDateFormat()
{
    return 'Y-m-d';
}

function GetFirstDayOfWeek()
{
    return 0;
}

function GetEnableLessFilesRunTimeCompilation()
{
    return false;
}



?>