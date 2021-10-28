(*Jakub Radzik*)

(*2*)
let curry3 f a b c = f(a,b,c);;
let curry3 f = function x -> (function y -> (function z -> f(x,y,z)));;

let uncurry3 f (x,y,z) = f x y z;;
let uncurry3 = function  f -> function (x,y,z) -> f x y z ;;

(*3*)
let rec sumProd l =
  match l with
      h::t -> let (s,p) = sumProd t in (h+s,h*p)
      | [] -> (0,1);;
let sumProdF = List.fold_left(fun (x,y) k -> (x+k,y*k))(0,1);;

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
