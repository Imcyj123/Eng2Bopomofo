FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# 1. 複製所有檔案
COPY . .

# 2. 【除錯用】印出目前抓到的檔案清單 (這步如果失敗，看 Build Log 就能知道原因)
RUN ls -R

# 3. 自動搜尋所有 .java 檔案並編譯 (不管他在哪個資料夾)
RUN find . -name "*.java" > sources.txt && javac -encoding UTF-8 @sources.txt

# 第二階段：運行
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# 找出編譯好的 Main.class 並複製過來
COPY --from=build /app/**/*.class .

ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "Main"]