package com.huazai.aiyou.manager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.huazai.aiyou.manager.pojo.TbUser;
import com.huazai.aiyou.manager.pojo.TbUserExample;

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
public interface TbUserMapper
{
	int countByExample(TbUserExample example);

	int deleteByExample(TbUserExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TbUser record);

	int insertSelective(TbUser record);

	List<TbUser> selectByExample(TbUserExample example);

	TbUser selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

	int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

	int updateByPrimaryKeySelective(TbUser record);

	int updateByPrimaryKey(TbUser record);
}