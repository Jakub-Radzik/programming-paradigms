(*Jakub Radzik*)
(*1*)
let f1 x = x 1 1;;
(*  (int -> int -> 'a) -> 'a *)

let f2 x y z = x (y ^ z);;
(* (string -> 'a) -> string -> string -> 'a  *)

(*2*)
(*lukier*)
let curry3 f a b c = f(a,b,c);;
let curry3a f = function x -> (function y -> (function z -> f(x,y,z)));;
(* val curry3 : ('a * 'b * 'c -> 'd) -> 'a -> 'b -> 'c -> 'd = <fun> *)

let uncurry3 f (x,y,z) = f x y z;;
let uncurry3a = function  f -> function (x,y,z) -> f x y z ;;
(*val uncurry3a : ('a -> 'b -> 'c -> 'd) -> 'a * 'b * 'c -> 'd = <fun>*)

(*3*)
(*4*)

(*5*)
(*a*)
let insertionsort xs f =
    let rec insert xs x =
      match xs with
      [] -> [x]
      | h :: t when f x h -> x :: h :: t
      | h :: t -> h :: insert t x
    in List.fold_left(insert)([]) xs;;

let comp a b = a<b;;
insertionsort [1;2] comp = [1;2];;
insertionsort [10;9;8] comp = [8;9;10];;
insertionsort [11;9;11] comp = [9;11;11];;
insertionsort [10;1;2;3;4;5] comp = [1;2;3;4;5;10];;
(*//TEST STABILNOSCI*)
let pred = (fun (x1,y1) (x2, y1) -> x1 <= x2);;
insertionsort [(1,2);(1,3);(2,3);(2,4);(200,2);(100,1);(120,3)] pred = [(1, 3); (1, 2); (2, 4); (2, 3); (100, 1); (120, 3); (200, 2)];;
insertionsort [(5, 'a'); (3, 'a'); (5, 'b'); (6, 'a'); (2, 'a'); (9, 'a'); (6, 'b'); (2, 'b'); (6, 'c')] pred = [(2, 'b'); (2, 'a'); (3, 'a'); (5, 'b'); (5, 'a'); (6, 'c'); (6, 'b'); (6, 'a'); (9, 'a')];;
