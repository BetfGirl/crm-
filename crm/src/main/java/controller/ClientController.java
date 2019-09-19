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
import model.C_Operator;
import service.ClientType_Service;
import service.Client_Service;
import service.Operator_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Client")
public class ClientController {
	@Autowired
	Client_Service service;
	
	@Autowired
	ClientType_Service tservice;
	
	@Autowired
	Operator_Service oservice;
	
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {

		if(txt!=null) txt=" where C_client.name like '%"+txt+"%' ";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(C_Client b,ModelMap m) {
		 service.insert(b);
		 return "{\"status\":1}";
	}
	@RequestMapping("update")
	public @ResponseBody String  update(C_Client b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		 service.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	private @ResponseBody C_Client edit(int id,ModelMap m) {
		return service.selectById(id);
	}
	
	@RequestMapping("sexs")
	public @ResponseBody String[] sexs() {
		return C_Client.sexs;
	}
	
	
	@RequestMapping("stttus")
	public @ResponseBody String[] stttus() {
		return C_Client.stttus;
	}
	
	@RequestMapping("link")
	public @ResponseBody String[] link() {
		
		return C_Client.link;
	}
	@RequestMapping("client")
	public @ResponseBody String[] client() {
		return C_Client.client;
	}
	@RequestMapping("purpose")
	public @ResponseBody String[] purpose() {
		return C_Client.purpose;
	}
	@RequestMapping("assesss")
	public @ResponseBody String[] assesss() {
		return C_Client.assesss;
	}
	@RequestMapping("exec")
	public @ResponseBody String[] exec() {
		return C_Client.exec;
	}
	@RequestMapping("srcid")
	public @ResponseBody String[] srcid() {
		return C_Client.srcids;
	}
	
	@RequestMapping("clienttype")
	public @ResponseBody List<C_ClientType> clienttype(){
		return tservice.select(null, null, null).getList();
		
	}
	@RequestMapping("operatorname")
	public @ResponseBody List<C_Operator> operatorname(){
		return oservice.select(null, null, null).getList();
		
	}
}

