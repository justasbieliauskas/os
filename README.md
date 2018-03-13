# Virtualios ir Realios Mašinos (VM ir RM) konceptas
**Reali mašina** - tai fizinė skaičiavimo mašina, turinti techninės įrangos komponentus, tokius kaip: procesorių, operatyviąją atmintį, kietajį diską, duomenų perdavimo magistrales bei įvedimo/išvedimo įrenginius. Tai objektas, skirtas palaikyti virtualias mašinas, bei atlikti jų užduotus skaičiavimus. Realias mašinas lengva modifikuoti bei pritaikyti pagal norus, ir kad palaikytų reikiamas virtualias mašinas. 

**Virtuali mašina** yra realios mašinos analogas. Virtualioje Mašinoje sudedami reikalingiausi komponentai, tokie kaip atmintis, procesorius, įvedimo/išvedimo įrenginiai, bei supaprastinama naudotojo sąsaja. Sudėtingos ir nepatogios sąsajos virtualioje mašinoje yra aprašomos supaprastintai, taip yra palengvinamas pats programavimo procesas. Taip pat Virtuali Mašina realizuoja realios mašinos komandas paprastesniu, lengviau suprantamu būdu interpretuojant virtualios mašinos komandas kaip realios mašinos komandas ar jų rinkiniu. Be to Virtuali Mašina pateikia supaprastintą atminties adresavimą. Visa tai leidžia pasiekti realią mašiną ir virtualios mašinos mašininiu kodu parašytą programą sėkmingai įvykdyti realioje mašinoje.
# Komandos
### Bendros
- `LRxy` *Load to R word at address xy*

  Nukopijuoja atmintyje esantį žodį virtualiu adresu *xy* į **R**. Čia **R** - vienas iš registrų **A**, **B**, **C**, **D**. Adresas yra šešioliktainis skaičius iš dviejų skaitmenų, *x* nurodo virtualios atminties puslapio numerį, *y* nurodo ląstelės tame puslapyje numerį. Naudojantis puslapiavimo mechanizmu, *xy* paverčiamas į realų adresą, kuriame esantis žodis nukopijuojamas į registrą **R**.
- `PTOR` *copy word in P To R*

  Nukopijuoja žodį registre **P** į registrą **R**. Čia **P** ir **R** skirtingi registrai iš **A**, **B**, **C**, **D**.
- `XCPR` *exchange words in P and R*

  Sukeičia registrų **P** ir **R** žodžius vietomis. Čia **P** ir **R** skirtingi registrai iš **A**, **B**, **C**, **D**.
### Aritmetinės ir loginės
Visos aritmetinės komandos (išskyrus `COMP`) ir loginės komandos išsaugo rezultatą registre **A**. Unarinės komandos operuoja su žodžiais registre **A**,  binarinės komandos operuoja su žodžiais registruose **A** ir **B**. Visos aritmetinės ir loginės komandos formuoja požymių registro reikšmę.
- `ADD` Add **A** to **B**

  Suma. Požymiai:
  - `ZF = 1`, jei suma lygi 0, kitu atveju `ZF = 0`;
  - `CF = 1`, jei suma peržengia žodžio (4 baitų) ribas, kitu atveju `CF = 0`;
  - `OF = 1`, jei dvieju žodžių, kurių vyriausias bitas yra 0, sumos vyriausias bitas tampa 1 arba jei dviejų žodžių, kurių vyriausias bitas yra 1, sumos vyriausias bitas yra 0. Kitu atveju `OF = 0`

- `SUB` *Subtract **B** from **A***

  Atimtis. Požymiai: 
  - `ZF = 1`, jei skirtumas lygus 0, kitu atveju `ZF = 0`;
  - `CF = 1`, jei atimama didesnį skaičių iš mažesnio, kitu arveju `CF = 0`.

- `COMP` *Compare **A** and **B***

  Palygina du skaičius. Vykdo `SUB`, bet rezultato neišsaugo, tik keičia požymių registrą.

- `INC` *Increment **A***

  Padidina vienetu. Vykdo `ADD`, kur **B** lygus 1.

- `DEC` *Decrement **B***

  Sumažina vienetu. Vykdo `SUB`, kur **B** lygus 1.

- `MUL` *Multiply **A** and **B***

  Daugyba. Požymiai:
  
  - `ZF = 1`, jei dauginama iš 0, kitu atveju `ZF = 0`;
  - `CF = 1`, jei sandauga peržengia žodžio (4 baitų) ribas, kitu atveju `CF = 0`.

- `DIV` *Divide **A** and **B***

  Dalyba. Jei bandoma dalinti iš 0, fiksuojama klaida, kurios kodas 4.

- `MOD` *Modulo **A** and **B***

  Dalybos liekana. Jei bandoma dalinti iš 0, fiksuojama klaida, kurios kodas 4.
  
- `AND` ***A** AND **B***

  Konjunkcija. Požymiai:
  - `ZF = 1`, jei rezultatas 0, kitu atveju `ZF = 0`;
  - `CF = 0`;
  - `OF = 0`.

- `OR` ***A** OR **B***

  Disjunkcija. Požymiai tie patys.
  
- `XOR` ***A** XOR **B***

  XOR. Požymiai tie patys.

- `NOT` ***A** NOT **B***

  Inversija.

- `LSHF` *Left Shift **A** by **C***

  Bitu postūmis į kairę. Postūmio skaičius nurodomas registre C. Nulinis postūmis nekeičia požymių registro. Požymiai:
  - `ZF = 1`, jei rezultatas lygus 0, kitu atveju `ZF = 0`;
  - `CF` lygus paskutiniam išstumtam bitui;
  - `OF = 1`, jei **C** lygus 1 ir išstumtas bitas nelygus kairiausiam bitui po operacijos.

- `RSHF` *Right Shift **A** by **C***

  Bitu postūmis į dešinę. Postūmio skaičius nurodomas registre C. Nulinis postūmis nekeičia požymių registro. Požymiai:
  - `ZF = 1`, jei rezultatas lygus 0, kitu atveju `ZF = 0`;
  - `CF` lygus paskutiniam dešiniausiam išstumtam bitui;
  - Jei **C** lygus 1, `OF` lygus kairiausiam bitui prieš bitų postumį.

### Valdymo perdavimo
Valdymo perdavimo komandos perduoda valdymą, t.y. virtualų adresą *xy* registre **C** priskiria registrui **IC**. Adresas *xy* yra šešioliktainis skaičius iš dviejų skaitmenų, *x* nurodo virtualios atminties puslapio numerį, *y* nurodo ląstelės tame puslapyje numerį. Adresas yra reliatyvus kodo segmentui. Jei *x* užeina už virtualios atminties ribų, fiksuojama klaida, kurios kodas 1.
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
