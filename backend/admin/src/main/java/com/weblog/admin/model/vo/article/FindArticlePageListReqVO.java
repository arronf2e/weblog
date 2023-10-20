package com.weblog.admin.model.vo.article;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "文章分页VO")
public class FindArticlePageListReqVO {
    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long current;

    private Long size;
}
