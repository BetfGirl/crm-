package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_ClientType;
import service.ClientType_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("ClientType")
public class ClientTypeController {
	@Autowired
	ClientType_Service service;
	
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		if(txt!=null) txt=" where C_ClientType.name like '%"+txt+"%' ";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(C_ClientType b,ModelMap m) {
		 service.insert(b);
		 return "{\"status\":1}";
	}
	@RequestMapping("update")
	public @ResponseBody String  update(C_ClientType b,ModelMap m) {
		System.out.println(b.getName());
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		System.out.println(id);
		 service.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	private @ResponseBody C_ClientType edit(int id,ModelMap m) {
		return service.selectById(id);
	}
	
}

