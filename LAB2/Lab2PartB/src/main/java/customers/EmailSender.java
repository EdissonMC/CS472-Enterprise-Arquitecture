package customers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class EmailSender implements IEmailSender {


//	@Value("${outgoingMailServer}")
//	@Value("${spring.application.outgoingMailServer}")
	@Value("${spring.application.outgoingMailServer:smtp.acme.com}")
	String outgoingMailServer ;

//	String outgoingMailServer = "smtp.acme.com";

	private ILogger logger  ;//new Logger();

//	public EmailSender(ILogger logger) {
//		this.logger = logger;
//	}

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}


	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}


	@Autowired
	public void setLogger(ILogger logger){
		this.logger= logger;
	}

}
