package dev.abhinav.restapis.utils;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestClientUtils {

	@Autowired
	RestTemplate restTemplate;
	
	private URI getURIwithRequestVariablesAndQueryParameters(String scheme, String hostname, Integer port,
			String resourcePath, Map<String, String> pathVariables, MultiValueMap<String, String> queryParameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
		builder = builder.scheme(scheme); // restrict scheme to http or https?
		builder = builder.host(hostname);
		builder = builder.port(port);
		builder = builder.path(resourcePath);
		if(pathVariables!=null)
		{
			Map<String, Object> uriVariables = new HashMap<String, Object>(pathVariables);
			builder = builder.uriVariables(uriVariables);
		}
		if(queryParameters!=null)
		{
		builder = builder.queryParams(queryParameters);
		}
		builder = builder.encode();
		return builder.build().toUri();
	}
	
	public ResponseEntity makeGetCall(String scheme, String hostname, Integer port,
			String resourcePath, Map<String, String> pathVariables, MultiValueMap<String, String> queryParameters,MultiValueMap<String, String> headers, Class responseType)
	{
		URI uriWithPathAndQueryParameters= getURIwithRequestVariablesAndQueryParameters(scheme, hostname, port, resourcePath, pathVariables, queryParameters);
		HttpEntity requestEntity=new HttpEntity(headers);
		
		return restTemplate.exchange(uriWithPathAndQueryParameters, HttpMethod.GET, requestEntity, responseType);
	}
	
	public ResponseEntity makePOSTCall(String scheme, String hostname, Integer port,
			String resourcePath, Map<String, String> pathVariables, MultiValueMap<String, String> queryParameters,MultiValueMap<String, String> headers, Class responseType)
	{
		URI uriWithPathAndQueryParameters= getURIwithRequestVariablesAndQueryParameters(scheme, hostname, port, resourcePath, pathVariables, queryParameters);
		HttpEntity requestEntity=new HttpEntity(headers);
		
		return restTemplate.exchange(uriWithPathAndQueryParameters, HttpMethod.GET, requestEntity, responseType);
	}
	
}
