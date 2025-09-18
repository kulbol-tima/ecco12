package kg.mlsp.ubk.config;

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
        basePackages = "kg.mlsp.ubk.repository",
        entityManagerFactoryRef = "ubkEntityManagerFactory",
        transactionManagerRef = "ubkTransactionManager"
)
public class UbkDataSourceConfig {

    @Bean(name = "ubkDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.ubk")
    public DataSource ubkDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ubkEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean ubkEntityManagerFactory(
            @Qualifier("ubkDataSource") DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("kg.mlsp.ubk.model");
        em.setPersistenceUnitName("ubkPU");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaProperties(jpaProperties);

        return em;
    }

    @Bean(name = "ubkTransactionManager")
    @Primary
    public PlatformTransactionManager ubkTransactionManager(
            @Qualifier("ubkEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}


