package com.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.weblog.common.config.InsertBatchMapper;
import com.weblog.common.domain.dos.ArticleTagRelDO;

import java.util.List;

public interface ArticleTagRelMapper extends InsertBatchMapper<ArticleTagRelDO> {
    /**
     * 根据文章 ID 删除关联记录
     *
     * @param articleId
     * @return
     */
    default int deleteByArticleId(Long articleId) {
        return delete(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getArticleId, articleId));
    }

    /**
     * 根据文章 ID 来查询
     *
     * @param articleId
     * @return
     */
    default List<ArticleTagRelDO> selectByArticleId(Long articleId) {
        return selectList(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .eq(ArticleTagRelDO::getArticleId, articleId));
    }

    /**
     * 根据文章 ID 集合批量查询
     *
     * @param articleIds
     * @return
     */
    default List<ArticleTagRelDO> selectByArticleIds(List<Long> articleIds) {
        return selectList(Wrappers.<ArticleTagRelDO>lambdaQuery()
                .in(ArticleTagRelDO::getArticleId, articleIds));
    }
}
