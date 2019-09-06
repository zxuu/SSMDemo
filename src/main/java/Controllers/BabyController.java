package Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entity.Baby;
import Service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.Page;

import java.util.List;

@Controller
@RequestMapping("")
public class BabyController {
	   @Autowired
	    private BabyService babyService;

	    @RequestMapping("/toAdd")
	    public String toAdd() {


	    	return "addBaby";
	    }

	    @RequestMapping("/addBaby")
	    public String addBaby(HttpServletRequest request, HttpServletResponse response) {

	        Baby baby = new Baby();

	        int babyID = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        String sex = request.getParameter("sex");

	        baby.setId(babyID);
	        baby.setName(name);
	        baby.setAge(age);
	        baby.setSex(sex);

	        babyService.addBaby(baby);

	        return "redirect:listBaby";
	    }

	    @RequestMapping("/listBaby")
	    public String listBaby(HttpServletRequest request, HttpServletResponse response) {

	        // 获取分页参数
	        int start = 0;
	        int count = 10;

	        try {
	            start = Integer.parseInt(request.getParameter("page.start"));
	            count = Integer.parseInt(request.getParameter("page.count"));
	        } catch (Exception e) {
	        }

	        Page page = new Page(start, count);

	        List<Baby> babys = babyService.list(page.getStart(), page.getCount());
			int total = babyService.getTotal();
			int male = babyService.getMale();
			int female = babyService.getFemale();
			page.setTotal(total);

			request.setAttribute("babys", babys);
			request.setAttribute("page", page);
			request.setAttribute("male", male);
			request.setAttribute("female", female);
	        return "listBaby";
	    }

	    @RequestMapping("/deleteBaby")
	    public String deleteBaby(int id) {
	        babyService.deleteBaby(id);
	        return "redirect:listBaby";
	    }

	    @RequestMapping("/editBaby")
	    public ModelAndView editBaby(int id) {
	        ModelAndView mav = new ModelAndView("editBaby");
	        Baby baby = babyService.getBaby(id);
	        mav.addObject("baby", baby);
	        return mav;
	    }

	    @RequestMapping("/updateBaby")
	    public String updateBaby(HttpServletRequest request, HttpServletResponse response) {
	        Baby baby = new Baby();
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        String sex = request.getParameter("sex");

	        baby.setId(id);
	        baby.setName(name);
	        baby.setAge(age);
	        baby.setSex(sex);

	        babyService.updateBaby(baby);
	        return "redirect:listBaby";
	    }

	    //zxuu
//		@RequestMapping(value = "getAllBabys",method = RequestMethod.POST)
//		public String Get(){
////			System.out.println(requestBody.getParameter(""));
//			List<Baby> urineList = babyService.list(0,10);
//
//			String jsonResult = com.alibaba.fastjson.JSON.toJSONString(urineList);
//			System.out.println("babys:"+jsonResult);
//			return jsonResult;
//		}
}
