package com.huazai.aiyou.manager.service;

import java.util.List;

import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.module.EasyUITreeNode;

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
	public List<EasyUITreeNode> getTbItemCatListById(Long parentId);

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title getItemCatList
	 *        <ul>
	 * @description TbItemCat 分页集合
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param parentId
	 * @return
	 * @return List<EasyUITreeNode>
	 *
	 * @version : V1.0.0
	 */
	public EasyUIDataGrid getTbItemCatList(Integer page, Integer rows, Object object);
}
