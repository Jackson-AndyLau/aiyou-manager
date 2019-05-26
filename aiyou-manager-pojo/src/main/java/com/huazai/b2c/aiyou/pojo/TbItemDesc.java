package com.huazai.b2c.aiyou.pojo;

import java.util.Date;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TbItemParamItemMapper
 * @package com.huazai.b2c.aiyou.mapper
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
public class TbItemDesc
{
	private Long itemId;

	private Date created;

	private Date updated;

	private String itemDesc;

	public Long getItemId()
	{
		return itemId;
	}

	public void setItemId(Long itemId)
	{
		this.itemId = itemId;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public Date getUpdated()
	{
		return updated;
	}

	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}

	public String getItemDesc()
	{
		return itemDesc;
	}

	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc == null ? null : itemDesc.trim();
	}
}