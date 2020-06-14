package com.task;

import com.task.dao.LoginDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configtion {

    @Bean
    public LoginDao getLoginDao(){

        LoginDao loginDao = new LoginDao();

        return loginDao;
    }


}
