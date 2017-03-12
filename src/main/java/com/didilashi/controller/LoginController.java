package com.didilashi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.didilashi.bean.User;
import com.didilashi.service.AlibabaSmsNumSendUtil;
import com.didilashi.service.UserService;


@RestController
public class LoginController {

	@Autowired
	private AlibabaSmsNumSendUtil code;
	
	@Autowired
	private UserService userService;
	
	//手机登录功能
			@RequestMapping(method=RequestMethod.GET,value="/login/{phone}/{password}")
			public String login(HttpSession session,HttpServletRequest request,
					HttpServletResponse response,@PathVariable("phone") String phone,
					@PathVariable("password") String password) throws IOException{
				
				response.setContentType("text/html;charset=utf-8");
				User user=userService.findByPhone(phone);
				System.out.println(user.getPassword());
				String corPassword=user.getPassword();
				if (user!=null&& corPassword.equals(password)) {
				/*	OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
					writer.write("登录成功");
					writer.flush();*/
					return "登录成功";
				}else{
					/*OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
					writer.write("用户名或密码不正确");
					writer.flush();*/
					return "用户名或密码不正确";
				}		
			}
		
	//手机验证码功能--注册
			@RequestMapping(method=RequestMethod.GET,value="/sendVerificationText/{phone}")
			public String getCode(HttpSession session,HttpServletRequest request,HttpServletResponse response,@PathVariable("phone") String phone) throws IOException{
				String verification=code.SmsNumSend(phone);
				System.out.println(phone+":"+verification);
				/*OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
				writer.write(verification);
				writer.flush();*/
				return verification;
			}	
			
			//手机注册
			@RequestMapping(method=RequestMethod.GET,value="/sign/{data}")
			public String sign(HttpSession session,HttpServletRequest request,HttpServletResponse response,@PathVariable("data") String data) throws IOException, JSONException{
				response.setContentType("text/html;charset=utf-8");
				System.out.println(data);
				
				JSONObject object=new JSONObject(data);
				String input_phone=object.getString("Phone");
				String input_username=object.getString("Username");
				String input_password=object.getString("Password");
				
		    	System.out.println(input_phone+input_username+input_password);   
				
				
				User user=new User();
				user.setPhone(input_phone);
				user.setUsername(input_username);
				user.setPassword(input_password);
				System.out.println(user.getUsername());
				userService.save(user);
				/*OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
				writer.write("注册成功");
				writer.flush();*/
				return "注册成功";
			}
			
	
}
