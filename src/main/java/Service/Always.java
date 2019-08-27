package Service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Always implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //如果传进来有中文字符 可以使用 URLEncoder.encode 方法进行编码转换
                    //String start = "杭州";    //转换前
                    //start = URLEncoder.encode(start, "utf-8");  //转换中
                    //System.out.printin(start)   //转换后  %E6%9D%AD%E5%B7%9E
                    URL url = new URL("http://192.168.0.1/cgi-bin/node.cgi");
                    System.out.println(url);
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
                    System.out.println(result); //到这里就获取到结果了result是结果
                    rd.close();
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
