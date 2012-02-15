Hibernate dialect for Informix >= 10 version
============================================
# Build:

*  for Hibernate < 4 version:

`mvn install`

*  for Hibernate >= 4 version

`mvn install -Phibernate4`

# Usage:
Set the hibernate.dialect property to eu.vitaliy.hibernate.dialect.Informix10Dialect
*  for Hibernate < 4 version:

```
<dependency>
   <groupId>eu.vitaliy</groupId>
   <artifactId>informix10-dialect</artifactId>
   <version>1.0.4-SNAPSHOT</version>
   <classifier>h3</classifier>
</dependency>
```

*  for Hibernate >= 4 version

```
<dependency>
   <groupId>eu.vitaliy</groupId>
   <artifactId>informix10-dialect</artifactId>
   <version>1.0.4-SNAPSHOT</version>
   <classifier>h4</classifier>
</dependency>
```


