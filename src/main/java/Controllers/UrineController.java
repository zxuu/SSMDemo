package Controllers;

import Entity.Urine;
import Service.IUrineService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/increaseRecord",method = RequestMethod.POST)
    public void increaseRecord(@RequestParam(value = "name",defaultValue = "no") String s){
        System.out.println(s);

        service.deleteRecord(s.toString());
    }
}
