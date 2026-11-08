# **Navegacio-Activities-Android**
# <u>Enunciat</u>

Amb els coneixements vistos fins ara, desenvolupar una aplicació que permeti simular l’inici i el tancament de sessió d’un usuari mitjançant tres Activities diferents. Heu d’utilitzar Intents explícits per navegar, transmetre les dades necessàries i gestionar correctament el cicle de vida de les Activities.

**IMPORTANT  ·  Login simulat**

No cal implementar una base de dades ni un sistema d’autenticació real. En aquesta pràctica només es valida que els camps estiguin emplenats.

Les pantalles descrites a continuació són un exemple de contingut mínim, no un disseny tancat. Podeu personalitzar-les i afegir-hi camps, botons o funcionalitats, sempre que es compleixin tots els requisits.

### **Pantalla de Login**

* Ha de mostrar un camp per al nom d’usuari, un altre per a la contrasenya i un botó «Iniciar sessió».
* En prémer el botó, heu de comprovar que els dos camps estiguin emplenats. Si falta informació, cal mostrar un missatge o un error i mantenir-se en aquesta pantalla.
* Si els camps són vàlids per a aquesta simulació, heu d’obrir la segona Activity i transmetre-hi el nom d’usuari mitjançant un Intent.

### **Pantalla de sessió iniciada**

* Ha de recuperar el nom d’usuari de l’Intent rebut i mostrar un missatge de benvinguda personalitzat, per exemple: «Benvingut/da, Joan\!».
* Ha de disposar d’un botó «Tancar sessió» que obri la tercera Activity.

### **Pantalla de Logout**

* Ha de mostrar un missatge indicant que la sessió s’ha tancat.
* Ha de tenir un botó «Tornar al login» que obri la pantalla inicial per poder començar una nova sessió.

**És obligatori utilitzar tant putExtra() com Bundle per enviar dades entre Activities.**

Heu de fer com a mínim un enviament amb intent.putExtra() i un altre amb un Bundle afegit mitjançant intent.putExtras(). Per exemple, podeu passar el nom d’usuari del Login a la Sessió amb putExtra() i de la Sessió al Logout amb Bundle, mostrant-lo al missatge de comiat.

**És obligatori evitar que les Activities s’acumulin a la pila de navegació.**

Cada vegada que s’obri la següent Activity del recorregut, heu de finalitzar l’Activity d’origen mitjançant finish(). Per tant, quan l’usuari tanqui la sessió, el botó de retorn no ha de permetre recuperar la pantalla de sessió iniciada.