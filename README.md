# Projet MiniC

## Commandes

- `ant compile` : compile le projet
- `ant execute -Darg=input.txt` : compile et exécute le projet sur le fichier `inout.txt`
- `ant clean` : supprime les fichiers générés par la compilation ainsi que les `*.tam`
- `ant test` : lance execution sur tous les fichiers de [`tests/`](tests/)

## TODO (au minimum)

- [ ] TypeDeclaration (typedef)
- [ ] faire un script de test pour chaque élément
- [x] vérifier qu'une déclaration de fonction n'a pas plusieurs arguments de même nom (`_scope.accepts`)
- [x] tous les `collectAndPartialResolve`
- [x] tous les `completeResolve`
- [x] tous les `getType`
- [x] tous les `checkType`
- [ ] tous les `merge` (EnumerationType, FunctionType, RecordType)
- [X] tous les `length` (PointerType)
- [x] tous les `allocateMemory`
- [ ] tous les `getCode`
- [ ] toutes les classes `Abstract*`
