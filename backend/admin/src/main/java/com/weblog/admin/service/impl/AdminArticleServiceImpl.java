package com.weblog.admin.service.impl;

import com.weblog.admin.model.vo.article.PublishArticleReqVO;
import com.weblog.admin.service.AdminArticleService;
import com.weblog.common.domain.dos.ArticleCategoryRelDO;
import com.weblog.common.domain.dos.ArticleContentDO;
import com.weblog.common.domain.dos.ArticleDO;
import com.weblog.common.domain.dos.CategoryDO;
import com.weblog.common.domain.mapper.ArticleCategoryRelMapper;
import com.weblog.common.domain.mapper.ArticleContentMapper;
import com.weblog.common.domain.mapper.ArticleMapper;
import com.weblog.common.domain.mapper.CategoryMapper;
import com.weblog.common.exception.BizException;
import com.weblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.weblog.common.enums.ResponseCodeEnum;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class AdminArticleServiceImpl implements AdminArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleContentMapper articleContentMapper;

    @Resource
    private ArticleCategoryRelMapper articleCategoryRelMapper;

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 发布文章
     *
     * @param publishArticleReqVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response publishArticle(PublishArticleReqVO publishArticleReqVO) {
        // 1. VO 转 ArticleDO, 并保存
        ArticleDO articleDO = ArticleDO.builder()
                .title(publishArticleReqVO.getTitle())
                .cover(publishArticleReqVO.getCover())
                .summary(publishArticleReqVO.getSummary())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        articleMapper.insert(articleDO);
        // 拿到插入记录的主键 ID
        Long articleId = articleDO.getId();
        // 2. VO 转 ArticleContentDO，并保存
        ArticleContentDO articleContentDO = ArticleContentDO.builder()
                .articleId(articleId)
                .content(publishArticleReqVO.getContent())
                .build();
        articleContentMapper.insert(articleContentDO);
        // 3. 处理文章关联的分类
        Long categoryId = publishArticleReqVO.getCategoryId();
        // 3.1 校验提交的分类是否真实存在
        CategoryDO categoryDO = categoryMapper.selectById(categoryId);
        if (Objects.isNull(categoryDO)) {
            throw new BizException(ResponseCodeEnum.CATEGORY_NOT_EXISTED);
        }
        ArticleCategoryRelDO articleCategoryRelDO = ArticleCategoryRelDO.builder()
                .articleId(articleId)
                .categoryId(categoryId)
                .build();
        articleCategoryRelMapper.insert(articleCategoryRelDO);

        // 4. 保存文章关联的标签集合
        List<String> publishTags = publishArticleReqVO.getTags();
        insertTags(publishTags);

        return Response.success();
    }

    /**
     * 保存标签
     *
     * @param publishTags
     */
    private void insertTags(List<String> publishTags) {
        // TODO
    }
}