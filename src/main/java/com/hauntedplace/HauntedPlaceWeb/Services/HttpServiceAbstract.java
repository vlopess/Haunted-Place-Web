package com.hauntedplace.HauntedPlaceWeb.Services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public interface HttpServiceAbstract {

    public <T> Object post(String uri, Object body, Class<T> responseType, String token) ;
    public <T> T put(String uri, Object body, Class<T> responseType, String token);
    public <T> T delete(String uri, Class<T> responseType, String token);
    public <T> T get(String uri, Class<T> responseType, String token);
}
