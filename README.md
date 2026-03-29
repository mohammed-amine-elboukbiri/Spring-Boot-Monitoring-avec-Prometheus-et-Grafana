# 📊 Supervision & Observabilité — Spring Boot

> Mise en place d'une solution complète de supervision et d'observabilité pour une application Spring Boot avec Actuator, Prometheus, Grafana et un système de logging.

---



## 📌 Aperçu du projet

Ce projet illustre l'importance de l'**observabilité** dans les applications modernes. Il intègre une stack complète de supervision permettant de :

- Surveiller l'état de santé de l'application en temps réel
- Collecter et visualiser les métriques JVM, HTTP et système
- Analyser les performances (mémoire, CPU, temps de réponse)
- Centraliser les journaux applicatifs pour faciliter le débogage

---

## 🛠️ Technologies utilisées

| Outil | Rôle |
|---|---|
| **Spring Boot** | Framework applicatif principal |
| **Spring Boot Actuator** | Exposition des métriques et endpoints de santé |
| **Micrometer** | Façade de métriques — pont entre Actuator et Prometheus |
| **Prometheus** | Collecte et stockage des métriques |
| **Grafana** | Visualisation des métriques via tableaux de bord interactifs |
| **Logback / SLF4J** | Journalisation des événements applicatifs |

---

## 🏗️ Architecture

```
┌─────────────────────────────────┐
│        Spring Boot App          │
│                                 │
│  ┌──────────┐  ┌─────────────┐  │
│  │ Actuator │  │  Micrometer │  │
│  └────┬─────┘  └──────┬──────┘  │
│       │               │         │
└───────┼───────────────┼─────────┘
        │               │
        │     /actuator/prometheus
        │               │
        │        ┌──────▼──────┐
        │        │  Prometheus │  ← scrape toutes les X secondes
        │        └──────┬──────┘
        │               │
        │        ┌──────▼──────┐
        │        │   Grafana   │  ← dashboards interactifs
        │        └─────────────┘
        │
   ┌────▼──────┐
   │  Logging  │  → fichiers / console
   └───────────┘
```

---

## ✨ Fonctionnalités

- ✅ **Health check** — état de l'application, base de données, dépendances
- ✅ **Métriques JVM** — mémoire heap/non-heap, threads, garbage collector
- ✅ **Métriques HTTP** — nombre de requêtes, statuts, temps de réponse
- ✅ **Métriques système** — CPU, charge système
- ✅ **Tableaux de bord Grafana** — visualisation dynamique et alerting
- ✅ **Logging structuré** — niveaux configurables (DEBUG, INFO, WARN, ERROR)

---


## 🌐 Accès aux interfaces

| Interface | URL | Identifiants par défaut |
|---|---|---|
| Application Spring Boot | http://localhost:8081 | — |
| Spring Actuator | http://localhost:8081/actuator | — |
| Prometheus | http://localhost:9090 | — |
| Grafana | http://localhost:3000 | `admin` / `admin1` |

---

## 📈 Métriques exposées

Quelques métriques clés disponibles via `/actuator/prometheus` :

| Métrique | Description |
|---|---|
| `jvm_memory_used_bytes` | Mémoire JVM utilisée |
| `jvm_threads_live_threads` | Nombre de threads actifs |
| `http_server_requests_seconds` | Durée des requêtes HTTP |
| `process_cpu_usage` | Utilisation CPU du processus |
| `hikaricp_connections_active` | Connexions DB actives (si BDD configurée) |

---
## Affichage
<img width="1728" height="1117" alt="Health Check" src="https://github.com/user-attachments/assets/4a34c9cd-5708-48d8-94f4-5a8e953e3c77" />
<img wid<img width="1728" height="1117" alt="Métriques JVM" src="https://github.com/user-attachments/assets/11c04216-2236-4726-8446-d2b9ce01b16f" />
th="1728" h<img width="1728" height="1117" alt="Observation en direct" src="https://github.com/user-attachments/assets/3105acbe-b3dc-4b30-a69e-75e18716b1ce" />
eight="1117" alt="In<img width="1728" height="1117" alt="Requêtes par seconde" src="https://github.com/user-attachments/assets/a0b033e3-6300-4445-ba55-f80acc9a7b1a" />
<img width="1728" height="1117" alt="Vérifie la cible" src="https://github.com/user-attachments/assets/588973fe-72cc-4911-a829-857d6a5a0dd5" />
fos générale<img width="1728" height="1117" alt="Mémoire utilisée" src="https://github.com/user-attachments/assets/afe4fd4a-4aa4-4f06-a96c-70dde396849a" />

---
