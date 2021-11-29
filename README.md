## ssm_demo

利用springMVC整合ssm框架

1. 基本依赖junit、数据库驱动、数据库连接池（c3p0、druid）、Mybatis、springweb和springjdbc；maven资源过滤将properties和xml文件放在resource下
2. Mybatis层编写，配置文件database.properties。构建pojo，使用lombok无参数构建或者全参数构建。
3. dao层，接口和接口对应的Mapper文件，编写Mysql语句。
4. service层编写接口和实现类，主要有CRUD。
5. control层和前端相对应。
6. spring整合分层，在application中import dao，mvc和service的xml文件
7. tomcat需要引入新的依赖，生成web项目。然后就是前端和control层的交互内容了