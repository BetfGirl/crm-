package service;

import model.C_WorkGroup;
import utils.ReturnInfo;

public interface WorkGroup_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_WorkGroup selectById(int id);
	
	public void insert(C_WorkGroup t);
	
	public void update(C_WorkGroup t);
	
	public void delete(int id);
}
