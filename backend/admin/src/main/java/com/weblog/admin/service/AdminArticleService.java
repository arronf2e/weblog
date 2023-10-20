package com.weblog.admin.service;

import com.weblog.admin.model.vo.article.DeleteArticleReqVO;
import com.weblog.admin.model.vo.article.FindArticlePageListReqVO;
import com.weblog.admin.model.vo.article.PublishArticleReqVO;
import com.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.weblog.common.utils.Response;

public interface AdminArticleService {
    /**
     * 发布文章
     *
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);

    /**
     * 删除文章
     *
     * @param deleteArticleReqVO
     * @return
     */
    Response deleteArticle(DeleteArticleReqVO deleteArticleReqVO);

    /**
     * 查询文章分页数据
     *
     * @param findArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);
}
