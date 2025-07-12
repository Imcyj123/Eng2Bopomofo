FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app

COPY src/ .

RUN javac Eng2Bopomofo.java

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=builder /app/Eng2Bopomofo.class .

CMD ["java", "Eng2Bopomofo"]