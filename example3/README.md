## example3

Spring Cloud Eureka 服务注册中心实例，简单的服务注册实现。

- 支持负载平衡。
- 支持 Eureka Server 用户名密码安全认证。
- 支持 Eureka Server 主、从节点服务注册中心。
- 集群部署。
- 高可用。

```
│
├── example1
│   │  
│   ├── eureka-server-master --------- Eureka Server 服务注册中心主节点
│   ├── eureka-server-slave1 --------- Eureka Server 服务注册中心从节点 1
│   ├── eureka-server-slave1 --------- Eureka Server 服务注册中心从节点 2
│   ├── service1 --------------------- 服务 1
│   ├── service2 --------------------- 服务 2
│   ├── service2-1 ------------------- 服务 2 的 copy 1
│   ├── consumer1 -------------------- 消费者 1
│   │ 
```

- 集群部署要求主节点、从节点 1、从节点 2 部署在三台独立服务器上。
- 主节点（eureka-server-master）注册到从节点 1（ eureka-server-slave1）、从节点 2（eureka-server-slave2）。
- 从节点 1（ eureka-server-slave1）注册到主节点（eureka-server-master）、从节点 2（eureka-server-slave2）。
- 从节点 2（eureka-server-slave2）注册到主节点（eureka-server-master）、从节点 1（ eureka-server-slave1）。
- 所有服务需要注册到主节点（eureka-server-master）、节点 1（ eureka-server-slave1）、从节点 2（eureka-server-slave2）。

