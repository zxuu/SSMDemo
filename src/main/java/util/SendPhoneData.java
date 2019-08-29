package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class SendPhoneData {
    public static void sendData(String s){
        System.out.println("发送端启动...");
        /*
        *创建UDP传输的发送端
        * 思路：
        * 1.建立udp的socket服务（new socket)
        * 2,将要发送的数据封装到数据包中。(packet)
        * 3,通过udp的socket服务将数据包发送出去（send)
        * 4,关闭socket服务(close)

        **抛一个大异常：IOException
        */

        //1.udpsocket服务对象，使用DatagramSocket创建,可以指明本地IP和端口
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(5051);
            //2.将要发送的数据封装到数据包中
//            String str ="udp传输，udp手机端服务器终于搞定了";
            byte[] buf =s.getBytes("utf-8");
            DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.0.101"),8888);

            //3.udp发送,使用socket服务将数据包发送出去
            ds.send(dp);

            //4.关闭连接
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
