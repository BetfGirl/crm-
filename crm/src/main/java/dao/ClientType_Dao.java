package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.C_ClientType;

	@Repository()
public interface ClientType_Dao {

		@Select("select * from  C_clienttype ${where}")
		public List<C_ClientType> select(@Param("where") String where,@Param("limit") String limit);

		@Delete("delete from C_clienttype where id=#{id}")
		public void delete(int id);

		 @Insert("insert into C_clienttype (name) values(#{name})")
		 public void insert(C_ClientType t);

		 @Update("update C_clienttype set name=#{name} where id=#{id}")
		 public void update(C_ClientType t);

		 @Select(" select count(1) from c_clienttype ${where} ")
		 public int selectcount(@Param("where") String where);

}
