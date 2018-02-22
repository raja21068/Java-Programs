package p2pvideoconferencing;

/**
 * Title:        Live Media Transmision System based on RTP & RTCP protocols
 * Description:  This project will transfer video and audio contents on the network,
 * transmiter will take data from web-cam direct and transmit it to network and receiver will play that contents on the player on realtime mode. this implementation based on UDP protocol at transport level, at
 * application level we are developing our own protocols call RTP,RTCP
 * protocols at application level. as we know streams are only possible in TCP protocol, but RTP working on the top of UDP, RTP and RTCP provides here streams technique to be take data at realtime mode and relable this example aslo can be run on the Internet there will be no chance of losing packes RTCP protocol controlling this.
 * if this program not working please contact me thanks....
 * --------------------------------------------------------
 * Yougeshwar Khatri
 * BS-CS 3rd Year Student
 * IMCS, University of Sindh, Jamshoro.
 * Contact: yogeshwar_90@hotmail.com
 * Mobile: 03342811035
 * ---------------------------------------------------------------------
 * Mentor: Sachal Joyo (Network and Protocol designing)
 *                     (Java Technologies)
 * Title:        DatabaseManager
 * Description:  This class use to communicate with database.
 * Copyright:    Copyright (c) 2012
 * Company:      Institute of Mathematics and Computer Science, University of Sindh, Jamshoro
 * @author       Yougeshwar Khatri
 * @version      1.0
 * Date:         19 March, 2012
 */

import java.sql.*;
import java.util.Vector;

public class DatabaseManager {
    private static Connection con;

    static{
        try{
            init();
        }catch(Exception e){e.printStackTrace();}
    }
    
    private static void init()throws ClassNotFoundException, SQLException{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        String filename = "database/database.mdb";
	String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
	database+= filename.trim()+";DriverID=22;READONLY=true";
        con=DriverManager.getConnection(database);
    }
    
    public static Vector<PeerBean> getRestrictedPeers()throws SQLException{
        String query="SELECT peer_id, restricted_peer, restricted_peer, restricted_peer_address FROM restricted_peer ORDER BY restricted_peer DESC";
        System.out.println(query);

        Statement st=null;
        ResultSet result=null;

        Vector<PeerBean> v=new Vector<PeerBean>();
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            while (result.next()) {
                PeerBean bean=new PeerBean();

                bean.setPeerId(result.getInt("peer_id"));
                bean.setHostName(result.getString("restricted_peer"));
                bean.setHostAddress(result.getString("restricted_peer_address"));
                
                v.addElement(bean);
            }
            return v;
        }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
        }        
    }
    public static PeerBean getRestrictedPeer(String restrictedPeerAddress)throws SQLException{
        String query="SELECT peer_id, restricted_peer, restricted_peer_address FROM restricted_peer WHERE restricted_peer_address = '"+restrictedPeerAddress+"'";
        System.out.println(query);

        Statement st=null;
        ResultSet result=null;

        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            
            PeerBean bean = null;
            
            if (result.next()) {
                bean=new PeerBean();

                bean.setPeerId(result.getInt("peer_id"));
                bean.setHostName(result.getString("restricted_peer"));
                bean.setHostAddress(result.getString("restricted_peer_address"));
                
            }
            return bean;
        }finally{
            if(result!=null) result.close();
            if(st!=null) st.close();
        }        
    }
    public static int addRestrictionPeer(String restrictedPeer, String restrictedPeerAddress)throws SQLException{
        String query="INSERT INTO restricted_peer (restricted_peer, restricted_peer_address) VALUES ('"+restrictedPeer+"', '"+restrictedPeerAddress+"')";
        System.out.println(query);

        Statement st=null;

        try{
            st = con.createStatement();
            int record=st.executeUpdate(query);
            return record;
        }finally{
            if(st!=null) st.close();
        }
    }    
    public static int deleteRestrictionPeer(int peerId)throws SQLException{
        String query="DELETE FROM restricted_peer WHERE peer_id = " + peerId;
        System.out.println(query);

        Statement st=null;

        try{
            st = con.createStatement();
            int record=st.executeUpdate(query);
            return record;
        }finally{
            if(st!=null) st.close();
        }
    }    
}
