package com.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weblog.common.domain.dos.ArticleDO;
import com.weblog.common.utils.PageResponse;

import java.time.LocalDate;
import java.util.Objects;

public interface ArticleMapper extends BaseMapper<ArticleDO> {
    /**
     * 分页查询
     *
     * @param current   当前页码
     * @param size      每页展示的数据量
     * @param title     文章标题
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    default Page<ArticleDO> selectPageList(Long current, Long size, String title, LocalDate startDate, LocalDate endDate) {
        Page<ArticleDO> page = new Page<>(current, size);

        LambdaQueryWrapper<ArticleDO> wrapper = Wrappers.<ArticleDO>lambdaQuery()
                .like(StringUtils.isNotBlank(title), ArticleDO::getTitle, title.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), ArticleDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), ArticleDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(ArticleDO::getCreateTime); // 按创建时间倒叙
        return selectPage(page, wrapper);
    }
}
