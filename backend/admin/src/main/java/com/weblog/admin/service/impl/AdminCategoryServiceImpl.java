package com.weblog.admin.service.impl;

import com.weblog.common.enums.ResponseCodeEnum;
import com.weblog.admin.model.vo.category.AddCategoryReqVO;
import com.weblog.admin.service.AdminCategoryService;
import com.weblog.common.domain.dos.CategoryDO;
import com.weblog.common.domain.mapper.CategoryMapper;
import com.weblog.common.exception.BizException;
import com.weblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Response addCategory(AddCategoryReqVO addCategoryReqVO) {
        String categoryName = addCategoryReqVO.getName();

        CategoryDO categoryDO = categoryMapper.selectByName(categoryName);
        if (Objects.nonNull(categoryDO)) {
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_EXISTED);
        }

        CategoryDO insertCategoryDO = CategoryDO.builder()
                .name(categoryName)
                .build();
        categoryMapper.insert(insertCategoryDO);

        return Response.success();
    }
}
