package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.javabean.User;
import com.example.demo.service.IArticleService;
import com.example.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDruidApplicationTests {

    @Autowired
    IArticleService articleService;
    @Autowired
    IUserService iUserService;

    @Test
    public void test2() {
        long l = System.currentTimeMillis();
        List<User> emps = iUserService.list(
                new QueryWrapper<User>()
                        .eq("id", 22)
                        .or()
                        .eq("id", 21)
        );
        for (User emp : emps) {
            System.err.println(emp.getNickname());
        }
        long l1 = System.currentTimeMillis();
        System.err.println(l1 - l);
//        System.err.println(articleService.getById(108));
    }

    @Autowired
    //用于发送邮件
    private JavaMailSender jms;

    @Test
    /*发送文本文件*/
    public void sendTextEmail() {
        //用于封装邮件信息的实例
        SimpleMailMessage smm = new SimpleMailMessage();
        //由谁来发送邮件
        smm.setFrom("1972780113@qq.com");
        //邮件主题
        smm.setSubject("Hello");
        //邮件内容
        smm.setText("Hello SpringBoot_Email");
        //接收邮件
        smm.setTo("findingway@yeah.net");
        try {
            jms.send(smm);
            System.err.println("发送成功");
        } catch (Exception e) {
            System.err.println("发送失败///" + e.getMessage());
        }
    }

    @Test
    /*发送HTML文件*/
    public void sendHTMLEmail() throws MessagingException {
        //用于封装邮件信息的实例
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper smm = new MimeMessageHelper(message, true);
        //由谁来发送邮件
        smm.setFrom("1972780113@qq.com");
        //邮件主题
        smm.setSubject("Hello");
        //邮件内容
        smm.setText("<html>\n" +
                "<body>\n" +
                "<a href=\"http://www.w3school.com.cn\">W3School</a>"+
                "</body></html> ", true);
        //接收邮件
        smm.setTo("findingway@yeah.net");
        try {
            jms.send(message);
            System.err.println("发送成功");
        } catch (Exception e) {
            System.err.println("发送失败///" + e.getMessage());
        }
    }

}
