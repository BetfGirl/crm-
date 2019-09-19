package service;

import model.C_ClientType;
import utils.ReturnInfo;

public interface ClientType_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_ClientType selectById(int id);
	
	public void insert(C_ClientType t);
	
	public void update(C_ClientType t);
	
	public void delete(int id);
}
