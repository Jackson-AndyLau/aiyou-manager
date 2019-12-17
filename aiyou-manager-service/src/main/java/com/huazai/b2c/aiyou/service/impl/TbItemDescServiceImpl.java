package com.huazai.b2c.aiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.mapper.TbItemDescMapper;
import com.huazai.b2c.aiyou.pojo.TbItemDesc;
import com.huazai.b2c.aiyou.pojo.TbItemDescExample;
import com.huazai.b2c.aiyou.pojo.TbItemDescExample.Criteria;
import com.huazai.b2c.aiyou.repo.AiyouResultData;
import com.huazai.b2c.aiyou.service.TbItemDescService;
import com.huazai.b2c.aiyou.service.TbJedisClientService;
import com.huazai.b2c.aiyou.utils.JsonUtils;

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
	
	@Autowired
	private TbJedisClientService tbJedisClientService;

	@Value("${TB_ITEM_INFO_KEY}")
	private String TB_ITEM_INFO_KEY;
	
	@Value("${TB_ITEM_INFO_KEY_EXPIRE}")
	private Integer TB_ITEM_INFO_KEY_EXPIRE;

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

	@Override
	public TbItemDesc geTbItemDescById(Long itemId) {
		try
		{
			// 从缓存中获取数据
			if (itemId != null)
			{
				// 获取数据
				String str = tbJedisClientService.get(TB_ITEM_INFO_KEY + ":" + itemId + ":BASE");
				if (!StringUtils.isEmpty(str))
				{
					// 重置数据的有效时间
					tbJedisClientService.expire(TB_ITEM_INFO_KEY + ":" + itemId + ":BASE", TB_ITEM_INFO_KEY_EXPIRE);
					// 解析数据并返回
					TbItemDesc tbItemDesc = JsonUtils.jsonToPojo(str, TbItemDesc.class);
					return tbItemDesc;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(itemId);
		try
		{
			// 新增缓存
			tbJedisClientService.set(TB_ITEM_INFO_KEY + ":" + itemId + ":BASE", JsonUtils.objectToJson(tbItemDesc));
			// 设置过期时间
			tbJedisClientService.expire(TB_ITEM_INFO_KEY + ":" + itemId + ":BASE", TB_ITEM_INFO_KEY_EXPIRE);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return tbItemDesc;
	}

}
