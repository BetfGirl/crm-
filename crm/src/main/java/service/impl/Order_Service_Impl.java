package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Order_Dao;
import model.C_Order;
import service.Order_Service;
import utils.ReturnInfo;

@Service
public class Order_Service_Impl implements Order_Service{
	@Autowired
	Order_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_Order t) {
		 dao.insert(t);
	}

	public void update(C_Order t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_Order selectById(int id) {
		return (C_Order)dao.select(" where c_order.id="+id,"limit 1").get(0);
	}


}

