package service;

import model.C_Product;
import utils.ReturnInfo;

public interface Product_Service {

	public ReturnInfo select(String txt,Integer page,Integer max);
	
	public C_Product selectById(int id);
	
	public void insert(C_Product t);
	
	public void update(C_Product t);
	
	public void delete(int id);
}
