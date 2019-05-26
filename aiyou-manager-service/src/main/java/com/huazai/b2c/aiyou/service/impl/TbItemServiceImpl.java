package com.huazai.b2c.aiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.mapper.TbItemMapper;
import com.huazai.b2c.aiyou.pojo.TbItem;
import com.huazai.b2c.aiyou.pojo.TbItemExample;
import com.huazai.b2c.aiyou.pojo.TbItemExample.Criteria;
import com.huazai.b2c.aiyou.service.TbItemService;

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
public class TbItemServiceImpl implements TbItemService
{
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public EasyUIDataGrid getItemList(Integer pageNum, Integer pageSize, TbItem item)
	{
		// 通过PageHelper设置分页信息
		PageHelper.startPage(pageNum, pageSize);
		// 设置查询条件获得查询结果
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isEmpty(item) && item.getCid() != null)
			criteria.andCidEqualTo(item.getCid());
		List<TbItem> list = tbItemMapper.selectByExample(example);
		// 获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		// 封装返回结果
		EasyUIDataGrid resultData = new EasyUIDataGrid();
		resultData.setList(list);
		resultData.setTotal(pageInfo.getTotal());

		return resultData;
	}

}
