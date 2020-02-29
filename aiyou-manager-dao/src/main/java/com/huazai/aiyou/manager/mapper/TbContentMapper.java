package com.huazai.aiyou.manager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huazai.aiyou.manager.pojo.TbContent;
import com.huazai.aiyou.manager.pojo.TbContentExample;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * 			@description TODO
 *          </ul>
 * @className TbContentMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbContentMapper
{
	int countByExample(TbContentExample example);

	int deleteByExample(TbContentExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbContent record);

	int insertSelective(TbContent record);

	List<TbContent> selectByExampleWithBLOBs(TbContentExample example);

	List<TbContent> selectByExample(TbContentExample example);

	TbContent selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentExample example);

	int updateByExampleWithBLOBs(@Param("record") TbContent record, @Param("example") TbContentExample example);

	int updateByExample(@Param("record") TbContent record, @Param("example") TbContentExample example);

	int updateByPrimaryKeySelective(TbContent record);

	int updateByPrimaryKeyWithBLOBs(TbContent record);

	int updateByPrimaryKey(TbContent record);
}