package com.huazai.b2c.aiyou.service;

import java.util.List;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.pojo.TbItem;
import com.huazai.b2c.aiyou.repo.AiyouResultData;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品接口类
 *              </ul>
 * @className ItemService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemService
{
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemList
	 *        <ul>
	 * @description 获取商品列表
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param pageNum
	 *            当前页码
	 * @param pageSize
	 *            页大小
	 * @param item
	 *            查询条件
	 * @return EasyUIDataGrid 返回数据载体
	 *
	 * @version : V1.0.0
	 */
	public EasyUIDataGrid getTbItemList(Integer pageNum, Integer pageSize, TbItem item);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title saveTbItem
	 *        <ul>
	 * @description 添加商品
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param item
	 *            商品实体
	 * @param desc
	 *            商品描述
	 * @return AiyouResultData 相应数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData addTbItem(TbItem item, String itemDesc);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title deleteTbItem
	 *        <ul>
	 * @description 删除商品信息
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param ids 商品ID集合
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData deleteTbItem(List<Long> ids);

}
