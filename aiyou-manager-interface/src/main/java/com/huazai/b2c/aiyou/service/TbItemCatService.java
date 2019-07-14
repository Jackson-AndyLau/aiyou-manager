package com.huazai.b2c.aiyou.service;

import java.util.List;

import com.huazai.b2c.aiyou.common.EasyUITreeNode;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TbItemCat 接口类
 *              </ul>
 * @className TbItemCatService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
public interface TbItemCatService
{

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemCatList
	 *        <ul>
	 * @description TbItemCat 集合
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param parentId
	 * @return
	 * @return List<EasyUITreeNode>
	 *
	 * @version : V1.0.0
	 */
	public List<EasyUITreeNode> getTbItemCatList(Long parentId);
}
