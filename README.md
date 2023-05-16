# android-2023-unitbv

Regasiti in acest repository codul scris in ultimele 2 laboratoare (l-am aranjat putin ca sa arate mai bine).

Asadar, avem urmatoarea navigare si componente:

1. **MainActivityJava** - activitatea principala care asigura navigarea printre fragmente utilizand **Navigation Component**. Contine de asemenea si un buton pentru a accesa fragmentul **FagmentKotlinSecond**. De indata ce isi atinge acest scop, isi schimba comportamentul pentru a putea accesa **HomeActivity**. 
2. **FragmentKotlin** - destinatia initiala a MainActivityJava. Gasim aici un buton care ne ajuta sa navigam catre **FragmentJava**.
3. **FragmentJava** - un fragment care nu are nici o actiune proprie, ci o poate folosi numai pe cea oferita de activitatea in **context**-ul careia traieste.
4. **FragmentKoltinSecond** - un fragment care nu are nici o actiune proprie, ci o poate folosi numai pe cea oferita de activitatea in **context**-ul careia traieste.
5. **HomeActivity** - o activitate de tranzitie. Contine:
* un buton care afiseaza **FragmentContainerView**. Acesta are ca destinatie initiala **FragmentRecyclerView**.
* un buton care ne trimite catre activitatea **LocalDataBaseActivity**.
6. **FragmentRecyclerView** - contine:
* o lista de filme si seriale intr-un RecyclerView;
* un **FloatingActionButton** cu actiunea de navigare catre **FragmentNetworkData** atasata. 
7. **FragmentNetworkData** - afiseaza o lista de postari ale utilizatorilor (de exemplu Facebook wall), obtinuta in urma unui request catre un server. Rezultatul vine sub forma unui **JSONArray** plin cu obiecte de tip **JSONObject**. Acestea sunt extrase si afisate intr-o lista scrolabila folosind RecyclerView.
8. **MainActivity** - o activitate neutilizata. 
9. **LocalDataBaseActivity** - o activitate care utilizeaza integrarea cu Room pentru a salva date intr-o baza de date locala.

## FragmentKotlin
![Screenshot_1678445690](https://user-images.githubusercontent.com/94128900/224305248-0b5c2a5b-486c-4df8-90fc-7e57a48d7a68.png)

## FragmentJava
![Screenshot_1678445703](https://user-images.githubusercontent.com/94128900/224309099-693173aa-3219-44fb-a7e4-f6130f76f2b4.png)

## FragmentKoltinSecond
![Screenshot_1678445694](https://user-images.githubusercontent.com/94128900/224309154-bc1dca68-4d35-4961-89ae-cb11d7b3740a.png)

## HomeActivity
![Screenshot_1679478918](https://user-images.githubusercontent.com/67600264/226868618-5afe6030-6beb-4672-8e3d-e3fbce73ee88.png)

## FragmentRecyclerView
![Screenshot_1684240969](https://github.com/cstAcademy/android-2023-unitbv/assets/67600264/bf121a0b-f85a-406e-b0be-2f07c2462395)

## FragmentNetworkData 
![Screenshot_1684240963](https://github.com/cstAcademy/android-2023-unitbv/assets/67600264/eefbc89b-05b6-405a-b5eb-f8424be05ac7)

## FragmentNetworkData (**EMPTY STATE**)
![Screenshot_1684241091](https://github.com/cstAcademy/android-2023-unitbv/assets/67600264/7755e4ce-1163-417c-b704-13999319db35)

## LocalDataBaseActivity
![Screenshot_1683897555](https://github.com/cstAcademy/android-2023-unitbv/assets/67600264/482e8a85-dea2-4140-844f-1bb3c1930ca9)
