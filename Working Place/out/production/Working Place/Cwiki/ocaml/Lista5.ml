(* Jakub Radzik *)
(*1*)

type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

(*let rec toLazyList = function*)
(*	| [] -> LNil*)
(*	| h::t -> LCons(h, function() -> toLazyList t);;*)

(*let rec lloop = function LNil -> []*)
(*	| LCons(v,f) -> v :: (lloop @@ f());;*)

(*let rec lrepeat n list =*)
(*	let rec repeat v r tl =*)
(*		if r=0 then tl*)
(*		else repeat v (r-1) (LCons(v,fun() -> tl))*)
(*	in match list with*)
(*		| LNil -> LNil*)
(*		| LCons(v,tlf) -> repeat v n (lrepeat n (tlf()));;*)

(*lloop @@ lrepeat 3 (toLazyList [0;1;2;3]);;*)

(*(* 2 *)*)

(*let lfib =*)
(*	let rec fib a b = LCons(a,fun() -> fib b (a+b))*)
(*	in fib 1 1;;*)


(*let rec ltake = function*)
(*	(0, _) -> []*)
(*	| (_, LNil) -> []*)
(*	| (n, LCons(x,xf)) -> x::ltake(n-1, xf());;*)

(*ltake(15,lfib);;*)

(*(* 3 *)*)

(*type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;*)

(*let rec lTree n = LNode(n,(fun() -> lTree (2*n)),(fun() -> lTree (2*n+1)));;*)

(*let lTreeToList tree =*)
(*	let rec toLlist = function*)
(*		| [] -> LNil*)
(*		| LEmpty::tl -> toLlist tl*)
(*		| LNode(v, l, r)::tl -> LCons(v,fun() -> toLlist (tl @ l()::r()::[]))*)
(*	in toLlist [tree];;*)

(*ltake(10,lTreeToList @@ lTree 1);;*)