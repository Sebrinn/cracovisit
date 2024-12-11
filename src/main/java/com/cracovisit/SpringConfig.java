package com.cracovisit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.cracovisit.data.AttractionDAO;
import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.AttractionModel;
import com.cracovisit.models.UserModel;
import com.cracovisit.services.AttractionService;
import com.cracovisit.services.AttractionServiceInterface;
import com.cracovisit.services.UserService;
import com.cracovisit.services.UserServiceInterface;
import com.cracovisit.data.UserDAO;

@Configuration
public class SpringConfig {
	
	
    @Bean(name = "attractionService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    AttractionServiceInterface getAttractionService()
	{
		return new AttractionService();
	}

    @Autowired
    DataSource dataSource;
    
    @Bean(name = "attractionDao")
    @RequestScope
    DataAccessInterface<AttractionModel, String> getAttracionDao()
	{
		return new AttractionDAO(dataSource);
	}
    
    @Bean(name = "userDao")
    @RequestScope
    DataAccessInterface<UserModel, String> getUserDao()
	{
		return new UserDAO(dataSource);
	}
    
    @Bean(name = "userService", initMethod = "init", destroyMethod = "destroy")
    UserServiceInterface getUserService()
	{
		return new UserService();
	}

}
