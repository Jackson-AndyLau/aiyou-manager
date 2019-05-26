package com.huazai.b2c.aiyou.mapper;

import com.huazai.b2c.aiyou.pojo.TbContentCategory;
import com.huazai.b2c.aiyou.pojo.TbContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * 			@description TODO
 *          </ul>
 * @className TbContentCategoryMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbContentCategoryMapper
{
	int countByExample(TbContentCategoryExample example);

	int deleteByExample(TbContentCategoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbContentCategory record);

	int insertSelective(TbContentCategory record);

	List<TbContentCategory> selectByExample(TbContentCategoryExample example);

	TbContentCategory selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbContentCategory record,
			@Param("example") TbContentCategoryExample example);

	int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);

	int updateByPrimaryKeySelective(TbContentCategory record);

	int updateByPrimaryKey(TbContentCategory record);
}