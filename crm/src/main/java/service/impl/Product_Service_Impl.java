package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Product_Dao;
import model.C_Product;
import service.Product_Service;
import utils.ReturnInfo;

@Service
public class Product_Service_Impl implements Product_Service{
	@Autowired
	Product_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_Product t) {
		 dao.insert(t);
	}

	public void update(C_Product t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_Product selectById(int id) {
		return (C_Product)dao.select(" where C_Product.id="+id,"limit 1").get(0);
	}


}

