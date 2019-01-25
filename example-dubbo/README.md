本案例是dubbo以edas作为注册中心的案例   
缺少依赖
```` <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-actuator</artifactId>
           </dependency>
           <dependency>
               <groupId>com.alibaba.boot</groupId>
               <artifactId>dubbo-spring-boot-starter</artifactId>
               <version>0.2.0</version>
           </dependency>
           <!-- 没找到下面这个依赖包 -->
           <dependency>
               <groupId>com.alibaba.edas</groupId>
               <artifactId>edas-dubbo-extension</artifactId>
               <version>1.0.0-SNAPSHOT</version>
           </dependency>

````