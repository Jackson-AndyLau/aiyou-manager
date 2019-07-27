package com.huazai.b2c.aiyou.test.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazai.b2c.aiyou.mapper.TbItemDescMapper;
import com.huazai.b2c.aiyou.mapper.TbItemMapper;
import com.huazai.b2c.aiyou.pojo.TbItem;
import com.huazai.b2c.aiyou.pojo.TbItemDesc;
import com.huazai.b2c.aiyou.pojo.TbItemDescExample;
import com.huazai.b2c.aiyou.pojo.TbItemExample;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 测试MyBatis的PageHelper
 *              </ul>
 * @className TPageHelper
 * @package com.huazai.b2c.aiyou.pagehelper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public class TPageHelper
{

	@SuppressWarnings("resource")
	@Test
	public void THelperByItem()
	{
		// 初始化Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		// 获取TbItemMapper类的代理对象
		TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
		// 设置分页
		PageHelper.startPage(5, 20);
		// 设置查询条件
		TbItemExample example = new TbItemExample();
		// 获得查询结果
		List<TbItem> list = itemMapper.selectByExample(example);
		// 设置分页信息
		PageInfo<TbItem> info = new PageInfo<>(list);
		
		// 打印输出
		System.out.println("当前商品总的个数：" + info.getTotal());
//		for (TbItem tbItem : list)
//		{
//			System.out.println(tbItem);
//		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void THelperByItemDesc()
	{
		// 初始化Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		// 获取TbItemMapper类的代理对象
		TbItemDescMapper mapper = context.getBean(TbItemDescMapper.class);
		TbItemDescExample example = new TbItemDescExample();
		// 设置分页
		PageHelper.startPage(1, 3);
		List<TbItemDesc> list = mapper.selectByExample(example);
		// 设置分页信息
		PageInfo<TbItemDesc> info = new PageInfo<>(list);
		
		// 打印输出
		System.out.println("当前商品总的个数：" + info.getTotal());
		for (TbItemDesc tbItemDesc : list)
		{
			System.out.println(tbItemDesc.getItemId());
		}
	}

}
