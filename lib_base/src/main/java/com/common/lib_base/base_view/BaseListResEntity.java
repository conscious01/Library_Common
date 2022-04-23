package com.common.lib_base.base_view;

import com.common.lib_base.base_view.BaseListResEntity.PageDataEntity;
import java.util.List;

/**
 * Author: LJD
 * Date: 2019/11/13
 * Desc: 列表基础模型
 */
public class BaseListResEntity<T> extends BaseResEntity<PageDataEntity<T>> {

    public BaseListResEntity() {
    }


    public BaseListResEntity(PageDataEntity<T> data) {
        super(data);
    }

    public BaseListResEntity(PageDataEntity<T> data, int code, String msg) {
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
