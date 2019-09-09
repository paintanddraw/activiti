package com.jizhang.activiti.mapper;

import com.jizhang.activiti.annotation.DynamicSwitchDataSource;
import com.jizhang.activiti.constants.DataSourceConstants;
import com.jizhang.activiti.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author aaron
 * @since 2019-09-09
 */
@DynamicSwitchDataSource(dataSource = DataSourceConstants.DEFAULT_DATASOURCE)
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
