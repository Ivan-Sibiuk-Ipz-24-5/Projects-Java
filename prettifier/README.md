# ✈️ Itinerary Prettifier

**Itinerary Prettifier** — це консольний Java-інструмент, який форматує сирі дані про маршрути польотів у читабельний вигляд.
Він зчитує текстовий файл із рейсами, виконує розпізнавання аеропортів за кодами IATA та зберігає відформатований результат у вихідний файл.

---

## 🚀 Запуск

### 🔧 Компіляція

```bash
javac -d out src/main/Prettifier.java src/tools/*.java
```

### ▶️ Запуск

```bash
java -cp out main.Prettifier src/resources/input.txt src/resources/output.txt src/resources/airport-lookup.csv
```

де:

* `input.txt` — вхідний файл із сирими даними про рейси
* `output.txt` — файл, куди буде записано відформатований результат
* `airport-lookup.csv` — таблиця для пошуку назв аеропортів за IATA-кодом

---

## 📂 Структура проєкту

```text
itinerary/
├─ src/
│   ├─ main/
│   │   └─ Prettifier.java
│   ├─ resources/
│   │   ├─ airport-lookup.csv
│   │   ├─ input.txt
│   │   └─ output.txt
│   └─ tools/
│       ├─ Airport.java
│       ├─ AirportLookup.java
│       ├─ Formatter.java
│       └─ TextProcessor.java
```



## 💡 Приклад використання

```bash
> java -cp out main.Prettifier input.txt output.txt airport-lookup.csv
```

**Вихідний результат:**

```
Flight from London (LHR) to New York (JFK)
Date: 12 Oct 2025
Time: 10:45 AM (UTC+1)
```

---

## 📄 Автор
````
Ivan Sibiuk
````