//
//
//
//package com.bitwiser.service;
//
//import com.resend.Resend;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    private final JavaMailSender mailSender;
//
//
//
//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void sendEmail(String to, String subject, String body) {
//
//        try {
//
//            SimpleMailMessage message = new SimpleMailMessage();
//
//            message.setTo(to);
//            message.setSubject(subject);
//            message.setText(body);
//
//            mailSender.send(message);
//
//            System.out.println("Email sent successfully to: " + to);
//
//        } catch (Exception e) {
//
//            System.out.println("Failed to send email to: " + to);
//            e.printStackTrace();
//
//            throw e;
//        }
//    }
//}


package com.bitwiser.service;

import com.resend.Resend;
import com.resend.services.emails.model.CreateEmailOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Resend resend;

    public EmailService(@Value("${RESEND_API_KEY}") String apiKey) {
        this.resend = new Resend(apiKey);
    }

    public void sendEmail(String to, String subject, String body) {

        try {

            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from("BitWiser <onboarding@resend.dev>")
                    .to(to)
                    .subject(subject)
                    .text(body)
                    .build();

            resend.emails().send(params);

            System.out.println("Email sent successfully");

        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}