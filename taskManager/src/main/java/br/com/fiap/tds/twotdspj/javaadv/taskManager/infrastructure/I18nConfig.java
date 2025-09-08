package br.com.fiap.tds.twotdspj.javaadv.taskManager.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;
import java.util.Locale;

@Configuration
public class I18nConfig implements WebMvcConfigurer {
    private static final String LOCALE_COOKIE_NAME = "LOCALE";

    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver(LOCALE_COOKIE_NAME);
        localeResolver.setDefaultLocale(Locale.of("pt", "BR"));
        localeResolver.setCookieMaxAge(Duration.ofDays(365));
        localeResolver.setCookiePath("/");

        localeResolver.setCookieHttpOnly(true);
        localeResolver.setCookieSecure(true);
        localeResolver.setCookieSameSite("Lax"); // aceito somente cookies do mesmo site (impede invasões)

        return localeResolver;
    }

    @Bean
    // solicitação de troca de locale
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
