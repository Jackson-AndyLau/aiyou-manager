package com.huazai.b2c.aiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.mapper.TbItemDescMapper;
import com.huazai.b2c.aiyou.pojo.TbItemDesc;
import com.huazai.b2c.aiyou.pojo.TbItemDescExample;
import com.huazai.b2c.aiyou.pojo.TbItemDescExample.Criteria;
import com.huazai.b2c.aiyou.repo.AiyouResultData;
import com.huazai.b2c.aiyou.service.TbItemDescService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品描述实现类
 *              </ul>
 * @className TbItemDescServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
@Service
public class TbItemDescServiceImpl implements TbItemDescService
{

	@Autowired
	private TbItemDescMapper tbItemDescMapper;

	@Override
	public EasyUIDataGrid getItemDescList(Integer pageNum, Integer pageSize, TbItemDesc tbItemDesc)
	{

		return null;
	}

	@Override
	public AiyouResultData findTbItemDescById(long itemId)
	{
		TbItemDesc itemDesc;
		try
		{
			TbItemDescExample example = new TbItemDescExample();
			Criteria criteria = example.createCriteria();
			criteria.andItemIdEqualTo(itemId);
			List<TbItemDesc> list = tbItemDescMapper.selectByExampleWithBLOBs(example);
			itemDesc = list.get(0);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品描述查询异常");
		}
		return AiyouResultData.ok(itemDesc);
	}

}
