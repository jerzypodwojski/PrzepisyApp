package com.example.przepisyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.przepisyapp.ListFragment.Global.Companion.categoryNumber
import com.example.przepisyapp.ListFragment.Global.Companion.isCategory

class RecyclerAdapter(
    private val routes: Array<String>
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val descriptions = mapOf(
        "1 Mięsne" to "Opis drogi 1\nDługość trasy: 2h\nTrasa przebiega przez miasta: Poznań",
        "2 Wegańskie" to "Opis drogi 2\nDługość trasy: 1h\nTrasa przebiega przez miasta: Poznań, Luboń",
        "3 Kuchnia Polska" to "Opis drogi 3\nDługość trasy: 1.5h\nTrasa przebiega przez miasta: Warszawa",
        "4 Kuchnia Zagraniczna" to "Opis drogi 4\nDługość trasy: 1h\nTrasa przebiega przez miasta: Kraków",
        "5 Zupy" to "Opis drogi 5\nDługość trasy: 2.5h\nTrasa przebiega przez miasta: Gdańsk, Gdynia, Sopot",
        "6 Drugie Dania" to "Opis drogi 6\nDługość trasy: 0.5h\nTrasa przebiega przez miasta: Poznań",
        "7 Surówki i sałatki" to "Opis drogi 7\nDługość trasy: 3.2h\nTrasa przebiega przez miasta: Poznań, Luboń",
        "8 Ciastka i desery" to "Opis drogi 8\nDługość trasy: 0.2h\nTrasa przebiega przez miasta: Warszawa",
    )
    private val descriptions1 = mapOf(
        "1 Amerykańskie burgery z pieczarkami i sadzonym jajem" to "Krok 1\n" +
                "Mięso oczyść z błon, pokrój na mniejsze kawałki i zmiel w maszynce. Dodaj przyprawę Knorr i dokładnie wyrób mięsną masę. Uformuj cztery, jednakowej wielkości burgery.\nKrok 2\n" +
                "Pieczarki przesmaż wraz z cebulą na rozgrzanej oliwie, dopraw solą i pieprzem.\nKrok 3\n" +
                "Burgery ułóż na rozgrzanym grillu i smaż 8-10 minut przewracając co jakiś czas. Podczas grillowania smaruj je sosem Hellmann’s Steak. Plastry boczku również ułóż na grillu. Bułki przekrój na połówki, opiecz na grillu i posmaruj majonezem.\nKrok 4\n" +
                "W tym samym czasie rozgrzej olej na patelni i usmaż 4 jajka sadzone.\nKrok 5\n" +
                "Gotowe kotlety ułóż na bułkach z majonezem oraz rukolą, nałóż następnie boczek, pieczarki oraz sadzone jajka. Wierzch hamburgerów przykryj pozostałą bułką. Gotowe burgery zepnij długimi wykałaczkami i podawaj z frytkami i sałatką coleslaw.\nmięso wołowe z udźca\n" +
                "\nSkładniki\n" +
                "500 gramów\n" +
                "\n" +
                "Przyprawa do grilla Knorr\n" +
                "\n" +
                "2 łyżki\n" +
                "\n" +
                "Sos Hellmann's Steak\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "boczek wędzony\n" +
                "\n" +
                "8 plastrów\n" +
                "\n" +
                "bułki do hamburgerów\n" +
                "\n" +
                "4 sztuki\n" +
                "\n" +
                "pieczarki pokrojone w plastry\n" +
                "\n" +
                "10 sztuk\n" +
                "\n" +
                "cebula biała pokrojona w piórka\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "rukola, garstka\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "jajka\n" +
                "\n" +
                "4 sztuki\n" +
                "\n" +
                "majonez\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "olej\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "pieprz czarny mielony\n" +
                "\n" +
                "1 szczypta\n" +
                "Czas gotowania: 30min",
        "2 Grillowane piersi z kurczaka z rozmarynem" to "Krok 1\n" +
                "Piersi z kurczaka przekrój wzdłuż na pół. Następnie rozbij delikatnie przez folię tak, aby mięso po całej długości miało podobną grubość. .\n" +
                "\n" +
                "Grillowane piersi z kurczaka z rozmarynem  - Krok 1\n" +
                "Krok 2\n" +
                "W misce wymieszaj miód z octem balsamicznym, oliwą, przyprawą Knorr, czarnym pieprzem oraz posiekanym rozmarynem i czosnkiem. W powstałej marynacie zanurz piersi z kurczaka.\n" +
                "\n" +
                "Grillowane piersi z kurczaka z rozmarynem  - Krok 2\n" +
                "Krok 3\n" +
                "Mięso grilluj po około 5 minut z każdej strony na średnio rozgrzanym grillu. Podawaj z sosem Hellmann's Samba.\nSkładniki\n" +
                "piersi kurczaka\n" +
                "\n" +
                "4 sztuki\n" +
                "\n" +
                "Przyprawa do grilla Knorr\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "Sos Hellmann's Samba\n" +
                "\n" +
                "100 mililitrów\n" +
                "\n" +
                "oliwa extra vergine\n" +
                "\n" +
                "75 mililitrów\n" +
                "\n" +
                "miód np. lipowy\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "świeży rozmaryn posiekany\n" +
                "\n" +
                "1 łyżka\n" +
                "\n" +
                "ocet balsamiczny\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "grubo zmielony czarny pieprz\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "ząbki czosnku\n" +
                "\n" +
                "3 sztuki\n" +
                "Czas gotowania: 30min"
    )

    private val descriptions2 = mapOf(
        "1 Wegańskie spaghetti bolognese" to "Krok 1\n" +
                "Obierz z łupin cebulę z czosnkiem. Umyj i wysusz paprykę oraz pomidorki koktajlowe.\n" +
                "\n" +
                "Krok 2\n" +
                "Czerwoną paprykę podziel na części, dokładnie oczyść z nasion, a następnie pokrój w niewielką kostkę. Pomidory koktajlowe przekrój na pół. Cebulę i czosnek posiekaj.\n" +
                "\n" +
                "Krok 3\n" +
                "Na dobrze rozgrzanej oliwie podsmaż cebulę wraz z czosnkiem. Dorzuć czerwoną paprykę i smaż przez kolejne 3 minuty, mieszając od czasu do czasu.\n" +
                "\n" +
                "Krok 4\n" +
                "Wlej pomidory z puszki, wlej 400 ml ciepłej wody, całość dopraw solą, pieprzem oraz suszonym oregano. Na koniec dodaj Magic Mince The Vegetarian Butcher, kilkakrotnie zamieszaj i gotuj sos ok. 10 minut, aż wszystkie składniki się ze sobą połączą, a sos zgęstnieje. Na końcu wsyp do sosu pomidorki koktajlowe i jeszcze raz delikatnie zamieszaj. Gotowy sos zdejmij z ognia. W międzyczasie ugotuj spaghetti zgodnie z instrukcją podaną na opakowaniu.\n" +
                "\n" +
                "Krok 5\n" +
                "Odcedzony makaron polej wciąż gorącym sosem. Udekoruj grubo siekaną, świeżą bazylią oraz płatkami drożdżowymi. Spaghetti bolognese wegańskie podawaj natychmiast po przygotowaniu.\nSkładniki\n" +
                "Wegański pełnoziarnisty makaron spaghetti\n" +
                "\n" +
                "150 gramów\n" +
                "\n" +
                "Magic Mince The Vegetarian Butcher\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "cebula\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "ząbek czosnku\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "czerwona papryka\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "pomidorki koktajlowe\n" +
                "\n" +
                "150 gramów\n" +
                "\n" +
                "krojone pomidory z puszki\n" +
                "\n" +
                "400 gramów\n" +
                "\n" +
                "suszone oregano\n" +
                "\n" +
                "1 łyżka\n" +
                "\n" +
                "oliwa\n" +
                "\n" +
                "2 łyżki\n" +
                "\n" +
                "sól i pieprz do smaku\n" +
                "\n" +
                "2 szczypty\n" +
                "\n" +
                "świeża bazylia\n" +
                "\n" +
                "2 garść\n Czas gotowania 25 min",
        "2 Wegańska lasagne w stylu bolognese" to "Krok 1\n" +
                "Rozgrzej piekarnik do 180°C. Obierz i posiekaj czosnek. Na patelni rozgrzej łyżkę oliwy i podsmaż czosnek wraz Magic Mince The Vegetarian Butcher.\n" +
                "\n" +
                "Krok 2\n" +
                "Po chwili smażenia dodaj mieszankę warzyw. Wymieszaj, wlej passatę, dopraw szczyptą soli, oregano i gotuj powoli ok 10 minut.\n" +
                "\n" +
                "Krok 3\n" +
                "Przygotuj wegański sos beszamelowy. Na oliwie podsmaż mąkę, następnie wlej napój owsiany i dokładnie wymieszaj. Dopraw szczyptą soli, gałką muszkatołową i dokładnie mieszając zagotuj.\n" +
                "\n" +
                "Krok 4\n" +
                "Dno małego naczynia do pieczenie (20cm x 20cm) posmaruj sosem pomidorowym. Rozłóż na nim 2 arkusze lasagne, następnie posmaruj sosem beszamelowym i sosem pomidorowym. Przykryj arkuszem makaronu. Czynność powtarzaj aż do wyczerpania sosu w stylu bolognese. Ostatnią warstwę powinien stanowić makaron. Posmaruj go na wierzchu sosem beszamelowy.\n" +
                "\n" +
                "Krok 5\n" +
                "Lasagne przykryj folią aluminiową i piecz przez 35 minut. Po tym czasie zdejmij folię, zwiększ temperaturę do 220 stopni i zapiecz na wierzchu. Po wyjęciu z pieca odczekaj 10 minut i podawaj.\n Składniki\n" +
                "makaron lasagne - płaty\n" +
                "\n" +
                "9 sztuk\n" +
                "\n" +
                "Magic Mince The Vegetarian Butcher\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "ząbek czosnku\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "oliwa z oliwek\n" +
                "\n" +
                "3 łyżki\n" +
                "\n" +
                "mieszanka mrożonych warzyw\n" +
                "\n" +
                "600 gramów\n" +
                "\n" +
                "passata pomidorowa\n" +
                "\n" +
                "600 gramów\n" +
                "\n" +
                "suszone oregano\n" +
                "\n" +
                "2 łyżeczki\n" +
                "\n" +
                "mąka\n" +
                "\n" +
                "25 gramów\n" +
                "\n" +
                "napój owsiany\n" +
                "\n" +
                "350 mililitrów\n" +
                "\n" +
                "gałka muszkatołowa\n" +
                "\n" +
                "1 szczypta\n" +
                "\n" +
                "sól\n" +
                "\n" +
                "1 szczypta\n Czas gotowania: 50 min"
    )

    private val descriptions3 = mapOf(
        "1 Barszcz polski" to "Krok 1\n" +
                "Przygotuj 1,5 litra wywaru mięsno – warzywnego.\n" +
                "\n" +
                "Barszcz polski - Krok 1\n" +
                "Krok 2\n" +
                "Umyj i ugotuj buraki. Następnie obierz i zetrzyj na tarce o dużych oczkach.\n" +
                "\n" +
                "Barszcz polski - Krok 2\n" +
                "Krok 3\n" +
                "Zagotuj wywar i zalej buraki częścią wrzącego wywaru.\n" +
                "\n" +
                "Barszcz polski - Krok 3\n" +
                "Krok 4\n" +
                "Dodaj Barszcz czerwony Knorr i gotuj przez 10 minut. Przecedź, następnie dopraw do smaku majerankiem oraz cukrem.\n" +
                "\n" +
                "Barszcz polski - Krok 4\n" +
                "Krok 5\n" +
                "Obierz ziemniaki, pokrój je w kostkę, ugotuj w pozostałym wywarze.\n" +
                "\n" +
                "Barszcz polski - Krok 5\n" +
                "Krok 6\n" +
                "Obierz kiełbasę z osłonki, pokrój w plastry i połącz z ziemniakami oraz wywarem z buraków. Śmietanę zmieszaj z mąką oraz koperkiem, po czym dodaj do całości. Gotuj przez chwilę. Dopraw do smaku, jeśli uznasz, że jest to konieczne.\nSkładniki\n" +
                "buraki\n" +
                "\n" +
                "50 dekagramów\n" +
                "\n" +
                "ziemniaki\n" +
                "\n" +
                "40 dekagramów\n" +
                "\n" +
                "Barszcz czerwony Ulubione Smaki Knorr\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "kiełbasa biała parzona pokrojona w plastry\n" +
                "\n" +
                "20 dekagramów\n" +
                "\n" +
                "śmietana\n" +
                "\n" +
                "0.5 szklanki\n" +
                "\n" +
                "mąka pszenna\n" +
                "\n" +
                "2 dekagramy\n" +
                "\n" +
                "koperek posiekany\n" +
                "\n" +
                "\n" +
                "cukier\n" +
                "\n" +
                "\n" +
                "majeranek\n" +
                "\n" +
                "\n" +
                "pieprz\nCzas gotowania: 1h",
        "2 Polskie łazanki z kapustą" to "Krok 1\n" +
                "Przygotuj ciasto na łazanki - z mąki, jajek i niewielkiej ilości wody zagnieć jednolite ciasto.\n" +
                "\n" +
                "Polskie łazanki z kapustą - Krok 1\n" +
                "Krok 2\n" +
                "Ciasto rozwałkuj cienko i pozostaw chwilę, aby obeschło. Następnie wykrawaj małe kwadratowe łazanki i gotuj je w osolonym wrzątku. Odcedź.\n" +
                "\n" +
                "Polskie łazanki z kapustą - Krok 2\n" +
                "Krok 3\n" +
                "Cebulę pokrój w kostkę. Kapustę poszatkuj drobno. W dużym garnku na rozgrzanej oliwie przesmaż cebulę i kapustę. Dodaj liść laurowy, ziele angielskie, pokruszone grzyby i kostki Knorr. Kapustę duś do miękkości.\n" +
                "\n" +
                "Polskie łazanki z kapustą - Krok 3\n" +
                "Krok 4\n" +
                "Naczynie żaroodporne natłuść. Ułóż na spodzie warstwę łazanek, następnie warstwę kapusty - czynność powtórz.\n" +
                "\n" +
                "Polskie łazanki z kapustą - Krok 4\n" +
                "Krok 5\n" +
                "Na wierzchu ułóż kilka plasterków masła. Naczynie wstaw do piekarnika nagrzanego do temperatury 170 stopni. Zapiekaj 45 minut. Posyp natką.\nSkładniki\n" +
                "kapusta\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "grzyby suszone\n" +
                "\n" +
                "\n" +
                "Bulion grzybowy na borowikach leśnych Knorr\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "cebula\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "mąka\n" +
                "\n" +
                "250 gramów\n" +
                "\n" +
                "jajko\n" +
                "\n" +
                "3 sztuki\n" +
                "\n" +
                "pieprz czarny mielony\n" +
                "\n" +
                "1 szczypta\n" +
                "\n" +
                "liść laurowy\n" +
                "\n" +
                "3 listków\n" +
                "\n" +
                "ziele angielskie\n" +
                "\n" +
                "5 ziaren\n" +
                "\n" +
                "oliwa\n" +
                "\n" +
                "30\n" +
                "\n" +
                "masło\n" +
                "\n" +
                "50\n" +
                "\n" +
                "natka pietruszki (posiekana)\n" +
                "\n" +
                "\n" +
                "woda w miarę potrzeb\nCzas gotowania: 90min",
    )

    private val descriptions4 = mapOf(
        "1 Kartoffelsalat" to "Krok 1\n" +
                "Ziemniaki wyszoruj dokładnie szczoteczką i obgotuj przez 10 minut w mundurkach, w dobrze osolonej wodzie. Nie odcedzaj od razu, zostaw jeszcze na 10 minut pod przykryciem.\n" +
                "\n" +
                "Kartoffelsalat czyli niemiecka sałatka ziemniaczana - Krok 1\n" +
                "Krok 2\n" +
                "W tym czasie z oleju, octu, posiekanej cebuli, posiekanej natki i ziół przygotuj marynatę. Wymieszaj dokładnie z bulionem i dopraw do smaku.\n" +
                "\n" +
                "Kartoffelsalat czyli niemiecka sałatka ziemniaczana - Krok 2\n" +
                "Krok 3\n" +
                "Ziemniaki przelej zimną wodą i ściągnij z nich mundurki. Pokrój w dużą kostkę i wsadź do marynaty.\n" +
                "\n" +
                "Kartoffelsalat czyli niemiecka sałatka ziemniaczana - Krok 3\n" +
                "Krok 4\n" +
                "Czekając, aż ziemniaki całkowicie wystygną pokrój w kostkę ogórki konserwowe. Jeżeli mają bardzo duże pestki wybierz środki i skrój tylko same wierzchy.\n" +
                "\n" +
                "Kartoffelsalat czyli niemiecka sałatka ziemniaczana - Krok 4\n" +
                "Krok 5\n" +
                "Odcedź ziemniaki z marynaty i wymieszaj. Kartoffelsalat najlepiej jest jeść tak jak w Niemczech, zamiast surówki i ziemniaków, podany do pieczeni lub kotletów.\nSkładniki\n" +
                "ziemniaki\n" +
                "\n" +
                "1 kilogram\n" +
                "\n" +
                "cebula\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "ogórki konserwowe\n" +
                "\n" +
                "100 gramów\n" +
                "\n" +
                "bulion\n" +
                "\n" +
                "125 mililitrów\n" +
                "\n" +
                "majeranek\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "natka pietruszki\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "sól\n" +
                "\n" +
                "1 szczypta\n" +
                "\n" +
                "czarny pieprz mielony\n" +
                "\n" +
                "1 szczypta\n" +
                "\n" +
                "olej\n" +
                "\n" +
                "3 łyżki\n" +
                "\n" +
                "ocet winny\n" +
                "\n" +
                "2 łyżki\nCzas gotowania: 45min",
        "2 Reibekuchen, czyli chrupiące niemieckie placki ziemniaczane" to "Krok 1\n" +
                "Ziemniaki obierz i zetrzyj na grubych oczkach tarki. Odciśnij.\n" +
                "\n" +
                "Reibekuchen, czyli chrupiące niemieckie placki ziemniaczane - Krok 1\n" +
                "Krok 2\n" +
                "Wymieszaj z surowymi jajkami, mąką, dodaj pokrojoną w drobniutką kosteczkę cebulę. Dopraw ciasto przyprawami.\n" +
                "\n" +
                "Reibekuchen, czyli chrupiące niemieckie placki ziemniaczane - Krok 2\n" +
                "Krok 3\n" +
                "Formuj dość duże placki grubości ok. 1,5 cm i smaż na rozgrzanym oleju.\n" +
                "\n" +
                "Reibekuchen, czyli chrupiące niemieckie placki ziemniaczane - Krok 3\n" +
                "Krok 4\n" +
                "Chrupiące placki ziemniaczane ułóż na papierowym ręczniku, aby odsączyć nadmiar tłuszczu. Podawaj same, z musem jabłkowym lub gulaszem.\nSkładniki\n" +
                "ziemniaki\n" +
                "\n" +
                "1 kilogram\n" +
                "\n" +
                "jajko\n" +
                "\n" +
                "3 sztuki\n" +
                "\n" +
                "mąka\n" +
                "\n" +
                "5 łyżek\n" +
                "\n" +
                "cebula\n" +
                "\n" +
                "3 sztuki\n" +
                "\n" +
                "olej do smażenia\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "gałka muszkatołowa\n" +
                "\n" +
                "1 szczypta\n" +
                "\n" +
                "sól do smaku\n" +
                "\n" +
                "2 łyżeczki\n" +
                "\n" +
                "czarny pieprz mielony\n" +
                "\n" +
                "2 łyżeczki\nCzas gotowania: 30min",
    )

    private val descriptions5 = mapOf(
        "1 Zupa grzybowa kremowa" to "Krok 1\n" +
                "Cebule pokrój w kostkę. Podsmaż na oleju, dodaj czosnek smaż chwilę.\n" +
                "\n" +
                "Zupa grzybowa kremowa - Krok 1\n" +
                "Krok 2\n" +
                "Zupę Knorr rozprowadź ze śmietaną i wywarem. Dodaj do garnka, doprowadź do wrzenia – gotuj jeszcze na wolnym ogniu około 3 minut.\n" +
                "\n" +
                "Zupa grzybowa kremowa - Krok 2\n" +
                "Krok 3\n" +
                "W osobnym naczyniu rozmieszaj żółtka z piwem. Dodaj do gotującej się zupy. Zupę odstaw na bok. Dokładnie mieszaj przez chwilę, do momentu, kiedy zupa zrobi się aksamitnie gęsta.\n" +
                "\n" +
                "Zupa grzybowa kremowa - Krok 3\n" +
                "Krok 4\n" +
                "Kabanosy pokrój w plastry, podsmaż na patelni. Szczypior posiekaj.\n" +
                "\n" +
                "Zupa grzybowa kremowa - Krok 4\n" +
                "Krok 5\n" +
                "Zupę podawaj w płaskim naczyniu, z porcją kabanosów wyłożonych na środek talerza, posypaną szczypiorkiem.\nSkładniki\n" +
                "kabanosy\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "wywar z mięsa i warzyw\n" +
                "\n" +
                "500 mililitrów\n" +
                "\n" +
                "Zupa grzybowa Ulubione Smaki Knorr\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "ciemne piwo\n" +
                "\n" +
                "0.5 szklanki\n" +
                "\n" +
                "śmietana\n" +
                "\n" +
                "300 mililitrów\n" +
                "\n" +
                "cebule szalotki\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "olej roślinny\n" +
                "\n" +
                "20 mililitrów\n" +
                "\n" +
                "ząbek czosnku\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "jajka\n" +
                "\n" +
                "2 sztuki\nCzas gotowania: 40min",
        "2 Zupa cebulowa" to "Krok 1\n" +
                "Zetrzyj marchew na tarce na grubych oczkach, czosnek drobno posiekaj, cebule pokrój w piórka. Rozgrzej w garnku tłuszcz, odczekaj chwilę i wrzuć warzywa. Chwilę je przysmaż, następnie duś przez około 2 minuty. Dolej 300 mililitrów zimnej wody i gotuj przez 10 minut.\n" +
                "\n" +
                "Zupa cebulowa - Krok 1\n" +
                "Krok 2\n" +
                "Dodaj kolejne 300 mililitrów zimnej wody. Wsyp zawartość torebki zupy cebulowej Knorr i gotuj na małym ogniu przez 15 minut. W trakcie gotowania dodaj przyprawy (zupa musi być ostra). Na koniec zupę mocno zmiksuj.\n" +
                "\n" +
                "Zupa cebulowa - Krok 2\n" +
                "Krok 3\n" +
                "Podawaj, przybierając nitką szafranu i cienkimi paskami surowej marchewki.\nSkładniki\n" +
                "cebule\n" +
                "\n" +
                "5 sztuk\n" +
                "\n" +
                "Francuska zupa cebulowa Knorr\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "obrana marchew\n" +
                "\n" +
                "200 gramów\n" +
                "\n" +
                "nitki szafranu\n" +
                "\n" +
                "3 sztuki\n" +
                "\n" +
                "chilli mielone\n" +
                "\n" +
                "\n" +
                "ząbek czosnku\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "margaryna\n" +
                "\n" +
                "2 łyżki\n" +
                "\n" +
                "woda\n" +
                "\n" +
                "600 mililitrów\nCzas gotowania: 45min",
    )

    private val descriptions6 = mapOf(
        "1 Pieczeone parówki ze śliwką" to "Krok 1\n" +
                "Parówki obierz z osłonek, natnij wzdłuż, uważając, aby nie przeciąć całej parówki. Posmaruj środki ostrą musztardą, nadziej śliwkami przekrojonymi na pół i owiń każdą w 2 plasterki boczku.\n" +
                "\n" +
                "Krok 2\n" +
                "Tak przygotowane parówki ułóż na blasze. Wstaw do piekarnika nagrzanego do temp. 170 stopni i piecz, aż boczek się ładnie zarumieni.\n" +
                "\n" +
                "Krok 3\n" +
                "Podawaj z keczupem oraz musztardą np. jako dodatek do piwa.\nSkładniki\n" +
                "parówki\n" +
                "\n" +
                "8 sztuk\n" +
                "\n" +
                "cienkie i długie plasterki boczku\n" +
                "\n" +
                "16 plastrów\n" +
                "\n" +
                "suszone śliwki kalifornijskie\n" +
                "\n" +
                "20 dekagramów\n" +
                "\n" +
                "ostra musztarda (dijon, rosyjska)\n" +
                "\n" +
                "2 łyżki\nCzas gotowania: 15min",
        "2 Indyk w marynacie jogurtowej (hinduskiej)" to "Krok 1\n" +
                "W misce rozmieszaj kostkę rosołową Knorr z jogurtem, koncentratem pomidorowym, posiekaną natką kolendry, sokiem z cytryny, posiekaną ostrą papryczką, czosnkiem oraz startymi ziarnami kolendry i kuminu.\n" +
                "\n" +
                "Indyk w marynacie jogurtowej (hinduskiej)  - Krok 1\n" +
                "Krok 2\n" +
                "W tak przygotowaną marynatę włóż pokrojone w małą kostkę - 1 centymetr na 1 centymetr- mięso z indyka. Całość pozostaw w chłodnym miejscu na kilka godzin.\n" +
                "\n" +
                "Indyk w marynacie jogurtowej (hinduskiej)  - Krok 2\n" +
                "Krok 3\n" +
                "Na patyki nadziewaj ananasa, pokrojonego w kostkę, na przemian z mięsem, zaczynając od indyka.\n" +
                "\n" +
                "Indyk w marynacie jogurtowej (hinduskiej)  - Krok 3\n" +
                "Krok 4\n" +
                "Szaszłyki grilluj około 20-25 minut, uważając jednak, aby się nie przypaliły.\nSkładniki\n" +
                "mięso z indyka, np. pierś\n" +
                "\n" +
                "600 gramów\n" +
                "\n" +
                "Rosół z kury Knorr\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "cytryna\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "oliwa z oliwek\n" +
                "\n" +
                "50 mililitrów\n" +
                "\n" +
                "jogurt lub kwaśne mleko\n" +
                "\n" +
                "200 mililitrów\n" +
                "\n" +
                "czosnek ząbki\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "koncentrat pomidorowy\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "sproszkowane ziarenka kolendry\n" +
                "\n" +
                "0.5 łyżeczki\n" +
                "\n" +
                "kmin rzymski\n" +
                "\n" +
                "0.5 łyżeczki\n" +
                "\n" +
                "natka kolendry\n" +
                "\n" +
                "1 pęczek\n" +
                "\n" +
                "mała papryczka chilli\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "ananas z puszki\n" +
                "\n" +
                "3 plastry\n" +
                "\n" +
                "długie patyki do robienia szaszłyków\n" +
                "\n" +
                "8 sztuk\nCzas gotowania: 90min",
    )

    private val descriptions7 = mapOf(
        "1 Sałatka zielona" to "Krok 1\n" +
                "Czosnek posiekaj. Sos sałatkowy Knorr przygotuj według wskazówek umieszczonych na opakowaniu dodając jeszcze posiekany czosnek.\n" +
                "\n" +
                "Sałatka zielona - Krok 1\n" +
                "Krok 2\n" +
                "Oliwki pokrój w krążki. Ogórka przekrój wzdłuż na pół, a następnie w cienkie plasterki. Szpinak porwij na mniejsze kawałki.\n" +
                "\n" +
                "Sałatka zielona - Krok 2\n" +
                "Krok 3\n" +
                "Wymieszaj delikatnie wszystkie składniki sałatki wraz z sosem i przełóż do czystej salaterki. Na wierzchu ułóż pokrojony w kostkę ser i oprósz suszonym oregano. Podawaj z grillowaną bagietką.\nSkładniki\n" +
                "szpinak świeży\n" +
                "\n" +
                "0.5 opakowania\n" +
                "\n" +
                "Sos sałatkowy grecki Knorr\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "rukola\n" +
                "\n" +
                "0.5 opakowania\n" +
                "\n" +
                "ząbek czosnku\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "ogórek zielony\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "oliwki zielone\n" +
                "\n" +
                "3 łyżki\n" +
                "\n" +
                "ser feta\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "suszone oregano\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "oliwa z oliwek\n" +
                "\n" +
                "3 łyżki\nCzas gotowania: 15min",
        "2 Sałatka Szwedzka" to "Krok 1\n" +
                "Buraczki, ziemniaki, jajka, szynkę, ogórki oraz jabłka pokrój w półcentymetrową kostkę. Cebulę pokrój w drobną kostkę, dodaj do pozostałych składników.\n" +
                "\n" +
                "Sałatka Szwedzka - Krok 1\n" +
                "Krok 2\n" +
                "Sos sałatkowy Knorr wymieszaj ze śmietaną i dopraw cukrem.\n" +
                "\n" +
                "Sałatka Szwedzka - Krok 2\n" +
                "Krok 3\n" +
                "Z chleba tostowego zrób grzanki, zapiekając kromki w rozgrzanym do 170 stopni piekarniku przez 12 minut.\n" +
                "\n" +
                "Sałatka Szwedzka - Krok 3\n" +
                "Krok 4\n" +
                "Połącz wszystkie składniki z sosem. Posiekaj koperek i dodaj do sałatki.\n" +
                "\n" +
                "Sałatka Szwedzka - Krok 4\n" +
                "Krok 5\n" +
                "Sałatkę podawaj na grzankach, udekorowaną świeżym koperkiem.\nSkładniki\n" +
                "szynka\n" +
                "\n" +
                "80 gramów\n" +
                "\n" +
                "Sos sałatkowy włoski Knorr\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "słoik buraczków marynowanych\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "ugotowane ziemniaki\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "ogórki konserwowe\n" +
                "\n" +
                "6 sztuk\n" +
                "\n" +
                "biała cebula\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "jabłka\n" +
                "\n" +
                "2 sztuki\n" +
                "\n" +
                "jajka ugotowane na twardo\n" +
                "\n" +
                "3 sztuki\n" +
                "\n" +
                "śmietana 18%\n" +
                "\n" +
                "80 mililitrów\n" +
                "\n" +
                "cukier\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "pęczek świeżego koperku\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "kromki chleba tostowego\n" +
                "\n" +
                "4 sztuki\nCzas gotowania: 30min",
    )

    private val descriptions8 = mapOf(
        "1 Włoskie ciastka z warzywami" to "Krok 1\n" +
                "Na rozgrzanej oliwie przesmaż czosnek oraz cebulę. Pomidory pokrój w paski i dodaj wraz ze szpinakiem na patelnię.\n" +
                "\n" +
                "Krok 2\n" +
                "Farsz dopraw do smaku przyprawą włoską.\n" +
                "\n" +
                "Krok 3\n" +
                "Płat ciasta rozłóż. Wyłóż farsz i zwiń jak roladę.\n" +
                "\n" +
                "Krok 4\n" +
                "Zwinięte ciasto pokrój w 2 cm grubości plastry. Ułóż je na blasze wyłożonej pergaminem.\n" +
                "\n" +
                "Krok 5\n" +
                "Rozłożone ciastka posmaruj rozkłóconym jajkiem i posyp serem. Blachę wstaw do nagrzanego do 180 °C piekarnika na 25 minut. Podawaj na ciepło lub zimno.\nSkładniki\n" +
                "ciasto francuskie\n" +
                "\n" +
                "1 opakowanie\n" +
                "\n" +
                "Mieszanka Włoska Knorr\n" +
                "\n" +
                "1 łyżeczka\n" +
                "\n" +
                "szpinak świeży\n" +
                "\n" +
                "2 pęczki\n" +
                "\n" +
                "pomidory suszone w oliwie\n" +
                "\n" +
                "10 sztuk\n" +
                "\n" +
                "ząbek czosnku\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "cebula\n" +
                "\n" +
                "1 sztuka\n" +
                "\n" +
                "oliwa z suszonych pomidorów\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "parmezan starty\n" +
                "\n" +
                "4 łyżki\n" +
                "\n" +
                "jajko\n" +
                "\n" +
                "1 sztuka\nCzas gotowania: 30min",
        "2 Proste ciastka" to "Krok 1\n" +
                "W robocie kuchennym utrzyj masło z cukrem pudrem aż będzie jasne i puszyste. Dodaj obie mąki i wymieszaj.\n" +
                "\n" +
                "Proste ciastka - Krok 1\n" +
                "Krok 2\n" +
                "Za pomocą worka cukierniczego nakładaj ciasto na blaszkę z pergaminem w formie małych ciasteczek.\n" +
                "\n" +
                "Proste ciastka - Krok 2\n" +
                "Krok 3\n" +
                "Każde ugnieć lekko zwilżonym widelcem i piecz w 170C przez 10-15 minut.\n" +
                "\n" +
                "Proste ciastka - Krok 3\n" +
                "Krok 4\n" +
                "Składniki kremu utrzyj w misce. Nakładaj na ciasteczka.\nSkładniki\n" +
                "masło\n" +
                "\n" +
                "200 gramów\n" +
                "\n" +
                "cukier puder\n" +
                "\n" +
                "100 gramów\n" +
                "\n" +
                "mąka pszenna\n" +
                "\n" +
                "250 gramów\n" +
                "\n" +
                "skrobia kukurydziana\n" +
                "\n" +
                "50 gramów\n" +
                "\n" +
                "krem:\n" +
                "\n" +
                "masło\n" +
                "\n" +
                "140 gramów\n" +
                "\n" +
                "cukier puder\n" +
                "\n" +
                "250 gramów\n" +
                "\n" +
                "sok z 3 cytryn\n" +
                "\n" +
                "\n" +
                "skórka otarta z 1 cytryny\nCzas gotowania: 20min",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val route = routes[position]
        holder.itemTitle.text = route
        holder.itemImage.setImageResource(R.drawable.route)
        //val number = route.filter { it.isDigit() }.toInt()
    }

    override fun getItemCount(): Int {
        return routes.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)

            itemView.setOnClickListener {
                val route = routes[position]
                val dishID = (route.filter{ it.isDigit() }).toInt()
                if (isCategory){
                    categoryNumber = dishID
                    isCategory = false
                    replaceFragment(ListFragment())
                }else{
                    var description: String? =
                        when(categoryNumber){
                            1 -> descriptions1[route]
                            2 -> descriptions2[route]
                            3 -> descriptions3[route]
                            4 -> descriptions4[route]
                            5 -> descriptions5[route]
                            6 -> descriptions6[route]
                            7 -> descriptions7[route]
                            else -> descriptions8[route]
                        }
                    categoryNumber = 0
                    isCategory = true
                    replaceFragment(DetailFragment.newInstance(route, description.toString(), dishID))
                }
            }
        }

        private fun replaceFragment(fragment: Fragment) {
            val smallestWidth = itemView.resources.configuration.smallestScreenWidthDp
            val manager = (itemView.context as FragmentActivity).supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()

            // phone/tablet mode
            if (smallestWidth < 720)
                fragmentTransaction.replace(R.id.fragment_container, fragment)
            else
                fragmentTransaction.replace(R.id.fragment_container2, fragment)

            fragmentTransaction.commit()
        }
    }
}