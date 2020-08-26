package com.huazai.aiyou.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.module.EasyUITreeNode;
import com.huazai.aiyou.manager.mapper.TbItemCatMapper;
import com.huazai.aiyou.manager.pojo.TbItemCat;
import com.huazai.aiyou.manager.pojo.TbItemCatExample;
import com.huazai.aiyou.manager.pojo.TbItemCatExample.Criteria;
import com.huazai.aiyou.manager.service.TbItemCatService;


/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TbItemCat 服务层实现类
 *              </ul>
 * @className TbItemCatServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService
{

	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EasyUITreeNode> getTbItemCatListById(Long parentId)
	{
		// 1、根据parentId查询商品类目列表
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		// 2、初始化商品类目列表
		List<EasyUITreeNode> resultList = new ArrayList<>();
		// 3、封装数据
		for (TbItemCat tbItemCat : list)
		{
			EasyUITreeNode treeNode = new EasyUITreeNode();
			treeNode.setId(tbItemCat.getId());
			treeNode.setText(tbItemCat.getName());
			treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
			resultList.add(treeNode);
		}
		return resultList;
	}

	@Override
	public EasyUIDataGrid getTbItemCatList(Integer page, Integer rows, Object object)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
