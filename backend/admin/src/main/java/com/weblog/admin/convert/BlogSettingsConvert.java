package com.weblog.admin.convert;

import com.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.weblog.common.domain.dos.BlogSettingsDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogSettingsConvert {
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    BlogSettingsDO convertVO2DO(UpdateBlogSettingsReqVO bean);
}
