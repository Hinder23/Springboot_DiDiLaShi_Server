package com.didilashi.service;

import java.util.Random;

import org.springframework.stereotype.Repository;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
@Repository
public class AlibabaSmsNumSendUtil {
	private static final String TaoBaoUrl="https://eco.taobao.com/router/rest";
    private static final String AppKey= "23631447";
    private static final String AppSecret= "b5a056a6c05b36b2bc380ec2689de054";
    private static final String SmsTemplateCode="SMS_45995043";
	
	 public  String  SmsNumSend( String mobile){
		 
		 //生成六位验证码
		 	Random random = new Random();
	        String genertedCode="";
	        for(int i=0;i<6;i++){
	        	genertedCode+=random.nextInt(10);
	        }
	        
	     //发送验证码
		 TaobaoClient client = new DefaultTaobaoClient(TaoBaoUrl, AppKey, AppSecret);
         AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
         req.setExtend(mobile);
         req.setSmsType("normal");
         req.setSmsFreeSignName("二家");
         req.setSmsParamString("{\"verification\":\""+genertedCode+"\"}");   				//变量中加入验证码
         req.setRecNum(mobile);
         req.setSmsTemplateCode(SmsTemplateCode);
         AlibabaAliqinFcSmsNumSendResponse rsp = null;
         try {
             rsp = client.execute(req);
         } catch (ApiException e) {
             e.printStackTrace();
         }   
       System.out.println(rsp.getBody());
       return genertedCode;
	 }

	public static void main(String[] args) {
		AlibabaSmsNumSendUtil alibabaSmsNumSendUtil=new AlibabaSmsNumSendUtil();	
		String codeString=alibabaSmsNumSendUtil.SmsNumSend("18758578355");
		System.out.println(codeString);
	}

	
	
}
