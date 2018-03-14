# Virtualios ir Realios Mašinos (VM ir RM) konceptas
**Reali mašina** - tai fizinė skaičiavimo mašina, turinti techninės įrangos komponentus, tokius kaip: procesorių, operatyviąją atmintį, kietajį diską, duomenų perdavimo magistrales bei įvedimo/išvedimo įrenginius. Tai objektas, skirtas palaikyti virtualias mašinas, bei atlikti jų užduotus skaičiavimus. Realias mašinas lengva modifikuoti bei pritaikyti pagal norus, ir kad palaikytų reikiamas virtualias mašinas. 

**Virtuali mašina** yra realios mašinos analogas. Virtualioje Mašinoje sudedami reikalingiausi komponentai, tokie kaip atmintis, procesorius, įvedimo/išvedimo įrenginiai, bei supaprastinama naudotojo sąsaja. Sudėtingos ir nepatogios sąsajos virtualioje mašinoje yra aprašomos supaprastintai, taip yra palengvinamas pats programavimo procesas. Taip pat Virtuali Mašina realizuoja realios mašinos komandas paprastesniu, lengviau suprantamu būdu interpretuojant virtualios mašinos komandas kaip realios mašinos komandas ar jų rinkiniu. Be to Virtuali Mašina pateikia supaprastintą atminties adresavimą. Visa tai leidžia pasiekti realią mašiną ir virtualios mašinos mašininiu kodu parašytą programą sėkmingai įvykdyti realioje mašinoje.
# Komandos
### Bendros
- `LRxy` *Load to R word at address xy*

  Nukopijuoja atmintyje esantį žodį virtualiu adresu *xy* į **R**. Čia **R** - vienas iš registrų **A**, **B**, **C**, **D**. Adresas yra šešioliktainis skaičius iš dviejų skaitmenų, *x* nurodo virtualios atminties puslapio numerį, *y* nurodo ląstelės tame puslapyje numerį. Naudojantis puslapiavimo mechanizmu, *xy* paverčiamas į realų adresą, kuriame esantis žodis nukopijuojamas į registrą **R**.
- `SRxy` *Save word in **R** to memory at address xy*

  Išsaugo žodį registre **R** į atmintį adresu *xy*. Čia **R** - vienas iš registrų **A**, **B**, **C**, **D**. Adresas yra šešioliktainis skaičius iš dviejų skaitmenų, *x* nurodo virtualios atminties puslapio numerį, *y* nurodo ląstelės tame puslapyje numerį. Naudojantis puslapiavimo mechanizmu, *xy* paverčiamas į realų adresą, į kurį nukopijuojamas registre **R** esantis žodis.
- `PTOR` *copy word in P To R*

  Nukopijuoja žodį registre **P** į registrą **R**. Čia **P** ir **R** skirtingi registrai iš **A**, **B**, **C**, **D**. Jie negali būti tokie patys, neleidžiama nukopijuoti to paties registro reikšmę į tą patį registrą.
- `XCPR` *exchange words in P and R*

  Sukeičia registruose **P** ir **R** esančius žodžius vietomis. Čia **P** ir **R** skirtingi registrai iš **A**, **B**, **C**, **D**. Jie negali būti tokie patys, neleidžiama sukeisti to paties registro reikšmės vietomis.
### Aritmetinės ir loginės
Visos aritmetinės ir loginės komandos, išskyrus `COMP`, išsaugo rezultatą registre **A**. Unarinės komandos operuoja su žodžiais registre **A**,  binarinės komandos operuoja su žodžiais registruose **A** ir **B**. Taip pat visos aritmetinės ir loginės komandos, išskyrus `DIV`, `MOD` ir `NOT` formuoja požymių registro reikšmę.
- `ADD` ***A** = **A** + **B***

  Požymiai:
  - `ZF = 1`, jei suma lygi 0, kitu atveju `ZF = 0`;
  - `CF = 1`, jei suma peržengia žodžio (4 baitų) ribas, kitu atveju `CF = 0`;
  - `OF = 1`, jei dvieju žodžių, kurių vyriausias bitas yra 0, sumos vyriausias bitas tampa 1 arba jei dviejų žodžių, kurių vyriausias bitas yra 1, sumos vyriausias bitas yra 0. Kitu atveju `OF = 0`

