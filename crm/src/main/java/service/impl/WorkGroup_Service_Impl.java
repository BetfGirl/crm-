package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WorkGroup_Dao;
import model.C_WorkGroup;
import service.WorkGroup_Service;
import utils.ReturnInfo;

@Service
public class WorkGroup_Service_Impl implements WorkGroup_Service{
	@Autowired
	WorkGroup_Dao dao;
	
	public ReturnInfo select(String where, Integer page, Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.selectcount(where));
		  return info;
	}


	public void insert(C_WorkGroup t) {
		 dao.insert(t);
	}

	public void update(C_WorkGroup t) {
		 dao.update(t);
	}

	public void delete(int id) {
		 dao.delete(id);
	}

	public C_WorkGroup selectById(int id) {
		return (C_WorkGroup)dao.select(" where c_workgroup.id="+id,"limit 1").get(0);
	}


}

