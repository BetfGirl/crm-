package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientType_Dao;
import model.C_ClientType;
import service.ClientType_Service;
import utils.ReturnInfo;

@Service
public class ClientType_Service_Impl implements ClientType_Service{
	@Autowired
	ClientType_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_ClientType t) {
		 dao.insert(t);
	}

	public void update(C_ClientType t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_ClientType selectById(int id) {
		return (C_ClientType)dao.select(" where C_ClientType.id="+id,"limit 1").get(0);
	}


}

