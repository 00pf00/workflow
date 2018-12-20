package workflow.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.JpaTransactionManager;
import workflow.SpringUtil.BeanUtil;

@Configuration
public class EngineConfig {

    @Autowired
    private Environment env;

    @Bean(name = "engineconfig")
    @ConfigurationProperties(prefix = "spring.datasource")
     public SpringProcessEngineConfiguration getEngine(){
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.druid.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.druid.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.druid.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.druid.password"));
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setTransactionManager((JpaTransactionManager)BeanUtil.getBeanByName("transactionManager"));
        return  springProcessEngineConfiguration;
     }
}
