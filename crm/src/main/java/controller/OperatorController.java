package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_Operator;
import service.Operator_Service;
import service.WorkGroup_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Operator")
public class OperatorController{
	@Autowired
	Operator_Service service;
	
	@Autowired
	WorkGroup_Service wservice;
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		if(txt!=null) txt=" where C_operator.name like '%"+txt+"%' ";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(C_Operator b,ModelMap m) {
		 service.insert(b);
		 return "{\"status\":1}";
	}
	@RequestMapping("update")
	public @ResponseBody String  update(C_Operator b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		 service.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	private @ResponseBody C_Operator edit(Integer id,ModelMap m) {
		return service.selectById(id);
	}
	
	@RequestMapping("login")
	public String login(C_Operator op, HttpSession s) {
		try{
			SecurityUtils.getSubject().login(new UsernamePasswordToken(op.getTel(),op.getPass()));
		}catch (AccountException e){
			return "redirect:/login.html";
		}
		return "redirect:/index.html";
	}
	
	@RequestMapping("powername")
	private @ResponseBody String[] powername() {
		return C_Operator.powername;
	}
	
	@RequestMapping("statuss")
	private @ResponseBody String[] statuss() {
		return C_Operator.statuss;
	}
	
	@RequestMapping("workgroup")
	private @ResponseBody List<C_Operator> workgroup() {
		return wservice.select(null, null, null).getList();
	}
}

