package com.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weblog.common.domain.dos.TagDO;

public interface TagMapper extends BaseMapper<TagDO> {
    default TagDO selectByName(String tagName) {
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TagDO::getName, tagName);
        return selectOne(wrapper);
    }
}
