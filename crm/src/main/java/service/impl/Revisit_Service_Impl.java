package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Revisit_Dao;
import model.C_Revisit;
import service.Revisit_Service;
import utils.ReturnInfo;

@Service
public class Revisit_Service_Impl implements Revisit_Service{
	@Autowired
	Revisit_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_Revisit t) {
		 dao.insert(t);
	}

	public void update(C_Revisit t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_Revisit selectById(Integer id) {
		return (C_Revisit)dao.select(" where C_revisit.id="+id,"limit 1").get(0);
	}


}

