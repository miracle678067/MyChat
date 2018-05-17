

# 类似公众号的自动回复

## 运行结果：

- 后端页面：

  ![1](E:\web_workplace\MyChat\1.png)


- 前端页面

  ![2](E:\web_workplace\MyChat\2.png)

## 实现功能

- 后端页面实现了新增内容，批量（单条）删除内容，修改内容，查询内容（模糊查询）以及分页功能
- 前端页面实现了回复关键字，从后端查询结果返回到前端。

## 运行环境

- IntelliJ IDEA 2018.1.1 x64
- maven  tomcat7.0

## 遇到的问题

![3](E:\web_workplace\MyChat\3.png)

**解决方法：** 没有加载jquery，在js使用前的部分加上就可以了

- *@Responsebody返回乱码*

**解决方法：**  

```
@RequestMapping(value = "/AutoReply",produces = "application/json;charset=utf-8")
```

- ```
  org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.test.dao.interfaceDao.MessageDao.updateCommand
  ```

**解决方法：**  （1）检查namespace是否正确

​		     （2）检查dao方法名是否和xml文件的id是否一致

​		      （3）检查配置文件是否有进行mapping.xml文件的加载

​			（4）若上述情况都检查，则rebuild一下即可，我就是这种情况，在工程目录下发现xml文件并没有因为代码修改了而更新，因为rebuild一下解决了问题。



- ![4](E:\web_workplace\MyChat\4.png)

**解决方法：**  在dao接口的方法参数前面加上@Param注解，@Param注解的作用是给参数命名,参数命名后就能根据名字得到参数值，如下：

```
List<Message> queryAllMessageList(@Param("command") String command, @Param("description") String description);
```

