package com.jizhang.activiti;

import com.jizhang.activiti.entity.LeaveInfo;
import com.jizhang.activiti.entity.UserInfo;
import com.jizhang.activiti.mapper.LeaveMapper;
import com.jizhang.activiti.mapper.TestMapper;
import com.jizhang.activiti.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Aaron
 * @Date: 2019/9/11 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private UserInfoMapper userMapper;

    @Test
    public void userMapperTest(){
        UserInfo userInfo = userMapper.queryOneById(123);
        //UserInfo userInfo = userMapper.selectById(123);
        System.out.println(userInfo);
    }

    @Test
    public void testMapperTest(){
        LeaveInfo leaveInfo = testMapper.getById("18131403-262b-4f00-bb85-e4ff4a71d859");
        System.out.println(leaveInfo);
    }

    @Test
    public void leaveMapperTest(){
        LeaveInfo leaveInfo = leaveMapper.getById("18131403-262b-4f00-bb85-e4ff4a71d859");
        System.out.println(leaveInfo);
    }

}
