package workflow.SpringUtil;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtil.applicationContext = applicationContext;
    }

    public static  Object getBeanByName(String beanname){
        if (applicationContext == null){
            return null;
        }else{
            return applicationContext.getBean(beanname);
        }
    }
}
