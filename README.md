# Fibula

Fibula är ett textbaserat fantasyrollspel som skapats av Per Vestin (spelmotor och värld), Nanga Kamau (karaktärer och
strider) och
Josefin Sundberg (föremål och inventarium).

Instruktioner för att spela Fibula:

1. Spelet består av totalt 15 rum. Spelaren spelar en hjälte som heter Arthur LightBringer. Hjälten
   slåss genom 11 eller 12 rum, beroende på vilken väg han väljer att ta. Spelet består av 6 olika typer av rum med
   varierande svårighetsgrad.
2. I varje rum möter spelaren mellan 1 och 2 fiender. Det finns 5 olika unika fiender varav 3 tillhör någon av
   bassvårigheterna, medan de andra 2 är boss-monster.
3. Striderna är turbaserade och spelaren kan använda sig av förbrukningsföremål för att skada fiender eller hela sig
   själv. Hjälten är alltid
   utrustad med ett vapen och under spelets gång kan han även få rustning och nya vapen från fiender som han kan byta
   fritt mellan.
4. Efter varje avklarat rum får hjälten möjlighet att byta rustning och använda föremål obegränsat.

I programmet har vi använt oss av Factory-mönstret för att skapa olika typer av föremål. Det underlättar vid repetitivt
skapande av
liknande föremålsobjekt och innebär att klassen som anropar fabriken inte behöver veta hur själva koden för att skapa
föremålet ser ut.
Vi har även använt Strategy-mönstret, som möjliggör och underlättar utformningen av dynamiska strider. Det ger en
förutsättning för strider
som påverkas av yttre faktorer.

Under Git-samarbetet stötte vi på en merge konflikt. Det var att en pull request innehöll en .idea-mapp, vilket skapade
problem när vi hade
mergat branchen till main. Vi löste problemet genom att en av oss la det felaktiga i en .gitignore-fil. I övrigt har vi
haft ett bra samarbete
med regelbundna pull requests och avstämningar.