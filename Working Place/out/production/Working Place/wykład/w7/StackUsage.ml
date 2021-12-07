#use "./Stack.ml";;
#use "./StackImpl.ml";;

let s = Stack.create();;
let s = Stack.push(1, s);;
let s = Stack.push(2, s);;


Stack.top s;;
(* #use "./StackUsage.ml";; *)