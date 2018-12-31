# Cookies Counter :cookie:

## Task :page_with_curl:
Nauczycielka w przedszkolu chce rozdać ciastka dzieciom w swojej grupie. Dzieci siedzą w linii obok siebie (i nie zmieniąją tych pozycji). Każde dziecko ma przypisaną ocenę Si, gdzie i należy do przedziału (1, 2, ..., n) zgodnie z wynikiem testu umiejetności. Nauczycielka chce dać każdemu dziecki co najmniej jedno ciestko. Jeśli dzieci siedzą obok siebie, dziecko z wyższą oceną musi dostać więcej ciastek niż z niższą oceną. Nauczycielka ma ograniczony budżet, więc chce rozdać jak najmniej ciastek. Zaproponuj algorytm, który zwróci najmniejszą liczbę ciastek, które musi rozdać nauczycielka.

## Algorithm :pencil2:
Jeśli liczba dzieci jest mniejsza lub równa 0 to minimalna liczba ciastek zawsze wynosi 0.
Jeżeli jest jedno dziecko, to minimalna liczba ciastek wynosi 1.

Jeżeli jest więcej niż dwoje dzieci to rozpatrujemy każde dziecko po kolei za każdym razem uwzględniając stosunek ocen sąsiadów do oceny dziecka, które rozpatrujemy. W ogólności ocena sąsiada może być: mniejsza, taka sama lub większa. Możliwe konfiguracje grupujemy w następujący sposób:
1.	Rozpatrujemy pierwsze dziecko
    - Jeżeli ocena pierwszego dziecka jest większa od oceny drugiego dziecka to aby uzyskać liczbę ciastek tego dziecka należy obliczyć ilość ciastek drugiego dziecka i dodać do niej 1.
    - W pozostałych przypadkach liczba ciastek pierwszego dziecka wynosić będzie 1.
2. Rozpatrujemy ostatnie dziecko
    - Jeżeli ocena ostatniego dziecka jest większa od oceny przedostatniego dziecka to aby otrzymać liczbę ciastek tego dziecka do liczby ciastek przedostatniego dziecka dodajemy 1.
    - W pozostałych przypadkach liczba ciastek ostatniego dziecka wynosić będzie 1.
3. W pozostałych przypadkach (takich, w których istnieje poprzednie i następne dziecko)
    - Jeżeli ocena rozpatrywanego dziecka jest większa od obu sąsiadów to musimy obliczyć ilość ciastek następnego dziecka. Następnie bierzemy liczbę ciastek sąsiada posiadającego więcej ciastek i dodajemy do niej 1.
    - Jeżeli ocena rozpatrywanego dziecka jest większa od oceny następnego dziecka i rozpatrywane dziecko ma co najmniej taką samą ocenę jak poprzednie dziecko to musimy obliczyć ilość ciastek następnego dziecka. Liczbą ciastek rozpatrywanego dziecka jest liczba ciastek następnego dziecka powiększona o 1.
    - Jeżeli ocena rozpatrywanego dziecka jest co najwyżej taka sama jak ocena następnego dziecka i rozpatrywane dziecko ma większą ocenę od poprzedniego dziecka to liczbą ciastek rozpatrywanego dziecka jest liczba ciastek poprzedniego dziecka powiększona o 1.
    - W pozostałych przypadkach liczba ciastek rozpatrywanego dziecka wynosi 1.

 Liczbę ciastek dla każdego dziecka liczymy zawsze tylko raz. Jeżeli w którymś kroku algorytmu zachodzi potrzeba obliczenia ilości ciastek następnego dziecka to ta liczba jest zapisywana i nie będzie liczona w kolejnych iteracjach.