package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.C_Revisit;

public interface Revisit_Dao {
	@Select(" select C_revisit.*,c_client.name clientname from c_revisit INNER JOIN c_client on c_revisit.clientid=c_client.id ${where} ${limit} ")
	public List<C_Revisit> select(@Param("where") String where,@Param("limit") String limit);

	@Delete("delete from C_revisit where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_revisit (clientid,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,askinfo,followinfo,probleminfo,status,comments) values(#{clientid},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{askinfo},#{followinfo},#{probleminfo},#{status},#{comments})")
	 public Integer insert(C_Revisit t);

	 @Update("update C_revisit set clientid=#{clientid},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},askinfo=#{askinfo},followinfo=#{followinfo},probleminfo=#{probleminfo},status=#{status},comments=#{comments} where id=#{id}")
	 public Integer update(C_Revisit t);

	 @Select(" select count(1) from C_revisit ${where} ")
	 public int selectcount(@Param("where") String where);

}
