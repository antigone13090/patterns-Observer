# Observer (Head First Design Patterns) — Projet IntelliJ/Gradle

## Objectif
Illustrer le **pattern Observateur** (pattern suivant après Strategy dans *Head First Design Patterns*) via l’exemple “Weather Station”.

## Sujet (problème)
Plusieurs écrans doivent s’actualiser automatiquement quand de nouvelles mesures météo arrivent.
Sans pattern :
- le sujet (`WeatherData`) dépend de classes concrètes d’affichage
- ajout/suppression d’un écran = modification du sujet
- couplage fort et évolutivité faible

## Solution (pattern Observateur)
- `Subject` gère une liste d’observateurs
- chaque `Observer` s’enregistre/désenregistre
- le sujet notifie automatiquement les observateurs lors d’un changement d’état

## Exécuter (2 options)
### Option A — via IntelliJ (sans wrapper)
Ouvre le projet (le dossier `observer/`) comme projet Gradle, puis :
Gradle Tool Window -> Tasks -> application -> `run`.

### Option B — en ligne de commande (avec wrapper)
Copie le wrapper depuis ton projet `strategy` (tu l’as déjà) :
```bash
cp -a ../strategy/gradlew ../strategy/gradlew.bat ../strategy/gradle .
./gradlew run
```

## Documentation
- Détails : `docs/OBSERVER.md`
