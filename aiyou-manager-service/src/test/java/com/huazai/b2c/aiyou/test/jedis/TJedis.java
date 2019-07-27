package com.huazai.b2c.aiyou.test.jedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 测试 Redis 服务器
 *              </ul>
 * @className TJedis
 * @package com.huazai.b2c.aiyou.test
 * @createdTime 2017年06月13日
 *
 * @version V1.0.0
 */
public class TJedis
{

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title testJedis
	 *        <ul>
	 * @description 测试单机版Redis
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @return void
	 *
	 * @version : V1.0.0
	 */
	@Test
	public void testJedisSingle()
	{
		// 创建Jedis对象
		Jedis jedis = new Jedis("192.168.159.144", 6379);
		// 使用jedis操作数据库
		String name = jedis.get("name");
		System.out.println(name);
		// 注意：每次操作完成后需要关闭连接
		jedis.close();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title testJedisPool
	 *        <ul>
	 * @description 测试通过jedis连接池连接Redis服务器
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @return void
	 *
	 * @version : V1.0.0
	 */
	@Test
	public void testJedisPool()
	{
		// 创建JedisPool对象
		JedisPool jedisPool = new JedisPool("192.168.159.144", 6379);
		// 获取Jedis对象
		Jedis jedis = jedisPool.getResource();
		// 通过jedis操作数据库
		String name = jedis.get("age");
		System.out.println(name);
		// 注意：每次操作完成后需要关闭连接(需要顺序关闭)
		jedis.close();
		jedisPool.close();
	}

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title testJedisCluster
	 *        <ul>
	 * @description 测试Redis集群
	 *              </ul>
	 * @createdTime 2017年06月14日
	 * @throws IOException
	 * @return void
	 *
	 * @version : V1.0.0
	 */
	@Test
	public void testJedisCluster() throws IOException
	{
		// 创建HostAndPort对象
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.159.144", 8001));
		nodes.add(new HostAndPort("192.168.159.144", 8002));
		nodes.add(new HostAndPort("192.168.159.144", 8003));
		nodes.add(new HostAndPort("192.168.159.144", 8004));
		nodes.add(new HostAndPort("192.168.159.144", 8005));
		nodes.add(new HostAndPort("192.168.159.144", 8006));
		// 创建JedisCluster对象
		JedisCluster jedisCluster = new JedisCluster(nodes);
		// 通过jedisCluster操作数据库
		String address = jedisCluster.get("address");
		System.out.println(address);
		// 注意：每次操作完成后需要关闭连接
		jedisCluster.close();
	}
}
