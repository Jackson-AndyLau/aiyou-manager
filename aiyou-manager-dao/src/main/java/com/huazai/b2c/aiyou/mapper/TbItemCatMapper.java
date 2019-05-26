package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbItemCat;
import com.huazai.b2c.aiyou.pojo.TbItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TbItemCatMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemCatMapper
{
	int countByExample(TbItemCatExample example);

	int deleteByExample(TbItemCatExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbItemCat record);

	int insertSelective(TbItemCat record);

	List<TbItemCat> selectByExample(TbItemCatExample example);

	TbItemCat selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

	int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatExample example);

	int updateByPrimaryKeySelective(TbItemCat record);

	int updateByPrimaryKey(TbItemCat record);
}