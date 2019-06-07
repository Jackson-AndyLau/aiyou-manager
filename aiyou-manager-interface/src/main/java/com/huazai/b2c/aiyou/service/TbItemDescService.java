package com.huazai.b2c.aiyou.service;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.pojo.TbItemDesc;

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
public interface TbItemDescService
{
	
	public EasyUIDataGrid getItemDescList(Integer pageNum, Integer pageSize,TbItemDesc tbItemDesc);
}
