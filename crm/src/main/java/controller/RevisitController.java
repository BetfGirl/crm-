package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_Client;
import model.C_ClientType;
import model.C_Revisit;
import service.ClientType_Service;
import service.Client_Service;
import service.Revisit_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Revisit")
public class RevisitController {
	@Autowired
	Revisit_Service service;
	
	@Autowired
	Client_Service cservice;
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		if(txt!=null) txt=" where C_revisit.name like '%"+txt+"%' ";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(C_Revisit b,ModelMap m) {
		 service.insert(b);
		 return "{\"status\":1}";
	}
	@RequestMapping("update")
	public @ResponseBody String  update(C_Revisit b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		 service.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("edit")//表内
	private @ResponseBody C_Revisit edit(Integer id,ModelMap m) {
		return service.selectById(id);
	}
	
	@RequestMapping("link")//表内
	public @ResponseBody String[] link() {
		System.out.println("into link");
		return C_Revisit.link;
	}
	@RequestMapping("client")//表内
	public @ResponseBody String[] client() {
		return C_Revisit.client;
	}
	@RequestMapping("purpose")//表内
	public @ResponseBody String[] purpose() {
		return C_Revisit.purpose;
	}
	@RequestMapping("assesss")//表内
	public @ResponseBody String[] assesss() {
		return C_Revisit.assesss;
	}
	@RequestMapping("exec")//表内
	public @ResponseBody String[] exec() {
		return C_Revisit.exec;
	}
	@RequestMapping("status")//表内
	public @ResponseBody String[] status() {
		return C_Revisit.sttatus;
	}
	
	
	@RequestMapping("clientt")//外键表关联获取数据
	public @ResponseBody List<C_Client> clientt() {
		return cservice.select(null, null, null).getList();
	}
}

