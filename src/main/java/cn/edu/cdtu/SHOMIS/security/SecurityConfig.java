package cn.edu.cdtu.SHOMIS.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author mars_sea
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("student").password("123456").roles("STUDENT");
		auth
				.inMemoryAuthentication()
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("doctor").password("123456").roles("DOCTOR");
		auth
				.inMemoryAuthentication()
				.passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("admin").password("123456").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// <X> 配置请求地址的权限
				.authorizeRequests()
				// 所有用户可访问
				.antMatchers("*").permitAll()
				// 需要 ADMIN 角色
				.antMatchers("/admin/*").hasRole("ADMIN")
				// 需要 student 角色。
				.antMatchers("/student/*").hasRole("STUDENT")
				// 需要 doctor 角色。
				.antMatchers("/doctor/*").hasRole("DOCTOR")
				// 任何请求，访问的用户都需要经过认证
				//.anyRequest().authenticated()
				.and()
				// <Y> 设置 Form 表单登录
				// 登录 URL 地址
				.formLogin()
                    .loginPage("/login")
				.permitAll() // 所有用户可访问
				.and()
				// 配置退出相关
				.logout()
//                    .logoutUrl("/logout") // 退出 URL 地址
				.permitAll(); // 所有用户可访问
	}
}
