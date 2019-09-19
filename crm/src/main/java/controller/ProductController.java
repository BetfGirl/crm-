package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.C_Product;
import service.Product_Service;
import utils.ReturnInfo;

@Controller
@RequestMapping("Product")
public class ProductController {
	@Autowired
	Product_Service service;
	
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	@RequestMapping("index")
	public @ResponseBody ReturnInfo index(String txt,ModelMap m,Integer page,Integer limit) {
		if(txt!=null) txt=" where C_Product.name like '%"+txt+"%' ";
		else txt="";
		return service.select(txt, page, limit);
	}
	
	@RequestMapping("insert")
	public @ResponseBody String insert(C_Product b,ModelMap m) {
		 service.insert(b);
		 return "{\"status\":1}";
	}
	@RequestMapping("update")
	public @ResponseBody String  update(C_Product b,ModelMap m) {
		service.update(b);
		return "{\"status\":1}";
	}
	@RequestMapping("delete")
	public @ResponseBody String  delete(int id,ModelMap m) {
		 service.delete(id);
		 return "{\"status\":1}";
	}
	
	@RequestMapping("edit")
	private @ResponseBody C_Product edit(int id,ModelMap m) {
		return service.selectById(id);
	}
	
}

