package com.weblog.admin.service;

import com.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.weblog.common.utils.PageResponse;
import com.weblog.common.utils.Response;

public interface AdminCategoryService {
    /**
     * 添加分类
     *
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);

    Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);
}
