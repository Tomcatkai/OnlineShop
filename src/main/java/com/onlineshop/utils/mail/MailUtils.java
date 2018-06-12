package com.onlineshop.utils.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * 邮件工具类
 *
 * @author kaizhang
 * @create 2018-04-07 16:05
 **/

public class MailUtils {
    public static Session createSession(String host, final String username, final String password) {
        Properties prop = new Properties();
        // 指定主机
        prop.setProperty("mail.host", host);
        // 指定验证为true
        prop.setProperty("mail.smtp.auth", "true");

        // 创建验证器
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // 获取session对象
        return Session.getInstance(prop, auth);
    }

    /**
     * 发送指定的邮件
     *
     * @param mail
     */
    public static void send(Session session, final Mail mail) throws MessagingException,
            IOException {

        // 创建邮件对象
        MimeMessage msg = new MimeMessage(session);
        // 设置发件人
        msg.setFrom(new InternetAddress(mail.getFrom()));
        // 设置收件人
        msg.addRecipients(MimeMessage.RecipientType.TO, mail.getToAddress());

        // 设置抄送
        String cc = mail.getCcAddress();
        if (!cc.isEmpty()) {
            msg.addRecipients(MimeMessage.RecipientType.CC, cc);
        }

        // 设置暗送
        String bcc = mail.getBccAddress();
        if (!bcc.isEmpty()) {
            msg.addRecipients(MimeMessage.RecipientType.BCC, bcc);
        }
        // 设置主题
        msg.setSubject(mail.getSubject());
        // 创建部件集对象
        MimeMultipart parts = new MimeMultipart();
        // 创建一个部件
        MimeBodyPart part = new MimeBodyPart();
        // 设置邮件文本内容
        part.setContent(mail.getContent(), "text/html;charset=utf-8");
        // 把部件添加到部件集中
        parts.addBodyPart(part);

        ///////////////////////////////////////////

        // 添加附件
        // 获取所有附件
        List<AttachBean> attachBeanList = mail.getAttachs();
        if (attachBeanList != null) {
            for (AttachBean attach : attachBeanList) {
                // 创建一个部件
                MimeBodyPart attachPart = new MimeBodyPart();
                // 设置附件文件
                attachPart.attachFile(attach.getFile());
                // 设置附件文件名
                attachPart.setFileName(MimeUtility.encodeText(attach
                        .getFileName()));
                String cid = attach.getCid();
                if(cid != null) {
                    attachPart.setContentID(cid);
                }
                parts.addBodyPart(attachPart);
            }
        }
        // 给邮件设置内容
        msg.setContent(parts);
        // 发邮件
        Transport.send(msg);
    }
}
