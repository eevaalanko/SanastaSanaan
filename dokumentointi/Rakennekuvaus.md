-	**Main**-luokassa luodaan uusi JFrame pelin graafiseksi käyttöliittymäksi ja **Sanavarasto**-luokan ilmentymä *varasto*.
-	*Varasto* hakee avainsanoja (5) ja näistä muodostettavissa olevia sanalistoja xml-tiedosto **kotus-sanalista_v1.xml**:stä
käyttäen staattisen luokan Sanahaku metodeja.
-	*Varasto* tallentaa sanat attribuuttinsa **Sanakirja**-luokan HashMapiin.
-	**Mainin** sisäinen tapahtumankuuntelijaluokka **AlsAloita** luo uuden Jframe’in **JFpelialusta** *pelin*. *Pelin* konstruktori luo
ja kaynnistaa uuden ajastimen sisaisen luokkansa **AlsAjastin** avulla.
-	**AlsAloita** luo myös uuden **HyvaksytytSanat**-luokan olion hyvaksytyt, joka asetetaan parametriksi *pelille*. 
*Hyvaksytyt*-oliolle annetaan parametriksi *varasto* ja käyttämän valitsema avainsana.
-	Kayttaja syöttää sanan *pelin* tekstikenttään ja painaa enteriä tai nappia btLisaaSana; kumpi vain laukaisee luokan lisäisen 
tapahtumankuuntelijaluokan **AlsLisaaSana**.
-	**AlsLisaaSana**-luokassa *hyvaksytyt* validoi käyttäjan syötteet ja tallentaa ne.
-	**AlsAjastin** laukaisee ajan loputtua *pelin* metodin naytaTulokset: *hyvaksytyt* laskee validoimiensa sanojen määrän ja *varaston*
sanakirjan HashMapista kaikki avainsanasta muodostettavissa olevissa sanat.
