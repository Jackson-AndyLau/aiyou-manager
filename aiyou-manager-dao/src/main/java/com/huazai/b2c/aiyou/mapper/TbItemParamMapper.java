package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbItemParam;
import com.huazai.b2c.aiyou.pojo.TbItemParamExample;
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
public interface TbItemParamMapper
{
	int countByExample(TbItemParamExample example);

	int deleteByExample(TbItemParamExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbItemParam record);

	int insertSelective(TbItemParam record);

	List<TbItemParam> selectByExampleWithBLOBs(TbItemParamExample example);

	List<TbItemParam> selectByExample(TbItemParamExample example);

	TbItemParam selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

	int updateByExampleWithBLOBs(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

	int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

	int updateByPrimaryKeySelective(TbItemParam record);

	int updateByPrimaryKeyWithBLOBs(TbItemParam record);

	int updateByPrimaryKey(TbItemParam record);
}