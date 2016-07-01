package com.xxbase.cache;

import java.io.Serializable;

/**
 * Created by admin on 16/06/14.
 */
public class EhcacheCacheProvider implements CacheProvider {

    @Override
    public void put(String key, Serializable cacheObject) {

    }

    @Override
    public Serializable get(String key) {
        return null;
    }

    @Override
    public void remove(String key) {

    }

}
