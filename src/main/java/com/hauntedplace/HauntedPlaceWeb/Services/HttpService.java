package com.hauntedplace.HauntedPlaceWeb.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hauntedplace.HauntedPlaceWeb.Models.StringWrapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;


public class HttpService implements HttpServiceAbstract {

    public HttpService() {
    }

    @Override
    public <T> T post(String uri, Object body, Class<T> responseType, String token){
        try{
            HttpRequest.Builder buildingRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .POST(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(body)));
            HttpRequest postRequest = generateHeaderDefault(buildingRequest, token).build();
            return sendRequest(postRequest, token, responseType);
        }catch (Exception e){
            return null;
        }
    }

    public <T> T postFile(String uri, MultipartFile fileToSend, Class<T> responseType, String token){
        try{
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", fileToSend.getResource());
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.postForEntity(uri, requestEntity, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.getBody(), responseType);
             //return restTemplate.getForObject(Objects.requireNonNull(response.getHeaders().getLocation()), responseType);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public <T> T put(String uri, Object body, Class<T> responseType, String token) {
        try{

            HttpRequest.Builder buildingRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .PUT(HttpRequest.BodyPublishers.ofString(new ObjectMapper().writeValueAsString(body)));

            HttpRequest putRequest = generateHeaderDefault(buildingRequest, token).build();
            return sendRequest(putRequest, token, responseType);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public <T> T delete(String uri, Class<T> responseType, String token) {
        try{

            HttpRequest.Builder buildingRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .DELETE();
            HttpRequest deleteRequest = generateHeaderDefault(buildingRequest, token).build();
            return sendRequest(deleteRequest, token, responseType);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public <T> T get(String uri, Class<T> responseType, String token) {
        try{

            HttpRequest.Builder buildingRequest = HttpRequest.newBuilder().uri(URI.create(uri)).GET();

            HttpRequest getRequest = generateHeaderDefault(buildingRequest, token).build();
            return sendRequest(getRequest, token, responseType);
        }catch (Exception e){
            return null;
        }
    }

    private <T> T sendRequest(HttpRequest request, String token, Class<T> responseType) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        verifyResponse(response);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(), responseType);
    }

    private <T> void verifyResponse(HttpResponse<T> response) throws Exception {
        var statusCode = response.statusCode();
        if (statusCode == HttpStatus.OK.value() || statusCode == HttpStatus.CREATED.value() || statusCode == HttpStatus.ACCEPTED.value() ) return;
        throw new Exception(String.valueOf(response.body()));
    }

    private HttpRequest.Builder generateHeaderDefault(HttpRequest.Builder request , String token) {
        request.header("Content-Type", "application/json");
        if (token != null)
            request.header("Authorization", "Bearer " + token);
        return request;
    }

    private HttpRequest.Builder generateHeaderFile(HttpRequest.Builder request , String token) {
        request.header("Content-Type", "multipart/form-data");
        if (token != null)
            request.header("Authorization", "Bearer " + token);
        return request;
    }
}
