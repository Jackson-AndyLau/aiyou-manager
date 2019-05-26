package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbOrder;
import com.huazai.b2c.aiyou.pojo.TbOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TbItemParamItemMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbOrderMapper
{
	int countByExample(TbOrderExample example);

	int deleteByExample(TbOrderExample example);

	int deleteByPrimaryKey(String orderId);

	int insert(TbOrder record);

	int insertSelective(TbOrder record);

	List<TbOrder> selectByExample(TbOrderExample example);

	TbOrder selectByPrimaryKey(String orderId);

	int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

	int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

	int updateByPrimaryKeySelective(TbOrder record);

	int updateByPrimaryKey(TbOrder record);
}