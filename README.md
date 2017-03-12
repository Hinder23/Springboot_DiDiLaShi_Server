# Springboot_DiDiLaShi_Server
  完成了hibenate的集成（一）：  
  
    步骤：  
    
        1. 配制maven的相关文件     

        2. 持久化配制（连接数据库）：src/main/resource--application.properties     

        3.创建Bean，使用了@Entity【import javax.persistence.Entity;】  

        4.创建UserRepository 用户库。  

          public interface UserRepository extends CrudRepository<User, Integer>{}  

        5.创建UserSerice @Service @Resource @Transactional  
            【save update delete 方法需要绑定事务使用@Transaction进行事务的绑定】  

        6.创建Controller   

        7.App.class配制   
          
          
         ----------------------------------------阶段一，落幕------------------------------------------  
         
   # 使用Spring Data Jpa的特性对数据库进行相关操作（进阶）
    1. 可以使用findBy+“你要查询的字段名称”，通过这样的方法就可以轻轻松松实现SQL查询的功能【在UserRepository接口中】
    2. 使用@Query方法来自定义方法，不用忘记加上@Param参数。
    
        -----------------------------------------阶段二，落幕---------------------------------------------
