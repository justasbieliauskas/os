# Virtualios ir Realios Mašinos (VM ir RM) konceptas
**Reali mašina** - tai fizinė skaičiavimo mašina, turinti techninės įrangos komponentus, tokius kaip: procesorių, operatyviąją atmintį, kietajį diską, duomenų perdavimo magistrales bei įvedimo/išvedimo įrenginius. Tai objektas, skirtas palaikyti virtualias mašinas, bei atlikti jų užduotus skaičiavimus. Realias mašinas lengva modifikuoti bei pritaikyti pagal norus, ir kad palaikytų reikiamas virtualias mašinas. 

**Virtuali mašina** yra realios mašinos analogas. Virtualioje Mašinoje sudedami reikalingiausi komponentai, tokie kaip atmintis, procesorius, įvedimo/išvedimo įrenginiai, bei supaprastinama naudotojo sąsaja. Sudėtingos ir nepatogios sąsajos virtualioje mašinoje yra aprašomos supaprastintai, taip yra palengvinamas pats programavimo procesas. Taip pat Virtuali Mašina realizuoja realios mašinos komandas paprastesniu, lengviau suprantamu būdu interpretuojant virtualios mašinos komandas kaip realios mašinos komandas ar jų rinkiniu. Be to Virtuali Mašina pateikia supaprastintą atminties adresavimą. Visa tai leidžia pasiekti realią mašiną ir virtualios mašinos mašininiu kodu parašytą programą sėkmingai įvykdyti realioje mašinoje.
# Komandos
### Bendros
- `LRxy` (*Load to R word at address xy*)

Nukopijuoja atmintyje esantį žodį virtualiu adresu *xy* į **R**. Čia **R** - vienas iš registrų **A**, **B**, **C**, **D**. Adresas yra šešioliktainis skaičius iš dviejų skaitmenų, *x* nurodo virtualios atminties puslapio numerį, *y* nurodo ląstelės tame puslapyje numerį. Naudojantis puslapiavimo mechanizmu, *xy* paverčiamas į realų adresą, kuriame esantis žodis nukopijuojamas į registrą **R**.
- `PTOR` (*copy word in P To R*)

Nukopijuoja žodį registre **P** į registrą **R**. Čia **P** ir **R** skirtingi registrai iš **A**, **B**, **C**, **D**.
- `XCPR` (*exchange words in P and R*)

Sukeičia registrų **P** ir **R** žodžius vietomis. Čia **P** ir **R** skirtingi registrai iš **A**, **B**, **C**, **D**.
