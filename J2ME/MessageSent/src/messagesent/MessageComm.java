package messagesent;

import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

/**
 *
 * @author Jay Kumar
 */
public class MessageComm {

    static MessageConnection conn;
    public static void send(String no , String msg)throws Exception{
        conn=(MessageConnection)Connector.open("sms://"+no);
        TextMessage textmessage = (TextMessage) conn.newMessage(MessageConnection.TEXT_MESSAGE);
        textmessage.setAddress("sms://"+no);
        textmessage.setPayloadText(msg);
        conn.send(textmessage);
    }
}
