package com.weblog.admin.model.vo.article;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "分页列表返回VO")
public class FindArticlePageListRspVO {
    private Long id;

    private String title;

    private String cover;

    private LocalDateTime createTime;

}
