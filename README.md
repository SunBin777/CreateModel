# CreateModel
作用：根据数据库创建Model和Dao  
这里使用接口方式（非xml方式） 不会生成xml，  
sql在dao包下接口中  

###使用事项
使用：src-->com-->company-->Main.java-->右键 Run 即可  
生成的Model所在文件夹：src-->com-->company-->createModel-->entity  
生成的Dao所在文件夹：src-->com-->company-->createModel-->dao  
修改链接数据库配置：src-->com-->company-->createModel-->config-->DatabaseConfigs   
![Image text](https://github.com/SunBin777/CreateModel/image/createModelImage4.jpg) 


###注意事项
  
 1：需要手动加入jar包
    1.1：点击File-->project Structure-->Modules-->Dependencies-->点击加号（＋）-->JAR or...  
    --> 选择jar包，尽量跟我的版本别差太多-->勾上对号--->点击ok即可
    mybatis版本:mybatis-3.5.3.jar  
    mysql版本:mysql-connector-java-8.0.17.jar  
![Image text](https://github.com/SunBin777/CreateModel/image/createModelImage1.jpg)  
![Image text](https://github.com/SunBin777/CreateModel/image/createModelImage2.jpg)  
![Image text](https://github.com/SunBin777/CreateModel/image/createModelImage3.jpg) 
 