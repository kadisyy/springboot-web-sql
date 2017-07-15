package org.eBike.controller;

import org.eBike.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordControllerUser {
	private Logger logger = LoggerFactory.getLogger(WordControllerUser.class);

	@Autowired
	private UserInfoService userService;
	//
	// @RequestMapping("/register")
	// public String register(@PathParam("username") String username,
	// @PathParam("password") String password,
	// @PathParam("rePassword") String rePassword, @PathParam("Email") String
	// email,
	// @PathParam("realName") String realName) {
	// logger.info("userinfo:" + username);
	// return "success";
	// }

}
