# 🎯 AI Mock Interview System — Backend

A full-stack AI-powered mock interview platform backend
built with Java Spring Boot 4.

## 🔗 Live Demo
👉 **[Try the App](https://ai-mock-interview-frontend-black.vercel.app)**

| | Link |
|---|---|
| 🌐 Frontend | https://ai-mock-interview-frontend-black.vercel.app |
| ⚙️ Backend API | https://ai-mock-interview-73qo.onrender.com |
| 📂 Frontend Repo | https://github.com/ranjeetmahto11/ai-mock-interview-frontend |

---

## ✨ Features

- 🔐 JWT Authentication (Register & Login)
- 🤖 AI Question Generation (Groq + LLaMA 3.3)
- 🎤 Voice Input Support
- 📊 AI Answer Evaluation with Score & Feedback
- 📈 Progress Dashboard with Score Analytics
- 📋 Interview History with Detailed Breakdown
- 📄 Resume Analysis — upload resume get AI feedback
- 🎯 Categories: Technical, HR, Behavioral, System Design
- ⚡ Difficulty Levels: Easy, Medium, Hard

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Spring Boot 4 | Backend Framework |
| Spring Security 7 | Authentication |
| JWT | Token-based Auth |
| Spring Data JPA | Database ORM |
| MySQL | Database |
| Groq AI (LLaMA 3.3) | AI Integration |
| Apache PDFBox | PDF Text Extraction |
| Apache POI | Word Doc Extraction |
| Docker | Containerization |
| Render | Deployment |
| Railway | MySQL Hosting |

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven
- MySQL
- Groq API Key (free at https://console.groq.com)

### Setup
```bash
# Clone repo
git clone https://github.com/ranjeetmahto11/ai-mock-interview.git
cd ai-mock-interview

# Create MySQL database
CREATE DATABASE ai_mock_interview;

# Configure application.properties
cp src/main/resources/application-example.properties \
   src/main/resources/application.properties
# Fill in your values

# Run
mvn spring-boot:run
```

---

## 📡 API Endpoints

### Auth
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register user |
| POST | `/api/auth/login` | Login user |

### Interviews
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/interviews/start` | Start interview |
| POST | `/api/interviews/submit-answer` | Submit & evaluate |
| GET | `/api/interviews/my-interviews` | Get history |
| GET | `/api/interviews/{id}` | Get details |

### Users
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/users/profile` | Get profile |
| PUT | `/api/users/profile` | Update profile |
| GET | `/api/users/dashboard` | Dashboard stats |

### Resume
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/resume/analyze` | Analyze resume |

---

## 🗄️ Database Schema

users        → id, fullName, email, password, role
interviews   → id, userId, targetRole, category, status
questions    → id, interviewId, questionText, questionOrder
answers      → id, questionId, answerText, score, aiFeedback



## 👨‍💻 Author

**Ranjeet**
- GitHub: [@ranjeetmahto11](https://github.com/ranjeetmahto11)

---