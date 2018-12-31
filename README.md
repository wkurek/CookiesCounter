# Cookies Counter 🍪

## Treść zadania :page_with_curl:

Nauczycielka w przedszkolu chce rozdać ciastka dzieciom w swojej grupie. Dzieci siedzą w linii obok siebie (i nie zmieniąją tych pozycji). Każde dziecko ma przypisaną ocenę Si, gdzie i należy do przedziału (1, 2, ..., n) zgodnie z wynikiem testu umiejetności. Nauczycielka chce dać każdemu dziecki co najmniej jedno ciestko. Jeśli dzieci siedzą obok siebie, dziecko z wyższą oceną musi dostać więcej ciastek niż z niższą oceną. Nauczycielka ma ograniczony budżet, więc chce rozdać jak najmniej ciastek. Zaproponuj algorytm, który zwróci najmniejszą liczbę ciastek, które musi rozdać nauczycielka.

## Algorytm ✏

Algorytm zakłada, że na początku zostanie utworzona kolekcja, w której będą przechowane indeksy uczniów, dla których nie można było wyznaczyć liczby ciastek bez znajomości liczby ciastek następnego ucznia.
Istnieje tablica, w której przechowywana jest liczba ciastek przyporządkowana danemu uczniowi. Przeglądamy od początku oceny kolejnych uczniów i na ich podstawie przypisujemy kolejnym uczniom liczbę ciastek jeśli jest to możliwe.

- Jeśli rozpatrujemy pierwszego ucznia i ma on ocenę mniejszą lub równą kolejnemu uczniowi to jego liczba ciastek wynosi: 1.
- Jeśli rozpatrujemy ostatniego ucznia i ma on ocenę większą od przedostatniego ucznia to jego liczba ciastek wynosi: liczba ciastek przedostatniego ucznia + 1.
- Jeśli ocena ucznia jest mniejsza od ocen obu sąsiadów to liczba ciastek wynosi: 1.
- Jeśli ocena ucznia jest większa od poprzednika i niewiększa od następnika to liczba ciastek wynosi: liczba ciastek poprzednika + 1.

Przypisanie nie będzie możliwe w następujących przypadkach:

- Rozważamy pierwszego ucznia i ma on większą ocenę niż drugi uczeń.
- Rozważamy ucznia mającego poprzednika i następnika.
  - Uczeń ma większą ocenę niż poprzednik i większa ocenę niż następnik.
  - Uczeń ma mniejszą ocenę niż poprzednik i większą ocenę niż następnik.

Następnie rozważamy uczniów, dla których nie zostały przydzielone ciastka – ich indeksy są przechowywane w kolekcji. Przeglądamy kolekcję od końca (uczeń z największym indeksem na początku).

- Jeśli indeks jest równy 0 (pierwszy uczeń) to przypisujemy mu ilość ciastek równą: ilości ciastek następnego dziecka + 1.
- Dla ucznia z oceną większą od sąsiadów przypisujemy liczbę ciastek równą:
  MAX z liczby ciastek sąsiadów + 1.
- Dla ucznia z oceną mniejsza niż poprzednik i większą niż następnik przypisujemy liczbę ciastek równą: liczba ciastek następnika + 1.

## Tryby wykonania ▶

Są trzy tryby wykonania definiowane poprzez parametr uruchomieniowy `-m`. Parametr może przjmować wartość 1, 2 lub 3. Poniżej opisane są kolejne tryby wykonania z liczą porządkową związaną z tym trybem wykonania.

#### 1. Rozwiązanie problemu zdefiniowanego w strumieniu wejściowym

W tym trybie dane problemu (oceny kolejnych uczniów) pobierane są ze standardowego strumienia wejścia.
Dane powinny być w formacie: `1, 2, 5, 4, 6`.

```sh
$ java -jar ./Cookies.jar -m 1 < sample_data.txt > result.txt
```

#### 2. Generacja i rozwiązanie problemu

W tym trybie wykonania program sam generuje problem o zdefiniowanej przez paramter `-n` wielkości a następnie go rozwiązuje.

```sh
$ java -jar ./Cookies.jar -m 2 -n 6
```

#### 3. Testowanie z pomiarem czasu

Tryb wykonania, który służy do testowania wraz z pomiarem czasu. Dane testowe są definiowane przez następujące parametry:

- `-n` początkowa wielkość problemu
- `-k` liczba testowanych wielkości problemu
- `-step` krok, czyli wartość o jaką zwiększa się rozmiar kolejnych testowanych wielkości problemów
- `-r` ilość badanych instancji danej wielkości problemu

```sh
$ java -jar ./Cookies.jar -m 3 -n 600000 -k 30 -step 5000 -r 50 > result.txt
```
