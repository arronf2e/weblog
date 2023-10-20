package com.weblog.common.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weblog.common.domain.dos.ArticleTagRelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsertBatchMapper<T> extends BaseMapper<T> {
    // 批量插入
    int insertBatchSomeColumn(@Param("list") List<T> batchList);
}
