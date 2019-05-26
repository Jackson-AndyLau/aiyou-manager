package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbOrderItem;
import com.huazai.b2c.aiyou.pojo.TbOrderItemExample;
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
public interface TbOrderItemMapper
{
	int countByExample(TbOrderItemExample example);

	int deleteByExample(TbOrderItemExample example);

	int deleteByPrimaryKey(String id);

	int insert(TbOrderItem record);

	int insertSelective(TbOrderItem record);

	List<TbOrderItem> selectByExample(TbOrderItemExample example);

	TbOrderItem selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") TbOrderItem record, @Param("example") TbOrderItemExample example);

	int updateByExample(@Param("record") TbOrderItem record, @Param("example") TbOrderItemExample example);

	int updateByPrimaryKeySelective(TbOrderItem record);

	int updateByPrimaryKey(TbOrderItem record);
}