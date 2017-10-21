package com.gobha.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.ibatis.cache.Cache;


/*
 * 使用第三方缓存服务器，处理二级缓存
 */
public class RedisCache implements Cache {
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	public RedisCache( final String id ) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;

	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void putObject( Object key , Object value ) {
		JedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));

	}

	@Override
	public Object getObject( Object key ) {
		Object value = SerializeUtil.unserialize(JedisUtil.getJedis().get(SerializeUtil.serialize(key.toString())));
		return value;

	}

	@Override
	public Object removeObject( Object key ) {
		return JedisUtil.getJedis().expire(SerializeUtil.serialize(key.toString()), 0);

	}

	@Override
	public void clear() {
		JedisUtil.getJedis().flushDB();
	}

	@Override
	public int getSize() {
		return Integer.valueOf(JedisUtil.getJedis().dbSize().toString());
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

}
