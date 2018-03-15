# Virtualios ir Realios Mašinos (VM ir RM) konceptas
**Reali mašina** - tai fizinė skaičiavimo mašina, turinti techninės įrangos komponentus, tokius kaip: procesorių, operatyviąją atmintį, kietajį diską, duomenų perdavimo magistrales bei įvedimo/išvedimo įrenginius. Tai objektas, skirtas palaikyti virtualias mašinas, bei atlikti jų užduotus skaičiavimus. Realias mašinas lengva modifikuoti bei pritaikyti pagal norus, ir kad palaikytų reikiamas virtualias mašinas. 

**Virtuali mašina** yra realios mašinos analogas. Virtualioje Mašinoje sudedami reikalingiausi komponentai, tokie kaip atmintis, procesorius, įvedimo/išvedimo įrenginiai, bei supaprastinama naudotojo sąsaja. Sudėtingos ir nepatogios sąsajos virtualioje mašinoje yra aprašomos supaprastintai, taip yra palengvinamas pats programavimo procesas. Taip pat Virtuali Mašina realizuoja realios mašinos komandas paprastesniu, lengviau suprantamu būdu interpretuojant virtualios mašinos komandas kaip realios mašinos komandas ar jų rinkiniu. Be to Virtuali Mašina pateikia supaprastintą atminties adresavimą. Visa tai leidžia pasiekti realią mašiną ir virtualios mašinos mašininiu kodu parašytą programą sėkmingai įvykdyti realioje mašinoje.
# Komandos
Visos komandos, nedirbančios su išoriniais įrenginiais, užima 1 taktą.
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
Valdymo perdavimo komandos perduoda valdymą, t.y. adresą *xy* registre **C** priskiria registrui **IC**. Adresas virtualus yra komandos (žodžio) indeksas reliatyvus kodo segmentui. *x* nurodo puslapio indeksą, *y* nurodo ląstelės tame puslapyje indeksą. Jei adresas užeina už virtualios atminties ribų, fiksuojama klaida, kurios kodas 1 (*bad address*).
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
Darbui su simbolių eilutėmis, adresai turi būti smulkesni. Adresai naudojami simbolių eilutėms yra skaičiai, nurodantys baito indeksą kokiame nors žodyje, kokiame nors bloke, duomenų segmente. Kadangi žodis yra 4 baitai, simbolių eilučių adresai yra 4 kartotiniai.

Po komandos vykdymo:
1. Jeigu `DF = 0`, adresai padidinami vienetu;
2. Jeigu `DF = 1`, adresai sumažinami vienetu.

Jei adresas užeina už duomenų segmentų ribų, fiksuojama klaida, kurios kodas 1 (*bad address*).
- `LODS` *Load String*

  Nukopijuoja simbolių eilutės simbolį atmintyje į registrą.
  
  Reikalavimai:
  - **D** adresas į simbolį duomenų segmente.
  
  Rezultatai:
  - **A** simbolis. Išsaugotas kaip registro jauniausias baitas.
- `STOS` *Store String*

  Išsaugo simbolį registre į simbolio vietą atmintyje. Simbolis yra laikomas jauniausias baitas registre.
  
  Reikalavimai:
  - **A** simbolio reikšmė;
  - **D** adresas į simbolį duomenų segmente.

- `CMPS` *Compare Strings*

  Palygina du simbolius atmintyje ir keičia požymių registrą. Požymiai tokie patys kaip `COMP` komandos.
  
  Reikalavimai:
  - **A** pirmojo simbolio duomenų segmente adresas;
  - **B** antrojo simbolio duomenų segmente adresas.
  
- `MOVS` *Move String*

  Nukopijuoja vieną simbolį atmintyje į kito baito atmintyje vietą.
  
  Reikalavimai:
  - **A** pirmojo simbolio duomenų segmente adresas;
  - **B** antrojo simbolio duomenų segmente adresas.
### Ciklams
Šios komandos kartoja tam tikrą operaciją *n* kartų. Skaičius *n* turi būti nurodytas registre **C**. Kiekvieną taktą atliekami šie veiksmai:
1. Tikrinamas žodis registre **C**. Jei **C** reikšmė lygi 0, sustojama, t.y. vykdoma kita komanda;
2. Kitu atveju vykdoma operacija;
3. Registro **C** reikšmė sumažinama vienetu ir vėl vykdomas 1 žingsnis.

- `LOOP`

  Besąlygiškai perduoda valdymą komandai.

  Reikalavimai:
  - **D** komandos adresas, kuriai bus perduotas valdymas. Adreso požymiai tokie patys kaip `JUMP` komandų adresams.
- `REP` *Repeat string command*

  Kartoja komandą darbui su simbolio eilutėmis. Po šios komandos iš karto rašoma arba `STOS`, arba `CMPS`, arba `MOVS`.
### Darbui su failais
Komandos darbui su failais užima 3 taktus.
- `OPEN`

  Atidaro failą. Laikoma, kad atidarius failą, galima jį ir skaityti, ir rašyti, nereikia nurodyti papildomo požymio. Jei failas neegzistuoja, fiksuojama klaida, kurios kodas 6 (*no such file*).
  
  Reikalavimai:
  - **A** failo pavadinimo (simbolių eilutės) adresas atmintyje.
  
  Rezultatai:
  - **D** atidaryto failo deskriptorius.
- `READ`

  Skaito iš failo. Jei failas nebuvo atidarytas, fiksuojama klaida, kurios kodas 7 (*file not open*).
  
  Reikalavimai:
  - **D** failo deskriptorius;
  - **A** simbolių eilutės, į kurią bus rašoma, adresas atmintyje;
  - **C** simbolių eilutės, į kurią bus rašoma, ilgis.
  
  Rezultatai:
  - **C** perskaitytų simbolių skaičius.
- `WRTE`

  Rašo į failą. Jei failas nebuvo atidarytas, fiksuojama klaida, kurios kodas 7 (*file not open*).
  
  Reikalavimai:
  - **D** failo deskriptorius;
  - **A** simbolių eilutės, kuri bus rašoma, adresas atmintyje;
  - **C** simbolių eilutės, kuri bus rašoma, ilgis.
- `CLOS`

  Uždaro failą. Jei failas nebuvo atidarytas, fiksuojama klaida, kurios kodas 7 (*file not open*).
  
  Reikalavimai:
  - **D** failo deskriptorius.
- `DSTR`

  Sunaikina failą. Jei toks failas neegzistuoja, fiksuojama klaida, kurios kodas 6 (*no such file*).
  
  Reikalavimai:
  - **A** failo pavadinimo (simbolių eilutės) adresas atmintyje.
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
  
  Registras **SI** įgauna reikšmę 5 ir iš vartotojo režimo pereinama į supervizorinį. Supervizoriniame režime piešiamas taškas. Ši operacija užima 2 taktus.
  
  Reikalavimai:
  - **A** *x* koordinatė - stulpelio numeris terminale;
  - **B** *y* koordinatė - eilutės numeris terminale;
  - **D** *RGB* reikšmė. *R*, *G* ir *B* komponentės užima po vieną baitą, t.y. tai skaičiai nuo 0 iki 255 (imtinai). Jauniausias registro **D** baitas yra komponentė *B*, antras pagal jaunumą yra *G*, trečias - *R*. Vyriausias baitas nenaudojamas.
- `HALT`

  Nutraukia programos vykdymą.
  
  Registrui **SI** priskiria reikšmę 6 - *stabdyti programą*. Iš vartotojo režimo pereinama į supervizorinį, kuriame programa sustabdoma.
