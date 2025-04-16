# 📱 Investments App

A clean architecture Android app built for the **NIT3213 Final Assessment** using Kotlin.  
This app connects to a RESTful API, supports login authentication, displays a list of investment assets, and shows detailed info on each.

---

## ✨ Features

- 🔐 **Login Authentication** (Username + Student ID)
- 📊 **Dashboard** showing a list of Investments
- 📃 **Details Screen** with more info on selected assets
- 📦 Built using **Clean Architecture**
- 🔄 Integrated with **Retrofit + Coroutines**
- 🎨 Uses **Material 3 UI** and **ViewBinding**

---

## 🧩 Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM with Clean Architecture
- **Networking:** Retrofit
- **UI:** Material 3 + ViewBinding
- **Async:** Kotlin Coroutines
- **Tools:** Android Studio Arctic Fox +

---

## 📁 Project Structure
InvestmentsApp/ ├── data/ │ └── repository/ ├── domain/ │ ├── model/ │ └── repository/ ├── network/ │ ├── ApiService.kt │ └── RetrofitClient.kt ├── viewmodel/ ├── adapter/ ├── ui/ │ ├── LoginActivity.kt │ ├── DashboardActivity.kt │ └── DetailsActivity.kt

---

## 🚀 How to Run

1. Clone this repo:
    ```bash
    git clone https://github.com/samrathona/NIT3213_FinalAssessment.git
    ```

2. Open in Android Studio.

3. Run on emulator or physical device.

> Make sure your internet is connected. This app uses a live hosted API.

---

## 🔑 API Info

Base URL: `https://nit3213api.onrender.com`

- Login Endpoint: `POST /sydney/auth`
- Dashboard: `GET /dashboard/{keypass}`

---

## 🧠 Author

👤 **Samrat Hona**  
📧 [samrathona@gmail.com](mailto:samrathona@gmail.com)  
📍 Sydney, Australia

---

## 📘 License

This project is for educational purposes under Victoria University’s NIT3213 Final Assessment.  
Not for commercial use.

---
