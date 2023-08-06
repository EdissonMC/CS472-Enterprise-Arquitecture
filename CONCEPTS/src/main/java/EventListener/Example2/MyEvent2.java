package EventListener.Example2;

import org.springframework.context.ApplicationEvent;

public class MyEvent2  extends ApplicationEvent {

    String message;
    public MyEvent2(Object source, String message) {
        super(source);
        this.message= message;
    }

    public String getMessage() {
        return message;
    }
}