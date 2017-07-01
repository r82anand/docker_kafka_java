FROM java:7
VOLUME /tmp
ADD QuickFeedKafkaClient-1.0-SNAPSHOT.jar /opt/QuickFeedKafkaClient-1.0-RELEASE.jar
RUN bash -c 'touch /opt/QuickFeedKafkaClient-1.0-RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/QuickFeedKafkaClient-1.0-RELEASE.jar"]