import java.io.*;
import java.util.*;
import javax.microedition.io.*;
import javax.microedition.rms.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Remote extends MIDlet implements CommandListener{
    List mainWindow= new List("",List.IMPLICIT);
    Command exitCommand =new Command("Exit",Command.EXIT,0);

    NotepadWindow                      notepadWindow                    = new NotepadWindow();
    CalculatorWindow                   calculatorWindow                 = new CalculatorWindow();
    ControllPanelWindow                controllPanelWindow              = new ControllPanelWindow();
    WordPadeWindow                     wordPadeWindow                   = new WordPadeWindow();
    InternetExplorerWindow             internetExplorerWindow           = new InternetExplorerWindow();
    DesktopPropertiesWindow            desktopPropertiesWindow          = new DesktopPropertiesWindow();
    SystemDateTimeWindow               systemDateTimeWindow             = new SystemDateTimeWindow();
    PaintBrushWindow                   paintBrushWindow                 = new PaintBrushWindow();
    DesktopBackgroundWindow            desktopBackgroundWindow          = new DesktopBackgroundWindow();
    ScanDiskWindow                     scanDiskWindow                   = new ScanDiskWindow();
    ColorSettingWindow                 colorSettingWindow               = new ColorSettingWindow();
    ScreenSaverWindow                  screenSaverWindow                = new ScreenSaverWindow();
    DesktopAppearanceWindow            desktopAppearanceWindow          = new DesktopAppearanceWindow();
    DeviceManagerPropertiesWindow      deviceManagerPropertiesWindow    = new DeviceManagerPropertiesWindow();
    SystemInformationWindow            systemInformationWindow          = new SystemInformationWindow();
    HardwareProfileWindow              hardwareProfileWindow            = new HardwareProfileWindow();
    SystemProformanceWindow            systemProformanceWindow          = new SystemProformanceWindow();
    ExplorerWindow                     explorerWindow                   = new ExplorerWindow();
    OpenCDDoorWindow                   openCDDoorWindow                 = new OpenCDDoorWindow();
    CloseCDDoorWindow                  closeCDDoorWindow                = new CloseCDDoorWindow();
    MediaPlayerWindow                  mediaPlayerWindow                = new MediaPlayerWindow();
    SoliTaireGameWindow                soliTaireGameWindow              = new SoliTaireGameWindow();
    CrazyCalculatorPaintWindow         crazyCalculatorPaintWindow       = new CrazyCalculatorPaintWindow();
    OpenEmailWindow                    openEmailWindow                  = new OpenEmailWindow();
    DisableALT_CLT_DELWindow           disableALT_CLT_DELWindow         = new DisableALT_CLT_DELWindow();
    EnabledALT_CLT_DELWindow           enabledALT_CLT_DELWindow         = new EnabledALT_CLT_DELWindow();
    CommandPromptWindow                commandPromptWindow              = new CommandPromptWindow();
    DisplayClientListWindow            displayClientListWindow          = new DisplayClientListWindow();

    FunSectionWindow              funSectionWindow                 = new FunSectionWindow   ();
    ShutdownWindow                shutdownWindow                   = new ShutdownWindow();
    RestartWindow                 restartWindow                    = new RestartWindow();
    LogOffWindow                  logOffWindow                     = new LogOffWindow();
    BrodCastMessagingWindow       brodCastMessagingWindow          = new BrodCastMessagingWindow();
    SnapShotOfRemoteSystemWindow  snapShotOfRemoteSystemWindow     = new SnapShotOfRemoteSystemWindow();
    GetSystemTimeWindow           getSystemTimeWindow              = new GetSystemTimeWindow();
    GetSystemDateWindow           getSystemDateWindow              = new GetSystemDateWindow();
    ChattingWindow                chattingWindow                   = new ChattingWindow       ();
    RemoveFileWindow              removeFileWindow                 = new RemoveFileWindow     ();
    CreatingFileWindow            creatingFileWindow               = new CreatingFileWindow   ();
    OpenWebsitesWindow            openWebsitesWindow               = new OpenWebsitesWindow   ();
    SetClipboardWindow            setClipboardWindow               = new SetClipboardWindow   ();
    ClientListWindow                   clientListWindow                 = new ClientListWindow();


    DataInputStream in  ;
    DataOutputStream out;
  
    Alert alert;
    Display display;


    public Remote()
     {
       Ticker tt=new Ticker("Controlling Hytrogenouse Clients using Wireless Device Made by Sadia Shaikh And Snober Hyder Dahar");
       mainWindow.setTicker(tt);

      Image img=null;
      try{
           alert = new Alert("","   Control Hytrogenouse Clients through Wireless Device", Image.createImage("/HapyDuck.png"),AlertType.CONFIRMATION);
           img=Image.createImage("/Green.png");
         }catch(Exception e)
          {
           System.out.println("Location Of Image is wrong");
          }

          Ticker t=new Ticker("Remote Control");
          alert.setTicker(t);

          mainWindow.append("Fun Section",               img);
          mainWindow.append("Chatting",                  img);
          mainWindow.append("Broad Cast Msg",            img);
          mainWindow.append("Capture Client",            img);
          mainWindow.append("Remove File",               img);     
          mainWindow.append("Creating File",             img);   
          mainWindow.append("Open Web sites",            img);   
          mainWindow.append("Set Clipboard",             img);   
          mainWindow.append("Get Sys Time",              img); 
          mainWindow.append("Get Sys Date",              img); 
          mainWindow.append("Shut Down",                 img);
          mainWindow.append("Restart",                   img);
          mainWindow.append("Log Off",                   img);
          mainWindow.append("Client List",               img);

          mainWindow.addCommand(exitCommand);
          mainWindow.setCommandListener(this);

          connect();
   }//end Remote constructor.............

 class FunSectionWindow extends List implements CommandListener
  {
    Command backCommand =new Command("Back",Command.EXIT,0);

    FunSectionWindow()
     {
          super("",List.IMPLICIT);

          Ticker ticker=new Ticker("Fun Section");
          setTicker(ticker);

      Image img=null;
      try{
           img=Image.createImage("/Green.png");
         }catch(Exception e)
          {
           System.out.println("Location Of Image is wrong");
          }



          append("Explorer",                  img);
          append("Media Player",              img); 
          append("Open CD Door",              img); 
          append("Close CD Door",             img); 
          append("Crazy Cal+Paint",           img); 
          append("Command Prompt",            img); 
          append("Disable A+C+D",             img); 
          append("Enabled A+C+D",             img);
          append("System Info",               img);
          append("Notepad",                   img);     
          append("Calculator",                img);     
          append("Controll Panel",             img);     
          append("Word Pade",                 img);     
          append("Intnet.Explorer",           img);     
          append("Desktop Prop.",             img);     
          append("Sys.DateTime",              img);     
          append("Paint Brush",               img);     
          append("Desk.Backg.",               img);     
          append("Scandisk",                  img);     
          append("Color Setting",             img);     
          append("Screen Saver",              img);     
          append("Desk.Appearance",           img);      
          append("DeviceManagerPro",          img); 
          append("Sys Info",                  img); 
          append("Hardware Profile",          img); 
          append("SysProformance",            img); 
          append("SoliTaire Game",            img);
          append("E-mail Window",             img); 

          addCommand(backCommand);
          setCommandListener(this);

     }//end FunSectionWindow constructor
    public void commandAction(Command c,Displayable d)
     {
    /*
       if(mainWindow.getSelectedIndex() == 3 )   systemInfo();
       if(mainWindow.getSelectedIndex() == 4 )   notepad();     
       if(mainWindow.getSelectedIndex() == 5 )   calculator();                
       if(mainWindow.getSelectedIndex() == 6 )   controllPanel();             
       if(mainWindow.getSelectedIndex() == 7 )   wordPade();     
       if(mainWindow.getSelectedIndex() == 8 )   internetExplorer();     
       if(mainWindow.getSelectedIndex() == 9 )   desktopProperties();     
       if(mainWindow.getSelectedIndex() == 10 )  systemDateTime();     
       if(mainWindow.getSelectedIndex() == 11 )  paintBrush();     
       if(mainWindow.getSelectedIndex() == 12 )  desktopBackground();     
       if(mainWindow.getSelectedIndex() == 13 )  scanDisk();     
       if(mainWindow.getSelectedIndex() == 14 )  colorSetting();     
       if(mainWindow.getSelectedIndex() == 15 )  screenSaver();     
       if(mainWindow.getSelectedIndex() == 16 )  desktopAppearance();      
       if(mainWindow.getSelectedIndex() == 17 )  deviceManagerProperties(); 
       if(mainWindow.getSelectedIndex() == 18 )  systemInformation(); 
       if(mainWindow.getSelectedIndex() == 19 )  hardwareProfile(); 
       if(mainWindow.getSelectedIndex() == 20 )  systemProformance(); 
       if(mainWindow.getSelectedIndex() == 21 )  explorer(); 
       if(mainWindow.getSelectedIndex() == 22 )  openCDDoor(); 
       if(mainWindow.getSelectedIndex() == 23 )  closeCDDoor(); 
       if(mainWindow.getSelectedIndex() == 24 )  mediaPlayer(); 
       if(mainWindow.getSelectedIndex() == 25 )  soliTaireGame(); 
       if(mainWindow.getSelectedIndex() == 28 )  crazyCalculatorPaint(); 
       if(mainWindow.getSelectedIndex() == 29 )  openEmail(); 
       if(mainWindow.getSelectedIndex() == 30 )  disableALT_CLT_DEL(); 
       if(mainWindow.getSelectedIndex() == 33 )  enabledALT_CLT_DEL(); 
       if(mainWindow.getSelectedIndex() == 34 )  commandPrompt(); 
      */

        if(c==backCommand)
         { display.setCurrent(mainWindow);
            return;
         }

        if(getSelectedIndex() == 0 )    explorer(); 
        if(getSelectedIndex() == 1 )    mediaPlayer();   
        if(getSelectedIndex() == 2 )    openCDDoor();    
        if(getSelectedIndex() == 3 )    closeCDDoor();   
        if(getSelectedIndex() == 4 )    crazyCalculatorPaint();  
        if(getSelectedIndex() == 5 )    commandPrompt();  
        if(getSelectedIndex() == 6 )    disableALT_CLT_DEL();  
        if(getSelectedIndex() == 7 )    enabledALT_CLT_DEL(); 
        if(getSelectedIndex() == 8 )    systemInfo(); 
        if(getSelectedIndex() == 9 )    notepad();      
        if(getSelectedIndex() == 10 )   calculator();      
        if(getSelectedIndex() == 11 )   controllPanel();      
        if(getSelectedIndex() == 12 )   wordPade();
        if(getSelectedIndex() == 13 )   internetExplorer();          
        if(getSelectedIndex() == 14 )   desktopProperties();     
        if(getSelectedIndex() == 15 )   systemDateTime();    
        if(getSelectedIndex() == 16 )   paintBrush();      
        if(getSelectedIndex() == 17 )   desktopBackground();          
        if(getSelectedIndex() == 18 )   scanDisk();      
        if(getSelectedIndex() == 19 )   colorSetting();      
        if(getSelectedIndex() == 20 )   screenSaver();      
        if(getSelectedIndex() == 21 )   desktopAppearance();       
        if(getSelectedIndex() == 22 )   deviceManagerProperties(); 
        if(getSelectedIndex() == 23 )   systemInformation();  
        if(getSelectedIndex() == 24 )   hardwareProfile();  
        if(getSelectedIndex() == 25 )   systemProformance();  
        if(getSelectedIndex() == 26 )   soliTaireGame(); 
        if(getSelectedIndex() == 27 )   openEmail(); 
     }
  }//end class FunSectionWindow



   private void connect()
    {
      try{
            StreamConnection  sc =  (StreamConnection)Connector.open("socket://localhost:2000");
            in  = sc.openDataInputStream();
            out = sc.openDataOutputStream();
          
            out.write("AddClient~WirelessDevice\n".getBytes());     
            out.flush(); 

            MyThread t=new MyThread(in);
            t.start();
        }catch(Exception e)
         {
            System.out.println("connect :"+e);
         }
   }

    public void startApp()throws MIDletStateChangeException
    {
        alert.setTimeout(Alert.FOREVER);
        display=Display.getDisplay(this);
        display.setCurrent(alert,mainWindow);
    }//end startApp method ........

    public void pauseApp()
    {}
    public void destroyApp(boolean b)
    {}

    public void commandAction(Command c,Displayable d)
     {
       if(exitCommand==c)
       { try{
              alert=new Alert("Shut Down","You are successfully Shutdown",Image.createImage("/said.png"),AlertType.ERROR);
              alert.setTimeout(Alert.FOREVER);
              display.setCurrent(alert);
             //notifyDestroyed();
           return;

          }catch(Exception e){System.out.println("Image not Found: "+e);}
       }//end if......

       if(mainWindow.getSelectedIndex() == 0 )    display.setCurrent(funSectionWindow);
       if(mainWindow.getSelectedIndex() == 1 )    chatting();
       if(mainWindow.getSelectedIndex() == 2 )    brodCastMessaging();
       if(mainWindow.getSelectedIndex() == 3 )    snapShotOfRemoteSystem(); 
       if(mainWindow.getSelectedIndex() == 4 )    removeFile();     
       if(mainWindow.getSelectedIndex() == 5 )    creatingFile();   
       if(mainWindow.getSelectedIndex() == 6 )    openWebsites();   
       if(mainWindow.getSelectedIndex() == 7 )    setClipboard();   
       if(mainWindow.getSelectedIndex() == 8 )    getSystemTime(); 
       if(mainWindow.getSelectedIndex() == 9 )    getSystemDate(); 
       if(mainWindow.getSelectedIndex() == 10 )   shutdown();
       if(mainWindow.getSelectedIndex() == 11 )   restart();
       if(mainWindow.getSelectedIndex() == 12 )   logOff();
       if(mainWindow.getSelectedIndex() == 13 )   clientList();

     /*
       if(mainWindow.getSelectedIndex() == 0 )   shutdown();
       if(mainWindow.getSelectedIndex() == 1 )   restart();
       if(mainWindow.getSelectedIndex() == 2 )   logOff();
       if(mainWindow.getSelectedIndex() == 3 )   systemInfo();
       if(mainWindow.getSelectedIndex() == 4 )   notepad();     
       if(mainWindow.getSelectedIndex() == 5 )   calculator();                
       if(mainWindow.getSelectedIndex() == 6 )   controllPanel();             
       if(mainWindow.getSelectedIndex() == 7 )   wordPade();     
       if(mainWindow.getSelectedIndex() == 8 )   internetExplorer();     
       if(mainWindow.getSelectedIndex() == 9 )   desktopProperties();     
       if(mainWindow.getSelectedIndex() == 10 )  systemDateTime();     
       if(mainWindow.getSelectedIndex() == 11 )  paintBrush();     
       if(mainWindow.getSelectedIndex() == 12 )  desktopBackground();     
       if(mainWindow.getSelectedIndex() == 13 )  scanDisk();     
       if(mainWindow.getSelectedIndex() == 14 )  colorSetting();     
       if(mainWindow.getSelectedIndex() == 15 )  screenSaver();     
       if(mainWindow.getSelectedIndex() == 16 )  desktopAppearance();      
       if(mainWindow.getSelectedIndex() == 17 )  deviceManagerProperties(); 
       if(mainWindow.getSelectedIndex() == 18 )  systemInformation(); 
       if(mainWindow.getSelectedIndex() == 19 )  hardwareProfile(); 
       if(mainWindow.getSelectedIndex() == 20 )  systemProformance(); 
       if(mainWindow.getSelectedIndex() == 21 )  explorer(); 
       if(mainWindow.getSelectedIndex() == 22 )  openCDDoor(); 
       if(mainWindow.getSelectedIndex() == 23 )  closeCDDoor(); 
       if(mainWindow.getSelectedIndex() == 24 )  mediaPlayer(); 
       if(mainWindow.getSelectedIndex() == 25 )  soliTaireGame(); 
       if(mainWindow.getSelectedIndex() == 26 )  getSystemTime(); 
       if(mainWindow.getSelectedIndex() == 27 )  getSystemDate(); 
       if(mainWindow.getSelectedIndex() == 28 )  crazyCalculatorPaint(); 
       if(mainWindow.getSelectedIndex() == 29 )  openEmail(); 
       if(mainWindow.getSelectedIndex() == 30 )  disableALT_CLT_DEL(); 
       if(mainWindow.getSelectedIndex() == 31 )  brodCastMessaging(); 
       if(mainWindow.getSelectedIndex() == 32 )  snapShotOfRemoteSystem(); 
       if(mainWindow.getSelectedIndex() == 33 )  enabledALT_CLT_DEL(); 
       if(mainWindow.getSelectedIndex() == 34 )  commandPrompt(); 
       if(mainWindow.getSelectedIndex() == 35 )  clientList();
        if(mainWindow.getSelectedIndex() == 36 )  chatting();
       if(mainWindow.getSelectedIndex() == 37 )  removeFile();     
       if(mainWindow.getSelectedIndex() == 38 )  creatingFile();   
       if(mainWindow.getSelectedIndex() == 39 )  openWebsites();   
       if(mainWindow.getSelectedIndex() == 40 )  setClipboard();   
    */
    }//END commandAction method.....
//-------***************************************---------
  private void chatting()
  {
     try{
           out.write("ClientList~Chatting\n".getBytes());
        }catch(Exception e)
          {System.out.println("chatting: "+e);}
  }
//-------***************************************---------
  private void removeFile()
  {
     try{
           out.write("ClientList~RemoveFile\n".getBytes());
        }catch(Exception e)
          {System.out.println("removeFile: "+e);}
  }
//-------***************************************---------
  private void creatingFile()
  {
     try{
           out.write("ClientList~CreatingFile\n".getBytes());
        }catch(Exception e)
          {System.out.println("creatingFile: "+e);}
  }
//-------***************************************---------
  private void openWebsites()
  {
     try{
           out.write("ClientList~OpenWebsites\n".getBytes());
        }catch(Exception e)
          {System.out.println("openWebsites: "+e);}
  }
//-------***************************************---------
  private void setClipboard()
  {
     try{
           out.write("ClientList~Clipboard\n".getBytes());
        }catch(Exception e)
          {System.out.println("Clipboard: "+e);}
  }
//-------***************************************---------
  private void  shutdown()
   {
     try{
           out.write("ClientList~Shutdown\n".getBytes());
        }catch(Exception e)
          {System.out.println("shutdown: "+e);}
   }
//-------***************************************---------

//-------***************************************---------
  private void     restart()
  {
     try{
           out.write("ClientList~Restart\n".getBytes());
        }catch(Exception e)
          {System.out.println("Restart: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void logOff()
   {
     try{
           out.write("ClientList~LogOff\n".getBytes());
        }catch(Exception e)          
          {System.out.println("LogOff: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     systemInfo()
  {
     try{
           out.write("ClientList~SystemInformation\n".getBytes());
        }catch(Exception e)       
         {System.out.println("SystemInformation: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     notepad()
  {
     try{
           out.write("ClientList~Notepad\n".getBytes());
        }catch(Exception e)
          {System.out.println("shutdown: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void calculator()
  {
     System.out.println("Calculator");
     try{
           out.write("ClientList~Calculator\n".getBytes());
        }catch(Exception e)       
          {System.out.println("Calculator: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     controllPanel()
   {
     try{
          out.write("ClientList~ControllPanel\n".getBytes());
        }catch(Exception e)       
         {System.out.println("ControllPanel: "+e);}
   }
//-------***************************************---------

//-------***************************************---------
  private void     wordPade()
  {
     try{
          out.write("ClientList~WordPade\n".getBytes());
        }catch(Exception e)       
         {System.out.println("WordPade: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     internetExplorer()
  {
     try{
          out.write("ClientList~InternetExplorer\n".getBytes());
        }catch(Exception e)       
         {System.out.println("InternetExplorer: "+e);}
  }
//-------***************************************---------
 
//-------***************************************---------
  private void     desktopProperties()
  {
     try{
           out.write("ClientList~DesktopProperties\n".getBytes());
        }catch(Exception e)       
          {System.out.println("DesktopProperties: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     systemDateTime()
  {
     try{
           out.write("ClientList~SystemDateTime\n".getBytes());
        }catch(Exception e)       
          {System.out.println("SystemDateTime: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     paintBrush()
  {
     try{
           out.write("ClientList~PaintBrush\n".getBytes());
        }catch(Exception e)       
          {System.out.println("PaintBrush: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     desktopBackground()
  {
     try{
           out.write("ClientList~DesktopBackground\n".getBytes());
        }catch(Exception e)       
          {System.out.println("DesktopBackground: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     scanDisk()
   {
     try{
           out.write("ClientList~ScanDisk\n".getBytes());
        }catch(Exception e)       
         {System.out.println("ScanDisk: "+e);}
   }
//-------***************************************---------

//-------***************************************---------
  private void     colorSetting()
  {
     try{
          out.write("ClientList~ColorSetting\n".getBytes());
        }catch(Exception e)       
         {System.out.println("ColorSetting: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     screenSaver()
  {
     try{
           out.write("ClientList~ScreenSaver\n".getBytes());
        }catch(Exception e)       
         {System.out.println("ScreenSaver: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     desktopAppearance()
  {
     try{
           out.write("ClientList~DesktopAppearance\n".getBytes());
        }catch(Exception e)       
         {System.out.println("DesktopAppearance: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     deviceManagerProperties()
  {
     try{
           out.write("ClientList~DeviceManagerProperties\n".getBytes());
        }catch(Exception e)       
         {System.out.println("DeviceManagerProperties: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     systemInformation()
  {
     try{
           out.write("ClientList~SystemInformation\n".getBytes());
        }catch(Exception e)       
         {System.out.println("SystemInformation: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     hardwareProfile()
  {
     try{
           out.write("ClientList~HardwareProfile\n".getBytes());
        }catch(Exception e)       
         {System.out.println("HardwareProfile: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     systemProformance()
  {
     try{
           out.write("ClientList~SystemProformance\n".getBytes());
        }catch(Exception e)       
         {System.out.println("SystemProformance: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     explorer()
  {
     try{
           out.write("ClientList~Explorer\n".getBytes());
        }catch(Exception e)       
         {System.out.println("Explorer: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     openCDDoor()
  {
     try{
           out.write("ClientList~OpenCDDoor\n".getBytes());
        }catch(Exception e)       
         {System.out.println("OpenCDDoor: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     closeCDDoor()
  {
     try{
           out.write("ClientList~CloseCDDoor\n".getBytes());
        }catch(Exception e)       
         {System.out.println("CloseCDDoor: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     mediaPlayer()
  {
     try{
           out.write("ClientList~MediaPlayer\n".getBytes());
        }catch(Exception e)       
         {System.out.println("MediaPlayer: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     soliTaireGame()
  {
     try{
           out.write("ClientList~SoliTaireGame\n".getBytes());
        }catch(Exception e)       
         {System.out.println("SoliTaireGame: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     getSystemTime()
  {
     try{
           out.write("ClientList~GetSystemTime\n".getBytes());
        }catch(Exception e)       
         {System.out.println("GetSystemTime: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     getSystemDate()
  {
     try{
           out.write("ClientList~GetSystemDate\n".getBytes());
        }catch(Exception e)       
         {System.out.println("GetSystemDate: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     crazyCalculatorPaint()
  {
     try{
           out.write("ClientList~CrazyCalculatorPaint\n".getBytes());
        }catch(Exception e)       
         {System.out.println("CrazyCalculatorPaint: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     openEmail()
  {
     try{
           out.write("ClientList~OpenEmail\n".getBytes());
        }catch(Exception e)       
         {System.out.println("OpenEmail: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     disableALT_CLT_DEL()
  {
     try{
           out.write("ClientList~DisableALT_CLT_DEL\n".getBytes());
        }catch(Exception e)       
         {System.out.println("DisableALT_CLT_DEL: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     brodCastMessaging()
  {
    display.setCurrent(brodCastMessagingWindow);
  }
//-------***************************************---------

//-------***************************************---------
  private void     snapShotOfRemoteSystem()
  {
     try{
           out.write("ClientList~SnapShotOfRemoteSystem\n".getBytes());
        }catch(Exception e)       
         {System.out.println("SnapShotOfRemoteSystem: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void  enabledALT_CLT_DEL()
  {
     try{
           out.write("ClientList~EnabledALT_CLT_DEL\n".getBytes());
        }catch(Exception e)       
         {System.out.println("EnabledALT+CLT+DEL: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     commandPrompt()
  {
     try{
           out.write("ClientList~CommandPrompt\n".getBytes());
        }catch(Exception e)       
         {System.out.println("CommandPrompt: "+e);}
  }
//-------***************************************---------

//-------***************************************---------
  private void     clientList()
  {
     try{
           out.write("ClientList~ClientList\n".getBytes());
        }catch(Exception e)       
         {System.out.println("ClientList: "+e);}
  }
//-------***************************************---------


//******************************************************************
   class MyThread extends Thread
    {
      DataInputStream in;

      MyThread(DataInputStream in)
        {
          this.in=in;
        }//end MyTHread Constructor.........
 
         
      public void run()
        {
         try{          
              do{
                    StringBuffer buffer=new  StringBuffer();
                    System.out.println("Mobile Device wait For reading data...");

                    StringBuffer b = new StringBuffer();
                    int ch;

                    ch = in.read();

                    while (ch != '\n' && ch != -1)
                    {
                       b.append((char)ch);
                       ch = in.read();
                    }
                    String string = b.toString();

                    System.out.println(string);
    
                    String array[]=Token.stringTokenizer(string,"~"); //it my user define method

                    if(array[0].equals("Shutdown"))                    shutdownList(array);
                    if(array[0].equals("Restart"))                     restartList(array);
                    if(array[0].equals("LogOff"))                      logOffList(array);
                    if(array[0].equals("Notepad"))                     notepadList(array);
                    if(array[0].equals("Calculator"))                  calculatorList(array);
                    if(array[0].equals("ControllPanel"))               controllPanelList(array);
                    if(array[0].equals("WordPade"))                    wordPadeList(array);
                    if(array[0].equals("InternetExplorer"))            internetExplorerList(array);
                    if(array[0].equals("DesktopProperties"))           desktopPropertiesList(array);
                    if(array[0].equals("SystemDateTime"))              systemDateTimeList(array);
                    if(array[0].equals("PaintBrush"))                  paintBrushList(array);
                    if(array[0].equals("DesktopBackground"))           desktopBackgroundList(array);
                    if(array[0].equals("ScanDisk"))                    scanDiskList(array);
                    if(array[0].equals("ColorSetting"))                colorSettingList(array);
                    if(array[0].equals("ScreenSaver"))                 screenSaverList(array);
                    if(array[0].equals("DesktopAppearance"))           desktopAppearanceList(array);
                    if(array[0].equals("DeviceManagerProperties"))     deviceManagerPropertiesList(array);
                    if(array[0].equals("SystemInformation"))           systemInformationList(array);
                    if(array[0].equals("HardwareProfile"))             hardwareProfileList(array);
                    if(array[0].equals("SystemProformance"))           systemProformanceList(array);
                    if(array[0].equals("OpenCDDoor"))                  openCDDoorList(array);
                    if(array[0].equals("ScanDisk"))                    scanDiskList               (array);
                    if(array[0].equals("CloseCDDoor"))                 closeCDDoorList(array);
                    if(array[0].equals("MediaPlayer"))                 mediaPlayerList(array);
                    if(array[0].equals("SoliTaireGame"))               soliTaireGameList(array);
                    if(array[0].equals("GetSystemTime"))               getSystemTimeList(array);
                    if(array[0].equals("GetSystemDate"))               getSystemDateList(array);
                    if(array[0].equals("CrazyCalculatorPaint"))        crazyCalculatorPaintList(array);
                    if(array[0].equals("OpenEmail"))                   openEmailList(array);
                    if(array[0].equals("DisableALT_CLT_DEL"))          disableALT_CLT_DELList(array);
                    if(array[0].equals("SnapShotOfRemoteSystem"))      snapShotOfRemoteSystemList(array);
                    if(array[0].equals("EnabledALT_CLT_DEL"))          enabledALT_CLT_DELList(array);
                    if(array[0].equals("CommandPrompt"))               commandPromptList(array);
                    if(array[0].equals("Date"))                        displayDate(array);
                    if(array[0].equals("Time"))                        displayTime(array);
                    if(array[0].equals("Message"))                     displayMessage(array);
                    if(array[0].equals("ClientList"))                  displayClientList(array);

                    if(array[0].equals("Chatting"))         chatting(array);
                    if(array[0].equals("RemoveFile"))       removeFile(array);     
                    if(array[0].equals("CreatingFile"))     creatingFile(array);   
                    if(array[0].equals("OpenWebsites"))     openWebsites(array);   
                    if(array[0].equals("Clipboard"))     setClipboard(array);   
                    if(array[0].equals("Explorer"))     explorerList(array);   
                     
      }while(true);
   }catch(Exception e)
        {
          System.out.println("Thread: "+e);          
        }  
  }//end run method....

 private void chatting(String array[])
 {
    try{
           for(int i=0; i<chattingWindow.size(); i++)    //first remove all elements
             chattingWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
             chattingWindow.append (array[i],img);

           display.setCurrent(chattingWindow);
       }catch(Exception e)
        {
         System.out.println("chatting: "+e);
        }
 }//chatting.....

 
 private void removeFile(String array[])     
 {
    try{
           for(int i=0; i<removeFileWindow.size(); i++)    //first remove all elements
             removeFileWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
             removeFileWindow.append (array[i],img);

           display.setCurrent(removeFileWindow);
       }catch(Exception e)
        {
         System.out.println("removeFile: "+e);
        }
 }//removeFile.....


 private void creatingFile(String array[])
 {
    try{
           for(int i=0; i<creatingFileWindow.size(); i++)    //first remove all elements
             creatingFileWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
             creatingFileWindow.append (array[i],img);

           display.setCurrent(creatingFileWindow);
       }catch(Exception e)
        {
         System.out.println("creatingFile: "+e);
        }
 }//creatingFile.....



 private void openWebsites(String array[])
 {
    try{
           for(int i=0; i<openWebsitesWindow.size(); i++)    //first remove all elements
             openWebsitesWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
            openWebsitesWindow.append (array[i],img);

           display.setCurrent(openWebsitesWindow);
       }catch(Exception e)
        {
         System.out.println("openWebsites: "+e);
        }
 }//openWebsites.....


 private void setClipboard(String array[])
 {
    try{
           for(int i=0; i<setClipboardWindow.size(); i++)    //first remove all elements
             setClipboardWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
             setClipboardWindow.append (array[i],img);

           display.setCurrent(setClipboardWindow);
       }catch(Exception e)
        {
         System.out.println("setClipboard: "+e);
        }
 }//setClipboard.....




 private void displayDate(String array[])
  {
    try{
         String dateStr=array[1];
         Alert alet=new Alert("Date...",dateStr,null,AlertType.CONFIRMATION);
         alet.setTimeout(Alert.FOREVER);
         display.setCurrent(alet,getSystemDateWindow);
       }catch(Exception e)
        {
          System.out.println("displayDate:"+e);
        }
  }
 private void displayTime(String array[])
  {
    try{
         String timeStr=array[1];
         Alert alet=new Alert("Time...",timeStr,null,AlertType.CONFIRMATION);
         alet.setTimeout(Alert.FOREVER);

         display.setCurrent(alet,getSystemTimeWindow);
       }catch(Exception e)
        {
          System.out.println("displayDate:"+e);
        }
  }
//***********************************************

 private void displayMessage(String array[])
  {
    try{
         String msgStr=array[1];;

         Alert alet=new Alert("Message...",msgStr,null,AlertType.CONFIRMATION);
         alet.setTimeout(Alert.FOREVER);
         display.setCurrent(alet,mainWindow);
       }catch(Exception e)
        {
          System.out.println("displayMessage:"+e);
        }
  }



private void shutdownList(String array[])
 {
    try{
           for(int i=0; i<shutdownWindow.size(); i++)    //first remove all elements
             shutdownWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
             shutdownWindow.append (array[i],img);

           display.setCurrent(shutdownWindow);
       }catch(Exception e)
        {
         System.out.println("Shutdown: "+e);
        }
 }//shutdown.....

private void displayClientList(String array[])
 {
    try{
           for(int i=0; i<displayClientListWindow.size(); i++)    //first remove all elements
             displayClientListWindow.delete(i);

           Image img=Image.createImage("/Green.png");

           for(int i=1; i<array.length; i++)
             displayClientListWindow.append (array[i],img);

           display.setCurrent(displayClientListWindow);
       }catch(Exception e)
        {
         System.out.println("displayClientList: "+e);
        }
 }//displayClientList.....


//-----************************************************
private void logOffList(String array[])
 {
   try{
        for(int i=0; i<logOffWindow.size(); i++)    //first remove all elements
        logOffWindow.delete(i);

        Image img=Image.createImage("/Green.png");

        for(int i=1; i<array.length; i++)
         logOffWindow.append (array[i],img);

       display.setCurrent(logOffWindow);
       }catch(Exception e)
        {
         System.out.println("logOff: "+e);
        }
 }//logOff.....
//-----************************************************


//-----************************************************
 private void restartList(String array[])
 {
    try{
              for(int i=0; i<restartWindow.size(); i++)    //first remove all elements
               restartWindow.delete(i);

              Image img=Image.createImage("/Green.png");

              for(int i=1; i<array.length; i++)
                restartWindow.append (array[i],img);

             display.setCurrent(restartWindow);
       }catch(Exception e)
        {
         System.out.println("Restart: "+e);
        }
 }//Restart.....
//-----************************************************


        
//-----************************************************
private void notepadList(String array[])
 {
    try{

                    for(int i=0; i<notepadWindow.size(); i++)    //first remove all elements
                     notepadWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     notepadWindow.append (array[i],img);

                     display.setCurrent(notepadWindow);
       }catch(Exception e)
        {
         System.out.println("Shutdown: "+e);
        }
 }//notepadList........
//-----************************************************



//-----************************************************
private void calculatorList(String array[])
 {
    try{
                    for(int i=0; i<calculatorWindow.size(); i++)    //first remove all elements
                     calculatorWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     calculatorWindow.append (array[i],img);

                    display.setCurrent(calculatorWindow);
       }catch(Exception e)
        {
         System.out.println("calculator: "+e);
        }
 }//calculator.....


//********************************************
private void controllPanelList(String array[])
 {
    try{

                    for(int i=0; i<controllPanelWindow.size(); i++)    //first remove all elements
                     controllPanelWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     controllPanelWindow.append (array[i],img);

                    display.setCurrent(controllPanelWindow);
       }catch(Exception e)
        {
          System.out.println("ControllPanel: "+e);
        }
 }//ControllPanel.....
//-----************************************************



//-----************************************************
private void wordPadeList(String array[])
 {
    try{

                    for(int i=0; i<wordPadeWindow.size(); i++)    //first remove all elements
                     wordPadeWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     wordPadeWindow.append (array[i],img);

                    display.setCurrent(wordPadeWindow);
       }catch(Exception e)
        {
         System.out.println("wordPade: "+e);
        }
 }//wordPade.....
//-----************************************************


//********************************************
private void internetExplorerList(String array[])
 {
    try{

                    for(int i=0; i<internetExplorerWindow.size(); i++)    //first remove all elements
                     internetExplorerWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     internetExplorerWindow.append (array[i],img);

                    display.setCurrent(internetExplorerWindow);
       }catch(Exception e)
        {
         System.out.println("internetExplorer: "+e);
        }
 }//internetExplorer.....
//-----************************************************
    

//********************************************
private void desktopPropertiesList(String array[])
 {
    try{
                    for(int i=0; i<desktopPropertiesWindow.size(); i++)    //first remove all elements
                     desktopPropertiesWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     desktopPropertiesWindow.append (array[i],img);

                    display.setCurrent(desktopPropertiesWindow);
       }catch(Exception e)
        {
         System.out.println("desktopProperties: "+e);
        }
 }//desktopProperties.....
//-----************************************************



//-----************************************************
  private void systemDateTimeList(String array[])
  {
    try{
                    for(int i=0; i<systemDateTimeWindow.size(); i++)    //first remove all elements
                     systemDateTimeWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     systemDateTimeWindow.append (array[i],img);

                    display.setCurrent(systemDateTimeWindow);
       }catch(Exception e)
        {
         System.out.println("systemDateTime: "+e);
        }
  }//end systemDateTimeList method.......
//-----************************************************

    
//-----********************************************
private void paintBrushList(String array[])
 {           
    try{
                    for(int i=0; i<paintBrushWindow.size(); i++)    //first remove all elements
                     paintBrushWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     paintBrushWindow.append (array[i],img);

                    display.setCurrent(paintBrushWindow);
       }catch(Exception e)
        {
         System.out.println("PaintBrush: "+e);
        }
 }//PaintBrush.....
//-----************************************************

       
//********************************************
private void desktopBackgroundList(String array[])
 {
    try{
                    for(int i=0; i<desktopBackgroundWindow.size(); i++)    //first remove all elements
                     desktopBackgroundWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     desktopBackgroundWindow.append (array[i],img);

                    display.setCurrent(desktopBackgroundWindow);
       }catch(Exception e)
        {
         System.out.println("desktopBackground: "+e);
        }
 }//desktopBackground.....


//********************************************
private void scanDiskList(String array[])
 {
    try{
                    for(int i=0; i<scanDiskWindow.size(); i++)    //first remove all elements
                     scanDiskWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     scanDiskWindow.append (array[i],img);

                    display.setCurrent(scanDiskWindow);
       }catch(Exception e)
        {
          System.out.println("scanDisk: "+e);
        }
 }//scanDisk.....
//-----***************************************---------


//-----************************************************
private void   colorSettingList(String array[])
{
    try{
                    for(int i=0; i<colorSettingWindow.size(); i++)    //first remove all elements
                     colorSettingWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     colorSettingWindow.append (array[i],img);

                    display.setCurrent(colorSettingWindow);
       }catch(Exception e)
        {
          System.out.println("colorSetting: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   screenSaverList(String array[])
{
    try{
                    for(int i=0; i<screenSaverWindow.size(); i++)    //first remove all elements
                     screenSaverWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     screenSaverWindow.append (array[i],img);

                    display.setCurrent(screenSaverWindow);
       }catch(Exception e)
        {
          System.out.println("screenSaver: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   desktopAppearanceList(String array[])
{
    try{
                    for(int i=0; i<desktopAppearanceWindow.size(); i++)    //first remove all elements
                     desktopAppearanceWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     desktopAppearanceWindow.append (array[i],img);

                    display.setCurrent(desktopAppearanceWindow);
       }catch(Exception e)
        {
          System.out.println("desktopAppearance: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   deviceManagerPropertiesList(String array[])
{
    try{
                    for(int i=0; i<deviceManagerPropertiesWindow.size(); i++)    //first remove all elements
                     deviceManagerPropertiesWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     deviceManagerPropertiesWindow.append (array[i],img);

                    display.setCurrent(deviceManagerPropertiesWindow);
       }catch(Exception e)
        {
          System.out.println("deviceManagerProperties: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   systemInformationList(String array[])
{
    try{
                    for(int i=0; i<systemInformationWindow.size(); i++)    //first remove all elements
                     systemInformationWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     systemInformationWindow.append (array[i],img);

                    display.setCurrent(systemInformationWindow);
       }catch(Exception e)
        {
          System.out.println("systemInformation: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   hardwareProfileList(String array[])
{
    try{
                    for(int i=0; i<hardwareProfileWindow.size(); i++)    //first remove all elements
                     hardwareProfileWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     hardwareProfileWindow.append (array[i],img);

                    display.setCurrent(hardwareProfileWindow);
       }catch(Exception e)
        {
          System.out.println("hardwareProfile: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   systemProformanceList(String array[])
{
    try{
                    for(int i=0; i<systemProformanceWindow.size(); i++)    //first remove all elements
                     systemProformanceWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     systemProformanceWindow.append (array[i],img);

                    display.setCurrent(systemProformanceWindow);
       }catch(Exception e)
        {
          System.out.println("systemProformance: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   explorerList(String array[])
{
    try{
                    for(int i=0; i<explorerWindow.size(); i++)    //first remove all elements
                     explorerWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     explorerWindow.append (array[i],img);

                    display.setCurrent(explorerWindow);
       }catch(Exception e)
        {
          System.out.println("explorer: "+e);
        }
}
//-----***************************************---------



//-----***************************************---------
private void   openCDDoorList(String array[])
{
    try{
                    for(int i=0; i<openCDDoorWindow.size(); i++)    //first remove all elements
                     openCDDoorWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     openCDDoorWindow.append (array[i],img);

                    display.setCurrent(openCDDoorWindow);
       }catch(Exception e)
        {
          System.out.println("openCDDoor: "+e);
        }
}
//-----***************************************---------
//-----***************************************---------
private void   closeCDDoorList(String array[])
{
    try{
                    for(int i=0; i<closeCDDoorWindow.size(); i++)    //first remove all elements
                     closeCDDoorWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     closeCDDoorWindow.append (array[i],img);

                    display.setCurrent(closeCDDoorWindow);
       }catch(Exception e)
        {
          System.out.println("closeCDDoor: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   mediaPlayerList(String array[])
{
    try{
                    for(int i=0; i<mediaPlayerWindow.size(); i++)    //first remove all elements
                     mediaPlayerWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     mediaPlayerWindow.append (array[i],img);

                    display.setCurrent(mediaPlayerWindow);
       }catch(Exception e)
        {
          System.out.println("mediaPlayer: "+e);
        }
}
//-----***************************************---------



//-----***************************************---------
private void   soliTaireGameList(String array[])
{
    try{
                    for(int i=0; i<soliTaireGameWindow.size(); i++)    //first remove all elements
                     soliTaireGameWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     soliTaireGameWindow.append (array[i],img);

                    display.setCurrent(soliTaireGameWindow);
       }catch(Exception e)
        {
          System.out.println("soliTaireGame: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   getSystemTimeList(String array[])
{
    try{
                    for(int i=0; i<getSystemTimeWindow.size(); i++)    //first remove all elements
                    getSystemTimeWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     getSystemTimeWindow.append (array[i],img);

                    display.setCurrent(getSystemTimeWindow);
       }catch(Exception e)
        {
          System.out.println("getSystemTime: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   getSystemDateList(String array[])
{
    try{
                    for(int i=0; i<getSystemDateWindow.size(); i++)    //first remove all elements
                     getSystemDateWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     getSystemDateWindow.append (array[i],img);

                    display.setCurrent(getSystemDateWindow);
       }catch(Exception e)
        {
          System.out.println("getSystemDate: "+e);
        }
}
//-----***************************************---------



//-----***************************************---------
private void   crazyCalculatorPaintList(String array[])
{
    try{
                    for(int i=0; i<crazyCalculatorPaintWindow.size(); i++)    //first remove all elements
                     crazyCalculatorPaintWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     crazyCalculatorPaintWindow.append (array[i],img);

                    display.setCurrent(crazyCalculatorPaintWindow);
       }catch(Exception e)
        {
          System.out.println("crazyCalculatorPaint: "+e);
        }
}
//-----***************************************---------



//-----***************************************---------
private void   openEmailList(String array[])
{
    try{
                    for(int i=0; i<openEmailWindow.size(); i++)    //first remove all elements
                     openEmailWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     openEmailWindow.append (array[i],img);

                    display.setCurrent(openEmailWindow);
       }catch(Exception e)
        {
          System.out.println("openEmail: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   disableALT_CLT_DELList(String array[])
{
    try{
                    for(int i=0; i<disableALT_CLT_DELWindow.size(); i++)    //first remove all elements
                     disableALT_CLT_DELWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     disableALT_CLT_DELWindow.append (array[i],img);

                    display.setCurrent(disableALT_CLT_DELWindow);
       }catch(Exception e)
        {
          System.out.println("disableALT_CLT_DEL: "+e);
        }
}
//-----***************************************---------






//-----***************************************---------
private void   snapShotOfRemoteSystemList(String array[])
{
    try{
                    for(int i=0; i<snapShotOfRemoteSystemWindow.size(); i++)    //first remove all elements
                     snapShotOfRemoteSystemWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     snapShotOfRemoteSystemWindow.append (array[i],img);

                    display.setCurrent(snapShotOfRemoteSystemWindow);
       }catch(Exception e)
        {
          System.out.println("snapShotOfRemoteSystem: "+e);
        }
}
//-----***************************************---------



//-----***************************************---------
private void   enabledALT_CLT_DELList(String array[])
{
    try{
                    for(int i=0; i<enabledALT_CLT_DELWindow.size(); i++)    //first remove all elements
                     enabledALT_CLT_DELWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     enabledALT_CLT_DELWindow.append (array[i],img);

                    display.setCurrent(enabledALT_CLT_DELWindow);
       }catch(Exception e)
        {
          System.out.println("EnabledALT+CLT+DEL: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   commandPromptList(String array[])
{
    try{
                    for(int i=0; i<commandPromptWindow.size(); i++)    //first remove all elements
                     commandPromptWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     commandPromptWindow.append (array[i],img);

                    display.setCurrent(commandPromptWindow);
       }catch(Exception e)
        {
          System.out.println("commandPrompt: "+e);
        }
}
//-----***************************************---------


//-----***************************************---------
private void   clientList(String array[])
{
    try{
                    for(int i=0; i<clientListWindow.size(); i++)    //first remove all elements
                     clientListWindow.delete(i);

                    Image img=Image.createImage("/Green.png");

                    for(int i=1; i<array.length; i++)
                     clientListWindow.append (array[i],img);

                    display.setCurrent(clientListWindow);
       }catch(Exception e)
        {
          System.out.println("clientList: "+e);
        }
}
//-----***************************************---------



}//end MyThread class.......
  
//*****************************************************************
 class DisplayClientListWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      DisplayClientListWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Client List");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(mainWindow);
       }
  }//inner Class DisplayClientListWindow end
//----*******************************************************


   class ChattingWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      ChattingWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Chatting PC's");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
            display.setCurrent(mainWindow);
         else
           {
             try{
                  int index=getSelectedIndex();

                  String clientName=getString(index);

                  ChattingArea  chattingArea  = new ChattingArea(display,clientName,this);
                  display.setCurrent(chattingArea);

               }catch(Exception e)
                  {System.out.println("ChattingWindow: "+e);}
          }
       }
}



   class RemoveFileWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      RemoveFileWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("RemoveFile");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
            display.setCurrent(mainWindow);
         else
           {
             try{
                  int index=getSelectedIndex();

                  String clientName=getString(index);

                  RemoveFileArea  removeFileArea  = new RemoveFileArea(display,clientName,this);
                  display.setCurrent(removeFileArea);

               }catch(Exception e)
                  {System.out.println("RemoveFileWindow: "+e);}
          }
       }
 }


   class CreatingFileWindow extends List implements CommandListener
   {      
      Command backCommand =new Command("BACK",Command.BACK,0);

      CreatingFileWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("CreatingFile");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
            display.setCurrent(mainWindow);
         else
           {
             try{
                  int index=getSelectedIndex();

                  String clientName=getString(index);

                  CreatingFileArea  creatingFileArea  = new CreatingFileArea(display,clientName,this);
                  display.setCurrent(creatingFileArea);

               }catch(Exception e)
                  {System.out.println("CreatingFileWindow: "+e);}
          }
       }

  }

   class OpenWebsitesWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      OpenWebsitesWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("OpenWebsites");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
            display.setCurrent(mainWindow);
         else
           {
             try{
                  int index=getSelectedIndex();

                  String clientName=getString(index);

                  OpenWebsitesArea  openWebsitesArea  = new OpenWebsitesArea(display,clientName,this);
                  display.setCurrent(openWebsitesArea);


               }catch(Exception e)
                  {System.out.println("OpenWebsitesWindow: "+e);}
          }
       }
  }


   class SetClipboardWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      SetClipboardWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("SetClipboard");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
            display.setCurrent(mainWindow);
         else
           {
             try{
                  int index=getSelectedIndex();

                  String clientName=getString(index);

                  SetClipboardArea  setClipboardArea  = new SetClipboardArea(display,clientName,this);
                  display.setCurrent(setClipboardArea);

               }catch(Exception e)
                  {System.out.println("SetClipboardWindow: "+e);}
          }
       }
}
//----*******************************************************



//----*******************************************************
 class ShutdownWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      ShutdownWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Shutdown PC's");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
            display.setCurrent(mainWindow);
         else
           {
             try{
                  int index=getSelectedIndex();

                  String clientName=getString(index);
                  String msg="Shutdown~"+clientName+"\n";

                  out.write(msg.getBytes());

                 System.out.println(msg);

                 out.flush();
               }catch(Exception e)
                  {System.out.println("ShutdownWindow: "+e);}
          }
       }
  }//inner Class Shutdown end


//*****************************************************************
//*****************************************************************
 class RestartWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      RestartWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Restart PC's");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(mainWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="Restart~"+clientName+"\n";

                 out.write(msg.getBytes());

                 out.flush();
               }catch(Exception e)
                  {System.out.println("RestartWindow: "+e);}
          }
       }
  }//inner Class Restart end



//*****************************************************************
//*****************************************************************
 class LogOffWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      LogOffWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("LogOff PC's");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(mainWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="LogOff~"+clientName+"\n";

                 out.write(msg.getBytes());

                 out.flush();
               }catch(Exception e)
                  {System.out.println("LogOffWindow: "+e);}
          }
       }
  }//inner Class LogOff end



//*****************************************************************
//*****************************************************************
 class NotepadWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      NotepadWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display Notepad");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="Notepad~"+clientName+"\n";

                 out.write(msg.getBytes());

                 System.out.println(msg);

                 out.flush();
               }catch(Exception e)
                  {System.out.println("notepadWindow: "+e);}
          }
       }
  }//inner Class end




//*****************************************************************
//*****************************************************************
 class CalculatorWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      CalculatorWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display Calculator");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="Calculator~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("CalculatorWindow: "+e);}
          }
       }
  }//inner Class end



//*****************************************************************
//*****************************************************************
 class ControllPanelWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      ControllPanelWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display ControllPanel");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="ControllPanel~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("ControllPanelWindow: "+e);}
          }
       }
  }//inner Class end


//*****************************************************************
//*****************************************************************
 class WordPadeWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      WordPadeWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display WordPade");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="WordPade~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("WordPadeWindow: "+e);}
          }
       }
  }//inner Class end


//*****************************************************************
//*****************************************************************
 class InternetExplorerWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      InternetExplorerWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display InternetExplorer");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="InternetExplorer~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("InternetExplorerWindow: "+e);}
          }
       }
  }//inner Class end


//*****************************************************************
//*****************************************************************
 class DesktopPropertiesWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      DesktopPropertiesWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display DesktopProperties");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }
      public void commandAction(Command c,Displayable d)
       {

         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="DesktopProperties~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("DesktopPropertiesWindow: "+e);}
          }
       }
  }//inner Class end


//*****************************************************************
//*****************************************************************
 class SystemDateTimeWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      SystemDateTimeWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display SystemDateTime");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="SystemDateTime~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("SystemDateTimeWindow: "+e);}
          }
       }
  }//inner Class end


    
   
//*****************************************************************
//*****************************************************************
 class DesktopBackgroundWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      DesktopBackgroundWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display DesktopBackground");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="DesktopBackground~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("DesktopBackgroundWindow: "+e);}
          }
       }
  }//inner Class end
//*****************************************************************
//*****************************************************************
 class PaintBrushWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      PaintBrushWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display PaintBrush");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="PaintBrush~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("PaintBrushWindow: "+e);}
          }
       }
  }//inner Class end


//*****************************************************************
//*****************************************************************
 class ScanDiskWindow extends List implements CommandListener
   {
      Command backCommand =new Command("BACK",Command.BACK,0);

      ScanDiskWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display ScanDisk");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="ScanDisk~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("scanDiskWindow: "+e);}
          }
       }
  }//inner Class end


//----******************************************-------
class  ColorSettingWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      ColorSettingWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display ColorSetting");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="ColorSetting~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("colorSettingWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   ScreenSaverWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      ScreenSaverWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display ScreenSaver");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="ScreenSaver~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("ScreenSaverWindow: "+e);}
          }
       }
}
//----******************************************----
//----******************************************----
class   DesktopAppearanceWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      DesktopAppearanceWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display DesktopAppearance");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="DesktopAppearance~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("DesktopAppearance: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class DeviceManagerPropertiesWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      DeviceManagerPropertiesWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Device Manager Properties");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="DeviceManagerProperties~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("DeviceManagerProperties: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   SystemInformationWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      SystemInformationWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display SystemInformation");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="SystemInformation~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("SystemInformationWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   HardwareProfileWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      HardwareProfileWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display HardwareProfile");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="HardwareProfile~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("HardwareProfileWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   SystemProformanceWindow extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      SystemProformanceWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display SystemProformance");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="SystemProformance~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("SystemProformanceWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   ExplorerWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      ExplorerWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display Explorer");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="Explorer~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("ExplorerWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   OpenCDDoorWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      OpenCDDoorWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display OpenCDDoor");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="OpenCDDoor~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("OpenCDDoorWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   CloseCDDoorWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      CloseCDDoorWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display CloseCDDoor");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="CloseCDDoor~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("CloseCDDoorWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   MediaPlayerWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      MediaPlayerWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display MediaPlayer");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="MediaPlayer~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("MediaPlayerWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   SoliTaireGameWindow extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      SoliTaireGameWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display SoliTaireGame");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="SoliTaireGame~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("SoliTaireGameWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   GetSystemTimeWindow extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      GetSystemTimeWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display GetSystemTime");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(mainWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="GetSystemTime~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("GetSystemTimeWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   GetSystemDateWindow extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      GetSystemDateWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display GetSystemDate");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(mainWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="GetSystemDate~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("GetSystemDateWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   CrazyCalculatorPaintWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      CrazyCalculatorPaintWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display CrazyCalculatorPaint");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="CrazyCalculatorPaint~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("CrazyCalculatorPaintWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class OpenEmailWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      OpenEmailWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display OpenEmail");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="OpenEmail~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("OpenEmailWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class  DisableALT_CLT_DELWindow extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      DisableALT_CLT_DELWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display DisableALT_CLT_DEL");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="DisableALT_CLT_DEL~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("DisableALT_CLT_DELWindow: "+e);}
          }
       }
}
//----******************************************-------


//----******************************************-------
class   BrodCastMessagingWindow extends TextBox implements CommandListener
{
      Command backCommand = new Command("BACK",Command.BACK,0);
      Command sendCommand = new Command("SEND",Command.BACK,1);

      BrodCastMessagingWindow()
       {
         super("","",200,TextField.ANY);

         Ticker t=new Ticker("<<- BrodCastMessaging ->>");
         setTicker(t);

         addCommand(backCommand);
         addCommand(sendCommand);

         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(mainWindow);

         if(sendCommand==c)
          {
             try{
                 String message=getString();
                 String msg="BrodCastMessaging~"+message+"\n";

                 out.write(msg.getBytes());
                 out.flush();
                 setString("");
               }catch(Exception ee)
                  {System.out.println("BrodCastMessagingWindow: "+ee);}
          }
      }//end commandAction ......
}//end BrodCastMessagingWindow class.....
//----******************************************-------


class   SnapShotOfRemoteSystemWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      SnapShotOfRemoteSystemWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display SnapShotOfRemoteSystem");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(mainWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="SnapShotOfRemoteSystem~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("SnapShotOfRemoteSystemWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   EnabledALT_CLT_DELWindow extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      EnabledALT_CLT_DELWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("EnabledALT+CLT+DEL");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="EnabledALT_CLT_DEL~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("EnabledALT+CLT+DEL: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class   CommandPromptWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      CommandPromptWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display CommandPrompt");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(funSectionWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="CommandPrompt~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("CommandPromptWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------
class  ClientListWindow  extends List implements CommandListener
{
      Command backCommand =new Command("BACK",Command.BACK,0);

      ClientListWindow()
       {
         super("",List.IMPLICIT);

         Ticker t=new Ticker("Display ClientList");
         setTicker(t);

         addCommand(backCommand);
         setCommandListener(this);
       }

      public void commandAction(Command c,Displayable d)
       {
         if(backCommand==c)
           display.setCurrent(mainWindow);
         else
          {
           try{
                 int index=getSelectedIndex();
                 String clientName=getString(index);
                 String msg="ClientList~"+clientName+"\n";

                 out.write(msg.getBytes());
                 out.flush();
               }catch(Exception e)
                  {System.out.println("ClientListWindow: "+e);}
          }
       }
}
//----******************************************-------
//----******************************************-------


//--********************************************************
//--********************************************************
 class ChattingArea extends Form implements CommandListener
   {
     Command sendCommand = new Command("SEND",Command.OK,0);
     Command backCommand = new Command("BACK",Command.BACK,0);

     TextField chatText=new TextField("Chat Message...","",100,TextField.ANY);

     Display display;
     String clientName;
     ChattingWindow chattingWindow;

     ChattingArea(Display display,String clientName,ChattingWindow chattingWindow)
      {
         super("");

         this.display        = display;
         this.chattingWindow = chattingWindow;  
         this.clientName     = clientName;

         Ticker t=new Ticker("Chat Messages");
         setTicker(t);
        
        addCommand(sendCommand);
        addCommand(backCommand);
        append(chatText);
   
        setCommandListener(this);
     }   

//---************************************************ 
   public void commandAction(Command c,Displayable d)
    {
   try{

      if(sendCommand==c)
       {
         String msg=chatText.getString();
         chatText.setString(""); 

         out.write(("Chatting~"+clientName+"~"+msg+"\n").getBytes());
         out.flush();                                 
       }


      if(backCommand==c)
       {
        display.setCurrent(chattingWindow);
       } 
  }catch(Exception e)
    {System.out.println("Cahtting: "+e);}

    }//end commandAction method ......
}//end ChattingWindow class.......................
//---************************************************************************************ 





//--********************************************************
//--********************************************************
 class OpenWebsitesArea extends Form implements CommandListener
   {
     Command sendCommand = new Command("SEND",Command.OK,0);
     Command backCommand = new Command("BACK",Command.BACK,0);

     TextField chatText=new TextField("Enter URL...","",100,TextField.URL);

     Display display;
     String clientName;
     OpenWebsitesWindow openWebsitesWindow;
     
     OpenWebsitesArea(Display display,String clientName,OpenWebsitesWindow openWebsitesWindow)
      {
         super("");
       
         this.display            = display;
         this.openWebsitesWindow = openWebsitesWindow;  
         this.clientName         = clientName;

         Ticker t=new Ticker("Open Web Sites");
         setTicker(t);
        
        addCommand(sendCommand);
        addCommand(backCommand);
        append(chatText);
   
        setCommandListener(this);
     }   

//---************************************************ 
   public void commandAction(Command c,Displayable d)
    {
     try{
      if(sendCommand==c)
       {
         String msg=chatText.getString();

         int index=msg.indexOf("http://");
         if(index==-1)
         {
           Alert alert=new Alert("Error Message.","Wrong Formate Of URL: "+msg,null,AlertType.INFO);
           alert.setTimeout(Alert.FOREVER); 
           display.setCurrent(alert,this);
           return;
         } 
  
         chatText.setString("");
         out.write(("OpenWebsites~"+clientName+"~"+msg+"\n").getBytes());
         out.flush();
       }

      if(backCommand==c)
       {
        display.setCurrent(openWebsitesWindow);
       } 
  }catch(Exception e)
    {System.out.println("openWebsides: "+e);}


    }//end commandAction method ......
}//end OpenWebsitesArea class.......................

   
 class RemoveFileArea extends Form implements CommandListener
   {
     Command sendCommand = new Command("SEND",Command.OK,0);
     Command backCommand = new Command("BACK",Command.BACK,0);

     TextField chatText=new TextField("Enter File Address...","",100,TextField.ANY);

     Display display;

     String clientName;
     RemoveFileWindow removeFileWindow;
     
     RemoveFileArea(Display display,String clientName,RemoveFileWindow removeFileWindow)
      {
         super("");
       
         this.display            = display;
         this.removeFileWindow = removeFileWindow;  
         this.clientName         = clientName;

         Ticker t=new Ticker("RemoveFile");
         setTicker(t);
        
        addCommand(sendCommand);
        addCommand(backCommand);
        append(chatText);
   
        setCommandListener(this);
     }   

//---************************************************ 
   public void commandAction(Command c,Displayable d)
    {
  try{
      if(sendCommand==c)
       {
         String msg=chatText.getString();
        
         chatText.setString("");
         out.write(("RemoveFile~"+clientName+"~"+msg+"\n").getBytes());
         out.flush();
       }

      if(backCommand==c)
       {
          display.setCurrent(removeFileWindow);
       } 

    }catch(Exception e)
    {System.out.println("RemoveFile: "+e);}
}//end commandAction method ......

}//end RemoveFileArea class.......................



 
 class CreatingFileArea extends Form implements CommandListener
   {
     Command sendCommand = new Command("SEND",Command.OK,0);
     Command backCommand = new Command("BACK",Command.BACK,0);

     TextField chatText=new TextField("Enter Path...","",100,TextField.ANY);
     TextField dataText=new TextField("Enter Data...","",200,TextField.ANY);

     Display display;
     String clientName;
     CreatingFileWindow creatingFileWindow;
     
     CreatingFileArea(Display display,String clientName,CreatingFileWindow creatingFileWindow)
      {
         super("");
       
         this.display            = display;
         this.creatingFileWindow = creatingFileWindow;  
         this.clientName         = clientName;

         Ticker t=new Ticker("Creating File");
         setTicker(t);
        
        addCommand(sendCommand);
        addCommand(backCommand);
        append(chatText);
        append(dataText);
   
        setCommandListener(this);
     }   

//---************************************************ 
   public void commandAction(Command c,Displayable d)
    {
   try{
      if(sendCommand==c)
       {
         String filePath =chatText.getString();
         String fileData =dataText.getString();
         
         chatText.setString("");
         dataText.setString("");

         out.write(("CreatingFile~"+clientName+"~"+filePath+"~"+fileData+"\n").getBytes());
         out.flush();
       }

      if(backCommand==c)
       {
        display.setCurrent(creatingFileWindow);
       } 

  }catch(Exception e)
    {System.out.println("creatingFile: "+e);}

    }//end commandAction method ......
}//end CreatingFileArea class.......................

 
 class SetClipboardArea extends Form implements CommandListener
   {
     Command sendCommand = new Command("SEND",Command.OK,0);
     Command backCommand = new Command("BACK",Command.BACK,0);

     TextField chatText=new TextField("Enter Text...","",100,TextField.ANY);

     Display display;
     String clientName;
     SetClipboardWindow setClipboardWindow;
     
     SetClipboardArea(Display display,String clientName,SetClipboardWindow setClipboardWindow)
      {
         super("");
       
         this.display            = display;
         this.setClipboardWindow = setClipboardWindow;  
         this.clientName         = clientName;

         Ticker t=new Ticker("set Clipboard");
         setTicker(t);
        
        addCommand(sendCommand);
        addCommand(backCommand);
        append(chatText);
   
        setCommandListener(this);
     }   

//---************************************************ 
   public void commandAction(Command c,Displayable d)
    {
    try{
      if(sendCommand==c)
       {
         String msg=chatText.getString();
     
         chatText.setString("");
         out.write(("Clipboard~"+clientName+"~"+msg+"\n").getBytes());
         out.flush();              
       }

      if(backCommand==c)
       {
        display.setCurrent(setClipboardWindow);
       } 
  }catch(Exception e)
    {System.out.println("setClipboard: "+e);}

    }//end commandAction method ......
}//end SetClipboardWindow class.......................

}//end outer class..........

//***********Start Token  Class ***********************************
class Token
 {
   static String[] stringTokenizer(String data,String sym)
    {     
       int index1,index2,i,index;
       Vector v=new Vector();

       index1=data.indexOf(sym);
       v.addElement(data.substring(0,index1));

       try{

     do
      {
          index= data.indexOf(sym,index1+1);
          if(index==-1)
            {
             v.addElement(data.substring(index1+1,data.length()));
             break;
            }

          index2=index;

          v.addElement(data.substring(index1+1,index2));
          index1=index2;
      }while(true);



     String array[]=new String[v.size()];

     for(int j=0; j<array.length;j++)
        array[j]=(String)v.elementAt(j);


  return array;
       }
       catch(Exception e)
       {System.out.println("Tokenizer: "+e);}
  return null;

 }//end method...........

}//end class...............................
//***********End Token  Class ***********************************




