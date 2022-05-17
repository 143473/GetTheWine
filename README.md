# GetTheWine

"Get the wine" is an application meant to help the user decide which bottle of wine they should choose. The user should be able to use the application to scan the bottle of wine and get extra information about it. The information can consist in available ratings/reviews, description about the wine type, or even recommandation for the event where the chosen wine should be used. An account is necessary to store a list of favorite bottles of wine.

I'm not a connoisseur of wine and i don't know much about it. I don't know which countries are best for which kind of wine, or what wine should i bring to a specific occasion. Many times i go to supermarket with the thought of buying a bottle of wine, but when i get to the wine department i immediately change my mind. There are too many wine types, brands and countries of provenance to choose from. 

# Requirements

1. ~~I want to be able to log in in order to personalize my choices.~~
2. I want to be able to scan different types of wine by using the phone's camera.
3. ~~I want to check information about the scanned wine(rating, description).~~ 
4. I want to save my wine preferences by adding the scanned bottle to the favorites list.
5. I want to be able to share the wine of choice with somebody else.
6. ~~I want to be able to add a wine to my list of favourites.~~
7. I want to be able to delete a wine of choices from the list of favourites.
8. ~~I want to be able to check suitable meals for the wine i'm checking.~~
9. ~~I want to search for a bottle of wine by typing its name.~~

Thoughts:
Implementing a Text recognition system proved to be more complicated than expected hence taking too much time to figure it out and to implement.
I didn't manage to find a proper free API for my application. Therefore i went with MockiAPI, basically dummy data. The dummy data is taken from a real API tested with swagger and the company's dummy token. All the formats used in the application follow the webAPI's structure.
