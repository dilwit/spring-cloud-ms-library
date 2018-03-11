# spring-cloud-ms-library
Application to demonstrate spring cloud microservice <br><br>

# Discovery server
- Not register itself as a client
- HTTP Basic authentication enabled

# Clients
- Plan to access the service via it's name, and able to scale in future ->  so set the port to 0 for clients
- There are multiple implementations of "Discovery Service" (eureka, consul, zookeeper). @EnableDiscoveryClient lives in spring-cloud-commons and picks the implementation on the classpath.  @EnableEurekaClient lives in spring-cloud-netflix and only works for eureka. If eureka is on your classpath, they are effectively the same.
