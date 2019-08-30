package com.pdsu.shop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pdsu.shop.entity.User;
import com.pdsu.shop.service.UserService;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	// 接收user
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	// 接收验证码:
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	//接收新密码
	private String password1;
	
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	// 注入userService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 跳转到注册页面
	public String registPage() {
		return "regist";
	}

	// 跳转到登录页面
	public String loginPage() {
		return "login";
	}
	//跳转到修改页面
	public String updatePage() {
		return "update";
	}
	// 异步查询用户名是否存在
	public String findByName() throws IOException {
		// 调用Service进行查询:
		User existUser = userService.findByUserName(user.getUsername());
		// 获得response对象,项页面输出:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}

	// 用户注册
	public String regist() {
		// 判断验证码程序:
		// 从session中获得验证码的随机值:
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("验证码输入错误!");
			return "registCheckcodeFail";
		}
		userService.save(user);
		return "login";
	}

	/**
	 * 登录的方法
	 */
	public String login() {
		// 判断验证码程序:
		// 从session中获得验证码的随机值:
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("验证码输入错误!");
			return "loginCheckcodeFail";
		}
		User existUser = userService.login(user);
		// 判断
		if (existUser == null) {
			// 登录失败
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return LOGIN;
		} else {
			// 登录成功
			// 将用户的信息存入到session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// 页面跳转
			return "loginSuccess";
		}

	}

	/**
	 * 用户退出的方法
	 */
	public String quit() {
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	/**
	 * 修改密码
	 * */
	public String update() {
		User existUser = userService.login(user);
		if(existUser == null) {
			// 登录失败
			this.addActionError("修改错误：原密码错误！");
			return "updateFail";
		}
		//System.out.println(password1);
		user.setPassword(password1);
		userService.update(user);
		return "updateSuccess";
	}
}