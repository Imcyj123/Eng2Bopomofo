[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Docker Ready](https://img.shields.io/badge/docker-ready-blue?logo=docker)](https://hub.docker.com/r/imcyj123/eng2bopomofo)
![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)

# Eng2Bopomofo (英文輸入 ➜ 注音轉換器)

這是一個輕量級的 Java 工具，專門將「英數鍵盤對應序列」轉換為相對應的「注音符號」。  
當您忘記切換輸入法而打出一串亂碼時（例如：`c9 su3cl3`），本工具能協助將其還原為注音（`ㄏㄞ ㄋㄧˇㄏㄠˇ`）。

本專案已完全 **容器化 (Containerized)**。您無需安裝任何 Java 環境，只要有 Docker，即可實現跨平台一鍵執行。

---

## ✨ 核心功能

*   **💬 互動模式 (Interactive)**：在終端機輸入英文，即時轉換。
*   **📂 檔案模式 (Batch File)**：讀取 `input.txt` 並輸出轉換結果至 `output.txt`。
*   **🐳 Docker 全支援**：支援本機 `build` 或直接拉取 Docker Hub 映像檔。

---

## 🚀 快速開始 (使用 Docker)

無需下載原始碼，確保 [Docker Desktop](https://www.docker.com/products/docker-desktop/) 已啟動後，依需求選擇模式：

### 模式 A：互動模式 (CMD Mode)
適用於單句測試。執行後直接輸入英文按 Enter 即可：
1. 操作：直接輸入英文（如 1qaz），按下 Enter 即可看到注音結果。
2. 退出：輸入 exit 或按下 Ctrl+C。
```bash
docker run -it --rm imcyj123/eng2bopomofo_cmd:v1.0
```

### 模式 B：檔案批次模式 (File Mode)
1. 請確保 data/input.txt 已填入內容，然後執行
2. 查看結果：轉換後的文字將儲存在 `data/output.txt` 中。

#### Windows (PowerShell):
```Powershell
docker run --rm -v "${PWD}/data:/app/data" imcyj123/eng2bopomofo_file:v1.0
```

#### Windows (CMD):
```Cmd
docker run --rm -v "%cd%/data:/app/data" imcyj123/eng2bopomofo_file:v1.0
```

#### Mac / Linux:
```Bash
docker run --rm -v "$(pwd)/data:/app/data" imcyj123/eng2bopomofo_file:v1.0
```



## 📂 專案結構
```Text
Eng2Bopomofo/
├── data/               # 存放輸入與輸出檔案
│   ├── input.txt       # 放置來源文字 (UTF-8)
│   └── output.txt      # 轉換後的結果
├── src/                # Java 原始碼
│   └── Eng2Bopomofo.java
├── Dockerfile          # 多階段環境建置檔
├── .dockerignore       # 排除不必要的檔案
└── README.md           # 本說明文件
```
