# android-2023-unitbv

Regasiti in acest repository codul scris in ultimele 2 laboratoare (l-am aranjat putin ca sa arate mai bine).

Asadar, avem urmatoarea navigare si componente:

1. **MainActivityJava** - activitatea principala care asigura navigarea printre fragmente utilizand **Navigation Component**. Contine de asemenea si un buton pentru a accesa fragmentul **FagmentKotlinSecond**. De indata ce isi atinge acest scop, isi schimba comportamentul pentru a putea accesa **HomeActivity**. 
2. **FragmentKotlin** - destinatia initiala a MainActivityJava. Gasim aici un buton care ne ajuta sa navigam catre **FragmentJava**.
3. **FragmentJava** - un fragment care nu are nici o actiune proprie, ci o poate folosi numai pe cea oferita de activitatea in **context**-ul careia traieste.
4. **FragmentKoltinSecond** - un fragment care nu are nici o actiune proprie, ci o poate folosi numai pe cea oferita de activitatea in **context**-ul careia traieste.
5. **HomeActivity** - o activitate finala. Contine un buton care afiseaza o lista de filme si seriale intr-un RecyclerView.
6. **MainActivity** - o activitate neutilizata. 

## FragmentKotlin
![Screenshot_1678445690](https://user-images.githubusercontent.com/94128900/224305248-0b5c2a5b-486c-4df8-90fc-7e57a48d7a68.png)

## FragmentJava
![Screenshot_1678445703](https://user-images.githubusercontent.com/94128900/224309099-693173aa-3219-44fb-a7e4-f6130f76f2b4.png)

## FragmentKoltinSecond
![Screenshot_1678445694](https://user-images.githubusercontent.com/94128900/224309154-bc1dca68-4d35-4961-89ae-cb11d7b3740a.png)

## HomeActivity
![Screenshot_1679478918](https://user-images.githubusercontent.com/67600264/226868618-5afe6030-6beb-4672-8e3d-e3fbce73ee88.png)

## HomeActivity with RecyclerView
![Screenshot_1679478922](https://user-images.githubusercontent.com/67600264/226868687-2907c99a-cbc8-4139-837f-627f161751e5.png)
