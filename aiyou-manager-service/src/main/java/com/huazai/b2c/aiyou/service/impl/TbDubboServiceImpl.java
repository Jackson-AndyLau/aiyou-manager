package com.huazai.b2c.aiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazai.b2c.aiyou.mapper.TbDubboMapper;
import com.huazai.b2c.aiyou.service.TbDubboService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TDubboServiceImpl
 * @package com.huazai.b2c.aiyou.service.impl
 * @createdTime 2017年06月07日
 *
 * @version V1.0.0
 */
@Service
public class TbDubboServiceImpl implements TbDubboService
{
	@Autowired
	private TbDubboMapper tDubboMapper;

	@Override
	public String getLocalDate()
	{

		return tDubboMapper.getLocalDate();
	}

}
