🧠 Chatbot IA RAG Java
Chatbot d’assistance interne (Java + Spring Boot + Angular + LLM + RAG)
🚀 Description du projet

Ce projet a pour objectif de créer un chatbot d’assistance interne combinant intelligence artificielle générative (LLM) et RAG (Retrieval-Augmented Generation).
L’application repose sur une architecture Java Spring Boot (backend) et Angular (frontend), permettant une interface web fluide et une API robuste pour interagir avec des modèles d’IA (OpenAI, Mistral, etc.).

Le pipeline RAG enrichit les réponses de l’IA en consultant des documents internes (PDF, textes, etc.) afin d’apporter des réponses contextuelles et pertinentes.

🏗️ Architecture du projet
chatbot-ia-rag-java/
│
├── backend/
│   └── springboot-app/        # API Java Spring Boot (LLM + RAG)
│       ├── src/
│       ├── pom.xml
│       └── README.md
│
├── frontend/
│   └── angular-app/           # Interface utilisateur Angular
│       ├── src/
│       ├── package.json
│       └── README.md
│
├── docs/                      # Documentation technique et captures
├── docker-compose.yml         # Lancement simultané backend + frontend (plus tard)
├── .gitignore
└── README.md                  # Ce fichier

⚙️ Stack technique
Couche	Technologie
Backend	Java 17 • Spring Boot 3.5 • Maven
Frontend	Angular 17 • TypeScript • TailwindCSS
IA / LLM	OpenAI API ou Mistral API
RAG	Embeddings + Base vectorielle (ChromaDB, Pinecone ou FAISS)
Sécurité	Spring Security (JWT ou Basic Auth)
CI/CD	GitHub Actions
Conteneurisation	Docker + Docker Compose
🧩 Fonctionnalités prévues
✅ Étape 1 – Base du projet

Initialisation du backend Spring Boot + frontend Angular

Configuration du repo GitHub + CI/CD

🤖 Étape 2 – Appel simple à un modèle LLM

Endpoint /api/chat qui envoie un message à un modèle d’IA et renvoie la réponse

Exemple : OpenAI gpt-4 ou Mistral mistral-medium

🧱 Étape 3 – Intégration du RAG

Extraction de texte à partir de documents (PDF, TXT)

Génération d’embeddings

Recherche sémantique et récupération de contexte

Combinaison du contexte avec la requête utilisateur avant l’envoi au LLM

💬 Étape 4 – Interface Angular

Champ de texte + bouton “Envoyer”

Affichage conversationnel (IA / utilisateur)

Connexion au backend REST API

🐳 Étape 5 – Docker & Déploiement

Dockerfile pour backend et frontend

docker-compose.yml pour tout lancer d’un coup

Intégration GitHub Actions pour build automatique

🚀 Installation & exécution
🔧 1. Cloner le dépôt
git clone https://github.com/<ton-pseudo>/chatbot-ia-rag-java.git
cd chatbot-ia-rag-java

🧩 2. Lancer le backend
cd backend/springboot-app
mvn spring-boot:run


👉 L’API sera disponible sur http://localhost:8080

💻 3. Lancer le frontend
cd frontend/angular-app
npm install
ng serve


👉 Interface accessible sur http://localhost:4200

🔑 Configuration de l’API IA

Crée un fichier .env (ou utilise les variables d’environnement) :

OPENAI_API_KEY=ta_cle_api
MISTRAL_API_KEY=ta_cle_api

🧠 Exemple de requête API
POST http://localhost:8080/api/chat
Content-Type: application/json

{
  "message": "Explique-moi le concept de RAG"
}


Réponse attendue :

{
  "response": "Le RAG (Retrieval-Augmented Generation) combine un modèle de génération avec une recherche contextuelle..."
}

📚 Documentation technique

docs/architecture.md → schéma global

docs/api.md → endpoints REST

docs/rag-pipeline.md → pipeline d’enrichissement des réponses

🧾 To-do / Roadmap

 Appel API LLM (OpenAI / Mistral)

 Extraction et indexation de documents

 Recherche vectorielle (embeddings)

 Intégration frontend Angular

 Authentification utilisateur

 Dockerisation complète

 CI/CD GitHub Actions

💡 Exemple d’usage

🗣️ “Bonjour, peux-tu me résumer la politique de télétravail de l’entreprise ?”

🤖 “Voici le résumé du document interne RH_Teletravail_2024.pdf :
Les employés peuvent télétravailler 3 jours par semaine, sous réserve d’accord du manager.”

🌟 Objectif final

Créer un assistant interne intelligent, capable de comprendre et retrouver des informations dans les documents de l’entreprise grâce à une architecture 100% Java/Angular.

🧑‍💻 Auteur

👨‍💻 Projet open-source d’apprentissage — Chatbot IA RAG Java
📘 Inspiré des architectures RAG modernes utilisées avec OpenAI et Mistral.