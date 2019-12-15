package com.huazai.b2c.aiyou.service;

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
public interface TbItemService {
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemList
	 *        <ul>
	 * @description 获取商品列表
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param pageNum  当前页码
	 * @param pageSize 页大小
	 * @param item     查询条件
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
	 * @param item 商品实体
	 * @param desc 商品描述
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
	public AiyouResultData deleteTbItem(String ids);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title instockTbItem
	 *        <ul>
	 * @description 下架商品
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param ids 商品ID集合
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData instockTbItem(String ids);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title reshelfTbItem
	 *        <ul>
	 * @description 上架商品
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param ids 商品ID集合
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData reshelfTbItem(String ids);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title findTbItemById
	 *        <ul>
	 * @description 根据商品ID获取商品信息
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param itemId 商品ID
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData findTbItemById(Long itemId);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title updateTbItem
	 *        <ul>
	 * @description 修改商品信息
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param item 商品信息实体
	 * @param desc 商品描述
	 * @return AiyouResultData 数据载体
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData updateTbItem(TbItem item, String desc);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getTbItemById
	 *        <ul>
	 * @description 根据商品Id，查询商品详情
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param itemId
	 * @return
	 * @return TbItem
	 *
	 * @version : V1.0.0
	 */
	public TbItem getTbItemById(Long itemId);

}
