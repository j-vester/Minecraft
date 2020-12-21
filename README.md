# Readme voor SquidSquad:

Dit document dient als manifest en guideline over hoe we er voor kunnen zorgen dat onze codebase netjes, schoon en functioneel blijft.

### TLDR:

- Maak een eigen branch aan.
- Pull de branch 'master' naar je eigen branch.
- Schrijf eerst tests in src/test/.../*Test.java
-- Het liefste alle tests in één test file!
- Schrijf dan implementatie in src/main/.../*.java
-- Liever meer kleine classes dan weinig grote!
- Voor iedere class in src/main/.../ moet een readme file geschreven zijn.
- Schrijf volledige maar beknopte commit messages. 
- Check de jobs die door je pushes gegenereerd worden voor fouten.
- Merge request alleen als je push volledig door de pipeline stages 'build' en 'test' heen komt.
- Maak issues aan als je hulp wilt.

## Master branch

Het is (als alles goed is) binnen de Dev rol niet mogelijk om de master branch direct te editen. Dat is ook niet zo gek, want de master representeert de werkende mods die ons team aan het ontwikkelen is, en code mag alleen in de master gemerged worden als deze compiled en door de tests heen komt. Zo garanderen we dat de code in de master functioneel is, en alleen code zonder compile errors en test fouten naar de server wordt gezet.

### .gitlab-ci.yml

De gitlab-ci.yml zorgt er voor dat vanaf een push, dingen automatisch afgehandeld gaan worden. De progress van deze automatische afhandeling kun je terug vinden onder CI/CD Jobs. Hier kun je bijvoorbeeld ook zien of de code die je gepushed hebt door de tests komt die je gescreven hebt. 

### Directory architecture:

Dat brengt mij op de folder structuur. In deze repository vind je een directory genaamd 'src' (naar source code). In deze directory vind je twee sub-directories, 'main' en 'test'. Binnen main en test vind je dezelfde hierarchie van directories, welke overeen moeten komen met de package definitie waarbinnen de classes die je definieert moeten vallen.

Aan het uiteinde van de test directory lijn staat een file genaamd fooTest.java. Naast deze file, dus op deze locatie, definieer je de class files voor je tests.

Op diezelfde wijze vind je aan het uiteinde van de main directory een file genaamd foo.java. Daarnaast moeten de class files komen voor de implementatie van de verschillende features. Voor elke class file zie ik graag een readme.md file.

### Readme.md:

Voor iedere class file (e.g. foo.java) moet een readme bijgehouden worden met dezelfde naam maar een .md extensie (i.e. foo.md voor foo.java). In deze readme moet zien wie er aan werkt, waar deze class van afhangt, en wat de beoogde functionaliteiten van de class file gaat zijn. Een goede foo.md ziet er als volgt uit:
- Naam van developer die er aan werkt (contactpersoon)
- Dependencies (en waar die te vinden) e.g. een andere class file.
- Beoogde functionaliteit (wat moet dit doen)
- Gebruiksaanwijzing (in hoeverre logisch)
- Wat er nog moet gebeuren

### ISSUES:

Als je ergens niet uit komt, moeite mee hebt of het lukt niet, dan kun je een ISSUE aanmaken. Deze issues zijn centraal terug te vinden, en kunnen onderling afgehandeld en opgelost worden.


Heel veel success!
Vragen, stel ze gerust!