# 🎯 AI Mock Interview System

An AI-powered full-stack mock interview platform built with
Java Spring Boot and React.

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
- 🎤 Voice Input (Web Speech API)
- 📊 AI Answer Evaluation with Score & Feedback
- 📈 Progress Dashboard with Score Analytics
- 📋 Interview History with Detailed Breakdown
- 🎯 Categories: Technical, HR, Behavioral, System Design
- ⚡ Difficulty Levels: Easy, Medium, Hard

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Spring Boot 4 | Backend Framework |
| Spring Security | Authentication |
| JWT | Token-based Auth |
| Spring Data JPA | Database ORM |
| MySQL | Database |
| Groq AI API | AI Integration |
| Docker | Containerization |

### Frontend
| Technology | Purpose |
|---|---|
| React 18 | UI Framework |
| Vite | Build Tool |
| Tailwind CSS | Styling |
| Axios | HTTP Client |
| React Router | Navigation |
| Web Speech API | Voice Input |

### Deployment
| Service | Purpose |
|---|---|
| Render | Backend Hosting |
| Railway | MySQL Database |
| Vercel | Frontend Hosting |
| GitHub | Version Control |

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven
- MySQL
- Node.js 18+
- Groq API Key (free at https://console.groq.com)

### Backend Setup
```bash
# Clone repo
git clone https://github.com/ranjeetmahto11/ai-mock-interview.git
cd ai-mock-interview

# Configure database
# Create MySQL database: ai_mock_interview
# Update src/main/resources/application.properties

# Run
mvn spring-boot:run
```

### Frontend Setup
```bash
# Clone repo
git clone https://github.com/ranjeetmahto11/ai-mock-interview-frontend.git
cd ai-mock-interview-frontend

# Install dependencies
npm install

# Create .env file
echo "VITE_API_URL=http://localhost:8080/api" > .env

# Run
npm run dev
```

---

## 📡 API Endpoints

### Auth
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Login user |

### Interviews
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/interviews/start` | Start interview |
| POST | `/api/interviews/submit-answer` | Submit & evaluate answer |
| GET | `/api/interviews/my-interviews` | Get history |
| GET | `/api/interviews/{id}` | Get details |

### Users
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/users/profile` | Get profile |
| PUT | `/api/users/profile` | Update profile |
| GET | `/api/users/dashboard` | Get dashboard stats |

---

## 🗄️ Database Schema