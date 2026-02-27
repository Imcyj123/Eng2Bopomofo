[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Docker Ready](https://img.shields.io/badge/docker-ready-blue?logo=docker)](https://hub.docker.com/r/imcyj123/eng2bopomofo)
![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)

# Eng2Bopomofo (英文輸入 ➜ 注音轉換器)

這是一個輕量級的 Java 工具，專門將「英數鍵盤對應序列」轉換為相對應的「注音符號」。  
當您忘記切換輸入法而打出一串亂碼時（例如：`c9 su3cl3`），本工具能協助將其還原為注音（`ㄏㄞ ㄋㄧˇㄏㄠˇ`）。

本專案已完全 **容器化 (Containerized)**。您無需安裝任何 Java 環境，只要有 Docker，即可實現跨平台一鍵執行。

---

## ✨ 核心功能

* **💬 互動模式 (Interactive)**：在終端機輸入英文，即時轉換。
* **📂 檔案模式 (Batch File)**：讀取 `input.txt` 並輸出轉換結果至 `output.txt`。
* **🐳 Docker 全支援**：支援本機 `build` 或直接拉取 Docker Hub 映像檔。

---

## 🚀 快速開始 (使用 Docker)

確保 [Docker Desktop](https://www.docker.com/products/docker-desktop/) 已啟動後，依需求選擇以下模式：

### 模式 A：互動模式 (CMD Mode) —— ⚡ 無需 Clone，直接執行！
適用於單句測試。因為不需要讀取本機檔案，您可以**直接執行**以下指令，完全不需要下載或 Clone 任何專案檔案：

1. **操作**：執行指令後，直接輸入英文（如 1qaz），按下 Enter 即可看到注音結果。
2. **退出**：輸入 `exit` 或按下 `Ctrl+C`。

```bash
docker run -it --rm imcyj123/eng2bopomofo_cmd:v1.0

```

---

### 模式 B：檔案批次模式 (File Mode) —— 📂 需先 Clone 專案

此模式會進行實體檔案的讀取與輸出，因此**需要先 Clone 專案**，以取得對應的 `data` 資料夾結構。

#### 步驟 1：Clone 專案並進入資料夾

請先開啟終端機，將專案下載到您的電腦中，並切換到 `file-mode` 目錄：

```bash
git clone [https://github.com/imcyj123/Eng2Bopomofo.git](https://github.com/imcyj123/Eng2Bopomofo.git)
cd Eng2Bopomofo/file-mode

```

#### 步驟 2：準備來源檔案

請確保 `data/input.txt` 中已填入您想轉換的亂碼內容。

#### 步驟 3：執行 Docker 掛載指令

執行以下指令進行轉換。完成後，轉換結果將會自動儲存並覆蓋至 `data/output.txt` 中。請依照您的作業系統選擇指令：

**Windows (PowerShell):**

```powershell
docker run --rm -v "${PWD}/data:/app/data" imcyj123/eng2bopomofo_file:v1.0

```

**Windows (CMD):**

```cmd
docker run --rm -v "%cd%/data:/app/data" imcyj123/eng2bopomofo_file:v1.0

```

**Mac / Linux:**

```bash
docker run --rm -v "$(pwd)/data:/app/data" imcyj123/eng2bopomofo_file:v1.0

```

---

## 📂 專案結構

```text
Eng2Bopomofo/
├── file-mode/              # 📂 檔案處理模式
│   ├── data/               # 存放輸入與輸出檔案
│   │   ├── input.txt       # 來源文字 (UTF-8)
│   │   └── output.txt      # 轉換後的結果
│   └── .gitignore       # 排除不必要的編譯暫存檔
├── cmd-mode/               # 💬 CMD 互動模式
│   └── .gitignore       # 排除不必要的編譯暫存檔
└── README.md               # 📖 專案說明文件 (您正在閱讀這份文件)
