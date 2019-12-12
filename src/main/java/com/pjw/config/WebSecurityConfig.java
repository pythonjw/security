package com.pjw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true) //启用Spring Security的@Secured注解
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用Spring Security的@PreAuthorize,在类或者方法上使用
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //定义用户信息服务
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //基于内存的
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("pakhm").password("123").authorities("p1").build());
//        manager.createUser(User.withUsername("meinv").password("456").authorities("p2").build());
//        return manager;
//    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        //直接判断密码，判断密码是不是123，实际开发不这么做
        return NoOpPasswordEncoder.getInstance();
    }
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭csrf
            .authorizeRequests()
            .antMatchers("/hello/*").authenticated()  //所有 /hello/**需要通过认证
            .antMatchers("/game/*").hasAuthority("p2")    //通过认证之后需要有p2权限
                //.antMatchers("/game/*").access("hasAuthority('p1') and hasAuthority('p2')")//通过认证之后需要有p1和p2权限
//             .antMatchers("/game/*").hasAnyAuthority("p1","p2")//有p1或p2就通过
            .anyRequest().permitAll()   //通过请求不需要认证
            .and()
            .formLogin()//允许表单登录
            // .loginPage("/login-page")//自定义登录地址
            //.loginProcessingUrl("/login-process")//自定义登录处理地址
//            .successForwardUrl("/login-success")  //自定义登录成功的地址 ,controller应该是post
        .and()
        .sessionManagement()//会话控制，我们可以通过以下选项准确控制会话合适创建以及Spring Security如何与之交互
                            //always:如果没有session存在就创建一个
                            //ifRequired:默认值，如果需要就创建一个session（默认）登录时
                            //never:springSecurity将不会创建session，但是如果应用中其他地方创建了session，那么springSecurity将不会创建session将会使用它
                            //stateless:springSecurity将绝对不会创建session，也不使用session
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .and()
        .logout()//????
        //.logoutUrl("/logout2")//自定义退出登录地址
        //.logoutSuccessUrl("/logout-success")//退出成功跳转地址
        ;
    }
}
