# WSDL Sample

The project shows the usage of spring boot to generate a web layer
in front of a wsdl service.
The example is based on a simple service that given a blz code
(Austrian and German bank identifier) returns a set of details.

# Jaxb object generation
By running the command `./gradlew genJaxb` the wsdl that is specified inside
the build.gradle (in our case bank.wsdl inside src/main/resources/wsdl) will be
used to generate a set of JaxbClasses inside the folder generated that should than
be used as an additional sourceset by the code

Once classes are generated there is a simple client (BlzClient) that
provides an utility method to do the call to the external soap service

This client is used by the main controller (BankController) that will accept
a blz in the url and forward the parameter to the client.

No additional code is needed in order to convert the response to json.

# Quickstart

From the root of the project run the command
`./gradlew genJaxb`

This will generate the classes that maps the model of request and response
of the service and an addtional ObjectFactory.

After that the project can be run with the command

`./gradlew bootRun`

Once the server is started from another console is possible to test
the endpoint with the following command:

`curl localhost:8080/documi/account/login -d '{"token":"123"}' -H "content-type:application/json"`