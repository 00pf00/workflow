package workflow.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ServiceDelegate implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.print("hello world");
    }
}
