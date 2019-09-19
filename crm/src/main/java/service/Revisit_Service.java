package service;

import model.C_Revisit;
import utils.ReturnInfo;

public interface Revisit_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_Revisit selectById(Integer id);
	
	public void insert(C_Revisit t);
	
	public void update(C_Revisit t);
	
	public void delete(int id);
}
