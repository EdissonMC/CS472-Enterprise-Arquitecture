package EventListener.Example1;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    String message;
    public MyEvent(Object source, String message) {
        super(source);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
