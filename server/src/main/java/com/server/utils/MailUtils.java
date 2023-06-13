package com.server.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailUtils {

    @Value("${mail.senderMail}")
    private String sender;

    @Value("${mail.smtpPassword}")
    private String smtpPassword;


    /**
     * 发送邮件信息
     * @param mail 收件人邮箱
     * @param title 邮件标题
     * @param text 邮件正文
     * @return
     */
    public static boolean sendMail(String mail,String title,String text){
        MailUtils mailUtils=new MailUtils();
        String sender=mailUtils.sender;
        String smtpPassword=mailUtils.smtpPassword;
        final Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        String[] strings=sender.split("@");
        String host="smtp."+strings[strings.length-1];
        properties.put("mail.smtp.host",host);
        properties.put("mail.user",sender);
        properties.put("mail.password",smtpPassword);

        //构建授权信息，用于进行SMTP身份认证
        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username=properties.getProperty("mail.user");
                String password=properties.getProperty("mail.password");
                return new PasswordAuthentication(username,password);
            }
        };
        //使用环境属性和授权信息，创建邮件会话
        Session mailSession=Session.getInstance(properties,authenticator);
        //创建邮件消息
        MimeMessage mimeMessage=new MimeMessage(mailSession);
        try {
            //设置发件人
            String username=properties.getProperty("mail.user");
            InternetAddress form=new InternetAddress(username);
            mimeMessage.setFrom(form);
            //设置收件人
            InternetAddress toAddress=new InternetAddress(mail);
            mimeMessage.setRecipients(Message.RecipientType.TO, String.valueOf(toAddress));
            //设置邮件标题
            mimeMessage.setSubject(title);
            //设置邮件内容
            mimeMessage.setContent(text,"text/html;charset=UTF-8");
            //发送邮件
            Transport.send(mimeMessage);
            return true;
        } catch (AddressException e) {
            e.printStackTrace();
            return false;
//            throw new RuntimeException(e);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
//            throw new RuntimeException(e);
        }
    }

}
