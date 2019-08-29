package Service;

import Entity.Bean.SensorL;
import Entity.Bean.funcList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.SendPhoneData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class Always implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
//        if ((int)Integer.valueOf(tempMList.get(1).getData().toString()) > 50) {
//            SendPhoneData.sendData("小便");
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        //如果传进来有中文字符 可以使用 URLEncoder.encode 方法进行编码转换
                        //String start = "杭州";    //转换前
                        //start = URLEncoder.encode(start, "utf-8");  //转换中
                        //System.out.printin(start)   //转换后  %E6%9D%AD%E5%B7%9E
                        URL url = new URL("http://192.168.0.1/cgi-bin/node.cgi");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty(
                                "User-Agent",
                                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1096.1 Safari/536.6");
                        conn.setRequestProperty("content-type",
                                "application/x-www-form-urlencoded;charset=UTF-8");
                        conn.setDoOutput(true);
                        if (conn.getResponseCode() == 302) {
                            System.out.println(302);
                            return ;
                        }
                        if (conn.getResponseCode() == 200) {
                            System.out.println(200);
                        }
                        BufferedReader rd = new BufferedReader(new InputStreamReader(
                                conn.getInputStream(), "utf-8"));
                        StringBuffer sb = new StringBuffer();
                        String s = "";
                        while ((s = rd.readLine()) != null) {
                            sb.append(s);
                        }
                        // System.out.println(sb);
                        if (sb.length() == 0) {
                            sb.append("[]");
                        }
                        String result;
                        result = sb.toString();
                        List<SensorL> list = JSONArray.parseArray(result, SensorL.class);
                        System.out.println(result); //到这里就获取到结果了result是结果
                        List<funcList> tempMList = JSONArray.parseArray(list.get(1).getFuncList(), funcList.class);
                        System.out.println(tempMList.size()+":size");
                        System.out.println("小明尿不湿温度： " + tempMList.get(0).getData().toString() + " ℃");
                        System.out.println("小明尿不湿湿度： " + tempMList.get(1).getData().toString() + " 湿度");
                        if ((int)Integer.valueOf(tempMList.get(1).getData().toString()) > 50) {
                            SendPhoneData.sendData("小明小便啦，爸爸妈妈快去处理吧！");
                        }

                        List<funcList> tempJList = JSONArray.parseArray(list.get(2).getFuncList(), funcList.class);
                        System.out.println("小军尿不湿温度： " + tempJList.get(0).getData().toString() + " ℃");
                        System.out.println("小军尿不湿湿度： " + tempJList.get(1).getData().toString() + " 湿度");
                        if ((int)Integer.valueOf(tempMList.get(1).getData().toString()) > 50) {
                            SendPhoneData.sendData("小军小便啦，爸爸妈妈快去处理吧！");
                        }
                        rd.close();
                        conn.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
