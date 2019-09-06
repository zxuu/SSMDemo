package Controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;


import Entity.Bean.SensorL;
import Entity.Bean.funcList;
import Entity.Sensor;
import Service.BabyService;
import Service.SensorService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.IP;
import util.SendPhoneData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class SensorController {
 
	 @Autowired
	 private SensorService sensorService;
	 private BabyService babyService;
	 
	 @RequestMapping("/zhe")
	   public ModelAndView zhe(String name) {
		  ModelAndView mav = new ModelAndView("zhe");
		 if(name==null){
			 List<Sensor> sensors = sensorService.list(3);
		        mav.addObject("sensor", sensors);
		 }
		 else{
			 
			 try{
	        String id = babyService.getId(name);
			 }
			catch(Exception e){
				 System.out.println("abcdef");
			 }
			 if(name.equals("小李"))
			 {
			 	String id = "0";
	        	List<Sensor> sensors = sensorService.list(Integer.parseInt(id));
	        	mav.addObject("sensor", sensors);
	        }
	        else if(name.equals("小王")){
				 String id = "1";
				 List<Sensor> sensors = sensorService.list(Integer.parseInt(id));
				 mav.addObject("sensor", sensors);
		 }
		 else {
				 List<Sensor> sensors = sensorService.list(3);
				 mav.addObject("sensor", sensors);
			 }
		 }
	        return mav;
	    }

//	int sum = 0;
	@RequestMapping(value = "/rfid", method = RequestMethod.POST)
	public void RFIDSensor(HttpServletRequest request, HttpServletResponse response) {
//		if (sum == 0) {
//
//		}i
		if(request.getParameter("key")!=null)
		{
			try {

				System.out.println("rfid------->执行了!!!!!!!!!!!!!!!!!!");
				String id = request.getParameter("key");

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
				if (sb.length() == 0) {
					sb.append("[]");
				}
				String result;
				result = sb.toString();
				List<SensorL> list = JSONArray.parseArray(result, SensorL.class);
				int num = 0;
				String[] names = new String[]{"null","null","小李","小王"};
				if (id.equals("355eb850")) {
					num = 2;
				} else {
					num = 3;
				}
//			System.out.println(result); //到这里就获取到结果了result是结果
				List<funcList> tempMList = JSONArray.parseArray(list.get(num).getFuncList(), funcList.class);
//				System.out.println(tempMList.size()+":size");
				if (tempMList.size() > 0) {
//					System.out.println(names[num]+"尿不湿温度： " + tempMList.get(0).getData().toString() + " ℃");
					System.out.println(names[num]+"尿不湿湿度： " + tempMList.get(1).getData().toString() + " 湿度");
					System.out.println(Float.valueOf(tempMList.get(1).getData().toString()) > 50);
					SendPhoneData.sendRFIDData(names[num]+",37,56");
					System.out.println(names[num]+"RFID");

					Sensor sensor = new Sensor();
					sensor.setId(0);
					sensor.setTemp(Float.valueOf(tempMList.get(0).getData().toString()));
					sensor.setHumi(Float.valueOf(tempMList.get(1).getData().toString()));
					sensor.setTime(new Date());
					sensorService.addSensor(sensor);

				} else {
					System.out.println(names[num]+"数据不对");
				}

				rd.close();	//
				conn.disconnect();	//关闭连接
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//zxuu
//	@RequestMapping(value = "getSensorsData",method = RequestMethod.POST)
//	public String Get(){
//		List<Sensor> sensorList = sensorService.listAllSensor();
//		String jsonResult = com.alibaba.fastjson.JSON.toJSONString(sensorList);
//		System.out.println("getSensorsData"+jsonResult);
//		return jsonResult;
//	}
}
