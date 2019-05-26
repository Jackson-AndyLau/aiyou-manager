package com.huazai.b2c.aiyou.service;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.pojo.TbItem;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * 			@description TODO
 *          </ul>
 * @className ItemService
 * @package com.huazai.b2c.aiyou.service
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public interface TbItemService
{
	
	public EasyUIDataGrid getItemList(Integer pageNum, Integer pageSize,TbItem item);

}
