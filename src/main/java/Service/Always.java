package Service;

import Entity.Bean.SensorL;
import Entity.Bean.funcList;
import Entity.Sensor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IP;
import util.SendPhoneData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Service
public class Always implements InitializingBean {

    @Autowired
    private SensorService sensorService;

    @Override
    public void afterPropertiesSet() throws Exception {
        class r1 implements Runnable {
            boolean f1 = true;
            boolean f2 = true;
            @Override
            public void run() {
                f1 = true;
                f2 = true;
                while (true) {
                    try {
                        Thread.sleep(4500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        //如果传进来有中文字符 可以使用 URLEncoder.encode 方法进行编码转换
                        //String start = "杭州";    //转换前
                        //start = URLEncoder.encode(start, "utf-8");  //转换中
                        //System.out.printin(start)   //转换后  %E6%9D%AD%E5%B7%9E
                        URL url = new URL(IP.HarhoneIp);
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
                            return;
                        }
                        if (conn.getResponseCode() == 200) {
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
                        //总list
                        List<SensorL> list = JSONArray.parseArray(result, SensorL.class);
//                        System.out.println(result); //到这里就获取到结果了result是结果
                        List<funcList> tempMList = JSONArray.parseArray(list.get(1).getFuncList(), funcList.class);
//                        System.out.println(tempMList.size()+":size");
                        if (tempMList.size() > 0&&list.get(1).getMacAddr().equals("9EE15305004B1200")) {
//                            System.out.println("小李尿不湿温度： " + tempMList.get(0).getData().toString() + " ℃");
                            System.out.println("小李尿不湿湿度： " + tempMList.get(1).getData().toString() + " 湿度");
                            if (Float.parseFloat(tempMList.get(1).getData().toString()) > 50.0&&f1) {
                                SendPhoneData.sendAlertData("小李");
                                f1 = false;
                                System.out.println("小李小便啦，爸爸妈妈快去处理吧！");
                            }

                            Sensor sensor = new Sensor();
                            sensor.setId(0);
                            sensor.setTemp(Float.valueOf(tempMList.get(0).getData().toString())-12);
                            sensor.setHumi(Float.valueOf(tempMList.get(1).getData().toString()));
                            sensor.setTime(new Date());
                            sensorService.addSensor(sensor);

                        } else {
                            System.out.println("小李数据不对");
                        }

                        List<funcList> tempJList = JSONArray.parseArray(list.get(2).getFuncList(), funcList.class);
                        if (tempJList.size() > 0&&list.get(2).getMacAddr().equals("35E05305004B1200")) {
//                            System.out.println("小军尿不湿温度： " + tempJList.get(0).getData().toString() + " ℃");
                            System.out.println("小王尿不湿湿度： " + tempJList.get(1).getData().toString() + " 湿度");
                            if (Float.parseFloat(tempJList.get(1).getData().toString()) > 50.0&&f2
                                    ) {
                                f2 = false;
                                SendPhoneData.sendAlertData("小王");
                                System.out.println("小王小便啦，爸爸妈妈快去处理吧！");
                            }
                            Sensor sensor2 = new Sensor();
                            sensor2.setId(1);
                            sensor2.setTemp(Float.valueOf(tempJList.get(0).getData().toString())-12);
                            sensor2.setHumi(Float.valueOf(tempJList.get(1).getData().toString()));
                            sensor2.setTime(new Date());
                            sensorService.addSensor(sensor2);
                        } else {
                            System.out.println("小王数据不对");
                        }
                        rd.close();
                        conn.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                //开始计时
                    System.out.println("建立进程！！！！！");
                    Thread t1 = new Thread(new r1());
                    t1.start();
                //时间到,
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t1.interrupt();
                    System.out.println("进程已销毁！！！！！");
                }
            }
        }).start();
    }

}
