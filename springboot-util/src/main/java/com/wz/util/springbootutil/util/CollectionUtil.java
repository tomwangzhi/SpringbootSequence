package com.wz.util.springbootutil.util;

import java.util.List;

public class CollectionUtil {

    /**
     *
     * @param list 要分页的list
     * @param page 页码
     * @param pageSize 页大小
     * @return
     */
    public List getPageList(List list, int page, int pageSize) {
        int start = (page - 1) * pageSize;
        if (start < 0)
            start = 0;
        if (start > list.size() - 1)
            return null;
        int end = page * pageSize;
        if (end < 0)
            return null;
        if (end > list.size())
            end = list.size();
        return list.subList(start, end);
    }
}
