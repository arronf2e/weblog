package com.weblog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weblog.admin.model.vo.tag.AddTagReqVO;
import com.weblog.admin.model.vo.tag.DeleteTagReqVO;
import com.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import com.weblog.admin.model.vo.tag.FindTagPageListRspVO;
import com.weblog.admin.service.AdminTagService;
import com.weblog.common.domain.dos.TagDO;
import com.weblog.common.domain.mapper.TagMapper;
import com.weblog.common.enums.ResponseCodeEnum;
import com.weblog.common.exception.BizException;
import com.weblog.common.model.vo.SelectRspVO;
import com.weblog.common.utils.PageResponse;
import com.weblog.common.utils.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AdminTagServiceImpl implements AdminTagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Response addTag(AddTagReqVO addTagReqVO) {
        String tagName = addTagReqVO.getName();

        TagDO tagDO = tagMapper.selectByName(tagName);
        if (Objects.nonNull(tagDO)) {
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_EXISTED);
        }

        TagDO insertTagDO = TagDO.builder()
                .name(tagName)
                .build();
        tagMapper.insert(insertTagDO);

        return Response.success();
    }

    @Override
    public PageResponse findTagList(FindTagPageListReqVO findTagPageListReqVO) {
        // 获取当前页、以及每页需要展示的数据数量
        Long current = findTagPageListReqVO.getCurrent();
        Long size = findTagPageListReqVO.getSize();

        // 分页对象(查询第几页、每页多少数据)
        Page<TagDO> page = new Page<>(current, size);

        // 构建查询条件
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        String name = findTagPageListReqVO.getName();
        LocalDate startDate = findTagPageListReqVO.getStartDate();
        LocalDate endDate = findTagPageListReqVO.getEndDate();

        wrapper
                .like(StringUtils.isNotBlank(name), TagDO::getName, name.trim()) // like 模块查询
                .ge(Objects.nonNull(startDate), TagDO::getCreateTime, startDate) // 大于等于 startDate
                .le(Objects.nonNull(endDate), TagDO::getCreateTime, endDate)  // 小于等于 endDate
                .orderByDesc(TagDO::getCreateTime); // 按创建时间倒叙

        // 执行分页查询
        Page<TagDO> tagDOPage = tagMapper.selectPage(page, wrapper);

        List<TagDO> tagDOS = tagDOPage.getRecords();

        // DO 转 VO
        List<FindTagPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> FindTagPageListRspVO.builder()
                            .id(tagDO.getId())
                            .name(tagDO.getName())
                            .createTime(tagDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }
        return PageResponse.success(tagDOPage, vos);
    }

    @Override
    public Response deleteTag(DeleteTagReqVO deleteTagReqVO) {
        Long tagId = deleteTagReqVO.getId();
        // 删除分类
        tagMapper.deleteById(tagId);
        return Response.success();
    }

    @Override
    public Response findTagSelectList() {
        List<TagDO> tagDOS = tagMapper.selectList(null);
        // DO 转 VO
        List<SelectRspVO> selectRspVOS = null;
        // 如果分类数据不为空
        if (!CollectionUtils.isEmpty(tagDOS)) {
            // 将分类 ID 作为 Value 值，将分类名称作为 label 展示
            selectRspVOS = tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(selectRspVOS);
    }
}
