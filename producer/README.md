# Getting Started

Este proyecto se encarga de enviar mensajes a un broker kafka


## Preparación

Antes de ejecutar esta aplicación es necesario levantar una instancia de zookeeper y kafka. 
Para ello se debe ejecutar el siguiente comando desde la líena de comandos (en la raiz del proyecto)

```bash
docker-compose up -d
```

Una vez levantado los contenedores, entrar al contenedor de kafka y ejecutar el siguiente comando para crear un tópico

```bash
/opt/bitnami/kafka/bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --topic mytopic --partitions 3 --replication-factor 3
```

Aclaracion: se puede descargar Offset Explorer 2.0 (Kafka Tool) y conectarse a través de dicho cliente y administrar los topicos desde ahí
Link: https://www.kafkatool.com/download.html


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

## Enviar mensajes

Ingresar http://localhost:8082 donde se abrirá una web simple con los datos para enviar mensajes al topico creado previamente.
