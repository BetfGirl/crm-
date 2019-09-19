package service;


import model.C_Operator;
import utils.ReturnInfo;

public interface Operator_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_Operator selectById(Integer id);
	
	public void insert(C_Operator t);
	
	public void update(C_Operator t);
	
	public void delete(int id);

	public C_Operator login(C_Operator c);
}
