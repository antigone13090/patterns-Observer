# Pattern Observateur — Explication détaillée

## 1) Intention
Définir une relation **1‑à‑N** : quand le **Sujet** change d’état, tous les **Observateurs** sont notifiés et se mettent à jour.

## 2) Problème (ce qu’on veut éviter)
Dans une station météo :
- `WeatherData` reçoit de nouvelles mesures (température, humidité, pression)
- plusieurs écrans doivent se mettre à jour

Sans Observateur, le sujet appelle directement chaque écran (couplage fort) :
- ajout/suppression d’un écran => modification de `WeatherData`
- difficile à réutiliser ailleurs

## 3) Solution : Subject + Observer
### 3.1 Rôles
- **Subject** : `registerObserver`, `removeObserver`, `notifyObservers`
- **Observer** : `update(...)`
- (optionnel) **DisplayElement** : `display()`

### 3.2 Flux
1. Un observateur s’enregistre
2. Le sujet change d’état (`setMeasurements`)
3. Le sujet notifie (`notifyObservers`)
4. Les observateurs exécutent `update(...)` puis `display()`

## 4) Cartographie du projet
Package :
`src/main/java/headfirst/designpatterns/observer/`

- Contrats : `Subject`, `Observer`, `DisplayElement`
- Sujet concret : `WeatherData`
- Observateurs : `CurrentConditionsDisplay`, `StatisticsDisplay`, `ForecastDisplay`, `HeatIndexDisplay`
- Démo : `WeatherStation`

## 5) Point clé
Le sujet dépend **uniquement** de l’interface `Observer`.
Donc on peut ajouter/enlever des affichages sans modifier le sujet.

## 6) Exercices
1. Ajouter un affichage `MinMaxDisplay`.
2. L’enregistrer dans `WeatherStation`.
3. Tester `removeObserver(...)` et vérifier qu’il ne reçoit plus d’updates.
