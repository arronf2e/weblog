package com.weblog.admin.service;

import com.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import com.weblog.admin.model.vo.category.FindCategoryPageListReqVO;
import com.weblog.admin.model.vo.tag.AddTagReqVO;
import com.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.weblog.common.utils.PageResponse;
import com.weblog.common.utils.Response;

public interface AdminTagService {
    /**
     * 添加分类
     *
     * @param addTagReqVO
     * @return
     */
    Response addTag(AddTagReqVO addTagReqVO);

    /**
     * 分类分页数据查询
     * @param findTagPageListReqVO
     * @return
     */
    PageResponse findTagList(FindTagPageListReqVO findTagPageListReqVO);

    Response deleteTag(DeleteTagReqVO deleteTagReqVO);

    /**
     * 获取文章分类的 Select 列表数据
     * @return
     */
    Response findTagSelectList();
}
