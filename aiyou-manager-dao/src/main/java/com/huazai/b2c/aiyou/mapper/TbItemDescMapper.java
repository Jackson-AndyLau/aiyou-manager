package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbItemDesc;
import com.huazai.b2c.aiyou.pojo.TbItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TbItemDescMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemDescMapper
{
	int countByExample(TbItemDescExample example);

	int deleteByExample(TbItemDescExample example);

	int deleteByPrimaryKey(Long itemId);

	int insert(TbItemDesc record);

	int insertSelective(TbItemDesc record);

	List<TbItemDesc> selectByExampleWithBLOBs(TbItemDescExample example);

	List<TbItemDesc> selectByExample(TbItemDescExample example);

	TbItemDesc selectByPrimaryKey(Long itemId);

	int updateByExampleSelective(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

	int updateByExampleWithBLOBs(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

	int updateByExample(@Param("record") TbItemDesc record, @Param("example") TbItemDescExample example);

	int updateByPrimaryKeySelective(TbItemDesc record);

	int updateByPrimaryKeyWithBLOBs(TbItemDesc record);

	int updateByPrimaryKey(TbItemDesc record);
}