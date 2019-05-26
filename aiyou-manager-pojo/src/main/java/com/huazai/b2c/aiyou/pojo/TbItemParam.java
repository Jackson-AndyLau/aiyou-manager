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
public class TbItemParam
{
	private Long id;

	private Long itemCatId;

	private Date created;

	private Date updated;

	private String paramData;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getItemCatId()
	{
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId)
	{
		this.itemCatId = itemCatId;
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

	public String getParamData()
	{
		return paramData;
	}

	public void setParamData(String paramData)
	{
		this.paramData = paramData == null ? null : paramData.trim();
	}
}