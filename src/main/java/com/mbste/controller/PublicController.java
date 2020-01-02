package com.mbste.controller;

import com.mbste.ExceptionH.NotFoundException;
import com.mbste.commons.security.ClientAuthenticationService;
import com.mbste.commons.utils.ReturnUtil;
import com.mbste.model.Appoitement;
import com.mbste.model.Client;
import com.mbste.model.ClientFilter;
import com.mbste.model.Cnt;
import com.mbste.model.filters.AppoitementFilter;
import com.mbste.model.filters.ClientForm;
import com.mbste.model.filters.LoginForm;
import com.mbste.service.ApoitementService;
import com.mbste.service.ClientService;
import com.mbste.service.NotificationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/public/twese")
public class PublicController {

    String password;

    @NonNull
    @Autowired
    ClientAuthenticationService authentication;
    @NonNull
    @Autowired
    ClientService clientService;

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    Integer register(@RequestBody ClientForm clientForm) {
        return clientService.createNewClient(clientForm);
    }

    @Autowired
    ApoitementService apoitementService;

    @Autowired
    private NotificationService notificationService;

    //
//    String register(@RequestParam("username") final String username,
//                    @RequestParam("password") final String password) {
//        users.save(new User(username,username,password));
//        return login(username, password);
//    }
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    Client login(@RequestBody LoginForm loginForm) {
        Map<String, Object> resultMap = new HashMap<>();

        Optional<String> token = authentication.login(loginForm.getUsername(), loginForm.getPassword());
        // System.err.println("@@@@@@@@$#$#@"+token.toString());
        Optional<Client> client = null;
        Client client2 = null;
        if (token.isPresent()) {
            client = clientService.findByUsername(loginForm.getUsername());
            client2 = client.get();

            client2.setToken(token.get());
//            resultMap.put("token", token);
//            resultMap.put("user", client);
//        return authentication.login(username, password)
//                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));

//            return ReturnUtil.resultSuccess(resultMap);
            return client2;
        }
        throw new NotFoundException("invalid username or password");
    }


    @PostMapping(value = "/forget", produces = "application/json;charset=UTF-8")
    String forget(@RequestBody LoginForm loginForm) {
        Map<String, Object> resultMap = new HashMap<>();

        Optional<String> token = authentication.findByPhoneNumber(loginForm.getUsername(), loginForm.getPhoneNumber());
        // System.err.println("@@@@@@@@$#$#@"+token.toString());
        Optional<Client> client1 = null;
        if (!token.isPresent()) {
            throw new NotFoundException("invalid username or phoneNumber");
        }
        client1 = clientService.findByUsername(loginForm.getUsername());
        resultMap.put("token", token);
        resultMap.put("user", client1);


        return ReturnUtil.resultSuccess(resultMap);

    }

    @RequestMapping("/createTable")
    public int creteT() {
        notificationService.dropTable();
        apoitementService.dropTable();
        clientService.dropTable();
        return apoitementService.createTable() | notificationService.createTable() | clientService.createTable();
    }

    /**
     * get technicians
     *
     * @return
     */
    @PostMapping(value = "/clients/all", produces = "application/json;charset=UTF-8")
    public List<Cnt> getAll(@RequestBody ClientFilter filter) {
        return clientService.getAll(filter);
    }


    @PostMapping(value = "/send", produces = "application/json;charset=UTF-8")
    public String email(@RequestBody ClientFilter filter) {

        password = clientService.getPassword(filter.getEmail());

        if (password == null) {
            return "invalid email";
        } else {
            try {
                sendMail(password,filter.getEmail());
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.print(e.getMessage());
            }
            return "Email sent succesfully";
        }
    }

    public void sendMail(String password,String email) throws AddressException, MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 25);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rugatete100@gmail.com", "gatete4321");//"dgatete4321@gmail.com","gatete1234");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("rugatete100@gmail.com", false));
        ((MimeMessage) msg).setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

        msg.setSubject("password recovery");
        msg.setContent("password:"+password, "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent("gatete agiryr", "text/html");

//        Multipart multipart=new MimeMultipart();
//        multipart.addBodyPart(mimeBodyPart);
//        MimeBodyPart bodyPart=new MimeBodyPart();
//        bodyPart.attachFile(new File("C://Users//Oops//Desktop//now"));
//        multipart.addBodyPart(bodyPart);
//        msg.setContent(multipart);
        Transport.send(msg);
    }

}
