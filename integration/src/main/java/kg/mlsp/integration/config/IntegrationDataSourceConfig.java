package kg.mlsp.integration.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "kg.mlsp.integration.repository",
        entityManagerFactoryRef = "integrationEntityManagerFactory",
        transactionManagerRef = "integrationTransactionManager"
)
public class IntegrationDataSourceConfig {

    @Bean(name = "integrationDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.integration")
    public DataSource integrationDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "integrationEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean integrationEntityManagerFactory(
            @Qualifier("integrationDataSource") DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("kg.mlsp.integration.model");
        em.setPersistenceUnitName("integrationPU");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaProperties(jpaProperties);

        return em;
    }

    @Bean(name = "integrationTransactionManager")
    @Primary
    public PlatformTransactionManager integrationTransactionManager(
            @Qualifier("integrationEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}


