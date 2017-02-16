package pt.nowak.familytree.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("pt.nowak.familytree.repository")
public class DataConfig {

	static private final String DATABASE_PROPERTIES_FILENAME = "db.properties";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter
	) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("pt.nowak.familytree.repository.entities");

		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		emfb.setJpaProperties(properties);
		return emfb;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}

	@Bean
	public DataSource mySqlDataSource() throws IOException {
		Properties properties = getDatabaseProperties();
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
		dataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
		dataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
		return dataSource;
	}

	private Properties getDatabaseProperties() throws IOException {
		InputStream stream = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream(DATABASE_PROPERTIES_FILENAME);
		Properties properties = new Properties();
		properties.load(stream);
		return properties;
	}
}
