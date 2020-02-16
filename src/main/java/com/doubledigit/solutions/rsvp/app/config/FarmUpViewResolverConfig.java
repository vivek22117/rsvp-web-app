package com.doubledigit.solutions.rsvp.app.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.groovy.GroovyMarkupConfigurer;
import org.springframework.web.servlet.view.groovy.GroovyMarkupViewResolver;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class FarmUpViewResolverConfig {

    //Freemarker view resolver
    @Bean(name = "ftlViewResolver")
    public ViewResolver ftlViewResolver(){
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

        viewResolver.setCache(true);
        viewResolver.setPrefix("/freemarker/");
        viewResolver.setSuffix(".ftl");
        viewResolver.setOrder(0);
        viewResolver.setViewNames(new String[]{"ftl_*"});

        return viewResolver;
    }

    @Bean(name = "freemarkerConfig")
    public FreeMarkerConfigurer ftlFreemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/templates");

        return configurer;
    }

    //Thymeleaf Viewresolver config
    @Bean
    public ViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(thymeleafEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[]{"th_*"});

        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine thymeleafEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();

        engine.setTemplateResolver(thymeLeafTemplateResolver());
        engine.setEnableSpringELCompiler(true);

        return engine;
    }

    @Bean
    public ITemplateResolver thymeLeafTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setPrefix("/templates/thymeleaf/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");

        return templateResolver;
    }

    //Mustache view resolver config
    @Bean
    public ViewResolver mstViewResolver(ResourceLoader resourceLoader) {
        MustacheViewResolver viewResolver = new MustacheViewResolver();

        viewResolver.setPrefix("classpath:/templates/mustache/");
        viewResolver.setSuffix(".mustache");
        viewResolver.setOrder(2);
        viewResolver.setViewNames(new String[]{"mst_*"});

        return viewResolver;
    }

    //Groovy Resolver
    @Bean
    public GroovyMarkupViewResolver groovyViewResolver(){
        GroovyMarkupViewResolver viewResolver = new GroovyMarkupViewResolver();

        viewResolver.setSuffix(".tpl");
        viewResolver.setOrder(3);
        viewResolver.setViewNames(new String[]{"tpl_*"});

        return viewResolver;
    }

    @Bean
    public GroovyMarkupConfigurer groovyMarkupConfigurer(){
        GroovyMarkupConfigurer configurer = new GroovyMarkupConfigurer();

        configurer.setResourceLoaderPath("classpath:/templates/groovy/");
        return configurer;
    }


    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver(){
        return new SpringResourceTemplateResolver();
    }
}
