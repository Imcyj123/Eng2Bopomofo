FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /build
COPY src/Eng2Bopomofo.java .
RUN javac Eng2Bopomofo.java

RUN jlink --add-modules java.se --strip-debug --no-header-files --no-man-pages --output /custom_jre

FROM alpine:latest
# 最終映像檔大小約為 126MB
WORKDIR /app

COPY --from=builder /build/Eng2Bopomofo.class .
 
COPY --from=builder /custom_jre .

ENTRYPOINT ["./bin/java", "-cp", ".", "Eng2Bopomofo"]

CMD ["data/input.txt", "data/output.txt"]



# FROM eclipse-temurin:17-jdk-jammy AS builder

# WORKDIR /app

# COPY src/ .

# RUN javac Eng2Bopomofo.java

# # 使用只包含 JRE (Java Runtime Environment) 的更輕量級映像檔(372MB)
# # FROM eclipse-temurin:17-jre-jammy

# # 這個鏡像的大小通常只有 250MB 左右，相比 372MB 大幅縮小
# FROM eclipse-temurin:17-jre-alpine

# WORKDIR /app

# COPY --from=builder /app/Eng2Bopomofo.class .

# CMD ["java", "Eng2Bopomofo"]