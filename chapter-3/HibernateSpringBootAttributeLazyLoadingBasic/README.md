**[How To Use Hibernate Attribute Lazy Loading](https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/HibernateSpringBootAttributeLazyLoadingBasic)**


```
Persisting several authors ...
Hibernate: select a1_0.id,a1_0.age,a1_0.genre,a1_0.name from author a1_0 where a1_0.id=?
Hibernate: select a1_0.id,a1_0.age,a1_0.genre,a1_0.name from author a1_0 where a1_0.id=?
Hibernate: select a1_0.id,a1_0.age,a1_0.genre,a1_0.name from author a1_0 where a1_0.id=?
Hibernate: insert into author (age,avatar,genre,name,id) values (?,?,?,?,?)
Hibernate: insert into author (age,avatar,genre,name,id) values (?,?,?,?,?)
Hibernate: insert into author (age,avatar,genre,name,id) values (?,?,?,?,?)

Fetch authors older than 40  ...
Hibernate: select a1_0.id,a1_0.age,a1_0.genre,a1_0.name from author a1_0 where a1_0.age>=?
[Author{name=Martin Ticher}, Author{name=Rennata Elibol}]

Fetch the avatar of author with id 1  ...
Hibernate: select a1_0.id,a1_0.age,a1_0.genre,a1_0.name from author a1_0 where a1_0.id=?
Hibernate: select a1_0.avatar from author a1_0 where a1_0.id=?
5086 bytes

N+1 (avoid this)  ...
Hibernate: select a1_0.id,a1_0.age,a1_0.genre,a1_0.name from author a1_0 where a1_0.age>=?
Hibernate: select a1_0.avatar from author a1_0 where a1_0.id=?
Hibernate: select a1_0.avatar from author a1_0 where a1_0.id=?
[Author{name=Martin Ticher}, Author{name=Rennata Elibol}]

Fetching DTO including avatars  ...
Hibernate: select a1_0.name,a1_0.avatar from author a1_0 where a1_0.age>=?
Martin Ticher, [B@1c8746a0
Rennata Elibol, [B@613d42ab

```

<b><a href="https://persistencelayer.wixsite.com/springboot-hibernate/post/how-to-use-hibernate-attribute-lazy-loading">If you prefer to read it as a blog-post containing the relevant snippets of code then check this post</a></b>
  
**Description:** By default, the attributes of an entity are loaded eagerly (all at once). But, we can load them **lazy** as well. This is useful for column types that store large amounts of data: `CLOB`, `BLOB`, `VARBINARY`, etc or *details* that should be loaded on demand. In this application, we have an entity named `Author`. Its properties are: `id`, `name`, `genre`, `avatar` and `age`. And, we want to load the `avatar` lazy. So, the `avatar` should be loaded on demand.

**Key points:**
- in `pom.xml`, activate Hibernate *bytecode enhancement* (e.g. use Maven *bytecode enhancement plugin*)
- in entity, annotate the attributes that should be loaded lazy with `@Basic(fetch = FetchType.LAZY)`
- in `application.properties`, disable Open Session in View     

**Check as well:**\
     - [Default Values For Lazy Loaded Attributes](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootAttributeLazyLoadingDefaultValues)\
     - [Attribute Lazy Loading And Jackson Serialization](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootAttributeLazyLoadingJacksonSerialization)
     
-----------------------------------------------------------------------------------------------------------------------    
<table>
     <tr><td><b>If you need a deep dive into the performance recipes exposed in this repository then I am sure that you will love my book "Spring Boot Persistence Best Practices"</b></td><td><b>If you need a hand of tips and illustrations of 100+ Java persistence performance issues then "Java Persistence Performance Illustrated Guide" is for you.</b></td></tr>
     <tr><td>
<a href="https://www.apress.com/us/book/9781484256251"><p align="left"><img src="https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/Spring%20Boot%20Persistence%20Best%20Practices.jpg" height="500" width="450"/></p></a>
</td><td>
<a href="https://leanpub.com/java-persistence-performance-illustrated-guide"><p align="right"><img src="https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/Java%20Persistence%20Performance%20Illustrated%20Guide.jpg" height="500" width="450"/></p></a>
</td></tr></table>

-----------------------------------------------------------------------------------------------------------------------    

