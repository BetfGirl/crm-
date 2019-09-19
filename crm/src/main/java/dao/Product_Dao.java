package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_Product;

@Repository()
public interface Product_Dao {

	@Select("select * from  C_Product ${where} ")
	public List<C_Product> select(@Param("where") String where,@Param("limit") String limit);

	@Delete("delete from C_Product where id=#{id}")
	public void delete(int id);

	 @Insert("insert into C_Product (name,amount,info) values(#{name},#{amount},#{info})")
	 public void insert(C_Product t);

	 @Update("update C_Product set name=#{name},amount=#{amount},info=#{info} where id=#{id}")
	 public void update(C_Product t);
	 

	 @Select(" select count(1) from C_Product ${where} ")
	 public int selectcount(@Param("where") String where);

}
