package org.example;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://94.198.50.185:7081/api/users";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String key = response.getHeaders().get("Set-Cookie")
                .get(0).substring(0, response.getHeaders()
                        .get("Set-Cookie").get(0).indexOf(';'));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Cookie",key);

        User user = new User();
        user.setId(3L);
        user.setName("James");
        user.setLastName("Brown");
        user.setAge((byte)20);
        HttpEntity<User>httpEntity = new HttpEntity<>(user, httpHeaders);
        String response1 = restTemplate.postForObject(url,httpEntity,String.class);

        user.setId(3L);
        user.setName("Tomas");
        user.setLastName("Shelbi");
        HttpEntity<User>httpEntity1 = new HttpEntity<>(user,httpHeaders);
        String response2 = restTemplate.exchange(url, HttpMethod.PUT,httpEntity,String.class).getBody();

        HttpEntity<User>httpEntity2 = new HttpEntity<>(httpHeaders);
        String response3 = restTemplate.exchange(url+"/3",HttpMethod.DELETE,httpEntity2,String.class).getBody();

        System.out.println(response1+response2+response3);
    }
}