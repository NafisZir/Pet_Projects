import javax.swing.*;
import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * created by Nafis on 27.12.2020
 */

public class ChatUDP extends JFrame {
    private JTextArea tAMain;
    private JTextField tFMsg;

    private final String FRM_TITLE = "Our tiny chat";
    private final int FRM_LOC_X = 100;
    private final int FRM_LOC_Y = 100;
    private final int FRM_WIDTH = 400;
    private final int FRM_HEIGHT = 400;

    private final int PORT = 3869;
    private final String IP_BROADCAST = "192.168.1.3";

    private class thdReceiver extends Thread{
        @Override
        public void start(){
            try {
                customize();
            } catch (Exception ex) { ex.printStackTrace(); }
        }
        private void customize() throws Exception{
            DatagramSocket receiveSocket = new DatagramSocket(PORT);
             while (true){
                 byte[] receiveData = new byte[1024];
                 DatagramPacket receiverPacket = new DatagramPacket(receiveData, receiveData.length);
                 receiveSocket.receive(receiverPacket);
                 String sentence = new String(receiverPacket.getData());
                 tAMain.append(sentence);
                 tAMain.setCaretPosition(tAMain.getText().length());
             }
        }
    }

    private void btnSendHandler() throws Exception{
        DatagramSocket sendSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName(IP_BROADCAST);
        byte[] sendData;
        String sentence = "Нафис: " + tFMsg.getText() + "\n";
        tFMsg.setText("");
        sendData = sentence.getBytes("UTF-8");
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
        sendSocket.send(sendPacket);
    }

    private void frameDraw(JFrame frame){
        tFMsg = new JTextField();
        tAMain = new JTextArea(FRM_HEIGHT/19, 50);
        JScrollPane sPMain = new JScrollPane(tAMain);
        sPMain.setLocation(0,0);
        tAMain.setLineWrap(true);
        tAMain.setEditable(false);

        JButton buttonSend = new JButton();
        buttonSend.setText("Send");
        buttonSend.setToolTipText("Broadcast a message");
        buttonSend.addActionListener(e -> {
            try{
                btnSendHandler();
            }catch (Exception ex) { ex.printStackTrace(); }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(FRM_TITLE);
        frame.setLocation(FRM_LOC_X, FRM_LOC_Y);
        frame.setSize(FRM_WIDTH, FRM_HEIGHT);
        frame.setResizable(false);
        frame.getContentPane().add(BorderLayout.NORTH, sPMain);
        frame.getContentPane().add(BorderLayout.CENTER, tFMsg);
        frame.getContentPane().add(BorderLayout.EAST, buttonSend);
        frame.setVisible(true);
    }

    private void antistatic(){
        frameDraw(new ChatUDP());
        new thdReceiver().start();
    }

    public static void main(String[] args) {
        new ChatUDP().antistatic();
    }
}
