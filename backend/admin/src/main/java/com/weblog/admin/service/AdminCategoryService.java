package com.weblog.admin.service;

import com.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.weblog.common.utils.Response;

public interface AdminCategoryService {
    /**
     * 添加分类
     *
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);
}
