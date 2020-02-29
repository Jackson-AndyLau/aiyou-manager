package com.huazai.aiyou.manager.service;

import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.manager.pojo.TbItemDesc;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品描述接口
 *              </ul>
 * @className TbItemDescService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemDescService {
	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemDescList
	 *        <ul>
	 * @description 获取商品描述列表
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param pageNum    当前页码
	 * @param pageSize   页大小
	 * @param tbItemDesc 查询条件
	 * @return EasyUIDataGrid 数据载体
	 *
	 * @version : V1.0.0
	 */
	public EasyUIDataGrid getItemDescList(Integer pageNum, Integer pageSize, TbItemDesc tbItemDesc);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title findTbItemDescById
	 *        <ul>
	 * @description 根据商品ID获取商品描述
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param itemId
	 * @return
	 * @return AiyouResultData
	 *
	 * @version : V1.0.0
	 */
	public AiyouResultData findTbItemDescById(long itemId);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title geTbItemDescById
	 *        <ul>
	 * @description 通过商品Id,获取商品描述
	 *              </ul>
	 * @createdTime 2017年06月18日
	 * @param itemId
	 * @return
	 * @return TbItemDesc
	 *
	 * @version : V1.0.0
	 */
	public TbItemDesc geTbItemDescById(Long itemId);
}
