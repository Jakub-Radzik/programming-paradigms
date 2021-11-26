(* Jakub Radzik *)

(*definicja list leniwych*)
type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec ltake = function
      (0, _) -> []
    | (_, LNil) -> []
    | (n, LCons(x,lazy xs)) -> x::ltake(n-1,xs);;


(* 3 *)
type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT) ;;

(*a*)
let lBreadth ltree =
  let rec breadthHelper = function
      [] -> LNil
      | LEmpty::t -> breadthHelper t
      | LNode(v, l, r)::t -> LCons(v, lazy (breadthHelper(t @ [l() ; r()])))
    in breadthHelper [ltree];;

(*b*)
let rec lTree n =
    LNode(
        n,
        (fun() -> lTree (2*n)),
        (fun() -> lTree (2*n+1))
    );;

lBreadth(lTree(1));;
ltake(20, lBreadth(lTree(1))) = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20];;
ltake(20, lBreadth(LEmpty)) = [];;
ltake(10, lBreadth(lTree(3))) = [3; 6; 7; 12; 13; 14; 15; 24; 25; 26];;