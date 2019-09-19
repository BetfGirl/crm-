package service;

import model.C_Client;
import utils.ReturnInfo;

public interface Client_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_Client selectById(int id);
	
	public void insert(C_Client t);
	
	public void update(C_Client t);
	
	public void delete(int id);
}
