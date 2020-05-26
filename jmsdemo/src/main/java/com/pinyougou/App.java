package com.pinyougou;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI2nWDZVcrrQ8w", "dMIGrRR0SBZn6ymrXwhxh1M7v3oPnx");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");

        //手机号：
         request.putQueryParameter("PhoneNumbers", "13263394663");
        //request.putQueryParameter("PhoneNumbers", phoneNumber);

        //签名：
         request.putQueryParameter("SignName", "来嗨");
        //request.putQueryParameter("SignName", signName);

        //模板code
         request.putQueryParameter("TemplateCode", "SMS_126345035");
       // request.putQueryParameter("TemplateCode", templateCode);

        //模板的参数
        request.putQueryParameter("TemplateParam", "{\"code\":\"1111\"}");
       // request.putQueryParameter("TemplateParam", templateParam);

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
          //  return response;
        } catch (Exception e) {
            e.printStackTrace();
           // return null;
        }
    }
}
