package com.cracovisit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.cracovisit.data.AttractionDAO;
import com.cracovisit.data.DataAccessInterface;
import com.cracovisit.models.AttractionModel;
import com.cracovisit.models.EventModel;
import com.cracovisit.models.FeedbackModel;
import com.cracovisit.models.LocationModel;
import com.cracovisit.models.MonumentModel;
import com.cracovisit.models.UserModel;
import com.cracovisit.services.AttractionService;
import com.cracovisit.services.AttractionServiceInterface;
import com.cracovisit.services.EventService;
import com.cracovisit.services.EventServiceInterface;
import com.cracovisit.services.LocationService;
import com.cracovisit.services.LocationServiceInterface;
import com.cracovisit.services.MonumentService;
import com.cracovisit.services.MonumentServiceInterface;
import com.cracovisit.services.UserService;
import com.cracovisit.services.UserServiceInterface;
import com.cracovisit.services.FeedbackService;
import com.cracovisit.services.FeedbackServiceInterface;
import com.cracovisit.data.UserDAO;
import com.cracovisit.data.LocationDAO;
import com.cracovisit.data.MonumentDAO;
import com.cracovisit.data.FeedbackDAO;
import com.cracovisit.data.EventDAO;

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
    
    @Bean(name = "locationDao")
    @RequestScope
    DataAccessInterface<LocationModel, Long> getLocationDao()
	{
		return new LocationDAO(dataSource);
	}
    
    @Bean(name = "monumentDao")
    @RequestScope
    DataAccessInterface<MonumentModel, Long> getMonumentDao()
	{
		return new MonumentDAO(dataSource);
	}
    
    @Bean(name = "eventDao")
    @RequestScope
    DataAccessInterface<EventModel, Long> getEventDao()
	{
		return new EventDAO(dataSource);
	}
    
    @Bean(name = "feedbackDao")
    @RequestScope
    DataAccessInterface<FeedbackModel, Long> getFeedbackDao()
	{
		return new FeedbackDAO(dataSource);
	}
    
    @Bean(name = "userService", initMethod = "init", destroyMethod = "destroy")
    UserServiceInterface getUserService()
	{
		return new UserService();
	}
    
    @Bean(name = "locationService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    LocationServiceInterface getLocationService()
	{
		return new LocationService();
	}
    
    @Bean(name = "monumentService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    MonumentServiceInterface getMonumentService()
	{
		return new MonumentService();
	}
    
    @Bean(name = "eventService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
   EventServiceInterface getEventService()
	{
		return new EventService();
	}
    
    
    @Bean(name = "feedbackService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    FeedbackServiceInterface getFeedbackService()
	{
		return new FeedbackService();
	}

}
