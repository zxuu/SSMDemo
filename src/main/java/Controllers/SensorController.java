package Controllers;

import java.util.List;


import Entity.Sensor;
import Service.BabyService;
import Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
			 List<Sensor> sensors = sensorService.list(1);
		        mav.addObject("sensor", sensors);
		 }
		 else{
			 
			 try{
	        String id = babyService.getId(name);
			 }
			catch(Exception e){
				 System.out.println("abcdef");
			 }
			 String id = "1";
	        List<Sensor> sensors = sensorService.list(Integer.parseInt(id));
	        mav.addObject("sensor", sensors);
	        }
	        return mav;
	    }
	 
}
