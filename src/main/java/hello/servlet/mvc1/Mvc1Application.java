package hello.servlet.mvc1;

import hello.servlet.mvc1.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class Mvc1Application {

    public static void main(String[] args) {

        SpringApplication.run(Mvc1Application.class, args);
    }

    //기존엔 이렇게 했지만 이젠 스프링 부트가 properties에 적으면  해주기 때문에 안해두됨
   /* @Bean
    ViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/views",".jsp");
    }*/

   /* @Bean
    SpringMemberFormControllerV1 springMemberFormControllerV1(){
        return new SpringMemberFormControllerV1();
    }*/

}
