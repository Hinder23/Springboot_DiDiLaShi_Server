# Springboot_DiDiLaShi_Server
  完成了hibenate的集成（一）：＜/br＞
    步骤：＜/br＞
          1. 配制maven的相关文件  ＜/br＞
          2. 持久化配制（连接数据库）：src/main/resource--application.properties ＜/br＞
          3.创建Bean，使用了@Entity【import javax.persistence.Entity;】
          4.创建UserRepository 用户库。
            public interface UserRepository extends CrudRepository<User, Integer>{}
          5.创建UserSerice ，@Service  @Resource  @Transactional  【save update delete 方法需要绑定事务使用@Transaction进行事务的绑定】
          6.创建Controller
          7.App.class配制
          
          -----------------------------------------------阶段一，落幕---------------------------------------------------------
