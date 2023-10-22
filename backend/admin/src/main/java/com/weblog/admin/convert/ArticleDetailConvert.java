package com.weblog.admin.convert;

import com.weblog.admin.model.vo.article.FindArticleDetailRspVO;
import com.weblog.common.domain.dos.ArticleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleDetailConvert {
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     *
     * @param bean
     * @return
     */
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);
}
