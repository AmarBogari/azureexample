# AzureExample

## Requirements

1. Java - 1.8.x

2. Gradle - 6.2.x

3. Azure Account and some key required.


## Steps to Setup

**1. Clone the application**

```bash
git clone https://gitlab.mynisum.com/abogari/azureexample.git
```

**2.Azure Account Creation and Define configurations:**
```bash
1) Login with Azure portal page.
2) Go to Azureconfiguration and Created "azurespringconfig" name.
3) Click on (*azurespringconfig*) name link and go to Access Keys and Read-only keys and copy connection string.
4) set connection string in your application environment in intelij with "CONNECTIONSTRING" key. 
5) bootstap.yml file need to add  
    cloud:   azure:appconfiguration:stores:- connection-string: ${CONNECTIONSTRING}
6) Go to *Configuration explorer* and create with your key.
key :"/application/config.message/"
value: any value.
```


Required Keys here : 
```bash
/application/azure.config.datasource
/application/azure.config.dbdriverclass
/application/azure.config.dbpassword
/application/azure.config.dbusername
/application/config.message
/application/config.test.message
```

**3.Spring Boot Applicaton with Azure Account :**
```bash
1) This spirng boot application connecting to h2 database with using azure for getting driver class name, datasource, username and password.
2) While starting application it automatically connect to h2 database.(here i added h2 dependency).
3) created configuration class for getting azure values and we can use @Value as also.
4) Creted endpoint for get all the keys and values.(http://localhost:8081/allazureproperties), Here it return the map with all the keys and values.
```
**Challenges**
1) Before run the application you need the set Environment Variable, But problem when we apply profile concept no need to create Environment Variable and 
connection url directly using in the bootstap.yaml file with different profiles.
I created following stackoverflow ticket : https://stackoverflow.com/questions/61389044/azure-connection-string-with-spring-profile

2) Problem while using config class.
Need to create /application/KEYNAME in the azure while using config class then work and @Value case not required to create this format.

important links : 
```bash

https://docs.microsoft.com/en-us/azure/azure-app-configuration/quickstart-java-spring-app

```

##Testing

Use following env property to populate connecting string for azure key vault.

`CONNECTIONSTRING=Endpoint=https://azurespringconfig.azconfig.io\;Id=XKvw-lh-s0:SVsLG6ZNdx+VyKOSBSjw\;Secret=xLoC2oj1vNL57bJjLHrv1ht/g7FDD8RwTHEUxoBGIOM=`