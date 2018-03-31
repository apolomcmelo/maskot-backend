package br.com.apolomcmelo.maskotbackend.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("br.com.apolomcmelo.maskotbackend.persistence")
public class DataSourceConfig {

	@Autowired
	private Environment environment;

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		PooledDataSource ds = new PooledDataSource();

		ds.setDriver("com.mysql.jdbc.Driver");
		ds.setUrl(environment.getProperty("maskot.datasource.url"));
		ds.setUsername(environment.getProperty("maskot.datasource.username"));
		ds.setPassword(environment.getProperty("maskot.datasource.password"));

		return ds;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory() throws Exception {

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(this.getDataSource());

		return sessionFactory.getObject();
	}

	@Bean(name = "sqlSession")
	public SqlSession getSqlSession()
			throws Exception {
		return new SqlSessionTemplate(getSqlSessionFactory());
	}
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()                                       
	      .apis(RequestHandlerSelectors.basePackage("melo.mc.apolo.loto.facil.backend.controller"))
	      .paths(PathSelectors.any())                     
	      .build();

	}
}