package org.eBike.service;

import org.eBike.bean.UserInfo;
import org.eBike.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public int queryByUserName(String userName) {
		return userInfoMapper.queryByUserName(userName);
	}

	public int insertUserInfo(UserInfo userInfo) {
		return userInfoMapper.insertUserInfo(userInfo);
	}

}
