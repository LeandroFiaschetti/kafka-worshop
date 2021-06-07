# Getting Started

Este proyecto se encarga de consumir los mensages a un broker kafka a un topico especifico


## Preparación

Verificar que el broker de kafka este levantado y configurado como se especifica en 
	

## Compilar

Para poder correr el proyecto es necesario ejecutar el siguiente comando de maven.
Si utilizan IntelliJ auntomaticamente se dará cuenta de que se trata de un proyecto maven y solicitara instalar las dependencias

```bash
mvn clean install
```


## Ejecución

La aplicación puede ser iniciada desde un IDE ejecutando la clase com.leandro.Producer o desde la línea de comandos.

```bash
mvn spring-boot:run
```

## Enviar mensages

modificar el archivo application.properties, con la url del broker y el topico creado. Luego identificar el consumidor con un nombre de grupo que se desee.

```properties
kafka.bootstrapAddress=localhost:9092
kafka.consumer.groupId=ventas
kafka.consumer.topics=my-topic
```