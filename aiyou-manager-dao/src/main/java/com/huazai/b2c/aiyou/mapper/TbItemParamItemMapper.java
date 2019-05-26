package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbItemParamItem;
import com.huazai.b2c.aiyou.pojo.TbItemParamItemExample;
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
public interface TbItemParamItemMapper
{
	int countByExample(TbItemParamItemExample example);

	int deleteByExample(TbItemParamItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbItemParamItem record);

	int insertSelective(TbItemParamItem record);

	List<TbItemParamItem> selectByExampleWithBLOBs(TbItemParamItemExample example);

	List<TbItemParamItem> selectByExample(TbItemParamItemExample example);

	TbItemParamItem selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbItemParamItem record,
			@Param("example") TbItemParamItemExample example);

	int updateByExampleWithBLOBs(@Param("record") TbItemParamItem record,
			@Param("example") TbItemParamItemExample example);

	int updateByExample(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemExample example);

	int updateByPrimaryKeySelective(TbItemParamItem record);

	int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

	int updateByPrimaryKey(TbItemParamItem record);
}