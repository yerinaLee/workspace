package edu.kh.project.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.MultipartConfigElement;

@Configuration
@PropertySource("classpath:/config.properties")
public class FileConfig implements WebMvcConfigurer{
	
	@Value("${my.images.connectpath}")
	private String connectPath; // 외부 폴더로 연결될 웹 요청 주소
	
	@Value("${my.images.resourcepath}")
	private String resourcePath; // 외부 폴더 경로
	
    @Value("${spring.servlet.multipart.file-size-threshold}")
    private long fileSizeThreshold; // 파일을 디스크에 쓸 때까지의 임계값
   
    @Value("${spring.servlet.multipart.max-file-size}")
    private long maxFileSize; // 개별 파일당 최대 크기
   
    @Value("${spring.servlet.multipart.max-request-size}")
    private long maxRequestSize; // HTTP 요청당 최대 크기
   
    @Value("${spring.servlet.multipart.location}")
    private String location; // 파일의 임시 저장 경로
	
	
	// 요청 주소가 /images로 시작할 때 외부 폴더로 연결하는 메서드
	// (WebMvcConfigurer 상속 -> addResourceHandlers() 오버라이딩)
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(connectPath).addResourceLocations(resourcePath);
		
		/* 웹 요청 주소에 따른 추가적인 폴더 구분이 필요한 경우 */
		// -> 그냥 위 구문 따라서 추가(connectPath, resourcePath는 알맞게 작성)
		
		// 만약 /pdf/** 요청이 오면
		// file:///C:/workspace/project-resources/pdf/ 폴더로 연결
		registry.addResourceHandler("/pdf/**").addResourceLocations("file:///C:/workspace/project-resources/pdf/");
		
	}
	
	
	   // MultipartResolver 설정 bean 생성
	   @Bean
	   public MultipartConfigElement multipartConfigElement() {
	      MultipartConfigFactory factory = new MultipartConfigFactory();
	      
	      factory.setFileSizeThreshold(DataSize.ofBytes(fileSizeThreshold)); // 파일을 디스크에 쓸 때까지의 임계값(기본값 0B)
	      // 디스크에 저장하지 않고 메모리에 유지하도록 허용하는 바이트 단위의 최대 용량을 설정.
	      
	      factory.setMaxFileSize(DataSize.ofBytes(maxFileSize)); // 개별 파일당 최대 크기(기본값 1MB)
	      
	      factory.setMaxRequestSize(DataSize.ofBytes(maxRequestSize)); // 요청당 최대 크기 (기본값 10MB)
	      
	      factory.setLocation(location); // 임시 저장 경로
	      
	      return factory.createMultipartConfig();
	   }
	   
	   // MultipartResolver : 
	   // 텍스트 요청 데이터(문자열, 숫자 등등)는 String으로 변환
	   // File 요청 데이터는 MultipartFile로 변환해서
	   // Controller 메서드로 전달
	   
	   // MultipartResolver bean 생성
	   @Bean
	   public MultipartResolver multipartResolver() {
	      StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
	      return multipartResolver;
	   }
	   
	   
}
