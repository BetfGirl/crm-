package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Operator_Dao;
import model.C_Operator;
import service.Operator_Service;
import utils.ReturnInfo;

@Service
public class Operator_Service_Impl implements Operator_Service{
	@Autowired
	Operator_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_Operator t) {
		 dao.insert(t);
	}

	public void update(C_Operator t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_Operator selectById(Integer id) {
		return (C_Operator)dao.select(" where C_operator.id="+id,"limit 1").get(0);
	}


	public C_Operator login(C_Operator c) {
		// TODO Auto-generated method stub
		return dao.login(c);
	}



}

