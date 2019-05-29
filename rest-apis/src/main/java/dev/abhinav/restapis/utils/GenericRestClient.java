package dev.abhinav.restapis.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GenericRestClient {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * Query parameters have no problems at all Path variables on the other hand to
	 * 
	 * @param scheme
	 * @param hostname
	 * @param port
	 * @param resourcePath    Templatised resource path. The placeholders need to in
	 *                        { }. E.g: /{version}/getdetails/{userId} version and
	 *                        userId are the placeholders
	 * @param pathVariables   pass the placeholders in resource template as keys in
	 *                        the map to avoid binding failures.
	 * @param queryParameters
	 * @return
	 */
	private URI getURIwithRequestVariablesAndQueryParameters(String scheme, String hostname, Integer port,
			String resourcePath, Map<String, String> pathVariables, MultiValueMap<String, String> queryParameters)
			throws URISyntaxException {
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
		builder = builder.scheme(scheme); // restrict scheme to http or https?
		builder = builder.host(hostname);
		builder = builder.port(port);
		builder = builder.path(resourcePath);
		if (pathVariables != null) {
			Map<String, Object> uriVariables = new HashMap<String, Object>(pathVariables);
			builder = builder.uriVariables(uriVariables);
		}
		if (queryParameters != null) {
			builder = builder.queryParams(queryParameters);
		}
		builder = builder.encode();
		return builder.build().toUri(); // known to throw URISyntaxException at runtime. explicitly including it in
										// the throws declaration here
	}

	public ResponseEntity makeGetCall(String scheme, String hostname, Integer port, String resourcePath,
			Map<String, String> pathVariables, MultiValueMap<String, String> queryParameters,
			MultiValueMap<String, String> headers, Class responseType) throws RestClientException {
		URI uriWithPathAndQueryParameters = null;
		try {
			uriWithPathAndQueryParameters = getURIwithRequestVariablesAndQueryParameters(scheme, hostname, port,
					resourcePath, pathVariables, queryParameters);
		} catch (URISyntaxException ex) {
			String message = "error forming url for GET call";
			log.error(message, ex);
			throw new RestClientException(message, ex);

		}
		HttpEntity requestEntity = new HttpEntity(headers);

		return restTemplate.exchange(uriWithPathAndQueryParameters, HttpMethod.GET, requestEntity, responseType);
	}

	public ResponseEntity makePOSTCall(String scheme, String hostname, Integer port, String resourcePath,
			Map<String, String> pathVariables, MultiValueMap<String, String> queryParameters,
			MultiValueMap<String, String> headers, Class responseType) throws RestClientException {
		URI uriWithPathAndQueryParameters;
		try {
			uriWithPathAndQueryParameters = getURIwithRequestVariablesAndQueryParameters(scheme, hostname, port,
					resourcePath, pathVariables, queryParameters);
		} catch (URISyntaxException ex) {
			String message = "error forming url for POST call";
			log.error(message, ex);
			throw new RestClientException(message, ex);

		}
		HttpEntity requestEntity = new HttpEntity(headers);

		return restTemplate.exchange(uriWithPathAndQueryParameters, HttpMethod.GET, requestEntity, responseType);
	}

}
