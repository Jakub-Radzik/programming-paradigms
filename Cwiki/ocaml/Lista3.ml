(*Jakub Radzik*)

let f1 x = x 2 2;;
(*
val f1 : (int -> int -> 'a) -> 'a = <fun>
*)

let f2 x y z = x ( y ^ z );;
(*
val f2 : (string -> 'a) -> string -> string -> 'a = <fun>
*)

(*2*)
let curry3 f a b c = f(a,b,c);;
let curry3_ f = function x -> (function y -> (function z -> f(x,y,z)));;
(*
val curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd = <fun>
*)

let uncurry3 f (x,y,z) = f x y z;;
let uncurry3_ = function  f -> function (x,y,z) -> f x y z ;;
(*
val uncurry3 : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd = <fun>
*)

let addition a b c = a+b+c;;
(*
val addition : int -> int -> int -> int = <fun>
*)

let addition_(a,b,c) = a+b+c;;
(*
val addition_ : int * int * int -> int = <fun>
*)

curry3 addition_ 1 2 3 = 6;;
uncurry3 addition (1,2,3) = 6;;

(*3*)
let sumProd = List.fold_left(fun (x,y) k -> (x+k,y*k))(0,1);;

sumProd [1;2;3;4;5] = (15, 120);;
sumProd [1;2;3;4;5;6;7;8] = (36, 40320);;
sumProd [2;2;2;2;2;2] = (12, 64);;
sumProd [5;5;5;5;5] = (25, 3125);;
