
@Configuration
@ComponentScan("com.baeldung.jdbc")
public class SpringJdbcConfig {
	@Bean
	public DataSource postgresDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://firstdb.clxi91edpc7j.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=project2");
        dataSource.setUsername("Hector");
        dataSource.setPassword("password");

        return dataSource;
	}
}
