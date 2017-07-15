package org.eBike.controller;

import java.util.ArrayList;
import java.util.List;

import org.eBike.bean.Person;
import org.eBike.bean.UserInfo;
import org.eBike.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerUser {
	private Logger logger = LoggerFactory.getLogger(ControllerUser.class);

	@Autowired
	private UserInfoService userService;

	@RequestMapping("/registerOK/{username}/{password}/{rePassword}/{Email}/{realName}/{province}")
	public String register(@PathVariable("username") String username, @PathVariable("password") String password,
			@PathVariable("rePassword") String rePassword, @PathVariable("Email") String email,
			@PathVariable("realName") String realName, @PathVariable("province") String province) {
		logger.info("userinfo:" + username);
		if (userService.queryByUserName(username) != 0) {
			return "existed";
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(username);
		userInfo.setPwd(password);
		userInfo.setEmail(email);
		userInfo.setProvince(province);
		userInfo.setRealName(realName);
		System.out.println("userinfo ok");

		int res = userService.insertUserInfo(userInfo);
		if (res > 0) {
			System.out.println("insert ok");
			return "registerOK";
		}
		return "404";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/register")
	public String register(Model model) {
		return "register";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submit(UserInfo userInfo) {

		logger.info("userinfo:" + userInfo.toString());
		// TODO: 查询数据
		// int info = userService.queryByUserName(userInfo.getUserName());
		// if (info == 0) {
		// // 用户名不存在，需要注册
		// logger.info(PrintUtils.User_Not_Existed);
		// return "UserNotExisted";
		// }
		// logger.info(PrintUtils.Login_OK);
		return "redirect:/successLogin";
	}

	@RequestMapping("/successLogin/{username}/{pwd}")
	public String successLogin(@PathVariable("username") String username, @PathVariable("pwd") String pwd) {
		logger.info("userinfo:" + username + pwd);
		return "successLogin";
	}

	@RequestMapping("/getQR")
	public String getQR(Model model) {
		return "getQR";
	}

	@RequestMapping("/")
	public String index(Model model) {
		Person single = new Person("aa", 11);
		List<Person> people = new ArrayList<>();
		Person p1 = new Person("zhangsan", 11);
		Person p2 = new Person("lisi", 22);
		Person p3 = new Person("wangwu", 33);
		people.add(p1);
		people.add(p2);
		people.add(p3);
		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);
		return "index";
	}

}
