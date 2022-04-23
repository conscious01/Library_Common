package com.common.lib_base.base;

import java.util.List;

/**
 * Author: LJD
 * Date: 2019/11/13
 * Desc: 列表基础模型
 */
public class BasicListResponseEntity<T> extends BasicResponseEntity<BasicListResponseEntity.PageDataEntity<T>> {

    public BasicListResponseEntity() {
    }


    public BasicListResponseEntity(PageDataEntity<T> data) {
        super(data);
    }

    public BasicListResponseEntity(PageDataEntity<T> data, int code, String msg) {
        super(data, code, msg);
    }

    public static class PageDataEntity<T> {

        private List<T> rows;

        private int page;

        private int total;

        private int page_size;

        public PageDataEntity() {
        }

        public PageDataEntity(List<T> rows, int page) {
            this.rows = rows;
            this.page = page;
        }

        public boolean hasMore() {
            return (page * page_size) < total;
        }

        public List<T> getList() {
            return rows;
        }
    }

}
