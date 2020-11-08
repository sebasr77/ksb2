package pl.sebasr.ksb2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.sebasr.ksb2.service.MailService;

@Aspect
@Component
public class VideoAspect {

//    @Before("execution(void pl.sebasr.ksb2.controller.VideoApi.addVideo())")
//    private void beforeVideo(){
//        System.out.println("beforeVideo");
//    }

//    @Before("@annotation(SendMail)")
//    private void beforeVideo(){
//        System.out.println("beforeVideo");
//    }


    private MailService mailService;
    @Value("${receiver}")
    private String mailTo;

    @Autowired
    public VideoAspect(MailService mailService) {
        this.mailService = mailService;
    }

    @Around("@annotation(VideoMail)")
    private boolean sendEmail(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Sending email");
        mailService.sendMail(mailTo,
                "Wygrałeś",
                "<b>1000 000 zł</b><br>:P", true);
        proceedingJoinPoint.proceed();
        return true;
    }
}
