这个包展示springboot集成mybatis的demo

加依赖，
启动类设置mapperscan，
配置yml中定义数据源，
配置yml中定义xml的解析路径，
定义mapper.xml ，
定义反参entity，
定义mapper接口并在接口上加注解

条件查询
模糊查询 使用#{%查询条件%}  或者 like '%${查询条件}%'
一对多
多条件查询：（各个条件在如参数时候使用@param注解修饰）