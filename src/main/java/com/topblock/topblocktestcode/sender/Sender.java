package com.topblock.topblocktestcode.sender;

import com.topblock.topblocktestcode.services.ClassService;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Sender {


public static void postData() {
    try {
    //the path for the post request
    String url = "http://54.90.99.192:5000/challenge";
    // instantiating a RestTemplate.
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    JSONObject personJsonObject = new JSONObject();
    personJsonObject.put("id", "imorhir@mail.depaul.edu");
    personJsonObject.put("name", "Issam Morhir");
    personJsonObject.put("average", ClassService.average());
    personJsonObject.put("studentIds", ClassService.getFemaleCsMajor());
    HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
    System.out.println(restTemplate.postForObject(url, request, String.class));

    }catch(Exception e){

    }

}
}
