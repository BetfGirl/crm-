package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.C_Client;

public interface Client_Dao {
	@Select("  SELECT c_client.*,c_clienttype.name clienttype, c_operator.name  operatorname from (c_client INNER JOIN c_clienttype ON c_client.id=c_clienttype.id) INNER JOIN c_operator on c_client.createoperatorid=c_operator.id ${where} ${limit} ")
	public List<C_Client> select(@Param("where") String where,@Param("limit") String limit);

	@Delete("delete from C_client where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_client (name,sex,tel,qq,email,infos,linkstatus,clientstatus,purposestatus,assessstatus,execstatus,status,clienttypeid,operatorids,createoperatorid,createdate,srcid,count,comments) values(#{name},#{sex},#{tel},#{qq},#{email},#{infos},#{linkstatus},#{clientstatus},#{purposestatus},#{assessstatus},#{execstatus},#{status},#{clienttypeid},#{operatorids},#{createoperatorid},#{createdate},#{srcid},#{count},#{comments})")
	 public Integer insert(C_Client t);

	 @Update("update C_Client set name=#{name},sex=#{sex},tel=#{tel},qq=#{qq},email=#{email},infos=#{infos},linkstatus=#{linkstatus},clientstatus=#{clientstatus},purposestatus=#{purposestatus},assessstatus=#{assessstatus},execstatus=#{execstatus},status=#{status},clienttypeid=#{clienttypeid},operatorids=#{operatorids},createoperatorid=#{createoperatorid},createdate=#{createdate},srcid=#{srcid},count=#{count},comments=#{comments} where id=#{id}")
	 public Integer update(C_Client t);
	 
	 @Select(" select count(1) from C_Client ${where} ")
	 public int selectcount(@Param("where") String where);

}
