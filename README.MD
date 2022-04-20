## Discovery Eureka: 8100
http://localhost:8100 test/test

## Api Gateway on port 8010

## Api Config server on port 8099
http://localhost:8099/msvc-users/default

## Rabbit for config spreading
http://localhost:15672   guest/guest 
## Zipkin for trace web
http://localhost:9411   guest/guest 

### User-msvc
- User-msvc: http://localhost:8010/msvc-users/users
- User-DB: http://localhost:8010/msvc-users/h2-console org.h2.Driver - DB name in spring logs

KeyTool:
keytool -genkeypair -alias apiEncryptionKey -keyalg RSA -dname "CN=Alexandr Ivankov,OU=Spring-MSVC,O=MyCompany,L=MyCity,S=MyState,C=MyCountry" -keypass 1q2w3e4r -keystore apiEncryptionKey.jks -storepass 1q2w3e4r
keytool -importkeystore -srckeystore apiEncryptionKey.jks -deststoretype pkcs12

Guide:
Pre-req:
1. Install java
1. Install docker
1. Configure it a bit: (cmd on Windows)
  ```
    wsl -d docker-desktop
    sysctl -w vm.max_map_count=262144
  ```
Main-Steps:
1. run docker-compose
1. start config
1. start discovery
1. start gateway
1. start all the rest