- `SUB` ***A** = **A** - **B***

  Požymiai: 
  - `ZF = 1`, jei skirtumas lygus 0, kitu atveju `ZF = 0`;
  - `CF = 1`, jei atimama didesnį skaičių iš mažesnio, kitu arveju `CF = 0`.

- `COMP` *Compare **A** and **B***

  Palygina du skaičius registruose **A** ir **B**: vykdo `SUB`, bet rezultato neišsaugo, tik keičia požymių registrą.

- `INC` ***A** = **A** + 1*

  Vykdo `ADD`, kur **B** lygus 1.

- `DEC` ***A** = **A** - 1*

  Vykdo `SUB`, kur **B** lygus 1.

- `MUL` ***A** = **A** * **B***

  Požymiai:
  
  - `ZF = 1`, jei **B** lygus 0, kitu atveju `ZF = 0`;
  - `CF = 1`, jei sandauga peržengia žodžio (4 baitų) ribas, kitu atveju `CF = 0`.

- `DIV` ***A** = **A** / **B***

  Rezultatas - sveikoji skaičiaus dalis. Požymių registras nekeičiamas. Jei bandoma dalinti iš 0, fiksuojama klaida, kurios kodas 2.

- `MOD` ***A** = **A** % **B***

  Požymių registras nekeičiamas. Jei bandoma dalinti iš 0, fiksuojama klaida, kurios kodas 2.
- `AND`, `OR`, `XOR`

  ***A** = **A** AND **B***
  ***A** = **A** | **B***
  ***A** = **A** ^ **B***

  Požymiai:
  - `ZF = 1`, jei rezultatas 0, kitu atveju `ZF = 0`;
  - `CF = 0`;
  - `OF = 0`.

- `NOT` ***A** = ~ **A**

  Požymių registro nekeičia.

- `LSHF` ***A** = **A** << **C***

  Nulinis postūmis nekeičia požymių registro. Kitu atveju:
  - `ZF = 1`, jei rezultatas lygus 0, kitu atveju `ZF = 0`;
  - `CF` lygus paskutiniam išstumtam bitui;
  - `OF = 1`, jei **C** lygus 1 ir išstumtas bitas nelygus kairiausiam bitui po operacijos.

- `RSHF` ***A** = **A** >> **C***

  Nulinis postūmis nekeičia požymių registro. Kitu atveju:
  - `ZF = 1`, jei rezultatas lygus 0, kitu atveju `ZF = 0`;
  - `CF` lygus paskutiniam dešiniausiam išstumtam bitui;
  - `OF` lygus kairiausiam bitui prieš bitų postumį, jei **C** lygus 1.

### Valdymo perdavimo
Valdymo perdavimo komandos perduoda valdymą, t.y. virtualų adresą *xy* registre **C** priskiria registrui **IC**. Adresas yra žodžio kokiame nors bloke numeris reliatyvus kodo segmentui. Jei adresas užeina už virtualios atminties ribų, fiksuojama klaida, kurios kodas 1.
- `JUMP`

  Besąlygiškai perduoda valdymą.
  
- `JE` *Jump if Equal*

  Perduoda valdymą, jei `ZF = 1`.

- `JNE` *Jump if Not Equal*

  Perduoda valdymą, jei `ZF = 0`.

- `JG` *Jump if Greater*

  Perduoda valdymą, jei `ZF = 0` ir `CF = 0`.

- `JGE` *Jump if Greater or Equal*

  Perduoda valdymą, jei `CF = 0`.

- `JL` *Jump if Lower*

  Perduoda valdymą, jei `CF = 1`.

- `JLE` *Jump if Lower or Equal*

  Perduoda valdymą, jei `ZF = 1` ir `CF = 1`.
### Darbui su simbolių eilutėmis
Darbui su simboliais, adresai turi būti smulkesni. Adresas yra virtualus baito numeris kokiame nors žodyje, kokiame nors bloke. Jei adresas užeina už virtualios atminties ribų, fiksuojama klaida, kurios kodas 1. Puslapiavimo mechanizmo pagalba virtualus baito adresas yra paverčiamas į realų.
- `LODS` *Load String*

  Nukopijuoja baitą, kurio adresas registre **D**, į registrą **A**. Šiuo atveju nukopijuotas baitas bus jauniausias registre **A**.

