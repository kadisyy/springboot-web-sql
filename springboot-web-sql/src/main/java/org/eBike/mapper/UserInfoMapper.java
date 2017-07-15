package org.eBike.mapper;

import org.eBike.bean.UserInfo;

public interface UserInfoMapper {
	public int queryByUserName(String userName);

	public int insertUserInfo(UserInfo userInfo);

	public int deleteUserInfo(UserInfo userInfo);
}
