# android-2023-unitbv

Regasiti in acest repository codul scris in ultimele 2 laboratoare (l-am aranjat putin ca sa arate mai bine).

Asadar, avem urmatoarea navigare si componente:

1. **MainActivityJava** - activitatea principala care asigura navigarea printre fragmente utilizand **Navigation Component**. Contine de asemenea si un buton pentru a accesa fragmentul **FagmentKotlinSecond**. De indata ce isi atinge acest scop, isi schimba comportamentul pentru a putea accesa **HomeActivity**. 
2. **FragmentKotlin** - destinatia initiala a MainActivityJava. Gasim aici un buton care ne ajuta sa navigam catre **FragmentJava**.
3. **FragmentJava** - un fragment care nu are nici o actiune proprie, ci o poate folosi numai pe cea oferita de activitatea in **context**-ul careia traieste.
4. **FragmentKoltinSecond** - un fragment care nu are nici o actiune proprie, ci o poate folosi numai pe cea oferita de activitatea in **context**-ul careia traieste.
5. **HomeActivity** - o activitate finala, fara posibilitatea de a initia o alta actiune.
6. **MainActivity** - o activitate neutilizata. 

## FragmentKotlin
![Screenshot_1678445690](https://user-images.githubusercontent.com/94128900/224305248-0b5c2a5b-486c-4df8-90fc-7e57a48d7a68.png)

## FragmentJava
![Screenshot_1678445703](https://user-images.githubusercontent.com/94128900/224309099-693173aa-3219-44fb-a7e4-f6130f76f2b4.png)

## FragmentKoltinSecond
![Screenshot_1678445694](https://user-images.githubusercontent.com/94128900/224309154-bc1dca68-4d35-4961-89ae-cb11d7b3740a.png)

## HomeActivity
![Screenshot_1678445706](https://user-images.githubusercontent.com/94128900/224310858-b46e960a-f01a-48f3-a016-8c26fdaa66ef.png)
