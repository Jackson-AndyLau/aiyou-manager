package com.huazai.aiyou.manager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazai.aiyou.common.constant.TbConstant;
import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.common.utils.IDUtils;
import com.huazai.aiyou.common.utils.JsonUtils;
import com.huazai.aiyou.manager.mapper.TbItemDescMapper;
import com.huazai.aiyou.manager.mapper.TbItemMapper;
import com.huazai.aiyou.manager.pojo.TbItem;
import com.huazai.aiyou.manager.pojo.TbItemDesc;
import com.huazai.aiyou.manager.pojo.TbItemExample;
import com.huazai.aiyou.manager.pojo.TbItemExample.Criteria;
import com.huazai.aiyou.manager.service.TbItemService;
import com.huazai.aiyou.manager.service.TbJedisClientService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品实现类
 *              </ul>
 * @className TbItemServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
@Service
public class TbItemServiceImpl implements TbItemService
{
	@Autowired
	private TbItemMapper tbItemMapper;

	@Autowired
	private TbItemDescMapper tbItemDescMapper;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private TbJedisClientService tbJedisClientService;

	@Resource(name = "itemTopicDestination")
	private Destination itemTopicDestination;

	@Value("${AIYOU_TB_SERVICE_ITEM_INFO_KEY}")
	private String AIYOU_TB_SERVICE_ITEM_INFO_KEY;

	@Value("${AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE}")
	private Integer AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE;

	@Override
	public EasyUIDataGrid getTbItemList(Integer pageNum, Integer pageSize, TbItem item)
	{
		// 初始化数据载体
		EasyUIDataGrid resultData = new EasyUIDataGrid();
		try
		{
			// 通过PageHelper设置分页信息
			PageHelper.startPage(pageNum, pageSize);
			// 设置查询条件获得查询结果
			TbItemExample example = new TbItemExample();
			Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(item) && item.getCid() != null)
				criteria.andCidEqualTo(item.getCid());
			criteria.andStatusNotEqualTo(Byte.valueOf("3"));
			List<TbItem> list = tbItemMapper.selectByExample(example);
			// 获取分页信息
			PageInfo<TbItem> pageInfo = new PageInfo<>(list);
			// 封装数据
			resultData.setRows(list);
			resultData.setTotal(pageInfo.getTotal());
			resultData.setPageSize(pageInfo.getPageSize());
			resultData.setPageNum(pageInfo.getPageNum());
			resultData.setPages(pageInfo.getPages());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return resultData;
	}

	@Transactional
	@Override
	public AiyouResultData addTbItem(TbItem item, String itemDesc)
	{
		// 获取生成商品ID
		final long itemId = IDUtils.genItemId();
		// 初始化系统时间
		Date date = new Date();
		// 补全商品信息
		item.setId(itemId);
		item.setStatus(TbConstant.TB_ITEM_STATUS_RESHELF);
		item.setCreated(date);
		item.setUpdated(date);
		// 初始化 TbItemDesc 对象
		TbItemDesc tbItemDesc = new TbItemDesc();
		// 补全商品描述信息
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(itemDesc);
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		try
		{
			// 添加商品数据
			tbItemMapper.insertSelective(item);
			// 添加商品描述
			tbItemDescMapper.insertSelective(tbItemDesc);
			// 同步更新索引库
			jmsTemplate.send(itemTopicDestination, new MessageCreator()
			{
				@Override
				public Message createMessage(Session session) throws JMSException
				{
					TextMessage textMessage = session.createTextMessage(String.valueOf(String.valueOf(itemId)));
					return textMessage;
				}
			});
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "添加商品失败");
		}
		return AiyouResultData.ok();
	}

	@Transactional
	private void optByTbItemId(String ids, Byte status) throws Exception
	{
		String[] idStrings = ids.split(",");
		for (int i = 0; i < idStrings.length; i++)
		{
			// 在一般的实际应用中，都是进行的是逻辑操作
			TbItem tbItem = tbItemMapper.selectByPrimaryKey(Long.valueOf(idStrings[i]));
			tbItem.setStatus(status);
			tbItemMapper.updateByPrimaryKey(tbItem);
			// 同步更新索引库

		}
	}

	@Transactional
	@Override
	public AiyouResultData deleteTbItem(String ids)
	{
		try
		{
			optByTbItemId(ids, TbConstant.TB_ITEM_STATUS_DELETE);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品删除异常");
		}
		return AiyouResultData.ok();
	}

	@Override
	public AiyouResultData instockTbItem(String ids)
	{
		try
		{
			optByTbItemId(ids, TbConstant.TB_ITEM_STATUS_INSTOCK);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品下架异常");
		}
		return AiyouResultData.ok();
	}

	@Override
	public AiyouResultData reshelfTbItem(String ids)
	{
		try
		{
			optByTbItemId(ids, TbConstant.TB_ITEM_STATUS_RESHELF);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品上架异常");
		}
		return AiyouResultData.ok();
	}

	@Override
	public AiyouResultData findTbItemById(Long itemId)
	{
		TbItem tbItem;
		try
		{
			tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "商品信息查询异常");
		}
		return AiyouResultData.ok(tbItem);
	}

	@Transactional
	@Override
	public AiyouResultData updateTbItem(TbItem item, String desc)
	{
		try
		{
			// 修改商品信息
			TbItem tbItem = tbItemMapper.selectByPrimaryKey(item.getId());
			// 补全信息
			Date date = new Date();
			tbItem.setCid(item.getCid());
			tbItem.setTitle(item.getTitle());
			tbItem.setSellPoint(item.getSellPoint());
			tbItem.setPrice(item.getPrice());
			tbItem.setNum(item.getNum());
			tbItem.setBarcode(item.getBarcode());
			tbItem.setImage(item.getImage());
			tbItem.setUpdated(date);
			tbItemMapper.updateByPrimaryKey(tbItem);
			// 修改商品描述
			TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(item.getId());
			// 补全信息
			tbItemDesc.setItemDesc(desc);
			tbItemDesc.setUpdated(date);
			tbItemDescMapper.updateByPrimaryKeyWithBLOBs(tbItemDesc);
			// 同步更新索引库

		} catch (Exception e)
		{
			e.printStackTrace();
			return AiyouResultData.build(-1, "修改商品信息异常");
		}
		return AiyouResultData.ok();
	}

	@Override
	public TbItem getTbItemById(Long itemId)
	{
		try
		{
			// 从缓存中获取数据
			if (itemId != null)
			{
				// 获取数据
				String str = tbJedisClientService.get(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE");
				if (!StringUtils.isEmpty(str))
				{
					// 重置数据的有效时间
					tbJedisClientService.expire(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
							AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE);
					// 解析数据并返回
					TbItem tbItemCache = JsonUtils.jsonToPojo(str, TbItem.class);
					return tbItemCache;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// 从数据库中获取数据
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		try
		{
			// 新增缓存
			tbJedisClientService.set(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
					JsonUtils.objectToJson(tbItem));
			// 设置过期时间
			tbJedisClientService.expire(AIYOU_TB_SERVICE_ITEM_INFO_KEY + ":" + itemId + ":BASE",
					AIYOU_TB_SERVICE_ITEM_INFO_KEY_EXPIRE);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return tbItem;
	}

}
