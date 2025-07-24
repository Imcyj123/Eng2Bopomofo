[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

# Eng2Bopomofo (英文輸入➜注音轉換器)

這是一個簡單的 Java 專案，可以將包含英數鍵盤對應的文字檔案，轉換為相對應的注音符號。例如，它會將 `
c9 su3cl3` 轉換為 `ㄏㄞ ㄋㄧˇㄏㄠˇ`。


此專案已完全容器化，您只需要安裝 Docker，即可在任何環境下輕鬆建置與執行。

## ✨ 功能

* 讀取一個 UTF-8 編碼的輸入檔案。
* 將檔案內容根據注音符號鍵盤對應表進行轉換。
* 將轉換後的結果寫入一個新的輸出檔案。

## 🚀 快速開始 (使用 Docker)

您不需要在您的電腦上安裝 Java 環境，只需要安裝 [Docker Desktop](https://www.docker.com/products/docker-desktop/) 即可。

1.  **複製 (Clone) 專案**

    首先，將此專案複製到您的本機電腦：
    ```bash
    git clone [https://github.com/Imcyj123/Eng2Bopomofo.git](https://github.com/Imcyj123/Eng2Bopomofo.git)
    cd Eng2Bopomofo
    ```

2.  **準備輸入檔案**

    在專案根目錄下的 `data` 資料夾中，有一個 `input.txt` 檔案。請將您想要轉換的內容填寫進去。
    ```
    /data
    └── input.txt
    ```

3.  **建置 Docker 映像檔 (Build)**

    在專案根目錄下，執行以下指令來建置 Docker image：
    ```bash
    docker build -t eng2bopomofo:latest .
    ```

4.  **執行轉換程式 (Run)**

    執行以下指令來啟動容器並進行轉換。此指令會將您本機的 `data` 資料夾掛載到容器中，讓程式可以讀取 `input.txt` 並產生 `output.txt`。
    ```bash
    # 將 <您的專案絕對路徑> 替換成您電腦上 Eng2Bopomofo 資料夾的完整路徑
    # 例如： D:\projects\Eng2Bopomofo
    # docker run --rm -v "<您的專案絕對路徑>\data:/app/data" eng2bopomofo:latest java Eng2Bopomofo data/input.txt data/output.txt
    docker run --rm -v "<您的專案絕對路徑>\data:/app/data" eng2bopomofo:latest 

    ```
    > **提示**:
    > * 在 Windows 上，您可以在檔案總管的位址列複製路徑。
    > * 在 Mac 或 Linux 上，路徑格式應為 `/path/to/your/project`。

    執行完畢後，您會在 `data` 資料夾中看到一個名為 `output.txt` 的新檔案，裡面就是轉換後的結果！

## 🛠️ 專案結構
```
Eng2Bopomofo/
├── data/               # 存放輸入與輸出檔案
│   └── input.txt
├── src/                # Java 原始碼
│   └── Eng2Bopomofo.java
├── .dockerignore       # 告訴 Docker 忽略哪些檔案
├── Dockerfile          # Docker 建置設定檔
└── README.md           # 就是您現在看到的這個檔案
```
