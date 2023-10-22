package com.weblog.admin.model.vo.article;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindArticleDetailRspVO {
    private Long id;

    private String title;

    /**
     * 文章封面
     */
    private String cover;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 分类 ID
     */
    private Long categoryId;

    /**
     * 标签 ID 集合
     */
    private List<Long> tagIds;
}
