package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_Client;
import model.C_Operator;
import model.C_Order;
import service.Client_Service;
import service.Operator_Service;
import service.Order_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Order")
public class OrderController {
	@Autowired
	Order_Service service;
	
	@Autowired
	Client_Service cservice;
	
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
	public @ResponseBody String insert(C_Order b,ModelMap m) {
		 service.insert(b);
		 return "{\"status\":1}";
	}
	@RequestMapping("update")
	public @ResponseBody String  update(C_Order b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		 service.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	private @ResponseBody C_Order edit(int id,ModelMap m) {
		return service.selectById(id);
	}
	
	@RequestMapping("status")
	public @ResponseBody String[] status() {
		return C_Order.statuss;
	}
//	
//	@RequestMapping("link")
//	public @ResponseBody String[] link() {
//		
//		return C_Client.link;
//	}
//	@RequestMapping("client")
//	public @ResponseBody String[] client() {
//		return C_Client.client;
//	}
//	@RequestMapping("purpose")
//	public @ResponseBody String[] purpose() {
//		return C_Client.purpose;
//	}
//	@RequestMapping("assesss")
//	public @ResponseBody String[] assesss() {
//		return C_Client.assesss;
//	}
//	@RequestMapping("exec")
//	public @ResponseBody String[] exec() {
//		return C_Client.exec;
//	}
	@RequestMapping("clientname")
	public @ResponseBody List<C_Client> clientname(){
		return cservice.select(null, null, null).getList();
	}
	@RequestMapping("operatorname")
	public @ResponseBody List<C_Operator> operatorname(){
		return oservice.select(null, null, null).getList();
	}
}

