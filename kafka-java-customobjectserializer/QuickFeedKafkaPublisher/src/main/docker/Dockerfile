FROM java:7
VOLUME /tmp
ADD QuickFeedKafkaPublisher-1.0-SNAPSHOT.jar /opt/QuickFeedKafkaPublisher-1.0-RELEASE.jar
RUN bash -c 'touch /opt/QuickFeedKafkaPublisher-1.0-RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/QuickFeedKafkaPublisher-1.0-RELEASE.jar"]