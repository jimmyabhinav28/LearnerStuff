package dev.abhinav.restapis;

//import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParametersAndHeaders {

	private Map<String, String> headers;
	private Map<String, String> pathParameters;
	private Map<String, String> queryParameters;
}
