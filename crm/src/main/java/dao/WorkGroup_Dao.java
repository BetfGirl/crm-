package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_WorkGroup;

@Repository()
public interface WorkGroup_Dao {

	@Select("select * from c_workgroup   ${where}")
	public List<C_WorkGroup> select(@Param("where") String where,@Param("limit") String limit);

	@Delete("delete from C_WorkGroup where id=#{id}")
	public void delete(int id);

	 @Insert("insert into C_WorkGroup(name) values(#{name})")
	 public void insert(C_WorkGroup t);

	 @Update("update C_WorkGroup set name=#{name} where id=#{id}")
	 public void update(C_WorkGroup t);
	 
	 @Select(" select count(1) from C_WorkGroup ${where} ")
	 public int selectcount(@Param("where") String where);

}
