# Pro-Gov

## Οδηγίες μεταγλώττισης του προγράμματος

Η εφαρμογή έχει υλοποιηθεί ως έργο Maven. Για τη μεταγλώττιση απαιτείται η εγκατάσταση του Java Development Kit (JDK) και του Maven στο σύστημα.

Από τον βασικό φάκελο του αποθετηρίου εκτελείται η παρακάτω εντολή:

```bash
mvn clean package
```

```text
 src/
 ├─ main/
 │  └─ java/
 │     └─ com/progov/
 │        ├─ app/
 │        ├─ model/
 │        ├─ service/
 │        ├─ ui/
 │        ├─ Users.java
 │        ├─ MenuEpilogwn.java
 │        ├─ Epiloges.java
 │        ├─ Trial.java
 │        ├─ CheckVariables.java
 │        ├─ BudgetComparator.java
 │        ├─ CompareCharts.java
 │        ├─ Diagram.java
 │        └─ DatabaseConnection.java
 └─ test/
    └─ java/
```


