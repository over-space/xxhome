package com.xxbase.cache;

import java.io.Serializable;

/**
 * Created by admin on 16/06/11.
 */
public interface CacheProvider {


    void put(final String key, Serializable cacheObject);

    Serializable get(final String key);

    void remove(final String key);

}
