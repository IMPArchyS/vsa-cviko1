# JPA - Persistance Unit
Entity manager vytvoríme na základe konfigurácie pripojenia v persistence unit.
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
EntityManager em = emf.createEntityManager();
```
### Čítanie údajov 
`nativeQuery` umožňuje použiť SQL dotaz na čítanie údajov
```java
Query q = em.createNativeQuery("select * from kniha", Kniha.class);
List<Kniha> knihy = q.getResultList();
for (Kniha k : knihy) {
System.out.println("" + k);
}
```
### Modifikácia dát
Ilustruje getTransaction, begin, commit
```java
Query q = em.createNativeQuery("select * from kniha", Kniha.class);
List<Kniha> knihy = q.getResultList();
em.getTransaction().begin();
for (Kniha k : knihy) {
k.setCena(k.getCena() * 0.8);
}
em.getTransaction().commit();
```
### Vyhľadávanie podľa kľúča
```java
Kniha k = em.find(Kniha.class, "Pipi");
System.out.println("" + k);
```
### Vytvorenie nového záznamu
```java
Kniha k = new Kniha();
k.setNazov("Brave new world");
em.getTransaction().begin();
em.persist(k);
em.getTransaction().commit();
```
## Tvorba databázy
### Hodnoty schema-generation.database.action
`none` -  žiadna akcia
`create` - pred spustením aplikácie vytvorí JPA tabuľku pre entitnú triedu, ak neexistovala.
`drop-and-create` pred spustením najprv odstráni existujúcu a znovu vytvorí prázdnu tabuľku.
