/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class config {
    public static final int UPLOAD_SIZE = 10000000;
    @Bean(name = "multipartResolver")
public CommonsMultipartResolver multipartResolver()
{
  CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
  multipartResolver.setMaxUploadSize( UPLOAD_SIZE );
  return new CommonsMultipartResolver();
}
}
