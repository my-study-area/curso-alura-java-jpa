# curso-alura-java-jpa

Curso de Java e JPA: Persista seus objetos com a JPA2 e Hibernate

## Anotações

**01-Sobre a Java Persistence API**
- O dialeto permite que o provider consiga enviar as queries corretamente ao banco de dados mesmo que alguns fabricantes tenham algumas variaçãoes de sintese no SQL
- A JPA é um ORM (Object Relacional Mapper) Java
- Um ORM mapeia as classes para tabelas e gera o SQL de forma automática
- Para inicializar a JPA, é preciso definir um arquivo de configuração, chamado persistence.xml. Nele, colocamos as configurações mais importantes, como o driver e os dados da conexão


**02-Usando EntityManager**
- A JPA sincroniza o estado de uma entidade gerenciada com o banco de dados. Isto é, o SQL será gerado baseado na diferença entre a entidade em memória e o banco de dados. Para essa sincronização acontecer, a entidade precisa estar gerenciada (Managed)
- Os estados de uma entidade são: `Managed`, `Detached`, `Transient` e `Removed`
- No estado `Managed` a entidade é automaticamente sincronizada com o banco
- No estado `Detached` a entidade pode conter id, mas não mantém uma sincronização com o banco
- No estado `Transient` a entidade nunca foi `Managed`, não possui um ID, provavelmente nunca passou pelo `EntityManager` e não está no banco de dados
- No estado `Removed` a entidade possui um ID, mas não possui está sendo gerenciado pelo `EntityManager` e não está no banco de dados


**03-Mapeando relacionamentos**
- Relacionamentos entre entidades precisam ser configurados pelas anotações no atributo que define o relacionamento na classe
- Um relacionamento do tipo Muitos-para-Um deve usar anotação @ManyToOne
- A anotação @ManyToOne causa a criação de uma chave estrangeira
- A JPA carrega automaticamente o relacionamento ao carregar a entidade
- Uma entidade com relacionamento só pode ser persistir se o seu relacionamento estiver no estado `Managed`

**04-Relacionamento para Muitos**
- Podemos relacionar entidades com @OneToOne, @OneToMany e @ManyToMany, dependendo da cardinalidade
- Um relacionamento @ManyToMany gera uma tabela extra no banco de dados para estabelecer o relacionamento
- Para persistir uma entidade, devemos persistir as entidades transientes do relacionamento
- No relacionamento @OneToOne devemos adicionar a anotação `@JoinColumn(unique = true)` para evitar a duplicidade
