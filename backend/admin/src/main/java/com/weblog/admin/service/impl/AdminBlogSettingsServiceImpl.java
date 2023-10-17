package com.weblog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weblog.admin.convert.BlogSettingsConvert;
import com.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.weblog.admin.service.AdminBlogSettingsService;
import com.weblog.common.domain.dos.BlogSettingsDO;
import com.weblog.common.domain.mapper.BlogSettingsMapper;
import com.weblog.common.utils.Response;
import org.springframework.stereotype.Service;

@Service
public class AdminBlogSettingsServiceImpl extends ServiceImpl<BlogSettingsMapper, BlogSettingsDO> implements AdminBlogSettingsService {
    @Override
    public Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO) {
        // VO 转DO
        BlogSettingsDO blogSettingsDO = BlogSettingsConvert.INSTANCE.convertVO2DO(updateBlogSettingsReqVO);
        blogSettingsDO.setId(1L);
        saveOrUpdate(blogSettingsDO);
        return Response.success();
    }
}