- `STOS` *Store String*

  Nukopijuoja jauniausiąjį baitą registre **A** į atmintį, kurios adresas registre **D**.

- `CMPS` *Compare Strings*

  Palygina du baitus (vykdoma `COMP` komanda), kurių adresai registruose **A** ir **B**, ir keičia požymių registrą.
  
- `MOVS` *Move String*

  Nukopijuoja vieną baitą, kurio adresas registre **A**, į kito baito, kurio adresas registre **B**, vietą.
  
Po komandos vykdymo:
1. Jeigu `DF = 0`, adresai padidinami vienetu;
2. Jeigu `DF = 1`, adresai sumažinami vienetu.
### Ciklams
Šios komandos vykdo ciklą: tikriną žodį registre **C**; jei jis 0, sustoja, kitu atveju atlieka operaciją ir vėl tikrina.
- `LOOP`

  Besąlygiškai perduoda valdymą komandai, kurios adresas registre **D**, t.y. vykdomas `JUMP`. Jei adresas užeina už virtualios atminties ribų, fiksuojama klaida, kurios kodas 1.
- `REP` *Repeat string command*

  Komanda, po kurios iš karto rašoma kita komanda `STOS`, `CMPS` arba `MOVS`, kuri yra kartojama.
### Darbui su failais
- `OPEN`

  Atidaro failą, kurio pavadinimo adresas yra registre **A** ir išsaugo jo deskriptorių registre **A**. Laikoma, kad atidarius failą, galima jį ir skaityti, ir rašyti, nereikia nurodyti papildomo požymio. Jei failas neegzistuoja, fiksuojama klaida, kurios kodas 6.
- `READ`

  Skaito iš failo. Failo deskriptorius turi būti registre **A**, adresas į baito vietą atmintyje, į kurią bus rašoma, turi būti registre **B**, maksimalus skaitomų simbolių skaičius turi būti registre **C**. Jei failas nebuvo atidarytas, fiksuojama klaida, kurios kodas 7.
- `WRTE`

  Rašo į failą. Failo deskriptorius turi būti registre **A**, adresas į simbolių eilutę, kuri bus rašoma, turi būti registre **B**, skaičius, kiek simbolių rašyti, turi būti registre **C**. Jei failas nebuvo atidarytas, fiksuojama klaida, kurios kodas 7.
- `CLOS`

  Uždaro failą. Failo deskriptorius turi būti registre **A**. Jei failas nebuvo atidarytas, fiksuojama klaida, kurios kodas 7.
- `DSTR`

  Sunaikina failą, kurio pavadinimo adresas yra registre **A**. Jei toks failas neegzistuoja, fiksuojama klaida, kurios kodas 6.
### Kitos
- `WTOS`

  Konvertuoja skaičių į simbolių eilutę.
  
  Reikalavimai:
  - **A** skaičius konvertavimui;
  - **D** simbolių eilutės adresas, į kurią bus rašoma.
  
  Rezultatai:
  - **C** simbolių eilutės ilgis.
- `STOW`

  Konvertuoja simbolių eilutę į skaičių.
  
  Reikalavimai:
  - **A** simbolių eilutės adresas;
  - **C** simbolių eilutės ilgis.
  
  Rezultatai:
  - **A** konvertuotas skaičius
- `DRAW`

  Nupiešia tašką ekrane.
  
  Registras **SI** įgauna reikšmę 5 ir iš vartotojo režimo pereinama į supervizorinį. Supervizoriniame režime piešiamas taškas. Ši operacija užima 2 *tickus*.
  
  Reikalavimai:
  - **A** *x* koordinatė - stulpelio numeris terminale;
  - **B** *y* koordinatė - eilutės numeris terminale;
  - **D** *RGB* reikšmė. *R*, *G* ir *B* komponentės užima po vieną baitą, t.y. tai skaičiai nuo 0 iki 255 (imtinai). Jauniausias registro **D** baitas yra komponentė *B*, antras pagal jaunumą yra *G*, trečias - *R*. Vyriausias baitas nenaudojamas.
- `HALT`

  Nutraukia programos vykdymą.
  
  Registrui **SI** priskiria reikšmę 6 - *stabdyti programą*. Iš vartotojo režimo pereinama į supervizorinį, kuriame programa sustabdoma.
