package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.C_Order;

public interface Order_Dao {
	@Select("select c_order.*,c_client.name clientname, c_operator.name  operatorname from ( c_client INNER JOIN c_order on c_client.id=c_order.clientid) INNER JOIN c_operator on c_order.operatorid=c_operator.id  ${where} ${limit} ")
	public List<C_Order> select(@Param("where") String where,@Param("limit") String limit);

	@Delete("delete from C_order where id=#{id}")
	public int delete(int id);

	 @Insert("insert into C_order (clientid,createdate,compdate,orderdate,startdate,enddate,operatorid,info,files,compoperatorids,compweight,status,amount,comments) values(#{clientid},#{createdate},#{compdate},#{orderdate},#{startdate},#{enddate},#{operatorid},#{info},#{files},#{compoperatorids},#{compweight},#{status},#{amount},#{comments})")
	 public Integer insert(C_Order t);

	 @Update("update C_order set clientid=#{clientid},createdate=#{createdate},compdate=#{compdate},orderdate=#{orderdate},startdate=#{startdate},enddate=#{enddate},operatorid=#{operatorid},info=#{info},files=#{files},compoperatorids=#{compoperatorids},compweight=#{compweight},status=#{status},amount=#{amount},comments=#{comments} where id=#{id}")
	 public Integer update(C_Order t);
	 
	 @Select(" select count(1) from C_order ${where} ")
	 public int selectcount(@Param("where") String where);

}
