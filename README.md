# Projet MiniC

## Commandes

### Java

- `ant generate` : génère le parser ANTLR depuis les fichiers .g4
- `ant compile` : compile le projet Java
- `ant clean` : supprime les fichiers générés et les fichiers .tam

### MiniC

- `ant verify -Dfile=program.c` : vérifie la syntaxe et la sémantique du fichier sans générer de code TAM
- `ant compile-tam -Dfile=program.c` : compile le fichier MiniC vers du code TAM

### TAM

- `ant runtam -Dfile=program.tam` : exécute le fichier TAM en ligne de commande
- `ant itam` : lance l'interface graphique de la machine TAM (nécessite JavaFX)

## Tests

- `ant test-verify` : lance la vérification sur tous les fichiers de test
- `ant test` : lance la compilation complète sur tous les fichiers de test

> Note: Pour utiliser itam, la variable d'environnement PATH_TO_FX doit être définie:
>
>```bash
>export PATH_TO_FX=/path/to/javafx-sdk/lib
>```

## TODO (au minimum)

- [ ] TypeDeclaration (typedef)
- [ ] faire un script de test pour chaque élément
- [x] vérifier qu'une déclaration de fonction n'a pas plusieurs arguments de même nom (`_scope.accepts`)
- [x] tous les `collectAndPartialResolve`
- [x] tous les `completeResolve`
- [x] tous les `getType`
- [x] tous les `checkType`
- [ ] tous les `merge`
- [ ] tous les `length`
- [x] tous les `allocateMemory`
- [ ] tous les `getCode`
- [ ] toutes les classes `Abstract*`
