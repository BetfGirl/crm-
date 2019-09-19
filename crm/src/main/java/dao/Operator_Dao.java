package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_Operator;

@Repository()
public interface Operator_Dao {

	@Select("select c_operator.*,c_workgroup.name workgroup from c_operator inner join c_workgroup on c_operator.groupid=c_workgroup.id ${where}")
	public List<C_Operator> select(@Param("where") String where,@Param("limit") String limit);

	@Delete("delete from C_operator where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_operator (tel,name,groupid,power,status) values(#{tel},#{name},#{groupid},#{power},#{status})")
	 public Integer insert(C_Operator t);

	 @Update("update C_operator set tel=#{tel},name=#{name},groupid=#{groupid},power=#{power},status=#{status} where id=#{id}")
	 public Integer update(C_Operator t);
	 
	 @Select(" select count(1) from C_operator ${where} ")
	 public int selectcount(@Param("where") String where);
	 
	 @Select(" select * from C_operator where tel=#{tel} and pass=#{pass} ")
	 public C_Operator login(C_Operator c);

}
