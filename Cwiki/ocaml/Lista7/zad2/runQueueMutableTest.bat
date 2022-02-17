ocamlc -c queueMutable.mli
ocamlc -c queueMutable.ml
ocamlc -c queueMutableTest.ml
ocamlc -o queueMutableTest queueMutable.cmo queueMutableTest.cmo
ocamlrun queueMutableTest