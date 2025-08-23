**[Optimize `SELECT DISTINCT` Via Hibernate `HINT_PASS_DISTINCT_THROUGH` Hint](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootHintPassDistinctThrough)**

**Description:** Starting with Hibernate 5.2.2, we can optimize JPQL (HQL) query entites of type `SELECT DISTINCT` via `HINT_PASS_DISTINCT_THROUGH` hint. Keep in mind that this hint is useful only for JPQL (HQL) JOIN FETCH-ing queries. Is not useful for scalar queries (e.g., `List<Integer>`), DTO or [HHH-13280](https://hibernate.atlassian.net/browse/HHH-13280). In such cases, the `DISTINCT` JPQL keyword is needed to be passed to the underlying SQL query. This will instruct the database to remove duplicates from the result set. 

**Key points:**
- use `@QueryHints(value = @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false"))`
     
**Output example:**\
![](https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/HibernateSpringBootHintPassDistinctThrough/HINT_PASS_DISTINCT_THROUGH.png)

-----------------------------------------------------------------------------------------------------------------------    
<table>
     <tr><td><b>If you need a deep dive into the performance recipes exposed in this repository then I am sure that you will love my book "Spring Boot Persistence Best Practices"</b></td><td><b>If you need a hand of tips and illustrations of 100+ Java persistence performance issues then "Java Persistence Performance Illustrated Guide" is for you.</b></td></tr>
     <tr><td>
<a href="https://www.apress.com/us/book/9781484256251"><p align="left"><img src="https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/Spring%20Boot%20Persistence%20Best%20Practices.jpg" height="500" width="450"/></p></a>
</td><td>
<a href="https://leanpub.com/java-persistence-performance-illustrated-guide"><p align="right"><img src="https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/Java%20Persistence%20Performance%20Illustrated%20Guide.jpg" height="500" width="450"/></p></a>
</td></tr></table>

-----------------------------------------------------------------------------------------------------------------------    


Why you don’t see duplicates

JPA + Hibernate contract:
Even if the SQL produces duplicate Author rows (because of the LEFT JOIN FETCH), Hibernate deduplicates results in memory when hydrating entities into the persistence context.
That means for any given Author.id, you’ll always get one entity object in the returned List.

So:

fetchWithDuplicates() → Hibernate deduplicates. You don’t see repeated Author objects.

fetchWithoutHint() → DISTINCT in JPQL affects entity uniqueness, not SQL. Hibernate again deduplicates.

fetchWithHint() → The hint hibernate.query.passDistinctThrough=false only tells Hibernate don’t push DISTINCT to SQL, handle it in-memory. But since Hibernate was deduplicating anyway, the outcome looks the same.

