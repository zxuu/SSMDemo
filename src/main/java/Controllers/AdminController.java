package Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entity.Admin;
import Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AdminController {
	
	
	 @Autowired
	    private AdminService adminService;
    @RequestMapping("/addAdmin")
    public String addAmin(HttpServletRequest request, HttpServletResponse response) {

        Admin Admin = new Admin();
        
        String AdminID = request.getParameter("id");
        String password = request.getParameter("password");

        Admin.setId(AdminID);
        Admin.setPassword(password);

        adminService.addAdmin(Admin);

        return "redirect:listAdmin";
    }
    
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
    	 String AdminID = request.getParameter("id");
         String password = request.getParameter("password");
         Admin tmp = adminService.getAdmin(AdminID);
         if(password.equals(tmp.getPassword())){
        	 return "redirect:listBaby";
         }
         else
        	 return "登陆失败！";
    	
    	
    }
    @RequestMapping("/config")
    public String config(HttpServletRequest request, HttpServletResponse response) {

        return "config";
    }
    @RequestMapping("/updateAdmin")
    public String updateAdmin(HttpServletRequest request, HttpServletResponse response) {

        Admin admin = new Admin();


        String name = request.getParameter("name");
        String password = request.getParameter("password");




        admin.setId(name);
        admin.setPassword(password);

        try{
            adminService.updateAdmin(admin);
            System.out.println("------------");
        }
        catch(Exception e){
            adminService.addAdmin(admin);
        }
        return "redirect:listBaby";
    }
}
