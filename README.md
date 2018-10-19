# Private blog platform

*Spring WebMVC, Security, Hibernate, MySQL*

*NO XML configuration*

This web-application allows an owner to perform CRUD-operations with articles. Access to admin's functions has provided by a login form.

---
To operate with database you have to add jdbc connection using <b><u>jdbc-mysql.properties</u></b> file in the directory <b>`src/main/resources`</b>:

```java
#
# JDBC connection properties
#
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/db_name?useSSL=false&serverTimezone=UTC
jdbc.user=yourusername
jdbc.password=yourPassword
```

---
