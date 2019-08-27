package Controllers;

import Entity.Baby;
import Entity.Urine;
import Service.IUrineService;
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

    @RequestMapping(value = "urineCheck",method = RequestMethod.POST)
    public String Get(HttpServletRequest requestBody){
        System.out.println(requestBody.getParameter(""));
        List<Urine> urineList = service.selectByCondition(new Urine());

        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(urineList);
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


    @RequestMapping(value = "http://192.168.0.1/cgi-bin/node.cgi",method = RequestMethod.GET)
    public String Gett(){
        List<Urine> urineList = service.selectByCondition(new Urine());
        System.out.println("999999");
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(urineList);
        return jsonResult;


    }
}
