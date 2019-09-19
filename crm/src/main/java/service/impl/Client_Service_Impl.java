package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Client_Dao;
import model.C_Client;
import service.Client_Service;
import utils.ReturnInfo;

@Service
public class Client_Service_Impl implements Client_Service{
	@Autowired
	Client_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_Client t) {
		 dao.insert(t);
	}

	public void update(C_Client t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_Client selectById(int id) {
		return (C_Client)dao.select(" where C_Client.id="+id,"limit 1").get(0);
	}


}

