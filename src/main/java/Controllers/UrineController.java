package Controllers;

import Entity.Baby;
import Entity.Sensor;
import Entity.Urine;
import Service.BabyService;
import Service.IUrineService;
import Service.SensorService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "",method = RequestMethod.POST)
public class UrineController {
    @Autowired
    private IUrineService service;

    @Autowired
    private BabyService babyService;
    @Autowired
    private SensorService sensorService;

    @RequestMapping(value = "/getAllBabys",method = RequestMethod.POST)
    public String Gett(){
//			System.out.println(requestBody.getParameter(""));
        List<Baby> urineList = babyService.list(0,10);

        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(urineList);
        System.out.println("babys:"+jsonResult);
        return jsonResult;
    }

    @RequestMapping(value = "babyCheck",method = RequestMethod.POST)
    public String Get(){
//        System.out.println(requestBody.getParameter(""));
        List<Urine> urineList2 = service.selectByCondition(new Urine());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(urineList2);
        System.out.println(jsonResult);
        return jsonResult;
    }

    @RequestMapping(value = "getSensorsData",method = RequestMethod.POST)
    public String Getsensor(){
        List<Sensor> sensorList = sensorService.listAllSensor();
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(sensorList);
        System.out.println("getSensorsData"+jsonResult);
        return jsonResult;
    }
    @RequestMapping(value = "/deleteByName",method = RequestMethod.POST)
    public void deleteByName(@RequestParam(value = "name",defaultValue = "no") String s){
        System.out.println(s);

        service.deleteRecord(s.toString());
    }

    @RequestMapping(value = "/increaseRecord")
    public String increaseRecord(HttpServletRequest request, HttpServletResponse response){
        System.out.println("insert");
        Urine newUrine = new Urine();

        String urineId = request.getParameter("urineId");
        String time = request.getParameter("time");
        String cateUrine = request.getParameter("cateUrine");

        newUrine.setUrineId("d");
        newUrine.setTime("d");
        newUrine.setCateUrine("df");

        service.insertRecord(newUrine);
        return "sfsd";
    }


//    @RequestMapping(value = "http://192.168.0.1/cgi-bin/node.cgi",method = RequestMethod.GET)
//    public String Gett(){
//        List<Urine> urineList = service.selectByCondition(new Urine());
//        System.out.println("999999");
//        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(urineList);
//        return jsonResult;
//
//
//    }
}
