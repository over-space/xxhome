package com.xxbase.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by admin on 16/06/22.
 */
public class Page<T> implements Serializable{

    private final Collection<T> content = new ArrayList<>();

    private final long total;

    private final Pageable pageable;

    public Page() {
        this.total = 0L;
        this.pageable = new Pageable();
    }

    public Page(Collection<T> content, long total, Pageable pageable) {
        this.content.addAll(content);
        this.total = total;
        this.pageable = pageable;
    }

    public Collection<T> getContent() {
        return content;
    }

    public long getTotal() {
        return total;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
