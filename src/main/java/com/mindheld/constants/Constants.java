package com.mindheld.constants;

public class Constants {

	//security
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final String SIGNING_KEY = "mindheld1qrt2";
    public static final String TOKEN_PREFIX = "Mindheld";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
    
    public static final String[] NON_AUTHENTICATED_URLS = {
    		"/token/*", 
    		"/signup", 
    		"/photos/*", 
    		"/photos/games/*", 
    		"/photos/games/*/*",
    		"/*/public/*",
    		"/*/public/*/*"
    		};
    
    //photo handler
    
//    public static final String PHOTOS_PATH = "src/main/resources/static/photos/";
    public static final String PHOTOS_PATH = "../webapps/mindheld/WEB-INF/classes/static/photos/";
//    public static final String PHOTOS_URL = "http://localhost:8085/photos/";
    public static final String PHOTOS_URL = "http://5.189.175.156:8085/mindheld/photos/";
    public static final String SUPPORT_FILES_URL = "http://localhost:8085/supportFiles/";
    public static final String SUPPORT_FILES_PATH = "src/main/resources/static/supportFiles/";
	public static final String JPG = ".jpg";
	public static final String PDF = ".pdf";
	
	//security
	
	public static final String ADMIN = "ADMIN";
	public static final String TEACHER = "TEACHER";
}
