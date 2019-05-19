package com.huazai.b2c.aiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazai.b2c.aiyou.mapper.TDubboMapper;
import com.huazai.b2c.aiyou.service.TDubboService;

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
public class TDubboServiceImpl implements TDubboService
{
	@Autowired
	private TDubboMapper tDubboMapper;

	@Override
	public String getLocalDate()
	{

		return tDubboMapper.getLocalDate();
	}

}
