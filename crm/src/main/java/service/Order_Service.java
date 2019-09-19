package service;

import model.C_Order;
import utils.ReturnInfo;

public interface Order_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_Order selectById(int id);
	
	public void insert(C_Order t);
	
	public void update(C_Order t);
	
	public void delete(int id);
}
