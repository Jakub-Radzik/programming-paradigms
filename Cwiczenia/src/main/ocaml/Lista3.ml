(*Jakub Radzik*)
(*1*)
let f1 x = x 1 1;;
(*  (int -> int -> 'a) -> 'a *)

let f2 x y z = x (y ^ z);;
(* (string -> 'a) -> string -> string -> 'a  *)

(*2*)
(*lukier*)
let curry3 f a b c = f(a,b,c);;
(* val curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd = <fun> *)
let curry3a f = function x -> (function y -> (function z -> f(x,y,z)));;
(* val curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd = <fun> *)

let uncurry3 f (x,y,z) = f x y z;;
(* val uncurry3 : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd = <fun> *)
let uncurry3a = function  f -> function (x,y,z) -> f x y z ;;
(*val uncurry3a : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd = <fun>*)

(*3*)
(*4*)
(*5*)